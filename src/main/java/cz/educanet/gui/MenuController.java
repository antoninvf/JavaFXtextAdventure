package cz.educanet.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuController {

    @FXML
    private Button buttonStart;
    @FXML
    private Button buttonOptions;
    @FXML
    private Button buttonExit;

    // Main Menu
    public void onClickedStart(ActionEvent actionEvent) {
        buttonStart.setText("Drz hubu!!!");
    }

    public void onClickedOptions(ActionEvent actionEvent) {
        buttonOptions.setText("Options open");
    }

    public void onClickedExit(ActionEvent actionEvent) {
        System.exit(0);
    }

    // Options


    // Character screen
}
