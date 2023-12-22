module com.example.t04_reisedauerzummond {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.t04_reisedauerzummond to javafx.fxml;
    exports com.example.t04_reisedauerzummond;
}