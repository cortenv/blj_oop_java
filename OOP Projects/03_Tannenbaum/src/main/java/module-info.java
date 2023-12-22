module com.example.t03_tannenbaum {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.t03_tannenbaum to javafx.fxml;
    exports com.example.t03_tannenbaum;
}