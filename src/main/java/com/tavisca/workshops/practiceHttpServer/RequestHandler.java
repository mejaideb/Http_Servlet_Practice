package com.tavisca.workshops.practiceHttpServer;

import java.io.BufferedInputStream;
import java.io.IOException;

public class RequestHandler {

    final BufferedInputStream in;
    public String fileName;
    public String methodName;


    public RequestHandler(BufferedInputStream in) {
        this.in = in;

    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName.replace("/", "");
    }

    public String getMethodName() {

        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public void handleRequest() throws IOException {
        byte[] b = new byte[256];
        in.read(b);
        String clientRequest = new String(b);

        String[] parseClientRequest = clientRequest.split(" ");
        setMethodName(parseClientRequest[0]);
        setFileName(parseClientRequest[1]);
    }


}

