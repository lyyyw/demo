package com.example.demo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

public class Server {
    public static void main(String[] args) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(16);
        ServerSocketChannel channel = ServerSocketChannel.open();
        channel.bind(new InetSocketAddress(8080));
        List<SocketChannel> channels = new ArrayList<>();
        while (true){
            System.out.println("connecting..........");
            SocketChannel sc = channel.accept();//阻塞方法
            System.out.println("connected,.........." + sc);
            channels.add(sc);
            for (SocketChannel socketChannel : channels) {
                socketChannel.read(buffer);
                buffer.flip();
                while (buffer.hasRemaining()) {
                    byte b = buffer.get();
                    System.out.println((char)b);
                }
                buffer.clear();
            }
        }
    }
}
