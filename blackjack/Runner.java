import java.util.*;

class Runner {

  public static void main(String[] args) {
    Deck deck = new Deck();
    deck.fillDeck();
    ArrayList<Card> cards = deck.getDeck();
  
    for (Card card : cards) {
      System.out.println(card.getValue() + " of " + card.getSuit());
    }
  }
}