package ru.nsu.shirokorad.lab3.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.io.FileWriter;
import java.io.IOException;

import static ru.nsu.shirokorad.lab3.Constants.SPLIT;
import static ru.nsu.shirokorad.lab3.Constants.TEMPORARY_SCORE_PATH;

public final class Score {

    private final IntegerProperty score = new SimpleIntegerProperty(0);

    public IntegerProperty scoreProperty() {
        return score;
    }

    public void addPoints(int additionalPoints, String userName){
        score.setValue(score.getValue() + additionalPoints);
        updateTemporaryScore(score.getValue(), userName);
    }

    private void updateTemporaryScore(int score, String userName) {
        try (var fw = new FileWriter(TEMPORARY_SCORE_PATH)){
            fw.write(score + SPLIT + userName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void reset() {
        score.setValue(0);
    }
}
