package com.ivanlechtmec;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Statistic {
    public static void main(String[] args) {
        try {
            FileOutputStream outputStream = new FileOutputStream("output_message.txt");
            FileInputStream inputStream = new FileInputStream("message.txt");
            byte[] buffer = new byte[1024];
            int byteRead;

            while ((byteRead = inputStream.read(buffer)) != -1){
                outputStream.write(buffer, 0, byteRead);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {

        }




    }

}
