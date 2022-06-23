package ru.nsu.shirokorad.lab2.commands;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ru.nsu.shirokorad.lab2.constants.Constants;
import ru.nsu.shirokorad.lab2.stackCalculator.Context;
import ru.nsu.shirokorad.lab2.stackCalculator.ICommand;

import java.util.EmptyStackException;

public class Multiply implements ICommand {
    private final Logger logger = LogManager.getLogger(getClass().getName());

    @Override
    public void execute(Context context) {
        logger.info("Multiply started");
        try {
            if (context.stackSize() < Constants.MIN_STACK_SIZE_FOR_PLUS) throw new EmptyStackException();
            context.stackPush(context.stackPop() * context.stackPop());
        } catch (EmptyStackException e) {
            logger.error("EmptyStackException!!!!");
        }
        logger.info("Multiply finished");
    }
}
