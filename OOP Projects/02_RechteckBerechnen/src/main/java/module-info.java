module com.example.t02_rechteckberechnen {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.t02_rechteckberechnen to javafx.fxml;
    exports com.example.t02_rechteckberechnen;
}