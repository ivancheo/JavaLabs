package ru.nsu.shirokorad.lab2.commands;

import org.junit.jupiter.api.Test;
import ru.nsu.shirokorad.lab2.stackCalculator.Context;
import ru.nsu.shirokorad.lab2.stackCalculator.ICommand;

import static org.junit.jupiter.api.Assertions.*;

class MultiplyTest {

    @Test
    void execute() {
        Context context = new Context();
        ICommand multyCommand = new Multiply();

        context.stackPush(1);
        context.stackPush(1);
        multyCommand.execute(context);
        assertEquals(1, context.stackPeek());

        context.stackPush(-1);
        context.stackPush(1);
        multyCommand.execute(context);
        assertEquals(-1, context.stackPeek());

        context.stackPush(0);
        context.stackPush(1);
        multyCommand.execute(context);
        assertEquals(0, context.stackPeek());

        context.stackPush(100);
        context.stackPush(0);
        multyCommand.execute(context);
        assertEquals(0, context.stackPeek());

        context.stackPush(0);
        context.stackPush(0);
        multyCommand.execute(context);
        assertEquals(0, context.stackPeek());

        context.stackPush(800);
        context.stackPush(0.5);
        multyCommand.execute(context);
        assertEquals(400, context.stackPeek());

        context.stackPush(700);
        context.stackPush(700);
        multyCommand.execute(context);
        assertEquals(700*700, context.stackPeek());

        context.stackPush(-5);
        context.stackPush(-20);
        multyCommand.execute(context);
        assertEquals(100, context.stackPeek());
    }
}