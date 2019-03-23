package com.adaptionsoft.games.uglytrivia;

public class Player {
    private final String name;
    private int coins;

    public Player(String name) {
        this.name = name;
        this.coins = 0;
    }

    public String name() {
        return name;
    }

    public int coins() {
        return coins;
    }

    public void addOneCoin() {
        this.coins++;
    }

    public boolean didPlayerWin() {
        return coins == 6;
    }
}
