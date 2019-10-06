package com.skilldistillery.Blackjack.blackjack;

public class Dealer extends Person {

	// C O N S T R U C T O R
	public Dealer(String type) {
		super(type);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Dealer hand= ");
		builder.append(this.getHand());
		return builder.toString();
	}

}
