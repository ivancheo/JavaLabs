package ru.nsu.shirokorad.lab3.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import ru.nsu.shirokorad.lab3.controller.GameController;

import java.io.*;
import java.util.ResourceBundle;

import static ru.nsu.shirokorad.lab3.Constants.*;
import static ru.nsu.shirokorad.lab3.Constants.GAME_NAME;

public class UserNameWindowController {

    @FXML
    private TextField userName;

    @FXML
    private Button readyButton;

    @FXML
    private Button mainMenuButton;


    public void pressReadyButton() {
        moveTempScore();
        String name = userName.getText();
        if (name.isEmpty()) {
            name = UNNAMED_USER;
        }
        if (name.length() <= MAX_USER_NAME_LENGHT) {
            Stage stage = (Stage) readyButton.getScene().getWindow();
            stage.close();

            ResourceBundle resources = null;
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(TETRIS_FXML_PATH), resources);
            Parent rootNode = null;
            try {
                rootNode = fxmlLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage = new Stage();
            Scene scene = new Scene(rootNode, TETRIS_WINDOW_WIDTH, TETRIS_WINDOW_HEIGHT);
            stage.setTitle(GAME_NAME);
            stage.getIcons().add(new Image(this.getClass().getResourceAsStream(ICON_PATH)));
            stage.setScene(scene);
            stage.show();
            new GameController(fxmlLoader.getController(), name);
        }
    }

    public void pressMainMenuButton() {
        Stage stage = (Stage) mainMenuButton.getScene().getWindow();
        stage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(MAIN_MENU_FXML_PATH));
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

    private void moveTempScore() {
        try (FileReader fr = new FileReader(TEMPORARY_SCORE_PATH);
             BufferedReader reader = new BufferedReader(fr);
             FileWriter fw = new FileWriter(LEADERBOARD_SCORES_PATH, true);
             BufferedWriter writer = new BufferedWriter(fw)) {

            String line = reader.readLine();
            if (line != null) {
                writer.write(line);
                writer.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
