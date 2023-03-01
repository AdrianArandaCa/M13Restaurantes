/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Model.Reserva;
import Model.Utils;
import com.mycompany.agustinadrianm13restaurante.DB.DaoReserva;
import com.mycompany.agustinadrianm13restaurante.DB.ReservaTV;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author adrian
 */
public class ReservaController implements Initializable {

    @FXML
    private TableView<ReservaTV> tableViewReserves;
    @FXML
    private TableColumn<ReservaTV, SimpleIntegerProperty> tableColumnIdReserva;
    
    @FXML
    private TableColumn<ReservaTV, SimpleStringProperty> tableColumnDia;
    @FXML
    private TableColumn<ReservaTV, SimpleStringProperty> tableColumnHora;
    @FXML
    private TableColumn<ReservaTV, SimpleIntegerProperty> tableColumnNpersonas;
    @FXML
    private TableColumn<ReservaTV, SimpleIntegerProperty> tableColumnIdTaula;
    @FXML
    private TableColumn<ReservaTV, SimpleStringProperty> tableColumnNomClient;    
    /*@FXML
    private TableColumn<ReservaTV, SimpleStringProperty> tableColumnTelefon;*/


    /**
     * Initializes the controller class.
     *     private SimpleIntegerProperty numReserva = new SimpleIntegerProperty();
    private SimpleIntegerProperty t = new SimpleIntegerProperty();
    private SimpleStringProperty nomClient = new SimpleStringProperty();
    private SimpleIntegerProperty telf= new SimpleIntegerProperty();

     */
    ObservableList<ReservaTV> reservestv;
    ReservaTV reservatv;
    @Override
    
    public void initialize(URL url, ResourceBundle rb) {
        tableColumnIdReserva.setCellValueFactory(new PropertyValueFactory<>("numReserva"));
        tableColumnDia.setCellValueFactory(new PropertyValueFactory<>("data"));
        tableColumnHora.setCellValueFactory(new PropertyValueFactory<>("hora"));
        tableColumnNpersonas.setCellValueFactory(new PropertyValueFactory<>("quantPersones"));
        tableColumnIdTaula.setCellValueFactory(new PropertyValueFactory<>("t"));        
        tableColumnNomClient.setCellValueFactory(new PropertyValueFactory<>("nomClient"));        
        /*tableColumnTelefon.setCellValueFactory(new PropertyValueFactory<>("telf"));*/


        
        // Inicialitzar l'ObservableList
        reservestv = FXCollections.observableArrayList();
        // Agafar tots els registres de la taula
        /*int numReserva, int t, String nomClient, int telf, String data, int quantPersones,String hora*/
        DaoReserva dao = new DaoReserva();
        
        try {
            ArrayList<Reserva> reserves = dao.llistaTots();
            
            // Omplim l'observableList
            for(Reserva reserva : reserves){
                ReservaTV rva = new ReservaTV(
                        reserva.getNumReserva(),
                        reserva.getT(),
                        reserva.getNomClient(),
                        reserva.getTelf(),
                        Utils.formatDateToTable(reserva.getData()),
                        reserva.getQuantPersones(),
                        reserva.getHora()
                );
                
                reservestv.add(rva);
            }
            
            //Assignar l'observableList a la taula
            tableViewReserves.setItems(reservestv);
        
        } catch (SQLException ex) {
            //Logger.getLogger(SecondaryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
     @FXML
    private Button btnAlta;

    @FXML
    private Button btnArribadaClients;


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
    void btnEsborrarClick(ActionEvent event) {

    }

    @FXML
    void btnModificacioClick(ActionEvent event) {

    }
    
}
