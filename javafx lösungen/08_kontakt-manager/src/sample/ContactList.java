package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ContactList {

    private ObservableList<Contact>  contacts =  FXCollections.observableArrayList();

    public ContactList() {
    }

    public void  clear() {
        getContacts().clear();
    }

    public void exportCsv(String filePath) throws IOException {
        FileWriter fw = new FileWriter(filePath);
        BufferedWriter bw = new BufferedWriter(fw);
        for (Contact c : contacts) {
            bw.write(c.getName() + ";");
            bw.write(c.getEmail() + ";");
            bw.write(c.getPhone() + "\n");
        }

        bw.close();
    }

    public void importCsv(String filePath) throws IOException {
        this.clear();
        Path path = Paths.get(filePath);
        List<String> contents = Files.readAllLines(path);
        for (String line : contents) {
            String[] properties = line.split(";");
            Contact contact = new Contact();
            contact.setName(properties[0]);
            contact.setEmail(properties[1]);
            contact.setPhone(properties[2]);
            contacts.add(contact);
        }
    }

    public ObservableList<Contact> getContacts() {
        return contacts;
    }
}
