package samples.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.time.*;

public class Controller {

    @FXML
    private RadioButton rbYears;
    @FXML
    private RadioButton rbMonths;
    @FXML
    private RadioButton rbWeeks;
    @FXML
    private RadioButton rbDays;
    @FXML
    private DatePicker dtpBirthDate;
    @FXML
    private TextField textFieldResult;

    @FXML
    private void onButtonCalculateClick() {

        if (dtpBirthDate.getValue() == null)
            return;

        LocalDate birthDate = dtpBirthDate.getValue();
        LocalDate todayDate = LocalDate.now();

        if (rbYears.isSelected()) {
            textFieldResult.setText(String.valueOf(this.calcYears(birthDate, todayDate)));
        }
        else if (rbMonths.isSelected()) {
            textFieldResult.setText(String.valueOf(this.calcMonths(birthDate, todayDate)));
        }
        else if (rbWeeks.isSelected()) {
            textFieldResult.setText(String.valueOf(this.calcWeeks(birthDate, todayDate)));
        }
        else if (rbDays.isSelected()) {
            textFieldResult.setText(String.valueOf(this.calcDays(birthDate, todayDate)));
        }
    }

    private int calcYears(LocalDate startDate, LocalDate endDate) {
        Period diffPeriod = Period.between(startDate, endDate);
        return diffPeriod.getYears();
    }

    private int calcMonths(LocalDate startDate, LocalDate endDate) {
        Period diffPeriod = Period.between(startDate, endDate);
        return (diffPeriod.getYears() * 12) + diffPeriod.getMonths();
    }

    private int calcWeeks(LocalDate startDate, LocalDate endDate) {
        int days = this.calcDays(startDate, endDate);
        return days / 7;
    }

    private int calcDays(LocalDate startDate, LocalDate endDate) {
        // to obtain epoch-seconds for a LocalDateTime instance, we need to convert
        // the LocalDateTime to a ZonedDateTime
        ZoneId zoneId = ZoneId.of("Europe/Berlin");
        long startDateSeconds = startDate.atTime(0,0,0).atZone(zoneId).toEpochSecond();
        long endDateSeconds = endDate.atTime(0,0,0).atZone(zoneId).toEpochSecond();

        long diffSeconds = endDateSeconds - startDateSeconds;

        // 1 day := 86'400 seconds
        return (int)diffSeconds / 86400;
    }
}

