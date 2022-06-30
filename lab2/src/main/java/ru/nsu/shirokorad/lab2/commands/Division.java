package ru.nsu.shirokorad.lab2.commands;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ru.nsu.shirokorad.lab2.constants.Constants;
import ru.nsu.shirokorad.lab2.stackCalculator.Context;
import ru.nsu.shirokorad.lab2.stackCalculator.ICommand;

import java.util.EmptyStackException;

public class Division implements ICommand {
    private final Logger logger = LogManager.getLogger(getClass().getName());

    @Override
    public void execute(Context context) {
        logger.info("Division started");
        try {
            if (context.stackSize() < Constants.MIN_STACK_SIZE_FOR_PLUS) throw new EmptyStackException();
            double denumerator = context.stackPop();
            double numerator = context.stackPop();
            if (denumerator == Constants.ZERO) throw new ArithmeticException();
            context.stackPush(numerator / denumerator);
        } catch (EmptyStackException e) {
            logger.error("EmptyStackException");
        } catch (ArithmeticException e) {
            logger.error("ArithmeticException. You can't divide on zero!!");
        }
        logger.info("Division finished");
    }
}
