package samples.javafx.usercontrols;

import ch.ictbz.lib.ui.UserControl;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import samples.javafx.interfaces.IObserver;
import samples.javafx.interfaces.ISubject;
import java.util.LinkedList;

/**
 * Created by nuu on 23.01.2017.
 */
public class TemperatureSensor extends UserControl implements ISubject{

    @FXML
    private Slider horizontalSlider;

    private LinkedList<IObserver> observers;


    /**
     * Constructor.
     */
    public  TemperatureSensor(){
        //horizontalSlider.setValue(0.0);
        observers = new LinkedList<IObserver>();

        // add a change listenter to the value property of the slider (see: http://code.makery.ch/blog/javafx-8-event-handling-examples/)
        horizontalSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            this.notifyObservers();
        });
    }

    /*
     * Destructor.
    @Override
    public void finalize () {
        for (IObserver observer : observers) {
            this.detach(observer);
        }
    }
    */

    @Override
    public void attach(IObserver observer) {
        if (!observers.contains(observer))
            observers.add(observer);
    }

    @Override
    public void detach(IObserver observer) {
        if (observers.contains(observer))
            observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (IObserver observer: observers) {
            observer.update((int)horizontalSlider.getValue());
        }
    }
}
