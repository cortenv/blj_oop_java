package com.example.t03_tannenbaum;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class Controller {

    private Tanne Tanne;

    @FXML
    private TextField Stammbreite;

    @FXML
    private TextField Stammhoehe;

    @FXML
    private TextField Kronenhoehe;

    @FXML
    private TextArea areaZeichnung;

    @FXML
    private void buttonMath() {
        if (Kronenhoehe.getText().trim().equals("")
                || Stammhoehe.getText().equals("")
                || Stammbreite.getText().equals("")) {
            return;
        }


        Tanne t = new Tanne(Integer.valueOf(Stammbreite.getText())
                , Integer.valueOf(Stammhoehe.getText())
                , Integer.valueOf(Kronenhoehe.getText()));

        t.zeichne();

        areaZeichnung.setText(t.getZeichnung());
    }
}