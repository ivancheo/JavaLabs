package ru.nsu.shirokorad.lab1;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {
            MyScanner scan = new MyScanner();
            Printer printer = new Printer();

            ErrorCatcher.throwIfError(args);
            Map<String, Integer> sortedMap = scan.getMap(args[Constants.INPUT_FILE]);

            printer.printTable(args[Constants.OUTPUT_FILE], sortedMap, scan.getWordsCount());
            System.out.println("success!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
