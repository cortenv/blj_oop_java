package samples.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainWindow extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
        primaryStage.setTitle("Fläche eines Rechtecks berechnen");
        primaryStage.setScene(new Scene(root, 450, 200));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
