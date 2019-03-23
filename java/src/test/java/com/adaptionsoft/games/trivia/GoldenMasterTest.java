package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.trivia.runner.GameRunner;
import com.adaptionsoft.games.uglytrivia.Game;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Random;

import static junit.framework.Assert.assertEquals;

public class GoldenMasterTest {

    @Test
    public void a_few_winner_games() throws IOException {
        // Arrange
        PrintStream fileStream = new PrintStream("output.txt");
        System.setOut(fileStream);

        // Act
        for (int i = 0; i < 100; i++) {
            final GameRunner gameRunner = new GameRunner();
            final Game aGame = new Game();
            aGame.add("Chet");
            aGame.add("Pat");
            aGame.add("Sue");
            gameRunner.runGame(aGame, new Random(i));
        }

        // Assert
        final String output = readOutputFile("output.txt");
        final String expectedOutput = readOutputFile("expectedOutput.txt");
        assertEquals(expectedOutput, output);
    }

    private String readOutputFile(String fileName) throws IOException {
        final FileInputStream fileInputStream = new FileInputStream(fileName);
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        String line = bufferedReader.readLine();
        final StringBuilder stringBuilder = new StringBuilder();

        while (line != null) {
            stringBuilder.append(line).append("\n");
            line = bufferedReader.readLine();
        }
        return stringBuilder.toString();
    }
}
