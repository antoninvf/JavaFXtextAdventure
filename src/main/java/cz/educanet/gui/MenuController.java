package cz.educanet.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MenuController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    // Main Menu
    public void onClickedStart(ActionEvent event) throws IOException {
        switchScene(event, "/rooms/room0.fxml");
    }

    public void onClickedOptions(ActionEvent event) throws IOException {
        switchScene(event, "/options.fxml");
    }

    public void onClickedExit(ActionEvent event) {
        System.exit(0);
    }

    // Options
    public void returnToMenu(ActionEvent event) throws IOException {
        switchScene(event, "/mainMenu.fxml");
    }

    // Character screen


    // Scene Switcher
    public void switchScene(ActionEvent event, String file) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(file)));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Text Adventure Game");
        stage.setScene(scene);
        stage.show();
    }
}
