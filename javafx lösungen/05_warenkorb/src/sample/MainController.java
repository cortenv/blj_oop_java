package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.LinkedList;

public class MainController {

    LinkedList<OrderItem> orderedItems = new LinkedList<OrderItem>();

    @FXML
    private TextField productNameTextField;

    @FXML
    private TextField amountTextField;

    @FXML
    private Label amountCountLabel;

    @FXML
    private Hyperlink showCartHyperlink;


    @FXML
    private void initialize() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                productNameTextField.requestFocus();
            }
        });
    }

    @FXML
    private void onButtonAddToCartClick() {
        if (productNameTextField.getText().isEmpty())
            return;

        OrderItem item = new OrderItem();
        item.setProductName(productNameTextField.getText());
        item.setAmount(Integer.parseInt(amountTextField.getText()));

        orderedItems.add(item);
        amountCountLabel.setText(String.valueOf(orderedItems.size()));
    }

    @FXML
    private void onHyperlinkShowCartClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("cartWindow.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        //Controller-Instanz holen
        CartController controller = fxmlLoader.getController();
        controller.setStage(stage);
        controller.setItems(orderedItems);
        //Modality setzen, um die Stage modal anzuzeigen
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }


}
