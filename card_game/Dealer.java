package card_game;
import java.util.*;

public class Dealer implements CardPlayer{
  private String name;
  private Hand hand;
  private int score;

  public Dealer(String name, Hand hand) {
    this.hand = hand;
    this.name = name;
  }

  public ArrayList<Card> showHand() {
    return this.hand.showHand();
  }

  public void receiveCard(Card card) {
    this.hand.receiveCard(card);
  }

  public String getName() {
    return this.name;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public int getScore() {
    return this.score;
  }
}