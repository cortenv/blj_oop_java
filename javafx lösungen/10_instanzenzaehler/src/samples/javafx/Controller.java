package samples.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class Controller {
    @FXML
    private TextField textFieldCounter;

    @FXML
    private void onCreateInstanceButtonClick() {
        C c = new C();
        textFieldCounter.setText(String.valueOf(C.getCountOfInstances()));
    }


    @FXML
    private void onResetCounterButtonClick(){
        C.resetInstaceCounter();
        textFieldCounter.setText(String.valueOf(C.getCountOfInstances()));
    }

}
