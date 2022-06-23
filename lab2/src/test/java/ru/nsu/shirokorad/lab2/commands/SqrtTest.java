package ru.nsu.shirokorad.lab2.commands;

import org.junit.jupiter.api.Test;
import ru.nsu.shirokorad.lab2.stackCalculator.Context;
import ru.nsu.shirokorad.lab2.stackCalculator.ICommand;

import static org.junit.jupiter.api.Assertions.*;

class SqrtTest {

    @Test
    void execute() {
        Context context = new Context();
        ICommand sqrtCommand = new Sqrt();


        context.stackPush(1);
        sqrtCommand.execute(context);
        assertEquals(1, context.stackPeek());

        context.stackPush(0);
        sqrtCommand.execute(context);
        assertEquals(0, context.stackPeek());

        context.stackPush(0.564*0.564);
        sqrtCommand.execute(context);
        assertEquals(0.564, context.stackPeek());

        context.stackPush(700*700);
        sqrtCommand.execute(context);
        assertEquals(700, context.stackPeek());

        context.stackPush(4);
        sqrtCommand.execute(context);
        assertEquals(2, context.stackPeek());

        context.stackPush(100);
        sqrtCommand.execute(context);
        assertEquals(10, context.stackPeek());
    }
}