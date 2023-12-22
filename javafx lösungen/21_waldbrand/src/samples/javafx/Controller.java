package samples.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import samples.javafx.model.Wald;
import java.util.Timer;
import java.util.TimerTask;


public class Controller {
    @FXML
    private TextArea areaForest;
    @FXML
    private Spinner spinnerWidth;
    @FXML
    private Spinner spinnerDepth;
    @FXML
    private Spinner spinnerGrowth;
    @FXML
    private Spinner spinnerIgnition;
    @FXML
    private Button buttonStartSim;
    @FXML
    private Button buttonStopSim;

    private Wald wald;
    Timer timer;
    TimerTask timerTask;

    @FXML
    private void onButtonStartClick() {
        // Wichtig: falls schon ein timer läuft, diesen canceln
        reset();

        buttonStartSim.setDisable(true);
        buttonStopSim.setDisable(false);

        wald = new Wald((int)spinnerWidth.getValue(), (int)spinnerDepth.getValue(), (int)spinnerGrowth.getValue(), (int)spinnerIgnition.getValue());
        areaForest.setText(wald.toString());

        timerTask = new TimerTask() {
            @Override
            public void run() {
                areaForest.setText(wald.toString());
            }
        };

        // timer erstellen u. starten
        timer = new Timer();
        timer.schedule(timerTask, 1500l, 1500l);
    }

    @FXML
    private void onButtonCancelClick() {
        reset();
    }

    private void reset() {
        if (timer != null) {
            timer.cancel(); // cancel killt auch gleich die Instanz, scheint's)
        }

        if (timerTask != null) {
            timerTask.cancel();
        }

        if (wald != null)
            wald = null;

        areaForest.clear();
        buttonStartSim.setDisable(false);
        buttonStopSim.setDisable(true);
    }
}
