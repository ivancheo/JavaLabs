package ru.nsu.shirokorad.lab2.commands;

import org.junit.jupiter.api.Test;
import ru.nsu.shirokorad.lab2.stackCalculator.Context;
import ru.nsu.shirokorad.lab2.stackCalculator.ICommand;

import static org.junit.jupiter.api.Assertions.*;

class DivisionTest {

    @Test
    void execute() {
        Context context = new Context();
        ICommand divisionCommand = new Division();

        context.stackPush(100);
        context.stackPush(10);
        divisionCommand.execute(context);
        assertEquals(10, context.stackPeek());

        context.stackPush(0);
        context.stackPush(1000);
        divisionCommand.execute(context);
        assertEquals(0, context.stackPeek());

        context.stackPush(60);
        context.stackPush(-12);
        divisionCommand.execute(context);
        assertEquals(-5, context.stackPeek());

        context.stackPush(1);
        context.stackPush(1);
        divisionCommand.execute(context);
        assertEquals(1, context.stackPeek());

        context.stackPush(-10);
        context.stackPush(-100);
        divisionCommand.execute(context);
        assertEquals(0.1, context.stackPeek());
    }
}