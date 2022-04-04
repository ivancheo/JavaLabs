package ru.nsu.shirokorad.lab1;



import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;


public class Printer {

    public void printTable (String fileName, Map<String, Integer> map, int wordsCount) {
        try (FileWriter fw = new FileWriter((fileName))) {
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                double wordFrequency = ((double) entry.getValue() / (double) wordsCount) * Constants.PERCENTS;
                wordFrequency = round(wordFrequency);
                fw.write(entry.getKey() + "," + entry.getValue() + "," + wordFrequency + "%");
                fw.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private double round (double value) {
        value *= Math.pow(10, Constants.DIGITS_AFTER_DOT);
        value = Math.ceil(value);
        value /= Math.pow(10, Constants.DIGITS_AFTER_DOT);
        return value;
    }
}
