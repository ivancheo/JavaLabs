package ru.nsu.shirokorad.lab2.commands;

import org.junit.jupiter.api.Test;
import ru.nsu.shirokorad.lab2.stackCalculator.Context;
import ru.nsu.shirokorad.lab2.stackCalculator.ICommand;

import static org.junit.jupiter.api.Assertions.*;

class MinusTest {

    @Test
    void execute() {
        Context context = new Context();
        ICommand minusCommand = new Minus();


        context.stackPush(100);
        context.stackPush(10);
        minusCommand.execute(context);
        assertEquals(90, context.stackPeek());

        context.stackPush(-500);
        context.stackPush(-200);
        minusCommand.execute(context);
        assertEquals(-300, context.stackPeek());

        context.stackPush(-222);
        context.stackPush(0);
        minusCommand.execute(context);
        assertEquals(-222, context.stackPeek());

        context.stackPush(6000);
        context.stackPush(-5000);
        minusCommand.execute(context);
        assertEquals(11000, context.stackPeek());

        context.stackPush(1000);
        context.stackPush(0);
        minusCommand.execute(context);
        assertEquals(1000, context.stackPeek());

        context.stackPush(1);
        context.stackPush(1);
        minusCommand.execute(context);
        assertEquals(0, context.stackPeek());

    }
}