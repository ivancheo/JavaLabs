package ru.nsu.shirokorad.lab2.commands;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ru.nsu.shirokorad.lab2.constants.Constants;
import ru.nsu.shirokorad.lab2.exceptions.DefineSecondArgNotDoubleException;
import ru.nsu.shirokorad.lab2.exceptions.IncorrectArgsCountException;
import ru.nsu.shirokorad.lab2.stackCalculator.Context;
import ru.nsu.shirokorad.lab2.stackCalculator.ICommand;

public class Define implements ICommand {
    private final Logger logger = LogManager.getLogger(getClass().getName());

    private boolean isNumber(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public void execute(Context context) {
        logger.info("Define started");
        try {
            var params = context.getCommandParameters();
            if (params.length != Constants.DEFINE_PARAMS_COUNT) throw new IncorrectArgsCountException();
            var defines = context.getDefinesMap();
            var varName = params[Constants.KEY_POSITION];
            var strValue = params[Constants.VALUE_POS];

            if (!isNumber(strValue)) throw new DefineSecondArgNotDoubleException();
            double dValue = Double.parseDouble(strValue);
            if (defines.containsKey(varName)) {
                logger.info("defines map already have this variable. replace");
                defines.replace(varName, dValue);
            } else {
                logger.info("put variable " + varName + " with value " + dValue + " in map");
                defines.put(varName, dValue);
            }
            context.setDefinesMap(defines);
        } catch (IncorrectArgsCountException e) {
            logger.error("Args count of define is incorrect");
        } catch (DefineSecondArgNotDoubleException e) {
            logger.error("second arg of define is not double");
        }
        logger.info("Define finished");
    }

    @Override
    public int getParamsCount() {
        return 2;
    }
}
