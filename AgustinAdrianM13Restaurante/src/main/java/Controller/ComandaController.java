/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Comanda;
import Model.Producte;
import Model.Reserva;
import Model.Taula;
import com.itextpdf.text.Chunk;
import com.mycompany.agustinadrianm13restaurante.DB.DaoReserva;
import java.io.FileOutputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPTable;
import java.io.FileNotFoundException;

/**
 *
 * @author agustincintas
 */
public class ComandaController implements Initializable {

    double totalApagarStatic = 0;

    @FXML
    private Button btnAfegirProducteComanda;

    @FXML
    private Button btnEliminarProducteComanda;

    @FXML
    private Button btnPagarComanda;

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
    private Label labelTotalAPagar;

    @FXML
    private ComboBox<Integer> cmbTaula;

    @FXML
    private TableColumn<Producte, String> tableColumnNom;

    @FXML
    private TableColumn<Producte, Double> tableColumnPreu;

    @FXML
    private TableColumn<Producte, String> tableColumnNomBeguda;

    @FXML
    private TableColumn<Producte, Double> tableColumnPreuBeguda;

    @FXML
    private TableColumn<Producte, String> tableColumnComandaTaulaNom;

    @FXML
    private TableColumn<Producte, Double> tableColumnComandaTaulaPreu;

    @FXML
    private TableView<Producte> tableViewMenjar;

    @FXML
    private TableView<Producte> tableViewBeguda;

    @FXML
    private TableView<Producte> tableViewComandaTaula;

    static double numTotal = 0.0;
    ObservableList<Producte> productesMenjar;
    ObservableList<Producte> productesBeguda;
    ObservableList<Producte> productesComanda;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            ObservableList<Integer> idTaules = FXCollections.observableArrayList(DaoReserva.llistaTaules());
            cmbTaula.setItems(idTaules);

            tableColumnNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
            tableColumnPreu.setCellValueFactory(new PropertyValueFactory<>("preu"));
            tableColumnNomBeguda.setCellValueFactory(new PropertyValueFactory<>("nom"));
            tableColumnPreuBeguda.setCellValueFactory(new PropertyValueFactory<>("preu"));
            tableColumnComandaTaulaNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
            tableColumnComandaTaulaPreu.setCellValueFactory(new PropertyValueFactory<>("preu"));

            this.carregarTaula();
        } catch (SQLException ex) {
            Logger.getLogger(ComandaController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void carregarTaula() {

        productesMenjar = FXCollections.observableArrayList();
        productesBeguda = FXCollections.observableArrayList();
        // Agafar tots els registres de la taula
        /*int numReserva, int t, String nomClient, int telf, String data, int quantPersones,String hora*/
        try {
            ArrayList<Producte> productosMenjarDAO = DaoReserva.llistaProductesMenjar();
            ArrayList<Producte> productosBegudaDAO = DaoReserva.llistaProductesBeguda();

            // Omplim l'observableList
            for (Producte pro : productosMenjarDAO) {

                Producte p = new Producte(pro.getIdProducte(), pro.getNom(), pro.getPreu(), pro.getCategoria());

                productesMenjar.add(p);
            }
            for (Producte pro : productosBegudaDAO) {

                Producte p = new Producte(pro.getIdProducte(), pro.getNom(), pro.getPreu(), pro.getCategoria());

                productesBeguda.add(p);
            }

            //Assignar l'observableList a la taula
            tableViewMenjar.setItems(productesMenjar);
            tableViewBeguda.setItems(productesBeguda);

        } catch (SQLException ex) {
            //Logger.getLogger(SecondaryController.class.getName()).log(Level.SEVERE, null, ex);
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
    void cmbTaulaSelected(ActionEvent event) {
        double total = 0;
        try {
            int numTaula = this.cmbTaula.getValue();

            carregarTaulaComanda(numTaula);

            ArrayList<Double> totalApagar = DaoReserva.getPreuTaula(numTaula);

            for (double num : totalApagar) {
                total += num;
            }
            totalApagarStatic = total;
            this.labelTotalAPagar.setText("TOTAL a pagar: " + totalApagarStatic + "€");
            System.out.println("total a pagar : " + totalApagarStatic);
        } catch (SQLException ex) {
            Logger.getLogger(ComandaController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void btnPagarComandaClick(ActionEvent event) throws SQLException {

        //Document documento = new Document();
        Document document = new Document();
        double total = 0;
        try {
            // Crear un objeto PDFWriter para escribir el PDF
            PdfWriter.getInstance(document, new FileOutputStream("totalApagar.pdf"));

            // Abrir el documento para escribir en él
            document.open();

            // Crear una tabla con el mismo número de columnas que la tabla en la interfaz de usuario
            PdfPTable table = new PdfPTable(tableViewComandaTaula.getColumns().size());
            Paragraph paragraph = new Paragraph("Factura de la taula " + this.cmbTaula.getValue() + " a nom de : " + DaoReserva.getNomClient(this.cmbTaula.getValue()), new Font(Font.FontFamily.TIMES_ROMAN, 20, Font.BOLD));
            paragraph.setAlignment(Element.ALIGN_CENTER);
            document.add(paragraph);
            document.add(Chunk.NEWLINE);
            ArrayList<Double> totalApagar = DaoReserva.getPreuTaula(this.cmbTaula.getValue());
            for (double num : totalApagar) {
                total += num;
            }
            Paragraph paragraph1 = new Paragraph("TOTAL DE LA TAULA: " + total + "€", new Font(Font.FontFamily.TIMES_ROMAN, 15, Font.BOLD));
            // document.addHeader();
             Paragraph paragraph2 = new Paragraph("TOTAL A PAGAR AMB EL 21% IVA: " + (total*1.21) + "€", new Font(Font.FontFamily.TIMES_ROMAN, 15, Font.BOLD));
            table.addCell("Nombre del Producte");

            table.addCell("Preu del Producte");

            ArrayList<Object> productes = (ArrayList<Object>) DaoReserva.getAllProductsTaula(this.cmbTaula.getValue());

            for (int i = 0; i < productes.size(); i++) {
                table.addCell(productes.get(i).toString());
            }

            document.add(table);
            document.add(Chunk.NEWLINE);
            paragraph1.setAlignment(Element.ALIGN_CENTER);
            document.add(paragraph1);
            document.add(Chunk.NEWLINE);
            paragraph2.setAlignment(Element.ALIGN_CENTER);
            document.add(paragraph2);
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Información");
            alert.setHeaderText(null);
            alert.setContentText("Factura de la taula " + this.cmbTaula.getValue() + " generada.");
            alert.showAndWait();
           
            int num = DaoReserva.esborrarRegistresReserva(this.cmbTaula.getValue());
            carregarTaulaComanda(this.cmbTaula.getValue());

            this.labelTotalAPagar.setText("TOTAL a pagar: " + 0.0 + "€");
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Cerrar el documento
            document.close();
        }
    }

    @FXML
    void btnAfegirProducteComandaClick(ActionEvent event) {
        System.out.println("KLK HAS CLICADO");
        int numTaula = cmbTaula.getValue();
        double total = 0;

        Producte productesMenjar = tableViewMenjar.getSelectionModel().getSelectedItem();
        Producte productesBeguda = tableViewBeguda.getSelectionModel().getSelectedItem();

        if (this.cmbTaula.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Información");
            alert.setHeaderText(null);
            alert.setContentText("Selecciona la mesa y un elemento de la tabla a añadir");
            alert.showAndWait();

        } else {

            Taula taula = new Taula(cmbTaula.getValue());
            Comanda comandaInsertar = new Comanda(0, taula);
            try {
                DaoReserva.afegirComanda(comandaInsertar);
                int nTaula = DaoReserva.getNumeroTaula(taula.getIdTaula());
                if (productesMenjar != null) {

                    DaoReserva.afegirLineaComanda(nTaula, productesMenjar);
                }
                if (productesBeguda != null) {

                    DaoReserva.afegirLineaComanda(nTaula, productesBeguda);
                }

            } catch (SQLException ex) {
                Logger.getLogger(ComandaController.class.getName()).log(Level.SEVERE, null, ex);
            }
            carregarTaulaComanda(numTaula);

            try {
                ArrayList<Double> totalApagar = DaoReserva.getPreuTaula(numTaula);
                for (double num : totalApagar) {
                    total += num;
                }
                this.labelTotalAPagar.setText("TOTAL a pagar: " + total + "€");
            } catch (SQLException ex) {
                Logger.getLogger(ComandaController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    @FXML
    void btnEliminarProducteComandaClick(ActionEvent event) {
        double total = 0;
        try {
            Producte productesMenjar = tableViewComandaTaula.getSelectionModel().getSelectedItem();
            int numTaula = cmbTaula.getValue();
            int lineaComanda = DaoReserva.getNumeroLineaComanda(productesMenjar.getIdProducte());

            DaoReserva.esborrarLineaComanda(lineaComanda);
            carregarTaulaComanda(numTaula);

            ArrayList<Double> totalApagar = DaoReserva.getPreuTaula(numTaula);

            for (double num : totalApagar) {
                total += num;
            }
            this.labelTotalAPagar.setText("TOTAL a pagar: " + total + "€");
        } catch (SQLException ex) {
            Logger.getLogger(ComandaController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void carregarTaulaComanda(int numTaula) {
        try {
            productesComanda = FXCollections.observableArrayList();
            ArrayList<Producte> productesComanda1 = DaoReserva.llistaProductesComanda(numTaula);

            for (Producte pro : productesComanda1) {

                Producte p = new Producte(pro.getIdProducte(), pro.getNom(), pro.getPreu(), pro.getCategoria());

                productesComanda.add(p);
            }
            tableViewComandaTaula.setItems(productesComanda);
        } catch (SQLException ex) {
            Logger.getLogger(ComandaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void tabBegudaOnSelectionChanged(Event event) {
        tableViewMenjar.getSelectionModel().clearSelection();

    }

    @FXML
    void tabMenjarOnSelectionChanged(Event event) {
        if (tableViewBeguda != null) {
            tableViewBeguda.getSelectionModel().clearSelection();
        }

    }

}
