package com.ivanlechtmec.default_option;

import com.ivanlechtmec.ContainerOfList;
import com.ivanlechtmec.InputFileReader;
import com.ivanlechtmec.ShortStatisticOption;
import com.ivanlechtmec.SortedElementWriter;

public class DefaultOption {
    private final ContainerOfList container;

    public DefaultOption(ContainerOfList container) {
        this.container = container;
    }
    public InputFileReader readFile(String inputFile){
        return new InputFileReader(inputFile,container);
    }
    public SortedElementWriter<Integer> writeInts(String outputFile){
        return new SortedElementWriter<>(outputFile, container.ints);
    }
    public SortedElementWriter<Float> writeFloats(String outputFile){
        return new SortedElementWriter<>(outputFile, container.floats);
    }
    public SortedElementWriter<String> writeStr(String outputFile){
        return new SortedElementWriter<>(outputFile, container.strings);
    }
    public ShortStatisticOption shortStatistic(ContainerOfList container){
        return new ShortStatisticOption(container);
    }

}
