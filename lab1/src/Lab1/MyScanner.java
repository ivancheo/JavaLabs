package Lab1;


import Lab1.Parser;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;


public class MyScanner {
    private Parser parser;
    private int wordsCount;
    public Map<String, Integer> getMap (String fileName) {
        try (FileReader fr = new FileReader(fileName);
                Scanner scan = new Scanner(fr)) {
                parser = new Parser();
                while (scan.hasNextLine()) {
                    parser.updateMap(scan.nextLine());
                }
                wordsCount = parser.getWordsCount();
            } catch (IOException e){
                e.printStackTrace();
            }
        return parser.getSortedHashMap();
    }

    public int getWordsCount() {
        return wordsCount;
    }

}
