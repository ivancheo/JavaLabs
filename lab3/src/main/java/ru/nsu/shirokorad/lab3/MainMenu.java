package ru.nsu.shirokorad.lab3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

import static ru.nsu.shirokorad.lab3.Constants.*;

public class MainMenu extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(MAIN_MENU_FXML_PATH));
        Scene scene = new Scene(fxmlLoader.load(), MENU_WINDOW_WIDTH, MENU_WINDOW_HEIGHT);

        stage.setTitle(GAME_NAME);
        stage.getIcons().add(new Image(this.getClass().getResourceAsStream(ICON_PATH)));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}