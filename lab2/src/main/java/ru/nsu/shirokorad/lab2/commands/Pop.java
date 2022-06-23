package ru.nsu.shirokorad.lab2.commands;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ru.nsu.shirokorad.lab2.stackCalculator.Context;
import ru.nsu.shirokorad.lab2.stackCalculator.ICommand;

import java.util.EmptyStackException;

public class Pop implements ICommand {
    private final Logger logger = LogManager.getLogger(getClass().getName());

    @Override
    public void execute(Context context) {
        logger.info("Pop[deleted last elem] started");
        try {
            if (context.stackIsEmpty()) throw new EmptyStackException();
            context.stackPop();
        } catch (EmptyStackException e) {
            logger.error("EmptyStackException!!");
        }
        logger.info("Pop finished");
    }
}
