package cz.educanet.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Objects;

public class Game extends Application {

    public static Stage stage;

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent rootNode = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/mainMenu.fxml")));

        primaryStage.setTitle("Text Adventure Game");
        primaryStage.setScene(new Scene(rootNode, 1175, 720));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
