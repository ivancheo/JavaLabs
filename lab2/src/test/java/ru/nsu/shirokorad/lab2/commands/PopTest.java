package ru.nsu.shirokorad.lab2.commands;

import org.junit.jupiter.api.Test;
import ru.nsu.shirokorad.lab2.stackCalculator.Context;
import ru.nsu.shirokorad.lab2.stackCalculator.ICommand;

import static org.junit.jupiter.api.Assertions.*;

class PopTest {

    @Test
    void execute() {
        Context context = new Context();
        ICommand popCommand = new Pop();

        context.stackPush(100);
        context.stackPush(-222);

        popCommand.execute(context);
        assertEquals(100, context.stackPeek());

        context.stackPush(0);
        context.stackPush(0);
        popCommand.execute(context);
        assertEquals(0, context.stackPeek());

        popCommand.execute(context);
        assertEquals(100, context.stackPeek());

        final int ONE_THOUSAND = 1000;
        for (int i = 0; i <= ONE_THOUSAND; i++) {
            context.stackPush(i);
        }
        for (int i = ONE_THOUSAND; i > 1; i--) {
            popCommand.execute(context);
            //System.out.println(i);
            assertEquals(i-1, context.stackPeek());
        }

    }
}