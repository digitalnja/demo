package com.ivanlechtmec;

import java.io.*;
import java.util.List;

public class SortedElementWriter<T> implements Operation {
    private final String outputFile;
    List<T> dataType;
    public SortedElementWriter(String outputFile, List<T> dataType){
        this.outputFile = outputFile;
        this.dataType = dataType;
    }

    @Override
    public void doOperation() {
        try(BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile)))){
            for(T element : dataType){
                writer.write(element.toString());
                writer.newLine();
            }

        }catch (IOException e){
            System.out.println("Проблема с записью в файл"+e.getMessage());
        }
    }
}
