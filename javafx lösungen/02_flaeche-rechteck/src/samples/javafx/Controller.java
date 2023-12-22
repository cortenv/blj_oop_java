package samples.javafx;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.util.DoubleSummaryStatistics;

/**
 * Controller Class for our MainWindow.
 * Note: We must put it in the same package as the MainWindow.fxml, otherwise the SceneBuilder won't find it.
 */
public class Controller {

    //region fields
    @FXML
    private TextField textFieldBreite;
    @FXML
    private TextField textFieldHoehe;
    @FXML
    private TextField textFieldResultat;
    //endregion

    // region methods
    @FXML
    private void onButtonCalculateClick() {

        if (textFieldBreite.getText().equals("") || textFieldHoehe.getText().equals("")) {
            this.showMessageBox("Bitte geben Sie sowohl die Breite als auch die Höhe des Rechtecks ein.");

            return;
        }

        try {
            double width = Double.parseDouble(textFieldBreite.getText());
            double height = Double.parseDouble(textFieldHoehe.getText());
            double result = width * height;

            Rechteck rechteck = new Rechteck();
            rechteck.setWidth(width);
            rechteck.setHeight(height);

            textFieldResultat.setText(String.valueOf(rechteck.getArea()));
        }
        catch (NumberFormatException ex) {
            this.showMessageBox("Bitte geben Sie eine Zahl ein.");
        }
        catch (Exception ex){
            // unknown exception occured
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

    /**
     * Initializes the controller class.
     * This method is automatically called after the fxml file has been loaded. At this time,
     * all the FXML fields should have been initialized already.
     */
    @FXML
    private void initialize() {
        // set focus on first textfield
        textFieldBreite.isFocused();
    }
    //endregion
}
