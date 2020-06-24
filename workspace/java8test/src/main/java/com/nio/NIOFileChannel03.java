package com.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * NIO 文件拷贝， 在项目下写一个1.txt， 复制到2.txt
 *
 * UTF8下一个汉字占三个字节
 */
public class NIOFileChannel03 {

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream01 = new FileInputStream("1.txt");
        FileChannel fileChannel01 = fileInputStream01.getChannel();

        FileInputStream fileInputStream02 = new FileInputStream("2.txt");
        FileChannel fileChannel02 = fileInputStream02.getChannel();

        ByteBuffer buff = ByteBuffer.allocate(5);

        while (true) {
            buff.clear();// 这里如果不清空，每次循环读取的size都不变
            int size = fileChannel01.read(buff);
            if (size == 1) { // 表示读完了
                break;
            }
            buff.flip(); // 读切换为写
            fileChannel02.write(buff);
        }
        fileInputStream01.close();
        fileInputStream02.close();

        // 以上是通过buffer复制，可以使用filechannel api 完成复制
        fileChannel02.transferFrom(fileChannel01,0, fileChannel01.size());
        fileChannel01.close();
        fileChannel02.close();
        fileInputStream01.close();
        fileInputStream02.close();
        // -end
    }
}
