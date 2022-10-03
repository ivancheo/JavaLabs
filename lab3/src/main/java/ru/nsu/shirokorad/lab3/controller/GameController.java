package ru.nsu.shirokorad.lab3.controller;

import ru.nsu.shirokorad.lab3.model.events.EventSource;
import ru.nsu.shirokorad.lab3.model.events.InputEventListener;
import ru.nsu.shirokorad.lab3.model.events.MoveEvent;
import ru.nsu.shirokorad.lab3.model.*;
import ru.nsu.shirokorad.lab3.model.ClearRow;
import ru.nsu.shirokorad.lab3.model.DownData;
import ru.nsu.shirokorad.lab3.model.Board;
import ru.nsu.shirokorad.lab3.view.TetrisController;

import static ru.nsu.shirokorad.lab3.Constants.*;

public class GameController implements InputEventListener {
    private String userName;
    private Board board = new Board(BOARD_WIDTH, BOARD_HEIGHT);

    private final TetrisController viewGuiController;

    public GameController(TetrisController guiController, String userName) {
        this.userName = userName;
        viewGuiController = guiController;
        board.createNewBrick();
        viewGuiController.setEventListener(this);
        viewGuiController.initGameView(board.getBoardMatrix(), board.getViewData());
        viewGuiController.bindScore(board.getScore().scoreProperty());
    }

    @Override
    public DownData onDownEvent(MoveEvent event) {
        boolean canMove = board.moveBrickDown();
        ClearRow clearRow = null;
        if (!canMove) {
            board.mergeBrickToBackground();
            clearRow = board.clearRows();
            if (clearRow.getRemovedLines() > 0) {
                board.getScore().addPoints(clearRow.getScoreBonus(), userName);
            }
            if (board.createNewBrick()) {
                viewGuiController.gameOver();
            }

            viewGuiController.refreshGameBackground(board.getBoardMatrix());

        }
        else {
            if (event.getEventSource() == EventSource.USER) {
                board.getScore().addPoints(POINT_FOR_PRESS_DOWN, userName);
            }
        }
        return new DownData(clearRow, board.getViewData());
    }

    @Override
    public ViewData onLeftEvent(MoveEvent event) {
        board.moveBrickLeft();
        return board.getViewData();
    }

    @Override
    public ViewData onRightEvent(MoveEvent event) {
        board.moveBrickRight();
        return board.getViewData();
    }

    @Override
    public ViewData onRotateEvent(MoveEvent event) {
        board.rotateLeftBrick();
        return board.getViewData();
    }


}
