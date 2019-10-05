package com.skilldistillery.Blackjack.blackjack;


public class Player extends Person{

	// F I E L D S 
	//private List<Card> playerHand;
	//private BlackjackHand hand;
	
	
	// C O N S T R U C T O R
	public Player(String type) {
		super(type);
	}
	
//	public void addCardToHand(Card c) {
//		hand.addCard(c);
//	}
//	
//	public BlackjackHand getHand() {
//		return this.hand;
//	}
//	
//	public int checkHand() {
//		return hand.getHandValue();
//	}
//	
//	public void clearHand() {
//		this.hand.clear();
//	}
//	
//	public Card showOneCard() {
//		return hand.getFirstCard();
//	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Player hand= ");
		builder.append(this.getHand());
		return builder.toString();
	}

}
