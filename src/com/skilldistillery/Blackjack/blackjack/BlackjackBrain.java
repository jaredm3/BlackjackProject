package com.skilldistillery.Blackjack.blackjack;

import java.util.Scanner;

import com.skilldistillery.Blackjack.common.Deck;

public class BlackjackBrain {

	// F I E L D S
	Deck deck;
	Player player;
	Dealer dealer;
	private boolean playAgain = false;
	private boolean winner = false;

	public BlackjackBrain() {
		deck = new Deck();
		player = new Player();
		dealer = new Dealer();
	}

	public void dealCards() {
		player.addCardToHand(deck.dealCard());
		dealer.addCardToHand(deck.dealCard());
		player.addCardToHand(deck.dealCard());
		dealer.addCardToHand(deck.dealCard());
	}

	public boolean checkWinnerBeforePlay() {
		if (player.checkHand() == 21) {
			System.out.println("Player BLACKJACK");
			return true;
		} else if (dealer.checkHand() == 21) {
			System.out.println("Dealer BLACKJACK");
			return true;
		} else {
			return false;
		}
	}
	
	public boolean checkWinner() {
		if (player.checkHand() == 21) {
			System.out.println("Player BLACKJACK");
			return true;
		} else if (dealer.checkHand() == 21) {
			System.out.println("Dealer BLACKJACK");
			return true;
		} else {
			return false;
		}
	}

	public boolean getPlayAgain() {
		return playAgain;
	}

	public boolean checkBust() {
		if (player.checkHand() >= 21) {
			return true;
		} else if (dealer.checkHand() >= 21) {
			return true;
		} else {
			return false;
		}
	}

	public void showCards() {
		System.out.println(player + " " + player.checkHand());
		System.out.println("Dealer hand= [" + dealer.showOneCard() + ", xxxxxxx]");
	}

	public void gamePlay(Scanner kb) {

		while (!winner && !checkBust()) {
			System.out.println("Hit or Stay? ");
			String userHitStay = kb.nextLine();

			switch (userHitStay) {
			case "hit":
				player.addCardToHand(deck.dealCard());
				System.out.println(player.getHand().toString());
				System.out.println("Player hand: " + player.checkHand());

				if (player.getHand().isBust()) {
					System.out.println("Player BUST\nDealer wins");
					//checkWinner();
					//break;
					winner = true;
				}
				else if (player.getHand().isBlackJack()) {
					System.out.println("PLayer Wins! ?Blackjack?");
					winner = true;
				}
				break;
			case "stay":
				System.out.println(dealer);
				System.out.println("Dealer hand: " + dealer.checkHand());
				
				if (dealer.checkHand()>player.checkHand()) {
					System.out.println("DEALERR wins!");
					winner = true;
					break;
				}
				
				if (dealer.checkHand()==player.checkHand()) {
					System.out.println("PUSHhhhhhh");
					winner = true;//end game.. not really 'winner'
					break;
				}
				
				if (dealer.checkHand()==17) {
					System.out.println("Dealer must stay..\nPlayer Wins!!s");
					winner = true;//end game.. not really 'winner'
					break;
				}

				while (dealer.checkHand() < 17 && (dealer.checkHand() < player.checkHand())) {
					dealer.addCardToHand(deck.dealCard());
					System.out.println("Dealer hits..\n");
					System.out.println(dealer);
					
					if (dealer.getHand().isBust()) {
						System.out.println("Dealer BUSTSS! Player WINS!");
						winner = true;
						break;
					}
					
					else if (dealer.checkHand() > player.checkHand()) {
						System.out.println("Dealer WINS!");
						winner = true;
						break;
					}
					else if (dealer.checkHand() == player.checkHand()) {
						System.out.println("PUUshhhhhhh!");
						winner = true;
						break;
					}
//					else {
//						if (player.checkHand() > dealer.checkHand()) {
//							System.out.println("Player wins!");
//							winner = true;
//							break;
//						} else if (player.checkHand() < dealer.checkHand()) {
//							System.out.println("Dealer wins!");
//							winner = true;
//							break;
//						} else if (player.checkHand() == dealer.checkHand()) {
//							System.out.println("PUSHHHHHH");
//							winner = true;
//							break;
//						}
//					}
				}

				break;

			default:
				break;
			}

		}

		System.out.println("Play again?? y/n");
		String userPlayAgain = kb.nextLine();

		if (userPlayAgain.equals("y")) {
			player.clearHand();
			dealer.clearHand();
			playAgain = true;
			winner = false;
		} else {
			System.exit(0);
		}

	}

}
