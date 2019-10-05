package com.skilldistillery.Blackjack.common;

public enum Suit {
	HEARTS("Hearts"),
	SPADES("Spades"),
	CLUBS("Clubs"), 
	DIAMONDS("Diamonds");
	
	Suit(String name) {
		this.name = name;
	}

	//F I E L D
	 private String name;
	
	@Override
	  public String toString() {
	    return name;
	  }
}

