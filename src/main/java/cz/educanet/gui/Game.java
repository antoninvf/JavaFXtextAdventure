package cz.educanet.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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

    public void switchScene(String fxmlFile)
    {

        FXMLLoader loader = new FXMLLoader(getClass()
                .getResource(fxmlFile));
        Parent root;
        try
        {
            root = (Parent)loader.load();
            if(fxmlFile.equals("calculator.fxml"))
            {
                MenuController menucon = (MenuController)loader.getController();
                menucon.setModel(new MenuController(menucon));
                menucon.setLogic(this);
            }
            else if(fxmlFile.equals("TestSwitch.fxml"))
            {
                TestSwitch controller = (TestSwitch)loader.getController();
                controller.setLogic(this);
            }
            this.stage.setScene(new Scene(root));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    public static void main(String[] args) {
        launch(args);
    }
}
