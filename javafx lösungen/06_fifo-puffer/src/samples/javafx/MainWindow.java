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
        primaryStage.setTitle("FiFo Puffer");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 350, 245));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
