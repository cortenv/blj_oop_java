package com.example.t02_rechteckberechnen;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class HelloController {

    @FXML
    private TextField textfieldBreite;

    @FXML
    private TextField textfieldHoehe;

    @FXML
    private TextField textfieldAusgabe;

    @FXML
    private void onButtonCalculateClick() {

        if (textfieldBreite.getText().equals("") || textfieldHoehe.getText().equals("")) {
            this.showMessageBox("Bitte geben Sie sowohl die Breite als auch die Höhe des Rechtecks ein.");

            return;
        }

        try {
            double width = Double.parseDouble(textfieldBreite.getText());
            double height = Double.parseDouble(textfieldHoehe.getText());

            Rechteck rechteck = new Rechteck();
            rechteck.setWidth(width);
            rechteck.setHeight(height);

            textfieldAusgabe.setText(String.valueOf(rechteck.getArea()));
        }
        catch (NumberFormatException ex) {
            this.showMessageBox("Bitte geben Sie eine Zahl ein.");
        }
        catch (Exception ex){
            this.showMessageBox(ex.toString());
        }
    }

    private void showMessageBox(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Ungültige Eingabe");
        alert.setHeaderText("Ungültige oder fehlende Eingabe.");
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void onButtonExitClick(){
        Platform.exit();
    }

    @FXML
    private void initialize() {
        textfieldBreite.isFocused();
    }
}