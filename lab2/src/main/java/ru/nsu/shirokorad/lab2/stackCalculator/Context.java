package ru.nsu.shirokorad.lab2.stackCalculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

// класс содержит стэк, мапу с определенными значениям и параметрами команды
public class Context {
    private Stack<Double> stack;
    private Map<String, Double> definesMap;
    private String[] commandParameters;
    private static final Logger logger = LogManager.getLogger(Context.class);

    public Context() {
        logger.info("called Context() constructor");
        stack = new Stack<>();
        definesMap = new HashMap<>();
    }

    //return size of stack
    public int stackSize() {
        return stack.size();
    }

    //return true if stack is empty
    public boolean stackIsEmpty() {
        return stack.isEmpty();
    }

    //return and delete top element
    public double stackPop() {
        double value = stack.pop();
        logger.info("pop " + value + " from stack");
        return value;
    }

    //push elem to stack
    public void stackPush(double value) {
        logger.info("Push " + value + " in stack");
        stack.push(value);
    }

    //return top element
    public double stackPeek() {
        logger.info("start stackPeek()");
        double value = stack.peek();
        logger.info("peek " + value + " from stack");
        return value;
    }


    public Map<String, Double> getDefinesMap() {
        return definesMap;
    }
    public void setDefinesMap(Map<String, Double> map) {
        this.definesMap = map;
    }

    public String[] getCommandParameters() {
        return commandParameters;
    }
    public void setCommandParameters(String[] commParams) {
        logger.info("set command params: ");
        for (int i = 0; i < commParams.length; i++) {
            logger.info("param " + i + " is " + commParams[i]);
        }
        this.commandParameters = commParams;
    }

}
