
import java.util.*;

public class Deck {
 private ArrayList<Card> cards;

 public Deck(){
  this.cards = new ArrayList<Card>();
  }

  public void fillDeck() {
  CardSuit[] suits = CardSuit.values();
  CardValue[] values = CardValue.values();
  for (CardSuit suit : suits) {
    for (CardValue value : values) {
      cards.add(new Card(suit, value));
      }
    }
  }

  public ArrayList<Card> getCards() {
    Collections.shuffle(cards);
    return cards;
  }
}

