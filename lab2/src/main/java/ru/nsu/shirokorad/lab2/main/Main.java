package ru.nsu.shirokorad.lab2.main;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ru.nsu.shirokorad.lab2.constants.Constants;
import ru.nsu.shirokorad.lab2.stackCalculator.StackCalculator;


import java.io.File;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws Exception {
        logger.info("Main is started");
        StackCalculator stackCalculator = new StackCalculator();
        if (args.length > Constants.INPUT_CALC_ARGUMENTS_COUNT) {
            logger.error("incorrect count of arguments");
        }
        if (args.length == Constants.INPUT_CALC_ARGUMENTS_COUNT) {
            stackCalculator.fileCalculator(args[Constants.INPUT_FILE]);
        }
        else if (args.length == Constants.ZERO_ARGS) {
            stackCalculator.consoleCalculator();
        }
        logger.info("Main is finished");
    }
}
