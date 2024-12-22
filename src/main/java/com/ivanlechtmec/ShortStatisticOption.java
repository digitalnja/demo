package com.ivanlechtmec;

import java.util.List;

public class ShortStatisticOption implements  Operation{
    private final ContainerOfList container;


    public ShortStatisticOption(ContainerOfList container) {
        this.container = container;
    }

    @Override
    public void doOperation() {
        if(!container.ints.isEmpty()){
            int countInts = container.ints.size();
            System.out.println("Количество целых чисел записанных в файл: "+countInts);
        }else{
            System.out.println("Во входном файле не обнаружено int's");
        }
        if(!container.floats.isEmpty()){
            int countFloats = container.floats.size();
            System.out.println("Количество вещественных чисел: "+countFloats);
        }else {
            System.out.println("Во входном файле не обранужено float's");
        }
        if(!container.strings.isEmpty()){
           int countStrings = container.strings.size();
            System.out.println("Количество строк записанных в файл: "+countStrings);
        }else {
            System.out.println("Во входном файле не обнаружено string's ");
        }

    }
}
