package ru.nsu.shirokorad.lab2.stackCalculator;

public interface ICommand {
    void execute (Context context);

    default int getParamsCount() {
        return 0;
    }
}
