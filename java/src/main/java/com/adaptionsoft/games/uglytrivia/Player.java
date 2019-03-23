package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private static final int NUM_PLACES = 12;
    private static final int POTENTIAL_DEAD_ROLL = 6;

    private final String name;
    private int coins;
    private int place;
    private boolean inPenaltyBox;
    private List<Integer> rolls;

    public Player(String name) {
        this.name = name;
        this.coins = 0;
        this.place = 0;
        this.inPenaltyBox = false;
        this.rolls = new ArrayList<Integer>();
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
        rolls.add(roll);

        place += roll;
        if (place >= NUM_PLACES) place -= NUM_PLACES;

        if (isDeadlyRoll()) {
            coins = 0;
        }
    }

    private boolean isDeadlyRoll() {
        return rolls.size() >= 2 &&
                rolls.get(rolls.size() - 1) == POTENTIAL_DEAD_ROLL &&
                rolls.get(rolls.size() - 2) == POTENTIAL_DEAD_ROLL;
    }

    public void goToPenaltyBox() {
        this.inPenaltyBox = true;
    }

    public boolean inPenaltyBox() {
        return this.inPenaltyBox;
    }
}
