package com.mycompany.agustinadrianm13restaurante;

import Controller.ReservaController;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PrimaryController {

//    @FXML
//    private void switchToSecondary() throws IOException {
//        App.setRoot("secondary");
//    }
    
    @FXML
    private Button btnComandes;

    @FXML
    private Button btnReserves;

    @FXML
    void clickBtnComandes(ActionEvent event) {

    }

    @FXML
    void clickBtnReserves(ActionEvent event)  {
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Reserva.fxml"));
            Parent root = loader.load();
            
            ReservaController controllerReserva = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
}
