package com.meuapp.service;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class FileDownloader {

    public static void downloadFile(String fileURL, String saveDir) throws IOException {
        URL url = new URL(fileURL);
        URLConnection connection = url.openConnection();
        connection.connect();

        try (InputStream inputStream = connection.getInputStream();
             BufferedInputStream bis = new BufferedInputStream(inputStream);
             FileOutputStream fis = new FileOutputStream(saveDir)) {

            byte[] buffer = new byte[1024];
            int count;
            while ((count = bis.read(buffer)) != -1) {
                fis.write(buffer, 0, count);
            }
        }

        System.out.println("Arquivo baixado: " + saveDir);
    }
}
