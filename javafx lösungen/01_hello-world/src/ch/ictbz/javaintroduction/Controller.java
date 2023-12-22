package ch.ictbz.javaintroduction;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;

public class Controller {

    /**
     * Called when the user clicks the "Hello World" button.
     */
    @FXML
    private void onButtonClick() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Info");
        alert.setHeaderText("Hello World!");
        alert.setContentText("Welcome to my first JavaFX application.");
        alert.showAndWait();
    }
}
