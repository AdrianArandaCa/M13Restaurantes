/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Producte;
import Model.Reserva;
import com.mycompany.agustinadrianm13restaurante.DB.DaoReserva;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
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
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;

/**
 *
 * @author agustincintas
 */
public class ComandaController implements Initializable{
    
     @FXML
    private Button btnAlta;

    @FXML
    private Button btnEsborrar;

    @FXML
    private Button btnModificacio;

    @FXML
    private Tab tabBeguda;

    @FXML
    private Tab tabMenjar;

    @FXML
    private Label titolComanda;
    
    @FXML
    private Button btnDownCenter;

    @FXML
    private Button btnDownDer;

    @FXML
    private Button btnDownIzq;
    
     @FXML
    private Button btnUpCenter;

    @FXML
    private Button btnUpDer;

    @FXML
    private Button btnUpIzq;
    
    @FXML
    private TextArea labelPedido;
    
    @FXML
    private Label labelPreuTotal;
    
    @FXML
    private ComboBox<Integer> cmbTaula;

    static double numTotal = 0.0;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
   
        labelPedido.setEditable(false);
        
         try {
             ObservableList<Integer> idTaules = FXCollections.observableArrayList(DaoReserva.llistaTaules());
            cmbTaula.setItems(idTaules);
             ArrayList<Producte> productesMenjar = DaoReserva.llistaProductesMenjar();
             ArrayList<Button> botones = new ArrayList<Button>();
             botones.add(btnDownCenter);
             botones.add(btnDownDer);
             botones.add(btnDownIzq);
             botones.add(btnUpCenter);
             botones.add(btnUpDer);
             botones.add(btnUpIzq);
               
                     
                     for (int i = 0; i < productesMenjar.size(); i++) {
                         botones.get(i).setText(productesMenjar.get(i).getNom()+"\n"+productesMenjar.get(i).getPreu()+"€");
                         
                         
                         
                     }
                 
                 
                 
             
         } catch (SQLException ex) {
             Logger.getLogger(ComandaController.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        
       
    }
    
    @FXML
    void btnAltaClick(ActionEvent event) {

    }

    @FXML
    void btnEsborrarClick(ActionEvent event) {

    }

    @FXML
    void btnModificacioClick(ActionEvent event) {

    }
    
      @FXML
    void btnDownCenterClick(ActionEvent event) {
        
            this.labelPedido.setText(this.labelPedido.getText()+"\n\n"+this.btnDownCenter.getText());
            String substring = this.btnDownCenter.getText().substring(this.btnDownCenter.getText().length()-6,this.btnDownCenter.getText().length()-1);
            numTotal += Double.parseDouble(substring);
            
            this.labelPreuTotal.setText("Preu total: "+String.valueOf(numTotal));
    }

    @FXML
    void btnDownDerClick(ActionEvent event) {
        if(this.cmbTaula.getValue() == null) {
            System.out.println("SELECCIONA UNA HIJO DE PUTA");
        }else{
             this.labelPedido.setText(this.labelPedido.getText()+"\n\n"+this.btnDownDer.getText());
            String substring = this.btnDownDer.getText().substring(this.btnDownDer.getText().length()-6,this.btnDownDer.getText().length()-1);
            numTotal += Double.parseDouble(substring);
            
            this.labelPreuTotal.setText("Preu total: "+String.valueOf(numTotal));
        }
        
       
    }

    @FXML
    void btnDownIzqClick(ActionEvent event) {

    }
    
    @FXML
    void btnUpCenter(ActionEvent event) {

    }

    @FXML
    void btnUpDerClick(ActionEvent event) {

    }

    @FXML
    void btnUpIzqClick(ActionEvent event) {

    }
    
    @FXML
    void cmbTaulaSelected(ActionEvent event) {
        
        int numTaula = this.cmbTaula.getValue();
        System.out.println(numTaula);

    }

    
}
