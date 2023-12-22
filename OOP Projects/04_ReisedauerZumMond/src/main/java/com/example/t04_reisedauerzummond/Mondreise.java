package com.example.t04_reisedauerzummond;

public class Mondreise {

    private static final int distanzMond = 385000;

    private double Kmh = 0;

    public Mondreise(double speedKmh) {
        Kmh = speedKmh;
    }



    public double getTravelDurationDays() {
        return this.getTravelDurationHours() / 24;
    }

    public double getTravelDurationHours() {
        return distanzMond / Kmh;
    }

}
