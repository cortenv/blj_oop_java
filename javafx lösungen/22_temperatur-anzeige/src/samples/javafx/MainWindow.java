package samples.javafx;

import ch.ictbz.lib.ui.UserControl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import samples.javafx.usercontrols.GraphicDisplay;
import samples.javafx.usercontrols.NumericDisplay;
import samples.javafx.usercontrols.TemperatureSensor;

public class MainWindow extends Application {

    public static void main(String[] args) {
        launch(args);
        System.gc();
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        // we won't use a fxml file but we use a GridPane as our root-Layout
        //Parent root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
        GridPane root = new GridPane();

        // populate the GridPane
        this.initializeComponents(root);

        primaryStage.setTitle("Temperaturanzeige");
        primaryStage.setScene(new Scene(root, 435, 275));
        primaryStage.show();

    }

    private void initializeComponents(GridPane gridPane) {
        // create the NumericDisplay custom control
        NumericDisplay numDisplayControl = new NumericDisplay();
        gridPane.add(numDisplayControl, 1,0);

        // create the GraphicDisplay custom control
        GraphicDisplay graphDisplayControl = new GraphicDisplay();
        gridPane.add(graphDisplayControl, 1,1);

        // create the TemperatureSensor custom control
        TemperatureSensor temperatureSensor = new TemperatureSensor();
        gridPane.add(temperatureSensor, 0,0);

        // attach observers to subject
        temperatureSensor.attach(numDisplayControl);
        temperatureSensor.attach(graphDisplayControl);


        // set a small margin around the controls
        /*
        gridPane.setMargin(numDisplayControl, new Insets(5));
        gridPane.setMargin(graphDisplayControl, new Insets(5));
        gridPane.setMargin(temperatureSensor, new Insets(5));
        */
    }
}
