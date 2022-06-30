package ru.nsu.shirokorad.lab2.commands;

import org.junit.jupiter.api.Test;
import ru.nsu.shirokorad.lab2.stackCalculator.Context;
import ru.nsu.shirokorad.lab2.stackCalculator.ICommand;

import static org.junit.jupiter.api.Assertions.*;

class DefineTest {

    @Test
    void execute() {
        Context context = new Context();
        ICommand defineCommand = new Define();


        String[] params1 = {"a", "10"};
        context.setCommandParameters(params1);
        defineCommand.execute(context);
        var defines1 = context.getDefinesMap();
        assertEquals(10 ,defines1.get("a"));

        String[] params2 = {"s", "-1234567890"};
        context.setCommandParameters(params2);
        defineCommand.execute(context);
        var defines2 = context.getDefinesMap();
        assertEquals(-1234567890 ,defines2.get("s"));

        String[] params3 = {"wpepaeoqwoeqeqwmkeqe", "0"};
        context.setCommandParameters(params3);
        defineCommand.execute(context);
        var defines3 = context.getDefinesMap();
        assertEquals(0 ,defines3.get(params3[0]));

        //тест на перезапись
        String[] params1_ = {"a", "2022"};
        context.setCommandParameters(params1_);
        defineCommand.execute(context);
        var defines1_ = context.getDefinesMap();
        assertEquals(2022 ,defines1_.get("a"));


        // test with push
        ICommand pushCommand = new Push();
        String[] params4 = {"java", "1000"};
        context.setCommandParameters(params4);
        defineCommand.execute(context);
        String[] params4_1 = {"java"};
        context.setCommandParameters(params4_1);
        pushCommand.execute(context);
        assertEquals(1000, context.stackPeek());


        String[] params5 = {"test1", "1000"};
        context.setCommandParameters(params5);
        defineCommand.execute(context);
        String[] params5_1 = {"test2", "-1000"};
        context.setCommandParameters(params5_1);
        defineCommand.execute(context);

        String[] params5_2 = {"test1"};
        context.setCommandParameters(params5_2);
        pushCommand.execute(context);
        assertEquals(1000, context.stackPeek());
        String[] params5_3 = {"test2"};
        context.setCommandParameters(params5_3);
        pushCommand.execute(context);
        assertEquals(-1000, context.stackPeek());
    }
}
