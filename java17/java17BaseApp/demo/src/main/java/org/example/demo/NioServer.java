package org.example.demo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Set;

/**
 * @author 23167
 * @description Java is the best language
 * @date 2023/6/27--@7:52
 */
public class NioServer implements Demonstrable{
    @Override
    public void demo(String[] agrV) {
        try {
            // Create a ServerSocketChannel and configure it to listen for incoming connections
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(8080));
            serverSocketChannel.configureBlocking(false);
            Selector selector = Selector.open();
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            // Wait for incoming connections
            while (true) {
                int linkNode = selector.select();
                if(linkNode<1){
                    continue;
                }
                Set<SelectionKey> keys = selector.keys();
                for (SelectionKey key : keys) {
                    if (key.isConnectable()) {

                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
