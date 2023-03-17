/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Model.Reserva;
import Model.Utils;
import com.mycompany.agustinadrianm13restaurante.DB.DaoReserva;
import Model.ReservaTV;
import java.io.IOException;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author adrian
 */
public class ReservaController implements Initializable {

    @FXML
    private TableView<Reserva> tableViewReserves;
    @FXML
    private TableColumn<Reserva, Integer> tableColumnIdReserva;
    
    @FXML
    private TableColumn<Reserva, String> tableColumnDia;
    @FXML
    private TableColumn<Reserva, String> tableColumnHora;
    @FXML
    private TableColumn<Reserva, Integer> tableColumnNpersonas;
    @FXML
    private TableColumn<Reserva, Integer> tableColumnIdTaula;
       @FXML
    private TableColumn<Reserva, Integer> tableColumnTelefon;
     
    /*@FXML
    private TableColumn<ReservaTV, SimpleStringProperty> tableColumnTelefon;*/


    /**
     * Initializes the controller class.
     *     private SimpleIntegerProperty numReserva = new SimpleIntegerProperty();
    private SimpleIntegerProperty t = new SimpleIntegerProperty();
    private SimpleStringProperty nomClient = new SimpleStringProperty();
    private SimpleIntegerProperty telf= new SimpleIntegerProperty();

     */
    ObservableList<Reserva> reservestv;
    ReservaTV reservatv;
    @FXML
    private TableColumn<ReservaTV, SimpleStringProperty> tableColumnNomClient;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         tableColumnIdReserva.setCellValueFactory(new PropertyValueFactory<>("numReserva"));
        tableColumnIdTaula.setCellValueFactory(new PropertyValueFactory<>("t"));
        tableColumnNomClient.setCellValueFactory(new PropertyValueFactory<>("nomClient"));
       tableColumnTelefon.setCellValueFactory(new PropertyValueFactory<>("telf"));
        tableColumnDia.setCellValueFactory(new PropertyValueFactory<>("data"));
        tableColumnNpersonas.setCellValueFactory(new PropertyValueFactory<>("quantPersones"));
        tableColumnHora.setCellValueFactory(new PropertyValueFactory<>("hora"));
       

                this.carregarTaula();
        
//        // Inicialitzar l'ObservableList
//        reservestv = FXCollections.observableArrayList();
//        // Agafar tots els registres de la taula
//        /*int numReserva, int t, String nomClient, int telf, String data, int quantPersones,String hora*/
//        DaoReserva dao = new DaoReserva();
//        
//        try {
//            ArrayList<Reserva> reserves = dao.llistaTots();
//
//            // Omplim l'observableList
//            for(Reserva reserva : reserves){
//                Reserva rva = new Reserva(reserva.getNumReserva(),reserva.getData(),
//                        reserva.getHora(),reserva.getQuantPersones(),reserva.getT(),
//                        reserva.getNomClient(),reserva.getTelf());
//                        
//                
//                System.out.println("NOM DEL CLIENT : "+reserva.getNomClient());
//                reservestv.add(rva);
//            }
//            
//            //Assignar l'observableList a la taula
//            tableViewReserves.setItems(reservestv);
//            
//        
//        } catch (SQLException ex) {
//            //Logger.getLogger(SecondaryController.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }    
    public void carregarTaula() {
        reservestv = FXCollections.observableArrayList();
        // Agafar tots els registres de la taula
        /*int numReserva, int t, String nomClient, int telf, String data, int quantPersones,String hora*/
        DaoReserva dao = new DaoReserva();
        
        try {
            ArrayList<Reserva> reserves = dao.llistaTots();

            // Omplim l'observableList
            for(Reserva reserva : reserves){
                Reserva rva = new Reserva(reserva.getNumReserva(),reserva.getData(),
                        reserva.getHora(),reserva.getQuantPersones(),reserva.getT(),
                        reserva.getNomClient(),reserva.getTelf());
                        
                
                System.out.println("NOM DEL CLIENT : "+reserva.getNomClient());
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
    private Button btnEsborrar;

    @FXML
    private Button btnModificacio;
    
    
    @FXML
    private Button btnRefrescar;

    @FXML
    void btnAltaClick(ActionEvent event) {
                try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Alta.fxml"));
            Parent root = loader.load();
            
            AltaController controllerAlta = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    @FXML
    void btnEsborrarClick(ActionEvent event) {

        try {
            Reserva fila = tableViewReserves.getSelectionModel().getSelectedItem();
            DaoReserva.esborrarReserva(fila.getNumReserva());
             Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Información");
            alert.setHeaderText(null);
            alert.setContentText("Reserva ELIMINADA");
            this.tableViewReserves.getItems().clear();
         this.carregarTaula();
           
   

            // Mostrar el cuadro de diálogo
            alert.showAndWait();
            
        } catch (SQLException ex) {
            Logger.getLogger(ReservaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void btnModificacioClick(ActionEvent event) {
        
      
        Reserva fila = tableViewReserves.getSelectionModel().getSelectedItem();
        System.out.println(fila.getNomClient());
        
                           try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Modificacio.fxml"));
            Parent root = loader.load();
            
            ModificacioController controllerModificacio = loader.getController();
            controllerModificacio.initAttributes(fila);
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();
            
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
        @FXML
    void btnRefrescarClick(ActionEvent event) {
         this.carregarTaula();
           
    }

    
}
