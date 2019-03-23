package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.LinkedList;

public class Game {
    ArrayList<Player> players = new ArrayList();
    boolean[] inPenaltyBox  = new boolean[6];
    
    LinkedList popQuestions = new LinkedList();
    LinkedList scienceQuestions = new LinkedList();
    LinkedList sportsQuestions = new LinkedList();
    LinkedList rockQuestions = new LinkedList();
    
    int currentPlayer = 0;
    boolean isGettingOutOfPenaltyBox;
    
    public  Game(){
    	for (int i = 0; i < 50; i++) {
			popQuestions.addLast("Pop Question " + i);
			scienceQuestions.addLast(("Science Question " + i));
			sportsQuestions.addLast(("Sports Question " + i));
			rockQuestions.addLast(createRockQuestion(i));
    	}
    }

	public String createRockQuestion(int index){
		return "Rock Question " + index;
	}
	
	public boolean isPlayable() {
		return (howManyPlayers() >= 2);
	}

	public boolean add(String playerName) {
	    players.add(new Player(playerName));
	    inPenaltyBox[howManyPlayers()] = false;
	    
	    System.out.println(playerName + " was added");
	    System.out.println("They are player number " + players.size());
		return true;
	}
	
	public int howManyPlayers() {
		return players.size();
	}

	public void roll(int roll) {
		System.out.println(currentPlayer().name() + " is the current player");
		System.out.println("They have rolled a " + roll);
		
		if (inPenaltyBox[currentPlayer]) {
			if (isOddRoll(roll)) {
				isGettingOutOfPenaltyBox = true;
				
				System.out.println(currentPlayer().name() + " is getting out of the penalty box");
				currentPlayer().move(roll);

				System.out.println(currentPlayer().name()
						+ "'s new location is " 
						+ currentPlayer().place());
				System.out.println("The category is " + currentCategory());
				askQuestion();
			} else {
				System.out.println(currentPlayer().name() + " is not getting out of the penalty box");
				isGettingOutOfPenaltyBox = false;
			}
			
		} else {
			currentPlayer().move(roll);
			
			System.out.println(currentPlayer().name()
					+ "'s new location is " 
					+ currentPlayer().place());
			System.out.println("The category is " + currentCategory());
			askQuestion();
		}
		
	}

	private boolean isOddRoll(int roll) {
		return roll % 2 != 0;
	}

	private Player currentPlayer() {
		return players.get(currentPlayer);
	}

	private void askQuestion() {
		if (currentCategory() == "Pop")
			System.out.println(popQuestions.removeFirst());
		if (currentCategory() == "Science")
			System.out.println(scienceQuestions.removeFirst());
		if (currentCategory() == "Sports")
			System.out.println(sportsQuestions.removeFirst());
		if (currentCategory() == "Rock")
			System.out.println(rockQuestions.removeFirst());		
	}
	
	
	private String currentCategory() {
		if (currentPlayer().place() == 0) return "Pop";
		if (currentPlayer().place() == 4) return "Pop";
		if (currentPlayer().place() == 8) return "Pop";
		if (currentPlayer().place() == 1) return "Science";
		if (currentPlayer().place() == 5) return "Science";
		if (currentPlayer().place() == 9) return "Science";
		if (currentPlayer().place() == 2) return "Sports";
		if (currentPlayer().place() == 6) return "Sports";
		if (currentPlayer().place() == 10) return "Sports";
		return "Rock";
	}

	public boolean wasCorrectlyAnswered() {
		if (inPenaltyBox[currentPlayer]){
			if (isGettingOutOfPenaltyBox) {
				System.out.println("Answer was correct!!!!");
				currentPlayer().addOneCoin();
				System.out.println(currentPlayer().name()
						+ " now has "
						+ currentPlayer().coins()
						+ " Gold Coins.");
				
				boolean stillPlaying = isStillPlaying();
				currentPlayer++;
				if (currentPlayer == players.size()) currentPlayer = 0;
				
				return stillPlaying;
			} else {
				currentPlayer++;
				if (currentPlayer == players.size()) currentPlayer = 0;
				return true;
			}
			
			
			
		} else {
		
			System.out.println("Answer was corrent!!!!");
			currentPlayer().addOneCoin();
			System.out.println(currentPlayer().name()
					+ " now has "
					+ currentPlayer().coins()
					+ " Gold Coins.");
			
			boolean winner = isStillPlaying();
			currentPlayer++;
			if (currentPlayer == players.size()) currentPlayer = 0;
			
			return winner;
		}
	}
	
	public boolean wrongAnswer(){
		System.out.println("Question was incorrectly answered");
		System.out.println(currentPlayer().name() + " was sent to the penalty box");
		inPenaltyBox[currentPlayer] = true;
		
		currentPlayer++;
		if (currentPlayer == players.size()) currentPlayer = 0;
		return true;
	}

	private boolean isStillPlaying() {
		return !(currentPlayer().didPlayerWin());
	}
}
