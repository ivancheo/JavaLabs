package ru.nsu.shirokorad.lab2.commands;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ru.nsu.shirokorad.lab2.constants.Constants;
import ru.nsu.shirokorad.lab2.exceptions.CommandSyntaxErrorException;
import ru.nsu.shirokorad.lab2.exceptions.IncorrectArgsCountException;
import ru.nsu.shirokorad.lab2.stackCalculator.Context;
import ru.nsu.shirokorad.lab2.stackCalculator.ICommand;

public class Push implements ICommand {
    private final Logger logger = LogManager.getLogger(getClass().getName());

    private boolean isNumber(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public void execute(Context context) {
        logger.info("Push started");
        try {
            String[] params = context.getCommandParameters();
            if (params.length != Constants.PUSH_PARAMS_COUNT) throw new IncorrectArgsCountException();
            var map = context.getDefinesMap();
            String firstParam = params[0];
            if (isNumber(firstParam)) {
                logger.info("pushing just number");
                context.stackPush((Double.parseDouble(firstParam)));
            } else if (map.containsKey(firstParam)) {
                logger.info("pushing number from defined variable");
                context.stackPush(map.get(firstParam));
            } else {
                throw new CommandSyntaxErrorException();
            }
        } catch (IncorrectArgsCountException e) {
            logger.error("IncorrectArgsCountException");
        } catch (CommandSyntaxErrorException e) {
            logger.error("CommandSyntaxErrorException");
        }
        logger.info("Push finished");
    }

    @Override
    public int getParamsCount() {
        return 1;
    }
}
