package com.company;



import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;


public class Printer {
    FileWriter fw;
    public void printTable (Map<String, Integer> map, int wordsCount) throws Exception {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            double wordFrequency;
            wordFrequency = ((double) entry.getValue() /  (double) wordsCount) * 100.0;
            wordFrequency *= 1000.0;
            wordFrequency = Math.ceil(wordFrequency);
            wordFrequency /= 1000.0;
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
}
