package com.tavisca.workshops.practiceHttpServer;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Respond {

    public void sendRespondToRequest(BufferedOutputStream out,String fileName){

        FileInputStream fis= null;
        try {
            fis = new FileInputStream(fileName);
            int lengthOfFile=fis.available();
            byte[] fileData = new byte[lengthOfFile];
            fis.read(fileData);
            AttachHeaders attachHeaders=new AttachHeaders();
            String headers=attachHeaders.generateHeaders(fileName,lengthOfFile);
            out.write(headers.getBytes());
            out.write(fileData);
        }catch (FileNotFoundException e) {
            if(fileName.isEmpty())
                sendRespondToRequest(out,"index.html");
            else
                sendRespondToRequest(out,"filenotfound.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
