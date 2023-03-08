module com.mycompany.agustinadrianm13restaurante {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;

    opens com.mycompany.agustinadrianm13restaurante to javafx.fxml;
    exports com.mycompany.agustinadrianm13restaurante;
    
    opens Controller to javafx.fxml;
    exports Controller;
    
     opens Model to javafx.fxml;
     exports Model;
}
