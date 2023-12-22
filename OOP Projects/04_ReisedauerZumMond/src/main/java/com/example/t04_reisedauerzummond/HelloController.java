package com.example.t04_reisedauerzummond;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {

    @FXML
    private RadioButton indays; {
    }

    @FXML
    private RadioButton inHours;

    @FXML
    private TextField textFieldDuration;

    @FXML
    private TextField TextFieldSpeed;

    @FXML
    private void ButtonMath() {
        double speedKmh = Double.parseDouble(TextFieldSpeed.getText());
        double result = 0.0;

        Mondreise mondreise = new Mondreise(speedKmh);

        if (indays.isSelected() == true) {
            result = mondreise.getTravelDurationDays();
        } else {
            result = mondreise.getTravelDurationHours();
        }
            textFieldDuration.setText(Double.toString(result));
    }

}