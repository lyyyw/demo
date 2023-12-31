package com.example.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TestByteBuffer {
    public static void main(String[] args) {
        try (FileChannel channel = new FileInputStream("data.txt").getChannel()) {
            ByteBuffer buffer = ByteBuffer.allocate(10);
            channel.read(buffer);
            buffer.flip();
            while (buffer.hasRemaining()) {
            byte b = buffer.get();
                System.out.println((char)b);
            }

        } catch (IOException e) {
        }
    }
}
