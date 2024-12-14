package com.ivanlechtmec;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Statistic {
    public static void main(String[] args) {
        String inputFile = "message.txt";
        List<Integer> ints = new ArrayList<>();
        List<Float> floats = new ArrayList<>();
        List<String> strings = new ArrayList<>();


        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile)));) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                line.trim();
                if (line.matches("-?\\d+")) {
                    ints.add(Integer.parseInt(line));
                } else if (line.matches("-?\\d+\\.\\d+")) {
                    floats.add(Float.parseFloat(line));
                } else {
                    strings.add(line);
                }
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        System.out.println(ints);
        System.out.println(floats);
        System.out.println(strings);
    }
}