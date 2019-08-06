package com.tavisca.workshops.practiceHttpServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public Server(int port) throws IOException {

        ServerSocket serverSocket=new ServerSocket(port);

        while (true){
            MyLogger.log("waiting for client");
        Socket socket=serverSocket.accept();
            MyLogger.log("connection established..");

        Thread t=new HandleMultipleClient(socket);
        t.start();

       }

    }


    public static void main(String[] args) throws IOException {

    Server server=new Server(8000);

    }
}