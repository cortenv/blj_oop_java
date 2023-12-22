package samples.javafx;

/**
 * Created by nuu on 23.12.2016.
 */
public class C {

    private static int instanceCounter = 0;

    /**
     * Constructor.
     */
    public C() {
        instanceCounter++;
    }

    public static int getCountOfInstances() {
        return instanceCounter;
    }

    public static void resetInstaceCounter() {
        instanceCounter = 0;
    }

}
