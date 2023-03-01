/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author adrian
 */
public class ModificacioController implements Initializable {

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
    private ComboBox<?> cmbTaula;
    @FXML
    private Label labelNomClient;
    @FXML
    private TextField txtNomClient;
    @FXML
    private Button btnModificarReserva;
    @FXML
    private Pane panelModificar;
    @FXML
    private CheckBox checkBoxArribada;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void modificarReservaClick(ActionEvent event) {
    }
    
}
