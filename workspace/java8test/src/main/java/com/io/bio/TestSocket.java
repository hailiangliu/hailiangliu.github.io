package com.io.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TestSocket {
    public static void main(String[] args) {

        try {
            ServerSocket server = new ServerSocket(9999);

            while (true) {
                final Socket accept = server.accept();
                System.out.println(" client [" + accept.getPort()+"] connect ");
                new Thread(() -> {
                        try {
                            InputStream inputStream = accept.getInputStream();
                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                            while (true) {
                                System.out.println(bufferedReader.readLine());
                            }

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                }).start();

            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
