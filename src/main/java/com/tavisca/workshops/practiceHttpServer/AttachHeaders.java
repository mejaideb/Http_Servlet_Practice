package com.tavisca.workshops.practiceHttpServer;

public class AttachHeaders {

    public String generateHeaders(String fileName, int lengthOfFile){
        String headers="";
        String startLine="HTTP/1.1 200 OK\n";
        headers=headers + startLine ;
        String contentType="Content-type: "+RequestedFileExtension.getContentType(fileName)+"\n";
        headers=headers+contentType;
        String contentLength = "Content-length: " +lengthOfFile+ "\n";
        headers=headers+contentLength;
        headers=headers+"\n";

        return headers;

    }
}
