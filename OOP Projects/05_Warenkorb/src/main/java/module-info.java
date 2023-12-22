module com.example.t05_warenkorb {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.t05_warenkorb to javafx.fxml;
    exports com.example.t05_warenkorb;
}