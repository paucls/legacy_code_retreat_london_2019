package com.adaptionsoft.games.trivia.runner;

import com.adaptionsoft.games.uglytrivia.Game;

import java.util.Random;


public class App {

    public static void main(String[] args) {
        Random random = new Random();
        if (args != null && args.length > 0) {
            random = new Random(Integer.parseInt(args[0]));
        }

        final Game aGame = new Game();
        aGame.add("Chet");
        aGame.add("Pat");
        aGame.add("Sue");

        runGame(aGame, random);
    }

    private static void runGame(Game game, Random ramdom) {
        boolean notAWinner;
        do {
            game.roll(ramdom.nextInt(5) + 1);

            if (ramdom.nextInt(9) == 7) {
                notAWinner = game.wrongAnswer();
            } else {
                notAWinner = game.wasCorrectlyAnswered();
            }
        } while (notAWinner);
    }
}
