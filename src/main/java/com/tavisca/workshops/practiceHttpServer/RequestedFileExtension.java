package com.tavisca.workshops.practiceHttpServer;

import java.util.HashMap;

public class RequestedFileExtension {


    public static HashMap<String, String> extensionMap = new HashMap<String, String>() {{
        put("txt", "text/plain");
        put("html", "text/html");
        put("css", "text/css");
        put("jpg", "image/jpg");
        put("jpeg", "image/jpeg");
        put("png", "image/png");
        put("xml", "text/xml");

    }};


    public static String getContentType(String fileName) {
        String[] splits=fileName.split("\\.");
        String extension=splits[splits.length-1];
        return extensionMap.get(extension);
    }
}
