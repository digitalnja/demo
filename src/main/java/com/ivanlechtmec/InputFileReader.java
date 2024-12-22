package com.ivanlechtmec;

import java.io.*;


public class InputFileReader implements Operation {
    private final String inputFile;
    private final ContainerOfList container;

    public InputFileReader(String inputFile, ContainerOfList container) {
        this.inputFile = inputFile;
        this.container = container;
    }

    @Override
    public void doOperation() {
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile)))){
            String str;
            while ((str = bufferedReader.readLine()) != null){
                str.trim();
                if(str.matches("-?\\d+")){
                    container.ints.add(Integer.parseInt(str));
                } else if (str.matches("-?\\d+(\\.\\d+)?([eE][+-]?\\d+)?")) {
                    container.floats.add(Float.parseFloat(str));
                } else {
                    container.strings.add(str);
                }
            }
        } catch (IOException e){
            System.out.println("Проблема с чтением файла" + e.getMessage());
        }
    }
}