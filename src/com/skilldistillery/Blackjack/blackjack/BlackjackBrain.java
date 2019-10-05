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
		if (player.getHand().isBlackJack()) {
			System.out.println("Player BLACKJACK");
			winner = true;
			return true;
		} else if (dealer.getHand().isBlackJack()) {
			System.out.println("Dealer BLACKJACK");
			System.out.println(dealer);
			winner = true;
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

		while (!winner) {
			System.out.println("Hit or Stay? ");
			String userHitStay = kb.nextLine();

			switch (userHitStay) {

			case "hit":
				player.addCardToHand(deck.dealCard());
				System.out.println(player.getHand().toString());
				System.out.println("Player hand: " + player.checkHand());

				checkPlayerHand();
				break;

			case "stay":
				System.out.println(dealer);
				System.out.println("Dealer hand: " + dealer.checkHand());

				checkDealerHand();
				dealerHitLogic();
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
			System.out.println("You going to get more money?");
			kb.close();
			System.exit(0);
		}

	}

	public void checkPlayerHand() {
		if (player.getHand().isBust()) {
			System.out.println("Player BUST\nDealer wins");
			winner = true;
		} else if (player.getHand().isBlackJack()) {
			System.out.println("PLayer Wins! ?Blackjack?");
			winner = true;
		}
	}

	public void checkDealerHand() {
		if (dealer.getHand().isBlackJack()) {
			System.out.println("21!! Dealer Wins! ?BlackJack?");
			winner = true;
		}

		else if (dealer.checkHand() > player.checkHand()) {
			System.out.println("DEALERR wins!");
			winner = true;
		}

		else if (dealer.checkHand() == player.checkHand()) {
			System.out.println("PUSHhhhhhh");
			winner = true;// end game.. not really 'winner'
		}

		else if (dealer.checkHand() == 17) {
			System.out.println("Dealer must stay..\nPlayer Wins!!");
			winner = true;
		}

		else if (dealer.checkHand() > 17) {
			System.out.println("Over 17.. dealer must stay.\nPlayer wins!");
			winner = true;
		}
	}

	public void dealerHitLogic() {

		while (dealer.checkHand() < 17 && (dealer.checkHand() < player.checkHand())) {
			dealer.addCardToHand(deck.dealCard());
			System.out.println("Dealer hits..\n");
			System.out.println(dealer);

			if (dealer.getHand().isBust()) {
				System.out.println("Dealer BUSTSS! Player WINS!");
				winner = true;
				break;
			}
			else if (dealer.getHand().isBlackJack()) {
				System.out.println("Dealer Wins! ?Blackjack?");
				winner = true;
				break;
			}
			else if (dealer.checkHand() > player.checkHand()) {
				System.out.println("Dealer WINS!");
				winner = true;
				break;
			}
			else if (dealer.checkHand() == 17) {
				System.out.println("Dealer must stay..\nPlayer Wins!!s");
				winner = true;// end game.. not really 'winner'
				break;
			}
			else if (dealer.checkHand() == player.checkHand()) {
				System.out.println("PUUshhhhhhh!");
				winner = true;
				break;
			} 
			else if (dealer.checkHand() > 17) {
				System.out.println("Over 17.. dealer must stay.\nPlayer wins!");
				winner = true;
				break;
			}

		}
	}

}
