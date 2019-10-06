# Blackjack

Week 4 Homework Project for Skill Distillery

## Overview

This program utilizes OOP principals to create and Blackjack. There are two
packages used. One is a common package containing Card, Deck, Rank, and Suit.
The other package is specific to Blackjack, and contains many Classes used
for gameplay.

Upon launch, the user is asked if he/she wants a CardCounter player to play.

```
Welcome to BLACKJACK

Do you want your card counting friend to play with you? (y/n)

```

If the user selects **'n'**, the gameplay will only be between the **player and
the dealer**.

```
Do you want your card counting friend to play with you? (y/n)
n
Player hand= [EIGHT of Hearts, ACE of Diamonds] Player 19
Dealer hand= [KING of Spades, xxxxxxx]
```
Gameplay continues and the user is able to **'hit' or 'stay'**.

```
Hit or Stay?
stay

Dealer hand= [KING of Spades, QUEEN of Diamonds]
Dealer hand: 20
Dealer wins!
Play again?? y/n
```

```
Player hand= [EIGHT of Clubs, EIGHT of Diamonds] Player 16
Dealer hand= [THREE of Spades, xxxxxxx]

Hit or Stay?
hit

[EIGHT of Clubs, EIGHT of Diamonds, NINE of Clubs]
Player hand: 25
Player BUST
Dealer wins
Play again?? y/n
```

### Gameplay with CardCounter

If the user elects to play with the CardCounter, he/she will be able to hear
suggestions passed by CardCounter based on the count. The CardCounter counts
cards based off the popular Hi-Low strategy. During gameplay, only one deck is
used. Once fewer than 8 cards remain in the deck, a new deck is created.

```
Do you want your card counting friend to play with you? (y/n)
y
CardCounter will play first..

Player hand= [FOUR of Hearts, THREE of Clubs] Player 7
Dealer hand= [SEVEN of Spades, xxxxxxx]
Card Counting Player hand= [TWO of Hearts, SEVEN of Diamonds] CardCounter 9

Card count is 3, BET BIG
CardCounter hitting..
[TWO of Hearts, SEVEN of Diamonds, QUEEN of Spades]19

CardCounter stays at 19
Hit or Stay?
```
The CardCounter plays first. After analyzing the hand, CardCounter gives advice.
Then CardCounter hits or stays based off his logic & the count.

After CardCounter's turn, the player is up and gameplay continues.


## Technologies/Topics Applied

1) Object Oriented Programming -
  The Blackjack program is designed with good OO structure in mind. There are
multiple Classes that can be used for any card game.

  a) Abstraction
    The Class Hand is Abstract it my program because it implements an abstract
    method. The class BlackjackHand extends Hand and defines it's own method.
    This allows Hand to be used for multiple different games if created in the
    future.

  b) Inheritance
    The main example and use of Inheritance in this program is the parent class
    Person. Player, Dealer, and CardCounter are all 'Persons' (children of Person),
    and incorporate most behaviors.

  c) Encapsulation
    All of the Classes have Private variables, as well as a few private methods.

2) Enums
  Enums were very useful when designing the Card's suit and rank. Since it is
  defining a collection of constants, it worked very well.

3) UML Diagrams
  Since this program manipulates and calls many classes, a UML diagram
  was very helpful.
