package samples.javafx.model;

/**
 * Created by nuu in 2016.
 */
public class Tanne {
    private int stammbreite = 0;
    private int stammhoehe = 0;
    private int kronenhoehe = 0;
    private String zeichnung = "";

    public int getStammbreite() {
        return stammbreite;
    }

    public int getStammhoehe() {
        return stammhoehe;
    }

    public int getKronenhoehe() {
        return kronenhoehe;
    }

    public String getZeichnung() {
        return zeichnung;
    }

    /**
     * Constructor.
     */
    public Tanne(int stammbreite, int stammhoehe, int kronenhoehe) {
        this.stammbreite = stammbreite;
        this.stammhoehe = stammhoehe;
        this.kronenhoehe = kronenhoehe;
    }

    public void zeichne() {
        zeichnung = "";
        zeichneKrone();
        zeichneStamm();
    }

    private void zeichneKrone() {
        for (int i = 1; i <= kronenhoehe; ++i)
            zeichneZeile(kronenhoehe - i, 2 * i - 1);
    }

    private void zeichneStamm() {
        for (int i = 1; i <= stammhoehe; ++i)
            zeichneZeile(kronenhoehe - stammbreite / 2 - 1, stammbreite);
    }

    private void zeichneZeile(int anfang, int breite) {
        int i;
        for (i = 1; i <= anfang; ++i)
            zeichnung += " ";

        for (i = 1; i <= breite; ++i)
            zeichnung += "*";

        zeichnung += "\n";
    }
}
