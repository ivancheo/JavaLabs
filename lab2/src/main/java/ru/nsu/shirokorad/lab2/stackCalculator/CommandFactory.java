package ru.nsu.shirokorad.lab2.stackCalculator;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ru.nsu.shirokorad.lab2.constants.Constants;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class CommandFactory {
    private Map<String, ICommand> commandsMap;
    private static final Logger logger = LogManager.getLogger(CommandFactory.class);

    public CommandFactory() throws FileNotFoundException {
        logger.info("called CommandFactory() constructor");
        commandsMap = new HashMap<>();
        generateCommandsMap();
    }

    public ICommand getCommand(String commandName) {
        logger.info("get command " + commandName);
        return commandsMap.get(commandName.toUpperCase(Locale.ROOT));
    }

    private void generateCommandsMap() {
        logger.info("generation commands map is started");
        try (FileReader fr = new FileReader(Constants.COMMANDS_PATH_TXT)){
            Scanner scan = new Scanner(fr);
            while (scan.hasNextLine()){
                updateMap(scan.nextLine());
            }
        } catch (IOException e) {
            logger.error("IOException");
        } catch (ClassNotFoundException e){
            logger.error("ClassNotFoundException");
        } catch (NoSuchMethodException e) {
            logger.error("NoSuchMethodException");
        } catch (InvocationTargetException e) {
            logger.error("InvocationTargetException");
        } catch (InstantiationException e){
            logger.error("InstantiationException");
        } catch (IllegalAccessException e){
            logger.error("IllegalAccessException");
        } catch (Exception e) {
            logger.error("some Exception!");
        }
        logger.info("generation commands map is finished");
    }

    private void updateMap(String line) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String[] words = line.split(" ");
        Class<?> commClass = Class.forName(words[Constants.COMMAND_NAME_POSITION]);
        ICommand comm = (ICommand) commClass.getDeclaredConstructor().newInstance();
        commandsMap.put(words[Constants.KEY_POSITION], comm);
        logger.info(words[Constants.KEY_POSITION] + " command put in map");
    }
}
