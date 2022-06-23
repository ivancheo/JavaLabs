package ru.nsu.shirokorad.lab2.commands;

import org.junit.jupiter.api.Test;
import ru.nsu.shirokorad.lab2.stackCalculator.Context;
import ru.nsu.shirokorad.lab2.stackCalculator.ICommand;

import static org.junit.jupiter.api.Assertions.*;

class PlusTest {

    @Test
    void execute() {
        Context context = new Context();
        ICommand plusCommand = new Plus();


        context.stackPush(0);
        context.stackPush(0);
        plusCommand.execute(context);
        assertEquals(0, context.stackPeek());

        context.stackPush(100000);
        context.stackPush(100000);
        plusCommand.execute(context);
        assertEquals(200000, context.stackPeek());

        context.stackPush(100);
        context.stackPush(10);
        plusCommand.execute(context);
        assertEquals(110, context.stackPeek());

        context.stackPush(-500);
        context.stackPush(-200);
        plusCommand.execute(context);
        assertEquals(-700, context.stackPeek());

        context.stackPush(-222);
        context.stackPush(0);
        plusCommand.execute(context);
        assertEquals(-222, context.stackPeek());

        context.stackPush(6000);
        context.stackPush(-5000);
        plusCommand.execute(context);
        assertEquals(1000, context.stackPeek());

        context.stackPush(1000);
        context.stackPush(0);
        plusCommand.execute(context);
        assertEquals(1000, context.stackPeek());

        context.stackPush(1);
        context.stackPush(1);
        plusCommand.execute(context);
        assertEquals(2, context.stackPeek());
    }
}