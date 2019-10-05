package com.skilldistillery.Blackjack.blackjack;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.Blackjack.common.Card;

public class Player {

	// F I E L D S 
	//private List<Card> playerHand;
	private BlackjackHand hand;
	
	
	// C O N S T R U C T O R
	public Player() {
		hand = new BlackjackHand();
	}
	
	public void addCardToHand(Card c) {
		hand.addCard(c);
	}
	
	public BlackjackHand getHand() {
		return this.hand;
	}
	
	public int checkHand() {
		return hand.getHandValue();
	}
	
	public void clearHand() {
		this.hand.clear();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Player hand= ");
		builder.append(hand);
		return builder.toString();
	}

}
