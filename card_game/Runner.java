package card_game;

import java.util.*;

class Runner {

  public static void main(String[] args) {
    
    Deck deck = new Deck();
    deck.fillDeck();
    ArrayList<Card> cards = deck.getCards();

    for (Card card : cards) {
      String value = card.getValue().toString().toLowerCase();
      String valueCaps = value.substring(0, 1).toUpperCase() + value.substring(1);
      String suit = card.getSuit().toString().toLowerCase();
      String suitCaps = suit.substring(0, 1).toUpperCase() + suit.substring(1);
      System.out.println(valueCaps + " of " + suitCaps);
    }
  }
}
