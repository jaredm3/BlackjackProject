package com.skilldistillery.Blackjack.blackjack;

import com.skilldistillery.Blackjack.common.Card;

public class Person {

	// F I E L D S
	private BlackjackHand hand;
	private String type;

	// C O N S T R U C T O R
	public Person(String type) {
		hand = new BlackjackHand();
		this.type = type;
	}

	public void addCardToHand(Card c) {
		this.hand.addCard(c);
	}

	public BlackjackHand getHand() {
		return this.hand;
	}

	public int checkHand() {
		return this.hand.getHandValue();
	}

	public void clearHand() {
		this.hand.clear();
	}

	public Card showOneCard() {
		return hand.getFirstCard();
	}

	public String getType() {
		return this.type;
	}
}
