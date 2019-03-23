package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.uglytrivia.Game;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import static junit.framework.Assert.assertEquals;

public class GoldenMasterTest {

    private Game aGame;

    @Before
    public void setUp() {
        aGame = new Game();
    }

    @Test
    public void a_winner_game() throws IOException {
        // Arrange
        PrintStream fileStream = new PrintStream("output.txt");
        System.setOut(fileStream);

        // Act
        aGame.add("Chet");
        aGame.add("Pat");
        aGame.add("Sue");
        aGame.roll(6);

        // Assert
        final FileInputStream fileInputStream = new FileInputStream("output.txt");
        final String output = readOutputFile(fileInputStream);

        assertEquals("Chet was added\n" +
                        "They are player number 1\n" +
                        "Pat was added\n" +
                        "They are player number 2\n" +
                        "Sue was added\n" +
                        "They are player number 3\n" +
                        "Chet is the current player\n" +
                        "They have rolled a 6\n" +
                        "Chet's new location is 6\n" +
                        "The category is Sports\n" +
                        "Sports Question 0\n",
                output);
    }

    private String readOutputFile(FileInputStream fileInputStream) throws IOException {
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
