package samples.javafx.interfaces;

/**
 * Created by nuu on 23.01.2017.
 */
public interface ISubject {

    void attach(IObserver observer);
    void detach(IObserver observer);
    void notifyObservers();
}
