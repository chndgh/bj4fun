package com.snow.dream;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by dghcch on 2017/10/24.
 */
public class TestTest {


    public static void test() throws IOException {

        URL url = new URL("http://aaa");
        URLConnection conn = url.openConnection();
        conn.setConnectTimeout(3*1000);
        conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
        InputStream inputStream = conn.getInputStream();
        byte[] getData = readInputStream(inputStream);
        File saveDir = new File("D:\\work");
        if (!saveDir.exists()){
            saveDir.mkdir();
        }
        File file = new File(saveDir+File.separator+"download.mkv");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(getData);
        if (fos!=null){
            fos.close();
        }
        if(inputStream!=null){
            inputStream.close();
        }

        System.out.println("info: download success");
    }


    private static  byte[] readInputStream(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        return bos.toByteArray();
    }
}
