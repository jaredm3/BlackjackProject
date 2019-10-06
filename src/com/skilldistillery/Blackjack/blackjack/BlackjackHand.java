package com.skilldistillery.Blackjack.blackjack;

import com.skilldistillery.Blackjack.common.Card;

public class BlackjackHand extends Hand {

	public BlackjackHand() {

	}

	@Override
	public int getHandValue() {
		int cardValueHolder = 0;

		for (Card c : getCards()) {
			cardValueHolder += c.getValue();
		}

		return cardValueHolder;
	}

	public boolean isBlackJack() {

		if (getHandValue() == 21) {
			return true;
		} else {
			return false;
		}

	}

	public boolean isBust() {

		if (getHandValue() > 21) {
			return true;
		} else {
			return false;
		}

	}

}
