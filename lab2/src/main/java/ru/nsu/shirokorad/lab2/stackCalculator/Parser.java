package ru.nsu.shirokorad.lab2.stackCalculator;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Parser {
    private static int COMMAND_NAME_POSITION = 0;

    private String commandName;
    private String[] params;
    private static final Logger logger = LogManager.getLogger(Parser.class);


    Parser(String line){
        if (line.charAt(0) != '#') {
            logger.info("parsing line");
            String[] words = line.split(" ");
            commandName = words[COMMAND_NAME_POSITION];
            int paramsCount = words.length - 1;
            params = new String[paramsCount];
            // копируем length-1 элементов начиная с 1 индекса, записываем начиная с 0 элемента
            System.arraycopy(words, 1, params, 0, paramsCount);
        }
    }

    public String getCommandName () {
        return commandName;
    }

    public void updateContext (Context context) {
        context.setCommandParameters(params);
    }
}
