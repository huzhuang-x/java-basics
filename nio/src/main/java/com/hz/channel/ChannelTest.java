package com.hz.channel;



import org.junit.Test;
import sun.awt.CharsetString;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * @author HuZhuang
 * @date 2022-01-06 20:50
 */
public class ChannelTest {


    @Test
    public void testFileChannel() throws IOException {

        RandomAccessFile aFile = new RandomAccessFile("D:\\vpn密码.txt", "rw");
        FileChannel channel = aFile.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(64);

        int bytesRead = channel.read(buffer);
        while (bytesRead != -1) {
            System.out.println("read " + bytesRead);
            buffer.flip();
            while (buffer.hasRemaining()) {
                System.out.print((char)buffer.get());
            }
            buffer.clear();
            bytesRead = channel.read(buffer);
        }
        aFile.close();
    }
}
