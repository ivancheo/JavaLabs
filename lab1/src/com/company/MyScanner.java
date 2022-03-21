package com.company;


import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;


public class MyScanner {
    FileReader fr;
    Scanner scan;
    String fileName;
    int wordsCount;
    public Map<String, Integer> getMap (String fileName) throws IOException {
        this.fileName = fileName;
        openFile();
        Parser parser = new Parser();
        while (scan.hasNextLine()) {
            parser.updateMap(scan.nextLine());
        }
        fr.close();
        wordsCount = parser.getWordsCount();
        return parser.getSortedHashMap();
    }

    public int getWordsCount() {
        return wordsCount;
    }

    private void openFile () throws IOException {
        fr = new FileReader(fileName);
        scan = new Scanner(fr);
    }
}
