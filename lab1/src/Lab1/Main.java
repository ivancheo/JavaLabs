package Lab1;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {
            MyScanner scan = new MyScanner();
            Printer printer = new Printer();

            ErrorCatcher.throwIfError(args);
            Map<String, Integer> sortedMap = scan.getMap(args[Constants.INPUT_FILE]);
            printer.openFile(args[Constants.OUTPUT_FILE]);
            printer.printTable(sortedMap, scan.getWordsCount());
            printer.closeFile();
            System.out.println("success!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
