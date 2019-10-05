package com.skilldistillery.Blackjack.blackjack;

import java.util.List;

import com.skilldistillery.Blackjack.common.Card;
import com.skilldistillery.Blackjack.common.Deck;

public class CardCountingPlayer extends Person {

	// F I E L D S

	// C O N S T R U C T O R
	public CardCountingPlayer(String type) {
		super(type);
	}

	public int countCards(List<Card> cards) {
		int cardCount = 0;
		for (Card c : cards) {
			if (c.getValue() <= 6) {
				cardCount++;
			} else if (c.getValue() <= 9) {
				cardCount += 0;
			} else {
				cardCount--;
			}
		}

		return cardCount;
	}

	public void playCardCounter(List<Card> playedCards, BlackjackHand myHand, Deck deck) {
		int cardCount = countCards(playedCards);

		if (cardCount >= 3) {
			System.out.println("Card count is " + cardCount + ", BET BIG");
		} else if (cardCount >= 0) {
			System.out.println("Card count is " + cardCount + ", bet normally");
		} else {
			System.out.println("Card count is " + cardCount + ", bet minimum");
		}

		while (myHand.getHandValue() <= 11) {// hit

			Card cHolder = deck.dealCard();
			playedCards.add(cHolder);
			cardCount += countCards(playedCards);
			myHand.addCard(cHolder);
			System.out.println("CardCounter hitting..\n" + myHand + myHand.getHandValue());
			checkHand2(myHand);
		}

		if (myHand.getHandValue() < 15 && cardCount <= 0 && !myHand.isBust() && !myHand.isBlackJack()) {// hit
			Card cHolder = deck.dealCard();
			playedCards.add(cHolder);
			cardCount += countCards(playedCards);
			myHand.addCard(cHolder);
			System.out.println("Count is low...");
			System.out.println("CardCounter hitting..\n" + myHand + myHand.getHandValue());
			if (checkHand2(myHand)) {
				System.out.println("CardCounter stays at " + myHand.getHandValue());
			}
		} else {
			System.out.println("CardCounter stays at " + myHand.getHandValue());
		}

	}

	public boolean checkHand2(BlackjackHand myHand) {
		if (myHand.isBust()) {
			System.out.println("CardCounter BUST");
			return false;
		} else if (myHand.isBlackJack()) {
			System.out.println("CardCounter Wins!");
			return false;
		} else {
			System.out.println();
			return true;
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Card Counting Player hand= ");
		builder.append(this.getHand());
		return builder.toString();
	}

}
