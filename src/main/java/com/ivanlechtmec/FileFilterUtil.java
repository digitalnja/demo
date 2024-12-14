package com.ivanlechtmec;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class FileFilterUtil {

    public static void main(String[] args) {
        Config config = Config.parseArgs(args);

        if (config == null || config.inputFile == null) {
            System.out.println("Usage: java -jar util.jar [options] <input-file>");
            return;
        }

        try {
            processFile(config);
        } catch (Exception e) {
            System.err.println("Error during processing: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void processFile(Config config) throws IOException {
        Map<String, List<String>> data = new HashMap<>();
        data.put("integers", new ArrayList<>());
        data.put("floats", new ArrayList<>());
        data.put("strings", new ArrayList<>());

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(config.inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                classifyLine(line, data);
            }
        }

        writeOutputFiles(data, config);
        printStatistics(data, config);
    }

    private static void classifyLine(String line, Map<String, List<String>> data) {
        try {
            Integer.parseInt(line);
            data.get("integers").add(line);
        } catch (NumberFormatException e1) {
            try {
                Double.parseDouble(line);
                data.get("floats").add(line);
            } catch (NumberFormatException e2) {
                data.get("strings").add(line);
            }
        }
    }

    private static void writeOutputFiles(Map<String, List<String>> data, Config config) throws IOException {
        if (!data.get("integers").isEmpty()) {
            writeToFile(config.getOutputFileName("integers"), data.get("integers"), config.append);
        }
        if (!data.get("floats").isEmpty()) {
            writeToFile(config.getOutputFileName("floats"), data.get("floats"), config.append);
        }
        if (!data.get("strings").isEmpty()) {
            writeToFile(config.getOutputFileName("strings"), data.get("strings"), config.append);
        }
    }

    private static void writeToFile(String fileName, List<String> lines, boolean append) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileName),
                append ? StandardOpenOption.APPEND : StandardOpenOption.CREATE)) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        }
    }

    private static void printStatistics(Map<String, List<String>> data, Config config) {
        for (Map.Entry<String, List<String>> entry : data.entrySet()) {
            System.out.println("Statistics for " + entry.getKey() + ":");
            System.out.println("Count: " + entry.getValue().size());
            if (config.fullStatistics && (entry.getKey().equals("integers") || entry.getKey().equals("floats"))) {
                List<Double> numbers = entry.getValue().stream().map(Double::parseDouble).collect(Collectors.toList());
                System.out.println("Min: " + Collections.min(numbers));
                System.out.println("Max: " + Collections.max(numbers));
                System.out.println("Sum: " + numbers.stream().mapToDouble(Double::doubleValue).sum());
                System.out.println("Average: " + numbers.stream().mapToDouble(Double::doubleValue).average().orElse(0));
            } else if (config.fullStatistics && entry.getKey().equals("strings")) {
                OptionalInt minLength = entry.getValue().stream().mapToInt(String::length).min();
                OptionalInt maxLength = entry.getValue().stream().mapToInt(String::length).max();
                System.out.println("Shortest string length: " + minLength.orElse(0));
                System.out.println("Longest string length: " + maxLength.orElse(0));
            }
        }
    }

    static class Config {
        String outputDir = "";
        String prefix = "";
        boolean append = false;
        boolean fullStatistics = false;
        String inputFile;

        static Config parseArgs(String[] args) {
            Config config = new Config();
            for (int i = 0; i < args.length; i++) {
                switch (args[i]) {
                    case "-o":
                        if (i + 1 < args.length) {
                            config.outputDir = args[++i];
                        }
                        break;
                    case "-p":
                        if (i + 1 < args.length) {
                            config.prefix = args[++i];
                        }
                        break;
                    case "-a":
                        config.append = true;
                        break;
                    case "-f":
                        config.fullStatistics = true;
                        break;
                    case "-s":
                        config.fullStatistics = false;
                        break;
                    default:
                        if (config.inputFile == null) {
                            config.inputFile = args[i];
                        } else {
                            System.err.println("Unknown argument: " + args[i]);
                            return null;
                        }
                        break;
                }
            }
            return config;
        }

        String getOutputFileName(String type) {
            String fileName = prefix + type + ".txt";
            return outputDir.isEmpty() ? fileName : outputDir + File.separator + fileName;
        }
    }
}
