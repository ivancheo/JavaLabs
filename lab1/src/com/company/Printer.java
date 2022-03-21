package com.company;



import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;


public class Printer {
    private FileWriter fw;
    public void printTable (Map<String, Integer> map, int wordsCount) throws Exception {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            double wordFrequency = ((double) entry.getValue() /  (double) wordsCount) * Constants.PERCENTS;
            wordFrequency = round(Constants.DIGITS_AFTER_DOT, wordFrequency);
            fw.write(entry.getKey() + "," + entry.getValue() + "," + wordFrequency + "%");
            fw.write("\n");
        }
    }
    public void openFile (String fileName) throws IOException {
        fw = new FileWriter(fileName);
    }
    public void closeFile () throws IOException {
        fw.close();
    }
    private double round (int digitsAfterDot, double value) {
        value *= Math.pow(10, digitsAfterDot);
        value = Math.ceil(value);
        value /= Math.pow(10, digitsAfterDot);
        return value;
    }
}
