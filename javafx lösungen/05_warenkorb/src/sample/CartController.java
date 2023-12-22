package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.util.LinkedList;

public class CartController {

    private LinkedList<OrderItem> items;

    @FXML
    private ListView cartListView;

    @FXML
    private Stage stage;

    @FXML
    private void onButtonCancelClick() {
        stage.close();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setItems(LinkedList<OrderItem> items) {
        this.items = items;

        for (OrderItem item : this.items) {
            cartListView.getItems().add(item.getAmount() + " Ex. " + "\t" + item.getProductName());
        }
    }
}