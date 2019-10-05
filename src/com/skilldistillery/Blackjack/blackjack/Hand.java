package com.skilldistillery.Blackjack.blackjack;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.Blackjack.common.Card;

public abstract class Hand {

	// F I E L D S
	 private List<Card> cards;
	
	
	//C O N S T R U C T O R
	public Hand() {
		cards = new ArrayList<>();
	}
	
	public void addCard(Card card) {
		cards.add(card);
	}
	
	public void clear() {
		cards.removeAll(cards);
	}
	
	public Card getFirstCard() {
		return cards.get(0);
	}
	
	public List<Card> getCards() {
		return this.cards;
	}
	
	public abstract int getHandValue();

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(cards.toString());
		return builder.toString();
	}
	

}
