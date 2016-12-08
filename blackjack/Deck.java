
import java.util.*;

public class Deck {
 private ArrayList<Card> deck;

 public Deck(){
  this.deck = new ArrayList<Card>();
  }

  public void fillDeck() {
  CardSuit[] suits = CardSuit.values();
  CardValue[] values = CardValue.values();
  for (CardSuit suit : suits) {
    for (CardValue value : values) {
      deck.add(new Card(suit, value));
      }
    }
  }

  public ArrayList<Card> getDeck() {
    Collections.shuffle(deck);
    return deck;
  }
}

