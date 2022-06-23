package ru.nsu.shirokorad.lab2.exceptions;

public class CommandSyntaxErrorException extends Exception {
    public CommandSyntaxErrorException(String message) {
        super(message);
    }

    public CommandSyntaxErrorException() {
    }
}
