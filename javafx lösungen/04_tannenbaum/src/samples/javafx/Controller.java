package samples.javafx;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import samples.javafx.model.Tanne;

public class Controller {
    private Tanne tanne;

    @FXML
    private TextArea textAreaResult;
    @FXML
    private TextField textFieldTrunkWidth;
    @FXML
    private TextField textFieldTrunkHeight;
    @FXML
    private TextField textFieldCrownHeigt;

    @FXML
    private void onButtonDrawClick() {

        if (textFieldCrownHeigt.getText().trim().equals("")
                || textFieldTrunkHeight.getText().equals("")
                || textFieldTrunkWidth.getText().equals("")) {
            return;
        }


        Tanne t = new Tanne(Integer.valueOf(textFieldTrunkWidth.getText())
                , Integer.valueOf(textFieldTrunkHeight.getText())
                , Integer.valueOf(textFieldCrownHeigt.getText()));

        t.zeichne();

        textAreaResult.setText(t.getZeichnung());
    }

    @FXML
    private void onTextFieldKeyPress() {

    }

    @FXML
    private void initialize() {
        textFieldTrunkWidth.addEventFilter(KeyEvent.ANY, keyEventFilter);
        textFieldTrunkHeight.addEventFilter(KeyEvent.ANY, keyEventFilter);
        textFieldCrownHeigt.addEventFilter(KeyEvent.ANY, keyEventFilter);
    }


    /**
     *  Event Handler um Tastatureingaben "abzufangen".
     *  ------------------------------------------------
     *  Es gibt mehrere Möglichkeiten Benutzereingaben zu validieren:
     *    - während der Eingabe (Zeichen verbieten)
     *    - nach der Eingabe (Fehlermeldung)
     *    - Eingabe mittels spezieller Controls (Slider, Numberstep, Button mit Wert, u.ä.)
     *
     *  Wir entscheiden uns hier für die erste Variante und implementieren einen entsprechenden EventHandler.
     *
     * ********************************************************************************************************
     *  PS: Eine andere, bessere Lösung wäre, die TextField-Klasse zu erweitern (von ihr zu erben),
     *  und darin die Methoden replaceText() und replaceSelection() zu überschreiben.
     *  Nachfolgend ein Beispiel (von hier: http://blog.axxg.de/javafx-textfield-beschraenken/)
     *
     *  // TextField mit Nummern
     *  public class NumberTextField extends TextField {

     *      @Override
     *      public void replaceText(int start, int end, String text) {
     *          if (text.matches("[0-9]") || text == "") {
     *              super.replaceText(start, end, text);
     *          }
     *      }

     *      @Override
     *      public void replaceSelection(String text) {
     *          if (text.matches("[0-9]") || text == "") {
     *              super.replaceSelection(text);
     *          }
     *      }
     */
    private  EventHandler<KeyEvent> keyEventFilter = new EventHandler<KeyEvent>() {
        // Es werden immer die drei Events KEY_PRESSED, KEY_TYPED und KEY_RELEASED abgearbeitet, (in dieser Reihenfolge).
        // Es gibt das Problem, dass der KEY_TYPED Event den gedrückten Key nicht mitsendet (wir erhalten Code = UNDEFINED),
        // was bedeutet, dass der  consume() nicht funktionieren wird. Darum arbeiten wir mit einer Hilfsvariablen,
        // um die Tasteingaben abfangen zu können. Diese Hilfsvariable wird beim KEY_RELEASED wieder zurückgesetzt, damit
        // sie ihren Zweck beim nächsten Event wieder erfüllen kann.
        boolean isConsumed = false;

        @Override
        public void handle(KeyEvent keyEvent) {
            if (isConsumed) {
                keyEvent.consume();
            }

            // wir wollen nur Zahlen zulassen.
            if (!keyEvent.getCode().isDigitKey()) {
                if (keyEvent.getEventType() == KeyEvent.KEY_PRESSED) {
                    isConsumed = true;
                } else if (keyEvent.getEventType() == KeyEvent.KEY_TYPED) {
                    // we do not need to do anything here
                }
                else if (keyEvent.getEventType() == KeyEvent.KEY_RELEASED) {
                    isConsumed = false;
                }
            }
        }
    };

}
