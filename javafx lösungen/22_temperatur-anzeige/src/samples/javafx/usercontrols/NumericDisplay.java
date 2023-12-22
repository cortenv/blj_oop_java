package samples.javafx.usercontrols;

import  ch.ictbz.lib.ui.UserControl;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import samples.javafx.interfaces.IObserver;

/**
 * Created by nuu on 12.01.2017.
 */
public class NumericDisplay extends UserControl implements IObserver{

    @FXML
    private Label temperatureLabel;

    public NumericDisplay(){
        temperatureLabel.setText("0");
    }

    @Override
    public void update(int temperatureValue) {
        temperatureLabel.setText(toString().valueOf(temperatureValue));
    }
}
