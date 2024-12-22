package com.ivanlechtmec;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FullStatisticOption implements Operation {
    private final ContainerOfList container;

    public FullStatisticOption(ContainerOfList container) {
        this.container = container;
    }

    @Override
    public void doOperation() {
        if(!container.ints.isEmpty()){
            int sum = container.ints.stream().mapToInt(Integer::intValue).sum();
            double avg = container.ints.stream().mapToInt(Integer::intValue).average().orElse(0.0);
            int min = container.ints.stream().min(Comparator.naturalOrder()).orElseThrow(() -> new RuntimeException("список пуст"));
            int max = container.ints.stream().max(Comparator.naturalOrder()).orElseThrow(() -> new RuntimeException("список пуст"));
            System.out.println("Статистика целых чисел (полная)");
            System.out.println("Максимальное число: "+max);
            System.out.println("Минимальное число: "+min);
            System.out.println("Количество чисел записанных в файл: "+container.ints.size());
            System.out.println("Сумма чисел: "+sum);
            System.out.println("Среднее арифметичекое чисел записанных  в файл: "+avg);
            System.out.println("--------------------");
        }else{
            System.out.println("лист с целыми числами пуст");
        }
        if (!container.floats.isEmpty()) {
            float sum = (float) container.floats.stream().mapToDouble(Float::doubleValue).sum();
            double average = container.floats.stream().mapToDouble(Float::doubleValue).average().orElse(0.0);
            float min = container.floats.stream().min(Comparator.naturalOrder()).orElseThrow(() -> new RuntimeException("список пуст"));
            float max = container.floats.stream().max(Comparator.naturalOrder()).orElseThrow(() -> new RuntimeException("список пуст"));
            System.out.println("Статистика вещественных чисел (полная)");
            System.out.println("Максимальное число: "+max);
            System.out.println("минимальное число: " +min);
            System.out.println("Количество чисел записанных  в файл: " +container.floats.size());
            System.out.println("Сумма чисел: "+sum);
            System.out.println("Среднее арифметичекое чисел записанных  в файл: "+average);
            System.out.println("---------------------");
        } else {
            System.out.println("лист с вещественными числами пуст");
        }
        if(!container.strings.isEmpty()){
            String max = container.strings.stream().max(Comparator.comparingInt(String::length))
                    .orElse("сравниваемые елементы отсутсвуют");
            int countMax = max.length();
            String min = container.strings.stream().min(Comparator.comparingInt(String::length))
                    .orElse("сравниваемые елементы отсутсвуют");
            int countMin = min.length();
            int count = container.strings.size();
            System.out.println("Статистика строк (полная)");
            System.out.println("Количество строк записанных в файл: "+count);
            System.out.println("Размер самой длинной строки: "+countMax);
            System.out.println("Размер самой короткой строки: "+countMin);

        }
    }
}
