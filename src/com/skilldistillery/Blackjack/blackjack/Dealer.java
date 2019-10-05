package com.skilldistillery.Blackjack.blackjack;


public class Dealer extends Person{

	// F I E L D S 
	//private List<Card> dealerHand;
	//private BlackjackHand hand;
	
	// C O N S T R U C T O R
	public Dealer(String type) {
		super(type);
	}
	
//	public void addCardToHand(Card c) {
//		hand.addCard(c);
//	}
//	
//	public void clearHand() {
//		this.hand.clear();
//	}
//	
//	public BlackjackHand getHand() {
//		return this.hand;
//	}
//	
//	public int checkHand() {
//		return hand.getHandValue();
//	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Dealer hand= ");
		builder.append(this.getHand());
		return builder.toString();
	}
	
//	public Card showOneCard() {
//		return hand.getFirstCard();
//	}
}
