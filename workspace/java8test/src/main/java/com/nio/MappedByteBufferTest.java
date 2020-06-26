package com.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 *  韩顺平 netty视频 （java nio基础）
 * https://www.bilibili.com/video/BV1DJ411m7NR?p=18
 *
 */
public class MappedByteBufferTest {
    public static void main(String[] args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("1.txt", "rw");
        // 打开通道
        FileChannel channel = randomAccessFile.getChannel();

        /**
         * 参数1： FileChannel.MapMode.READ_WRITE 使用读写模式
         * 参数2： 0 可以直接修改的起始位置
         * 参数3： 5 映射到内存的大小，即将1.txt的多个字节映射到内存
         * 可以直接修改的范围是0-5
         */
        MappedByteBuffer mappedByteBuffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, 5);

        mappedByteBuffer.put(0, (byte) 'H');
        mappedByteBuffer.put(3, (byte) '9');

        randomAccessFile.close();

    }
}
