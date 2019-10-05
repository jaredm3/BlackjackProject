package com.skilldistillery.Blackjack.blackjack;

import java.util.Scanner;

public class BlackjackApp {

	private BlackjackBrain brain = new BlackjackBrain();

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		BlackjackApp app = new BlackjackApp();

		System.out.println("Welcome to BLACKJACK\n");

		do {
			app.launch(kb);
		} while (app.brain.getPlayAgain());
	
	}

	public void launch(Scanner kb) {
		brain.dealCards();
		brain.showCards();
		brain.checkWinnerBeforePlay();
		brain.gamePlay(kb);
	}

	public void deal() {

	}
}
