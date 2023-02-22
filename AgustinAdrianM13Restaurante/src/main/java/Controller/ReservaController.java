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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author adrian
 */
public class ReservaController implements Initializable {

    @FXML
    private TableView<?> tableViewReserves;
    @FXML
    private TableColumn<?, ?> tableColumnIdReserva;
    
    @FXML
    private TableColumn<?, ?> tableColumnDia;
    @FXML
    private TableColumn<?, ?> tableColumnHora;
    @FXML
    private TableColumn<?, ?> tableColumnNpersonas;
    @FXML
    private TableColumn<?, ?> tableColumnIdTaula;
    @FXML
    private TableColumn<?, ?> tableColumnNomClient;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tableColumnIdReserva.getStyleClass().add("name-column");
    }    
    
     @FXML
    private Button btnAlta;

    @FXML
    private Button btnArribadaClients;

    @FXML
    private Button btnConsulta;

    @FXML
    private Button btnEsborrar;

    @FXML
    private Button btnModificacio;

    @FXML
    void btnAltaClick(ActionEvent event) {

    }

    @FXML
    void btnArribadaClick(ActionEvent event) {

    }

    @FXML
    void btnConsultaClick(ActionEvent event) {

    }

    @FXML
    void btnEsborrarClick(ActionEvent event) {

    }

    @FXML
    void btnModificacioClick(ActionEvent event) {

    }
    
}
