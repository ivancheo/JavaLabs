package ru.nsu.shirokorad.lab1;

import java.util.*;
import java.util.stream.Collectors;

public class Parser {
    private HashMap <String, Integer> unsortedMap;
    private int wordsCount;
    public Parser() {
        unsortedMap = new HashMap<>();
        wordsCount = 0;
    }
    public int getWordsCount() {
        return wordsCount;
    }
    public Map <String, Integer> getSortedHashMap () {
        Map<String, Integer> sortedMap = unsortedMap.entrySet().stream()
                .sorted(Comparator.comparingInt(e -> -e.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> { throw new AssertionError(); },
                        LinkedHashMap::new
                ));
        return sortedMap;
    }
    public void updateMap (String string) {
        ArrayList<String> words = WordParser.getWords(string);
        for (String word : words) {
            wordsCount++;
            if (unsortedMap.containsKey(word)) {
                int newCount = unsortedMap.get(word) + 1;
                unsortedMap.put(word, newCount);
            }
            else {
                unsortedMap.put(word, 1);
            }
        }
    }
}
