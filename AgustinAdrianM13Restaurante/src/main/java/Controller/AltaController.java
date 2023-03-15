/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Model.Reserva;
import com.mycompany.agustinadrianm13restaurante.DB.DaoReserva;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author adrian
 */
public class AltaController implements Initializable {

    @FXML
    private Pane panelAfegir;
    @FXML
    private Label labelTituloAfegir;
    @FXML
    private Label txtDataReserva;
    @FXML
    private DatePicker datePickerReserva;
    @FXML
    private Label labelHora;
    @FXML
    private TextField txtHoraReserva;
    @FXML
    private Label labelNpersonas;
    @FXML
    private TextField txtNpersonas;
    @FXML
    private Label labelTaula;
    @FXML
    private ComboBox<Integer> cmbTaula;
    @FXML
    private Label labelNomClient;
    @FXML
    private TextField txtNomClient;
    @FXML
    private Button btnAfegirReserva;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<Integer> opciones = FXCollections.observableArrayList(1, 2, 3, 4, 5);
    cmbTaula.setItems(opciones);
    }    

    @FXML
    private void afegirReservaClick(ActionEvent event) {
        try {
            //int idReserva, String dia, String hora, int npersones, int t, String nomClient, int telefon
            
            LocalDate date = datePickerReserva.getValue();
            
            String hora = txtHoraReserva.getText();
            int npersones = Integer.parseInt(txtNpersonas.getText());
            int taula = Integer.parseInt(cmbTaula.getValue().toString());
            String nom = txtNomClient.getText();
            System.out.println("data"+date);
            Reserva res = new Reserva(0,date.toString(),hora,npersones,taula,nom,000);
            DaoReserva.afegirReserva(res);
            Stage stage = (Stage) btnAfegirReserva.getScene().getWindow();
            stage.close();
        } catch (SQLException ex) {
            Logger.getLogger(AltaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
