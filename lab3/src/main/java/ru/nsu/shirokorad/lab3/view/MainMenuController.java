package ru.nsu.shirokorad.lab3.view;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

import static ru.nsu.shirokorad.lab3.Constants.*;

public class MainMenuController {
    @FXML
    private Button aboutButton;

    @FXML
    private Button newGameButton;

    @FXML
    private Button leaderboardButton;

    @FXML
    private Button exitButton;

    public void pressExit(){
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }


    public void pressAboutButton() {
        Stage stage = (Stage) aboutButton.getScene().getWindow();
        stage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(ABOUT_FXML_PATH));
        Parent rootNode = null;
        try {
            rootNode = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage = new Stage();
        Scene scene = new Scene(rootNode, MENU_WINDOW_WIDTH, MENU_WINDOW_HEIGHT);
        stage.setTitle(GAME_NAME);
        stage.getIcons().add(new Image(this.getClass().getResourceAsStream(ICON_PATH)));
        stage.setScene(scene);
        stage.show();
    }

    public void pressLeaderboardButton() {
        Stage stage = (Stage) leaderboardButton.getScene().getWindow();
        stage.close();


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(LEADERBOARD_FXML_PATH));
        Parent rootNode = null;
        try {
            rootNode = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage = new Stage();
        Scene scene = new Scene(rootNode, MENU_WINDOW_WIDTH, MENU_WINDOW_HEIGHT);
        stage.setTitle(GAME_NAME);
        stage.getIcons().add(new Image(this.getClass().getResourceAsStream(ICON_PATH)));
        stage.setScene(scene);
        stage.show();
    }

    public void pressNewGameButton() {
        Stage stage = (Stage) newGameButton.getScene().getWindow();
        stage.close();


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(USER_NAME_WINDOW_FXML_PATH));
        Parent rootNode = null;
        try {
            rootNode = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage = new Stage();
        Scene scene = new Scene(rootNode, MENU_WINDOW_WIDTH, MENU_WINDOW_HEIGHT);
        stage.setTitle(GAME_NAME);
        stage.getIcons().add(new Image(this.getClass().getResourceAsStream(ICON_PATH)));
        stage.setScene(scene);
        stage.show();
    }
}
