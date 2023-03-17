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
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.stage.Stage;

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
    private ComboBox<Integer> cmbTaula;
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
    
       @FXML
    private TextField txtNumeroTelefono;
    
    private Reserva reserva;

    /**
     * Initializes the controller class.
     */
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
 
    }    

    @FXML
    private void modificarReservaClick(ActionEvent event) {
         LocalDate date = datePickerReserva.getValue();
            
            String hora = txtHoraReserva.getText();
            int npersones = Integer.parseInt(txtNpersonas.getText());
            int taula = Integer.parseInt(cmbTaula.getValue().toString());
            String nom = txtNomClient.getText();
            int nTelefon = Integer.parseInt(txtNumeroTelefono.getText());
            Reserva res = new Reserva(reserva.getNumReserva(),date.toString(),hora,npersones,taula,nom,nTelefon);
        try {
            DaoReserva.modificarReserva(res);
        } catch (SQLException ex) {
            Logger.getLogger(ModificacioController.class.getName()).log(Level.SEVERE, null, ex);
        }
            Stage stage = (Stage) btnModificarReserva.getScene().getWindow();
            stage.close();
        
    }
    
    public void initAttributes(Reserva r ) {
        ObservableList<Integer> taula = FXCollections.observableArrayList(r.getT());
        this.reserva = r;
        LocalDate fecha = LocalDate.parse(r.getData());
        this.datePickerReserva.setValue(fecha);
        this.txtHoraReserva.setText(r.getHora());
        this.txtNomClient.setText(r.getNomClient());
        this.txtNpersonas.setText(String.valueOf(r.getQuantPersones()));
        this.cmbTaula.setItems(taula);
        this.cmbTaula.getSelectionModel().selectFirst();
        this.txtNumeroTelefono.setText(String.valueOf(r.getTelf()));
        
    }
    
    
}
