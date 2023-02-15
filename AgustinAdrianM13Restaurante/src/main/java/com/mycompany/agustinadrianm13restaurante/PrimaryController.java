package com.mycompany.agustinadrianm13restaurante;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
    
    @FXML
    private Button btnComandes;

    @FXML
    private Button btnReserves;

    @FXML
    void clickBtnComandes(ActionEvent event) {

    }

    @FXML
    void clickBtnReserves(ActionEvent event) {

    }
}
