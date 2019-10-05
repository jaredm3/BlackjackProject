package com.skilldistillery.Blackjack.blackjack;

import com.skilldistillery.Blackjack.common.Card;

public class Dealer {

	// F I E L D S 
	//private List<Card> dealerHand;
	private BlackjackHand hand;
	
	// C O N S T R U C T O R
	public Dealer() {
		hand = new BlackjackHand();
	}
	
	public void addCardToHand(Card c) {
		hand.addCard(c);
	}
	
	public void clearHand() {
		this.hand.clear();
	}
	
	public BlackjackHand getHand() {
		return this.hand;
	}
	
	public int checkHand() {
		return hand.getHandValue();
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Dealer hand= ");
		builder.append(hand);
		return builder.toString();
	}
	
	public Card showOneCard() {
		return hand.getFirstCard();
	}
}
