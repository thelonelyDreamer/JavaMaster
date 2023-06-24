package org.example;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9000);
        while (true){
            try {
                Socket accept = serverSocket.accept();
                Scanner scanner = new Scanner(accept.getInputStream());
                while (scanner.hasNextLine()){
                    System.out.println(scanner.nextLine());
                }
                OutputStream outputStream = accept.getOutputStream();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
                writer.write("hello");
                writer.flush();
                writer.close();
            } catch (IOException e) {

            }
        }

    }
}