package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.trivia.runner.GameRunner;
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

    private GameRunner gameRunner;

    @Before
    public void setUp() {
        gameRunner = new GameRunner();
    }

    @Test
    public void a_winner_game() throws IOException {
        // Arrange
        PrintStream fileStream = new PrintStream("output.txt");
        System.setOut(fileStream);

        // Act
        gameRunner.main(new String[]{}, 123);

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
                        "They have rolled a 3\n" +
                        "Chet's new location is 3\n" +
                        "The category is Rock\n" +
                        "Rock Question 0\n" +
                        "Answer was corrent!!!!\n" +
                        "Chet now has 1 Gold Coins.\n" +
                        "Pat is the current player\n" +
                        "They have rolled a 2\n" +
                        "Pat's new location is 2\n" +
                        "The category is Sports\n" +
                        "Sports Question 0\n" +
                        "Answer was corrent!!!!\n" +
                        "Pat now has 1 Gold Coins.\n" +
                        "Sue is the current player\n" +
                        "They have rolled a 1\n" +
                        "Sue's new location is 1\n" +
                        "The category is Science\n" +
                        "Science Question 0\n" +
                        "Answer was corrent!!!!\n" +
                        "Sue now has 1 Gold Coins.\n" +
                        "Chet is the current player\n" +
                        "They have rolled a 5\n" +
                        "Chet's new location is 8\n" +
                        "The category is Pop\n" +
                        "Pop Question 0\n" +
                        "Answer was corrent!!!!\n" +
                        "Chet now has 2 Gold Coins.\n" +
                        "Pat is the current player\n" +
                        "They have rolled a 1\n" +
                        "Pat's new location is 3\n" +
                        "The category is Rock\n" +
                        "Rock Question 1\n" +
                        "Answer was corrent!!!!\n" +
                        "Pat now has 2 Gold Coins.\n" +
                        "Sue is the current player\n" +
                        "They have rolled a 5\n" +
                        "Sue's new location is 6\n" +
                        "The category is Sports\n" +
                        "Sports Question 1\n" +
                        "Answer was corrent!!!!\n" +
                        "Sue now has 2 Gold Coins.\n" +
                        "Chet is the current player\n" +
                        "They have rolled a 3\n" +
                        "Chet's new location is 11\n" +
                        "The category is Rock\n" +
                        "Rock Question 2\n" +
                        "Answer was corrent!!!!\n" +
                        "Chet now has 3 Gold Coins.\n" +
                        "Pat is the current player\n" +
                        "They have rolled a 3\n" +
                        "Pat's new location is 6\n" +
                        "The category is Sports\n" +
                        "Sports Question 2\n" +
                        "Answer was corrent!!!!\n" +
                        "Pat now has 3 Gold Coins.\n" +
                        "Sue is the current player\n" +
                        "They have rolled a 1\n" +
                        "Sue's new location is 7\n" +
                        "The category is Rock\n" +
                        "Rock Question 3\n" +
                        "Answer was corrent!!!!\n" +
                        "Sue now has 3 Gold Coins.\n" +
                        "Chet is the current player\n" +
                        "They have rolled a 5\n" +
                        "Chet's new location is 4\n" +
                        "The category is Pop\n" +
                        "Pop Question 1\n" +
                        "Answer was corrent!!!!\n" +
                        "Chet now has 4 Gold Coins.\n" +
                        "Pat is the current player\n" +
                        "They have rolled a 3\n" +
                        "Pat's new location is 9\n" +
                        "The category is Science\n" +
                        "Science Question 1\n" +
                        "Answer was corrent!!!!\n" +
                        "Pat now has 4 Gold Coins.\n" +
                        "Sue is the current player\n" +
                        "They have rolled a 2\n" +
                        "Sue's new location is 9\n" +
                        "The category is Science\n" +
                        "Science Question 2\n" +
                        "Answer was corrent!!!!\n" +
                        "Sue now has 4 Gold Coins.\n" +
                        "Chet is the current player\n" +
                        "They have rolled a 4\n" +
                        "Chet's new location is 8\n" +
                        "The category is Pop\n" +
                        "Pop Question 2\n" +
                        "Answer was corrent!!!!\n" +
                        "Chet now has 5 Gold Coins.\n" +
                        "Pat is the current player\n" +
                        "They have rolled a 4\n" +
                        "Pat's new location is 1\n" +
                        "The category is Science\n" +
                        "Science Question 3\n" +
                        "Answer was corrent!!!!\n" +
                        "Pat now has 5 Gold Coins.\n" +
                        "Sue is the current player\n" +
                        "They have rolled a 2\n" +
                        "Sue's new location is 11\n" +
                        "The category is Rock\n" +
                        "Rock Question 4\n" +
                        "Question was incorrectly answered\n" +
                        "Sue was sent to the penalty box\n" +
                        "Chet is the current player\n" +
                        "They have rolled a 2\n" +
                        "Chet's new location is 10\n" +
                        "The category is Sports\n" +
                        "Sports Question 3\n" +
                        "Answer was corrent!!!!\n" +
                        "Chet now has 6 Gold Coins.\n",
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
