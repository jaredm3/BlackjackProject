package com.skilldistillery.Blackjack.blackjack;

public class Player extends Person {

	// C O N S T R U C T O R
	public Player(String type) {
		super(type);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Player hand= ");
		builder.append(this.getHand());
		return builder.toString();
	}

}
