package samples.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import samples.javafx.model.FifoPuffer;

public class Controller {

    private FifoPuffer puffer;

    @FXML
    private Spinner spinnerCapacity;
    @FXML
    private TextField textFieldPut;
    @FXML
    private TextField textFieldGet;

    @FXML
    private void onCreateButtonClick(){
        puffer = new FifoPuffer((int)spinnerCapacity.getValue());
    }

    @FXML
    private void onPutClick(){
        try {
            puffer.put(Integer.parseInt(textFieldPut.getText()));
        }
        catch (Exception ex){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Die Zahl konnte nicht in den Puffer gelegt werden.");
            alert.setContentText("Meldung: " + ex.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    private void onGetClick() {
        try {
            textFieldGet.setText(String.valueOf(puffer.get()));
        }
        catch (Exception ex){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Die Zahl konnte nicht vom Puffer gelesen werden.");
            alert.setContentText("Meldung: " + ex.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    private void onGetAllClick() {
        try {
            textFieldGet.setText(String.valueOf(puffer.getAll()));
        }
        catch (Exception ex){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Die Zahlen konnten nicht vom Puffer gelesen werden.");
            alert.setContentText("Meldung: " + ex.getMessage());
            alert.showAndWait();
        }
    }

}
