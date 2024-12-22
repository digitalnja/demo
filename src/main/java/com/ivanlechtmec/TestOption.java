package com.ivanlechtmec;

import com.ivanlechtmec.default_option.DefaultOption;
import com.ivanlechtmec.directory_fullstatistic_option.SetDirectoryAndStatisticOption;

import java.util.ArrayList;
import java.util.List;

public class TestOption {
    public static void main(String[] args) {
        String fileName = "message2.txt";
        String directory = "C:\\Users\\Иван Лехтмец\\Desktop\\Repository\\resultSorting";
        String outputFileInt = "integers.txt";
        String outputFileFloat = "floats.txt";
        String outputFileStr = "strings.txt";
        ContainerOfList container = new ContainerOfList();
        DefaultOption defaultOption = new DefaultOption(container);
        SetDirectoryAndStatisticOption set = new SetDirectoryAndStatisticOption(container);

    }
}
