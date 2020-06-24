package com.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * demo代码，有可能无法正常运行
 */
public class SocketMultiplexingThreads {
    private ServerSocketChannel server = null;
    private Selector selector1 = null;
    private Selector selector2 = null;
    private Selector selector3 = null;

    int port = 9090;

    public void initServer() {

        try {
            server = ServerSocketChannel.open();
            server.configureBlocking(false);
            server.bind(new InetSocketAddress(port));
            selector1 = Selector.open();
            selector2 = Selector.open();
            selector3 = Selector.open();

            server.register(selector1, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SocketMultiplexingThreads service = new SocketMultiplexingThreads();
        service.initServer();

        NioThread t1 = new NioThread(service.selector1, 2);
        NioThread t2 = new NioThread(service.selector2);
        NioThread t3 = new NioThread(service.selector3);

        t1.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t2.start();
        t3.start();

        System.out.println("服务器启动了.........");
    }
}

class NioThread extends Thread {

    int selectors = 0;
    Selector selector;

    int id = 0;
    volatile static BlockingQueue<SocketChannel>[] queue;

    static AtomicInteger idx = new AtomicInteger();

    /**
     * 命名不太合适， 这里是初始化worker
     *
     * @param selector
     */
    public NioThread(Selector selector) {
        this.selector = selector;
        id = idx.getAndIncrement() % selectors;
        System.out.println("worker:" + id + " 启动");
    }

    /**
     * 命名不好，这里是初始化server
     * 用构造方法区分度太低，容易误解
     *
     * @param selector
     * @param selectors
     */
    public NioThread(Selector selector, int selectors) {
        this.selectors = selectors;
        this.selector = selector;
        queue = new LinkedBlockingQueue[selectors];

        for (int i = 0; i < selectors; i++) {
            queue[i] = new LinkedBlockingQueue<>();
        }
        System.out.println("Boss启动");

    }

    @Override
    public void run() {
        try {

            while (true) {
                while (selector.select(10) > 0) {
                    Set<SelectionKey> selectionKeys = selector.selectedKeys();
                    Iterator<SelectionKey> iter = selectionKeys.iterator();
                    while (iter.hasNext()) {
                        SelectionKey key = iter.next();
                        iter.remove();
                        if (key.isAcceptable()) {
                            acceptHandler(key);
                        } else if (key.isReadable()) {
                            readHandler(key);
                        }
                    }
                }
                if (!queue[id].isEmpty()) {
                    ByteBuffer buffer = ByteBuffer.allocate(8192);
                    SocketChannel client = queue[id].take();
                    client.register(selector, SelectionKey.OP_READ, buffer);
                    System.out.println("------------------------------------------------");
                    System.out.println("新客户端：" + client.socket().getPort() + " 分配到" + (id));
                    System.out.println("------------------------------------------------");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readHandler(SelectionKey key) {
    }

    private void acceptHandler(SelectionKey key) {
        try {
            ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
            SocketChannel client = ssc.accept();
            client.configureBlocking(false);
            int num = idx.getAndIncrement() % selectors;

            queue[num].add(client);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
