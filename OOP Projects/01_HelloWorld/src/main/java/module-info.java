module com.example.helloworld {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.helloworld to javafx.fxml;
    exports com.example.helloworld;
}