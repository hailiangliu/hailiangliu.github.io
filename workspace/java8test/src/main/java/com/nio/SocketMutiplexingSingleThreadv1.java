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

/**
 * 周之垒 nio epoll netty 底层剖析
 * demo代码，有可能无法正常运行
 * https://www.bilibili.com/video/BV1FZ4y1H7p9?p=6
 */
public class SocketMutiplexingSingleThreadv1 {

    private ServerSocketChannel server = null;

    // Linux 多路复用器: select、poll、epoll、kqueue      nginx event()
    private Selector selector = null;


    public void initServer() {

        try {
            server = ServerSocketChannel.open();
            server.bind(new InetSocketAddress(9999));

            // 非阻塞模式，  如果是ture 则是阻塞（bio模式）
            // 这里对应底层的系统调用就是 socket.accept， linux内核对accept提供多个选择，可以阻塞，也可以不阻塞
            server.configureBlocking(false);

            // 如果在epoll模型下， open    epoll_create->fd3
            selector = Selector.open();  //  select  poll  epoll  优选选择epoll， 但是可以用过jvm启动参数 -D修正

            // server 约等于 listen状态的fd4
            /**
             * register
             * 如果
             * select poll: jvm里开辟一个数组 fd4放进去      --> 每次所有都去轮询、全量的，由一点效率问题，因为内核无法知道将要轮询的fd是不是刚刚查询过
             * epoll: epoll_ctl(fd3, ADD, fd4, EPOLLIN)     --> 每次只查询内核中给的一个空间（改空间内是由IO事件的通道，也就是真正需要处理的channel），事件驱动了
             */
            server.register(selector, SelectionKey.OP_ACCEPT);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        initServer();
        System.out.println("服务器启动了......");
        try {
            while (true) {

                Set<SelectionKey> keys = selector.keys();
                System.out.println(keys.size() + " size");


                /**
                 * 1、调用多路复用器（select、poll or epoll(epoll_wait))
                 * select()是啥意思？
                 *  1， select/poll  其实内核的select(fd4)  poll(fd4）
                 *  2， epoll 其实是内核的epoll_wait()
                 *  参数可以带时间，没有时间，0： 阻塞，有时间设置一个超市
                 *
                 *  selector.wakeupo() 结果返回0
                 *
                 */
                while (selector.select(500) > 0){
                    Set<SelectionKey> selectionKeys = selector.selectedKeys();// 返回的有状态的fd集合
                    Iterator<SelectionKey> iterator = selectionKeys.iterator();
                    // 不管啥多路复用器，只能返回一个状态，我还得一个一个去处理他们的R/W.
                    // NIO， 自己对着每一个fd调用系统调用，浪费资源
                    while (iterator.hasNext()) {
                        SelectionKey key = iterator.next();
                        iterator.remove(); // set 不溢出会重复循环处理
                        if (key.isAcceptable()) {
                            /**
                             看代码时候，这里是重点。如果要去接受一个新的连接
                             语义上accept接受链接且返回新的连接fd对吧
                             那新的fd怎么办？
                             select、poll：因为他们内核没有空间，那么在jvm中保存和当前fd4那个listen的一起
                             epoll： 我们希望通过epoll_ctl把新的客户端fd注册到内核空间
                             */
                            acceptHandler(key);
                        } else if (key.isReadable()) {
                            readHandler(key);
                            // 在当前线程，这个方法可能会阻塞，如果阻塞十年，其他的IO早就没电了
                            // 所有，为什么提出了IO_THREADS
                        }
                    }
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
            SocketChannel client = ssc.accept();//  目的是调用accept接受客户端 fd7
            client.configureBlocking(false);

            ByteBuffer buffer = ByteBuffer.allocate(8192); //

            /**
             * 如果是select/poll： jvm里开启一个数组  fd7放进去
             * 如果是epoll， 通过系统调用 epoll_ctl( fd3【就是server】,ADD, fd7, EPOLLIN）
             */
            client.register(selector, SelectionKey.OP_READ, buffer);
            System.out.println("--------------------------------");
            System.out.println("新客户端: " + client.getRemoteAddress());
            System.out.println("--------------------------------");

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public static void main(String[] args) {

    }
}
