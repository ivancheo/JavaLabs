package ru.nsu.shirokorad.lab2.stackCalculator;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ru.nsu.shirokorad.lab2.constants.Constants;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class StackCalculator {
    private Context context;
    private Scanner scanner;
    private CommandFactory factory;
    private static final Logger logger = LogManager.getLogger(StackCalculator.class);

    public StackCalculator() throws FileNotFoundException {
        context = new Context();
        factory = new CommandFactory();
    }

    private void workWithLine(String line) {
        if (line.charAt(0) != '#') {
            logger.info("work with line is started");
            Parser parser = new Parser(line);
            String commandName = parser.getCommandName();
            parser.updateContext(context);
            factory.getCommand(commandName).execute(context);
            logger.info("work with line is ended");
        } else {
            logger.info("line is comment");
        }
    }

    public void fileCalculator(String inputPath) {
        logger.info("file calculator is started");
        try (FileReader fr = new FileReader(inputPath)) {
            scanner = new Scanner(fr);
            while (scanner.hasNextLine()) {
                logger.info("scan new line");
                String line = scanner.nextLine();
                workWithLine(line);
            }
        } catch (IOException e) {
            logger.error("IOException!");
        }
        logger.info("file calculator is finished");
    }
    public void consoleCalculator () {
        logger.info("console calculator is started");
        scanner = new Scanner(System.in);
        while (true) {
            String line = scanner.nextLine();
            logger.info("read new line");
            if (line.equals(Constants.STOP_CONSOLE_CALC)) {
                logger.info("read command STOP. stop console calculation");
                break;
            }
            workWithLine(line);
        }
        logger.info("console calculator is finished");
    }
}
