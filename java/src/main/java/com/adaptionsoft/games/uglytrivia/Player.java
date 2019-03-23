package com.adaptionsoft.games.uglytrivia;

public class Player {
    public static final int NUM_PLACES = 12;
    private final String name;
    private int coins;
    private int place;

    public Player(String name) {
        this.name = name;
        this.coins = 0;
        this.place = 0;
    }

    public String name() {
        return name;
    }

    public int coins() {
        return coins;
    }

    public int place() {
        return place;
    }

    public void addOneCoin() {
        this.coins++;
    }

    public boolean didPlayerWin() {
        return coins == 6;
    }

    public void move(int roll) {
        place += roll;
        if (place >= NUM_PLACES) place -= NUM_PLACES;
    }
}
