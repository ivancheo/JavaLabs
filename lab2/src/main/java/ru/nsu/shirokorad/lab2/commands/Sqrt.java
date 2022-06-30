package ru.nsu.shirokorad.lab2.commands;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ru.nsu.shirokorad.lab2.constants.Constants;
import ru.nsu.shirokorad.lab2.stackCalculator.Context;
import ru.nsu.shirokorad.lab2.stackCalculator.ICommand;

import java.util.EmptyStackException;

public class Sqrt implements ICommand {
    private final Logger logger = LogManager.getLogger(getClass().getName());

    @Override
    public void execute(Context context) {
        logger.info("Sqrt started");
        try {
            if (context.stackIsEmpty()) throw new EmptyStackException();
            double value = context.stackPop();
            if (value < Constants.ZERO) throw new IllegalArgumentException();
            context.stackPush(Math.sqrt(value));
        } catch (EmptyStackException e) {
            logger.error("EmptyStackException");
        } catch (IllegalArgumentException e) {
            logger.error("Value can't be < 0!!!");
        }
        logger.info("Sqrt finished");
    }
}

