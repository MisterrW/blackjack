package card_game;
import java.util.*;

public abstract class Player{
  private String name;
  private Hand hand;
  private int score;

  public Player(String name, Hand hand) {
    this.hand = hand;
    this.name = name;
    this.score = 0;
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