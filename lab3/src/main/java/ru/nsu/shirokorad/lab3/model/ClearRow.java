package ru.nsu.shirokorad.lab3.model;

public final class ClearRow {

    private final int removedLines;
    private final int[][] newMatrix;
    private final int scoreBonus;

    public ClearRow(int removedLines, int[][] newMatrix, int scoreBonus) {
        this.removedLines = removedLines;
        this.newMatrix = newMatrix;
        this.scoreBonus = scoreBonus;
    }

    public int getRemovedLines() {
        return removedLines;
    }

    public int[][] getNewMatrix() {
        return MatrixOperations.copy(newMatrix);
    }

    public int getScoreBonus() {
        return scoreBonus;
    }
}
