package com.skilldistillery.Blackjack.common;

public class Card {

	//F I E L D S
	private Suit suit;
	private Rank rank;
	
	//C O N S T R U C T O R
	
	public Card(Suit s, Rank r) {
		this.suit = s;
		this.rank = r;
	}

	
	public int getValue() {
		return rank.getValue();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (rank != other.rank)
			return false;
		if (suit != other.suit)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
//		builder.append("Card [suit=");
//		builder.append(suit);
//		builder.append("Rank=");
		builder.append(rank);
		builder.append(" of ");
		builder.append(suit);
		return builder.toString();
	}
	
}