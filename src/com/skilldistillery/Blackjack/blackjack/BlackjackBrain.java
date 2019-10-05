package com.skilldistillery.Blackjack.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.Blackjack.common.Card;
import com.skilldistillery.Blackjack.common.Deck;

public class BlackjackBrain {

	// F I E L D S
	private Deck deck;
	private Person player;
	private Person dealer;
	private Person cardCountingPlayer;
	private List<Person> players;
	private List<Card> dealtCards;

	private boolean playAgain = false;
	private boolean winner = false;

	public BlackjackBrain() {
		deck = new Deck();
		player = new Player("Player");
		dealer = new Dealer("Dealer");
		dealtCards = new ArrayList<>();
		players = new ArrayList<>();
		players.add(player);
		players.add(dealer);
	}

	public void setUpGame() {
		cardCountingPlayer = new CardCountingPlayer("CardCounter");
		players.add(cardCountingPlayer);
	}

	public void dealCards() {

		if (deck.checkDeckSize() <= 9) {
			System.out.println("OUTA CARDS..\n");
			System.out.println("Creating new deck..\n");// idkkkkkkkkk
			deck = new Deck();
		}

		for (int i = 0; i < 2; i++) {
			for (Person p : players) {
				Card cHolder = deck.dealCard();
				p.addCardToHand(cHolder);
				dealtCards.add(cHolder);
			}
		}
	}

	public boolean checkWinnerBeforePlay() {

		for (Person p : players) {

			if (p.getHand().isBlackJack()) {
				System.out.println("Player " + p.getType() + "BlackJACKK!");
				System.out.println(p);
				winner = true;
				return true;
			}
		}
		return false;
	}

	public boolean getPlayAgain() {
		return playAgain;
	}

	public void showCards() {

		for (Person p : players) {
			if (p.getType().equals("Dealer")) {// instance of?
				System.out.println("Dealer hand= [" + p.showOneCard() + ", xxxxxxx]");
			} else {
				System.out.println(p + " " + p.getType() + " " + p.checkHand());
			}
		}
		System.out.println();
	}

	public void gamePlay(Scanner kb) {

		while (!winner) {

			if (players.size() == 3) {
				if (cardCountingPlayer instanceof CardCountingPlayer) {
					((CardCountingPlayer) cardCountingPlayer).playCardCounter(dealtCards, cardCountingPlayer.getHand(),
							deck);
				}
			}

			System.out.println("Hit or Stay? ");
			String userHitStay = kb.nextLine();

			switch (userHitStay) {

			case "hit":
				Card cHolder2 = deck.dealCard();
				player.addCardToHand(cHolder2);
				dealtCards.add(cHolder2);
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
			try {
				cardCountingPlayer.clearHand();
			} catch (NullPointerException e) {
			}

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
			System.out.println("21! PLayer Wins!");
			winner = true;
		}
	}

	public void checkDealerHand() {
		if (dealer.getHand().isBlackJack()) {
			System.out.println("21!! Dealer Wins!");
			winner = true;
		}

		else if (dealer.checkHand() > player.checkHand()) {
			System.out.println("Dealer wins!");
			winner = true;
		}

		else if (dealer.checkHand() == player.checkHand()) {
			System.out.println("Pushhhh");
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
			Card cHolder3 = deck.dealCard();
			dealer.addCardToHand(cHolder3);
			dealtCards.add(cHolder3);
			System.out.println("Dealer hits..\n");
			System.out.println(dealer);

			if (dealer.getHand().isBust()) {
				System.out.println("Dealer BUSTSS! Player WINS!");
				try {
					if (!cardCountingPlayer.getHand().isBust()) {
						System.out.println("CardCounter Wins!");
					}
				} catch (Exception e) {
				}

				winner = true;
				break;
			} else if (dealer.getHand().isBlackJack()) {
				System.out.println("Dealer Wins!");
				winner = true;
				break;
			} else if (dealer.checkHand() > player.checkHand()) {
				System.out.println("Dealer WINS!");
				winner = true;
				break;
			} else if (dealer.checkHand() == 17) {
				System.out.println("Dealer must stay..\nPlayer Wins!!s");
				winner = true;// end game.. not really 'winner'
				break;
			} else if (dealer.checkHand() == player.checkHand()) {
				System.out.println("PUUshhhhhhh!");
				winner = true;
				break;
			} else if (dealer.checkHand() > 17) {
				System.out.println("Over 17.. dealer must stay.\nPlayer wins!");
				winner = true;
				break;
			}

		}
	}

}
