package com.example.t05_warenkorb;

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

public class HelloController {
    LinkedList<OrderItem> orderedItems = new LinkedList<OrderItem>();

    @FXML
    private TextField TextFieldProdukt;

    @FXML
    private TextField TextFieldAmount;

    @FXML
    private Label CountLabelamount;

    @FXML
    public Hyperlink HyperlinkWarenkorb;


    @FXML
    private void initialize() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                TextFieldProdukt.requestFocus();
            }
        });
    }

    @FXML
    private void onButtonWarenkorbHinzufuegen() {
        if (TextFieldProdukt.getText().isEmpty())
            return;

        OrderItem item = new OrderItem();

        item.setProductName(TextFieldProdukt.getText());
        item.setAmount(Integer.parseInt(TextFieldAmount.getText()));

        orderedItems.add(item);
        CountLabelamount.setText(String.valueOf(orderedItems.size()));
    }

    @FXML
    private void onHyperlinkWarenkorb() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Warenkorb.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        //Controller-Instanz holen
        ControllerWarenkorb controller = fxmlLoader.getController();
        controller.setStage(stage);
        controller.setItems(orderedItems);
        //Modality setzen, um die Stage modal anzuzeigen
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }
}