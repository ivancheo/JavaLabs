package ru.nsu.shirokorad.lab3.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

import static ru.nsu.shirokorad.lab3.Constants.*;
import static ru.nsu.shirokorad.lab3.Constants.GAME_NAME;

public class LeaderboardController {



    @FXML
    private Text firstPlace;
    @FXML
    private Text secondPlace;
    @FXML
    private Text thirdPlace;
    @FXML
    private Text fourthPlace;
    @FXML
    private Text fifthPlace;
    @FXML
    private Text sixthPlace;
    @FXML
    private Text seventhPlace;
    @FXML
    private Text eighthPlace;

    final int PLACES_COUNT = 8;


    @FXML
    private Button cleanTableButton;

    @FXML
    private Button fillDefaultScoresButton;

    @FXML
    private Button mainMenuButton;


    @FXML
    void initialize() {
        updateTable(LEADERBOARD_SCORES_PATH);
    }


    private void updateTable(String leaderboardScoresPath) {
        moveTempScore();
        sortScores(leaderboardScoresPath);
        fillPlaces(leaderboardScoresPath);
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

    private void fillPlaces(String leaderboardScoresPath) {
        File fin = new File(leaderboardScoresPath);
        try (FileReader fr = new FileReader(fin);
             Scanner scan = new Scanner(fr)) {
            for (int i = 1; i <= PLACES_COUNT; i++) {
                if (scan.hasNextLine()) {
                    fillPlace(i, scan.nextLine());
                } else break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void fillPlace(int placeNumber, String line) {
        switch (placeNumber) {
            case 1:
                firstPlace.setText(line);
                break;
            case 2:
                secondPlace.setText(line);
                break;
            case 3:
                thirdPlace.setText(line);
                break;
            case 4:
                fourthPlace.setText(line);
                break;
            case 5:
                fifthPlace.setText(line);
                break;
            case 6:
                sixthPlace.setText(line);
                break;
            case 7:
                seventhPlace.setText(line);
                break;
            case 8:
                eighthPlace.setText(line);
                break;
        }
    }

    private void sortScores(String leaderboardScoresPath) {
        var userScores = getAllUserScores(leaderboardScoresPath);
        var sortedUserScores = getSortedMap(userScores);
        updateLeaderboardFile(sortedUserScores, leaderboardScoresPath);
    }

    private void updateLeaderboardFile(Map<String, Integer> userScores, String leaderboardScoresPath) {
        try (FileWriter fw = new FileWriter((leaderboardScoresPath))) {
            int countPlaces = 0;
            for (Map.Entry<String, Integer> entry : userScores.entrySet()) {
                fw.write(entry.getValue() + " " + entry.getKey());
                fw.write("\n");
                countPlaces++;
                if (countPlaces == PLACES_COUNT) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private Map<String, Integer> getSortedMap (HashMap<String, Integer> unsortedMap) {
        Map<String, Integer> sortedMap = unsortedMap.entrySet().stream()
                .sorted(Comparator.comparingInt(e -> -e.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> { throw new AssertionError(); },
                        LinkedHashMap::new
                ));
        return sortedMap;
    }


    private HashMap<String, Integer> getAllUserScores(String leaderboardScoresPath) {
        var allScores = new HashMap<String, Integer>();
        File fin = new File(leaderboardScoresPath);
        try (FileReader fr = new FileReader(fin);
             Scanner scan = new Scanner(fr)){
            while (scan.hasNextLine()){
                String line = scan.nextLine(); // содержит счет и юзернейм
                var words = line.split(SPLIT, TWO_SPLIT);
                int userScore = Integer.parseInt(words[SCORE_POS]);
                String userName = words[USER_NAME_POS];
                if (allScores.containsKey(userName) && (allScores.get(userName) > userScore)) {
                    continue;
                }
                allScores.put(userName, userScore);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return allScores;
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

    //очищает файл тоже
    public void pressCleanTableButton() {
        try {
            new PrintWriter(LEADERBOARD_SCORES_PATH).close();
            new PrintWriter(TEMPORARY_SCORE_PATH).close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 1; i <= PLACES_COUNT; i++) {
            fillPlace(i, EMPTY_STRING);
        }

    }


    public void pressFillDefaultScores() {
        try {
            new PrintWriter(LEADERBOARD_SCORES_PATH).close();
            new PrintWriter(TEMPORARY_SCORE_PATH).close();
            copyFileUsingFileStreams(new File(DEFAULT_SCORES_PATH), new File(LEADERBOARD_SCORES_PATH));
        } catch (Exception e) {
            e.printStackTrace();
        }
        fillPlaces(DEFAULT_SCORES_PATH);
    }


    private static void copyFileUsingFileStreams(File source, File dest)
            throws IOException {
        InputStream input = null;
        OutputStream output = null;
        try {
            input = new FileInputStream(source);
            output = new FileOutputStream(dest);
            byte[] buf = new byte[1024];
            int bytesRead;
            while ((bytesRead = input.read(buf)) > 0) {
                output.write(buf, 0, bytesRead);
            }
        } finally {
            input.close();
            output.close();
        }
    }
}
