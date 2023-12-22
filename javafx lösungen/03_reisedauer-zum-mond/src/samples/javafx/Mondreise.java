package samples.javafx;

public class Mondreise {

    private static final int DURCHSCHNITTLICHE_ENTFERNUNG_MOND = 385000;

    private double kmh = 0;

    public Mondreise(double speedKmh) {
        kmh = speedKmh;
    }

    /**
     * Berechnet die Dauer der Reise zum Mond in Tagen.
     * @return Dauer der Reise zum Mond in Tagen.
    */
    public double getTravelDurationDays() {
        return this.getTravelDurationHours() / 24;
    }

    /**
     * Berechnet die Dauer der Reise zum Mond in Stunden.
     * @return Dauer der Reise zum Mond in Stunden.
     */
    public double getTravelDurationHours() {
        return DURCHSCHNITTLICHE_ENTFERNUNG_MOND / kmh;
    }
}
