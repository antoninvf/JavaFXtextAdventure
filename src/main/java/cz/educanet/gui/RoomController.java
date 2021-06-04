package cz.educanet.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class RoomController {

    @FXML
    private Button button;

    public void onClicked(ActionEvent actionEvent) {
        button.setText("Drz hubu!!!");
    }
}
