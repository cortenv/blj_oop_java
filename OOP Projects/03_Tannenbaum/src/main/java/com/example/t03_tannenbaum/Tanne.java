package com.example.t03_tannenbaum;

public class Tanne {

    private int Stammbreite;
    private int Stammhoehe;
    private int Kronenhoehe;
    private String Zeichnung;

    public void setStammhoehe(int stammhoehe) {
        this.Stammhoehe = stammhoehe;
    }

    public int getStammhoehe() {
        return Stammhoehe;
    }

    public void setStammbreite(int stammbreite) {
        this.Stammbreite = stammbreite;
    }

    public int getStammbreite() {
        return Stammbreite;
    }

    public void setKronenhoehe(int kronenhoehe) {
        this.Kronenhoehe = kronenhoehe;
    }

    public int getKronenhoehe() {
        return Kronenhoehe;
    }



    public String getZeichnung() {
        return Zeichnung;
    }

    public void setZeichnung(String zeichnung) {
        this.Zeichnung = zeichnung;
    }

    public Tanne(int stammbreite, int stammhoehe, int kronenhoehe) {
        this.Stammbreite = stammbreite;
        this.Stammhoehe = stammhoehe;
        this.Kronenhoehe = kronenhoehe;
    }

    public void zeichne() {
        Zeichnung = "";
        zeichneKrone();
        zeichneStamm();

    }

    private void zeichneKrone() {
        for (int i = 1; i <= Kronenhoehe; ++i)
            zeichneZeile(Kronenhoehe - i, 2 * i - 1);
    }

    private void zeichneStamm() {
        for (int i = 1; i <= Stammhoehe; ++i)
            zeichneZeile(Kronenhoehe - Stammbreite / 2 - 1, Stammbreite);
    }

    private void zeichneZeile(int start, int breite) {
        int i;
        for (i = 1; i <= start; ++i)
            Zeichnung += " ";

        for (i = 1; i <= breite; ++i)
            Zeichnung += "*";

        Zeichnung += "\n";
    }
}