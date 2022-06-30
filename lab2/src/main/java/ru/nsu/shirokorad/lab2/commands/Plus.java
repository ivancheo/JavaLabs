package ru.nsu.shirokorad.lab2.commands;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ru.nsu.shirokorad.lab2.constants.Constants;
import ru.nsu.shirokorad.lab2.stackCalculator.Context;
import ru.nsu.shirokorad.lab2.stackCalculator.ICommand;

import java.util.EmptyStackException;

public class Plus implements ICommand {
    private final Logger logger = LogManager.getLogger(getClass().getName());

    @Override
    public void execute(Context context) {
        logger.info("Plus started");
        try {
            if (context.stackSize() < Constants.MIN_STACK_SIZE_FOR_PLUS) throw new EmptyStackException();
            double a = context.stackPop();
            double b = context.stackPop();
            context.stackPush(a+b);
        } catch (EmptyStackException e) {
            logger.error("EmptyStackException");
        }
        logger.info("Plus finished");
    }
}
