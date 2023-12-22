module com.example.t06_autosimulator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.t06_autosimulator to javafx.fxml;
    exports com.example.t06_autosimulator;
}