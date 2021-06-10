package cz.educanet.logic;

import cz.educanet.gui.Game;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Controller {

    private Stage stage;
    private Scene scene;
    private Parent root;

    private double skeletonHP = 80;
    private int howMany = 0;

    @FXML
    public ProgressBar hpBar;
    @FXML
    public Text roomText;
    @FXML
    public Button fightButton;
    @FXML
    public Button proceedButton;
    @FXML
    public Pane fuckingskelly;
    @FXML
    public Button leftIdiotButton;

    // Main Menu
    public void onClickedStart(ActionEvent event) throws IOException {
        switchScene(event, "/startScreen.fxml");
    }

    public void onClickedOptions(ActionEvent event) throws IOException {
        switchScene(event, "/options.fxml");
    }

    public void onClickedExit(ActionEvent event) {
        System.exit(0);
    }

    public void returnToMenu(ActionEvent event) throws IOException {
        switchScene(event, "/mainMenu.fxml");
    }

    // Character screen
    public void enterDungeon(ActionEvent event) throws IOException {
        switchScene(event, "/room0.fxml");
    }

    // ROOM 01 - LEFT
    public void switchRoom1(ActionEvent event) throws IOException {
        switchScene(event, "/room1.fxml");
        hpBar.setProgress(Game.adventurerHP);
    }

    public void fight(ActionEvent event) throws IOException {
        double enemyRandDMG = Math.floor(Math.random() * (40 - 20 + 1) + 20);
        skeletonHP = skeletonHP - enemyRandDMG;
        String skeletonmsg = "You hit the skeleton for " + enemyRandDMG + "DMG. The skeleton is on " + skeletonHP + "HP.";

        if(skeletonHP < 0) {
            winUnlockButton();
        }
        else {
            // if ur luck is so bad, change it
            int min = 30;
            int max = 60;
            double randomDMG = Math.floor(Math.random() * (max - min + 1) + min);
            Game.adventurerHP = Game.adventurerHP - randomDMG;
            hpBar.setProgress(Game.adventurerHP / 100);
            roomText.setText(skeletonmsg + "\nThe skeleton hits you back for " + randomDMG + "DMG. You are on " + Game.adventurerHP + "HP.");
            if(Game.adventurerHP < 0) {
                gameOver(event);
            }
        }
    }

    public void winUnlockButton() {
        fightButton.setDisable(true);
        fuckingskelly.setVisible(false);
        proceedButton.setDisable(false);
        skeletonHP = 80;
        roomText.setText("You defeated the skeleton. You can now proceed.");
    }

    // ROOM 02 - RIGHT
    public void switchRoom2(ActionEvent event) throws IOException {
        switchScene(event, "/room2.fxml");
        hpBar.setProgress(Game.adventurerHP);
    }

    // ROOM 03 - BOARDED UP/ ONLY CAN ENTER ROOM 04
    public void switchRoom3(ActionEvent event) throws IOException {
        switchScene(event, "/room3.fxml");
        hpBar.setProgress(Game.adventurerHP);
    }

    public void ramIntoDoor(ActionEvent event) {
        leftIdiotButton.setDisable(true);
        hpBar.setProgress((Game.adventurerHP / 100) - 0.25);
        roomText.setText("What?.. You just rammed straight into the boarded up door..\nYou didn't even achieve anything, you just hurt yourself.");
    }

    // ROOM 04 - LAVA ROOM
    public void switchRoom4(ActionEvent event) throws IOException {
        switchScene(event, "/room4.fxml");
        hpBar.setProgress(Game.adventurerHP);
    }

    public void dontYouDare(ActionEvent event) throws IOException {
        if(howMany == 0) {
            roomText.setText("DON'T EVEN THINK ABOUT JUMPING INTO THAT LAVA POOL.");
        }
        else if(howMany > 0) {
            gameOver(event);
        }
        howMany++;
    }


    // ENDING - OUTSIDE
    public void switchEnd(ActionEvent event) throws IOException {
        switchScene(event, "/end.fxml");
    }


    // Scene Switcher
    public void switchScene(ActionEvent event, String file) throws IOException {
        if(Game.adventurerHP < 0) {
            gameOver(event);
        }
        else {
            howMany = 0;
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(file)));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setTitle("Text Adventure Game");
            stage.setScene(scene);
            stage.show();
        }
    }

    // Game Over Switch
    public void gameOver(ActionEvent event) throws IOException {
        Game.adventurerHP = 100;
        howMany = 0;
        skeletonHP = 80;
        System.out.println("YOU DIED");

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/gameOver.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("GAME OVER - YOU DIED");
        stage.setScene(scene);
        stage.show();
    }
}


