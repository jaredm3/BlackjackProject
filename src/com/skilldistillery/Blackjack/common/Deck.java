package com.skilldistillery.Blackjack.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	// F I E L D S
	List<Card> cards;

	// C O N S T R U C T O R
	public Deck() {
		cards = new ArrayList<>(52);
		cards = makeDeck();
		shuffle();
	}

	public List<Card> makeDeck() {
		List<Card> cardDeck = new ArrayList<>();

		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				cardDeck.add(new Card(s, r));
			}
		}

		return cardDeck;
	}

	public void shuffle() {
		Collections.shuffle(cards);
	}

	public Card dealCard() {
		return cards.remove(0);
	}

	public int checkDeckSize() {
		return cards.size();
	}

}
