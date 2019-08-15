package com.tavisca.workshops.practiceHttpServer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;

public class HandleMultipleClient extends Thread {

    Socket socket;

    public HandleMultipleClient(Socket socket) {
        this.socket = socket;
    }


    public void run() {

        try (BufferedInputStream in = new BufferedInputStream(socket.getInputStream());
             BufferedOutputStream out = new BufferedOutputStream(socket.getOutputStream())) {
            RequestHandler requestHandler = new RequestHandler(in);
            requestHandler.handleRequest();
            String methodName = requestHandler.getMethodName();
            String fileName = requestHandler.getFileName();

            if (methodName.equals("GET")) {
                Respond respond = new Respond();
                respond.sendRespondToRequest(out, fileName);
            }
            out.flush();
            socket.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
