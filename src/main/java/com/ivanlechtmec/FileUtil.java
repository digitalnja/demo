package com.ivanlechtmec;

import java.io.File;

public class FileUtil {

        public static String buildFilePath(String directory, String fileName) {
            File dir = new File(directory);
            if (!dir.exists()) {
                if (dir.mkdirs()) {
                    System.out.println("Директория создана: " + dir.getAbsolutePath());
                } else {
                    System.out.println("Не удалось создать директорию: " + dir.getAbsolutePath());
                }
            }
            return directory + File.separator + fileName;
        }
    }


