module com.example.secondprojet {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.secondprojet to javafx.fxml;
    exports com.example.secondprojet;

    exports models;
    exports vue;
    exports controler;
    exports tools;
}