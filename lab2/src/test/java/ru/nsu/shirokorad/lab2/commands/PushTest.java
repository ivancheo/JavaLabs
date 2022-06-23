package ru.nsu.shirokorad.lab2.commands;

import org.junit.jupiter.api.Test;
import ru.nsu.shirokorad.lab2.stackCalculator.Context;
import ru.nsu.shirokorad.lab2.stackCalculator.ICommand;

import static org.junit.jupiter.api.Assertions.*;

class PushTest {

    @Test
    void execute() {
        Context context = new Context();
        ICommand pushCommand = new Push();


        String[] params = {"100"};
        context.setCommandParameters(params);
        pushCommand.execute(context);
        assertEquals(100, context.stackPeek());

        String[] params1 = {"2"};
        context.setCommandParameters(params1);
        pushCommand.execute(context);
        assertEquals(2, context.stackPeek());

        String[] params2 = {"-23"};
        context.setCommandParameters(params2);
        pushCommand.execute(context);
        assertEquals(-23, context.stackPeek());

        String[] params3 = {"0"};
        context.setCommandParameters(params3);
        pushCommand.execute(context);
        assertEquals(0, context.stackPeek());

        String[] params4 = {"-0.666"};
        context.setCommandParameters(params4);
        pushCommand.execute(context);
        assertEquals(-0.666, context.stackPeek());

        String[] params5 = {"0"};
        context.setCommandParameters(params5);
        pushCommand.execute(context);
        assertEquals(0, context.stackPeek());
    }
}