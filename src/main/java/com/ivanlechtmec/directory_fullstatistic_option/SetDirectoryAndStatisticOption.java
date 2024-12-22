package com.ivanlechtmec.directory_fullstatistic_option;

import com.ivanlechtmec.ContainerOfList;

import com.ivanlechtmec.FileUtil;
import com.ivanlechtmec.SortedElementWriter;

import java.nio.file.Path;

public class SetDirectoryAndStatisticOption {
    private final ContainerOfList container;

    public SetDirectoryAndStatisticOption(ContainerOfList container) {
        this.container = container;
    }
    public SortedElementWriter<Integer> writeInts(String directory, String outputFile){
        String fullPath = FileUtil.buildFilePath(directory, outputFile);
        return new SortedElementWriter<>(outputFile, container.ints);
    }
    public SortedElementWriter<Float> writeFloats(String directory,String outputFile){
        String fullPath = FileUtil.buildFilePath(directory, outputFile);
        return new SortedElementWriter<>(outputFile, container.floats);
    }
    public SortedElementWriter<String> writeStr(String directory,String outputFile){
        String fullPath = FileUtil.buildFilePath(directory, outputFile);
        return new SortedElementWriter<>(outputFile, container.strings);
    }

}
