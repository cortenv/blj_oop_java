package samples.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *       TODO: wenn der Benutzer das MainWindow schliesst, während die Simulation noch läuft, läuft letzter im Hintergrund weiter
 *             (da der Timer in einem eigenen Thread läuft)
 *             -> Mechanismus einbauen, der beim Schliessen des MainWindows die allenfalls noch laufende Simulation stoppt!
 */

public class MainWindow extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
        primaryStage.setTitle("Waldbrand Simulation");
        primaryStage.setScene(new Scene(root, 566, 552));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
