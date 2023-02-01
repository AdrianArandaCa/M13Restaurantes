module com.mycompany.agustinadrianm13restaurante {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.agustinadrianm13restaurante to javafx.fxml;
    exports com.mycompany.agustinadrianm13restaurante;
}
