package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;

public class Controller {

    ContactList contactList = new ContactList();

    @FXML
    private TableView tableContacts;
    @FXML
    private TextField textFieldName;
    @FXML
    private TextField textFieldEmail;
    @FXML
    private TextField textFieldPhone;


    @FXML
    public void initialize() {

        // Spalten für die TableView definieren
        tableContacts.getColumns().clear();

        TableColumn tColName = new TableColumn("Name");
        tColName.setMinWidth(220);
        tColName.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn tColEmail = new TableColumn("EMail");
        tColEmail.setMinWidth(175);
        tColEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        TableColumn tColPhone = new TableColumn("Phone");
        tColPhone.setMinWidth(155);
        tColPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));

        tableContacts.getColumns().addAll(tColName, tColEmail, tColPhone);

        // Datenquelle setzen
        tableContacts.setItems(contactList.getContacts());
    }

    @FXML
    public void onButtonAddClick() {

        if (textFieldName.getText().isEmpty())
            return;

        Contact newContact = new Contact();
        newContact.setName(textFieldName.getText());
        newContact.setEmail(textFieldEmail.getText());
        newContact.setPhone(textFieldPhone.getText());

        contactList.getContacts().add(newContact);
    }

    @FXML
    public void onButtonClearClick() {
        contactList.clear();
    }

    @FXML
    public void onButtonExportClick() throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Kontakte exportieren");
        File file = fileChooser.showSaveDialog(null);

        contactList.exportCsv(file.getPath());
    }

    @FXML
    public void onButtonImportClick() throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Kontakte importieren");
        File file = fileChooser.showOpenDialog(null);

        contactList.importCsv(file.getPath());
    }
}
