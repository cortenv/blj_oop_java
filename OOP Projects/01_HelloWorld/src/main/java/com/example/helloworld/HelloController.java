package com.example.helloworld;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;

public class HelloController {

    @FXML
    private TextField inputTextField;

    @FXML
    private Label welcomeText;


    @FXML
    private Button btn;

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

        inputTextField.setText("Gugus");
        btn.setText("Vera ");

        }

}
