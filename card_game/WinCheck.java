package card_game;
import java.util.*;    

public class WinCheck {
  private ArrayList<CardPlayer> allPlayers;

  public WinCheck(ArrayList<CardPlayer> allPlayers){
    this.allPlayers = allPlayers;
  }

  public void showAllHands() {
    for (CardPlayer player : allPlayers) {
      showHand(player);
    }
  }

  public void showHand(CardPlayer player){
    System.out.println(player.getName() + " has these cards:");

    ArrayList<Card> cards = player.showHand();
    for (Card card : cards) {
      String value = card.getValue().toString().toLowerCase();
      String valueCaps = value.substring(0, 1).toUpperCase() + value.substring(1);
      String suit = card.getSuit().toString().toLowerCase();
      String suitCaps = suit.substring(0, 1).toUpperCase() + suit.substring(1);
      System.out.println(valueCaps + " of " + suitCaps);
    }
    System.out.println("*~*~*~*~*");
  }

  public int calcScore(CardPlayer player) {
    int score = 0;
    for (Card card : player.showHand()) {
      CardValue value = card.getValue();
      int cardWorth;
      switch (value) {
        case TWO: cardWorth = 2;
        break;
        case THREE: cardWorth = 3;
        break;
        case FOUR: cardWorth = 4;
        break;
        case FIVE: cardWorth = 5;
        break;
        case SIX: cardWorth = 6;
        break;
        case SEVEN: cardWorth = 7;
        break;
        case EIGHT: cardWorth = 8;
        break;
        case NINE: cardWorth = 9;
        break;
        case TEN: cardWorth = 10;
        break;
        case JACK: cardWorth = 10;
        break;
        case QUEEN: cardWorth = 10;
        break;
        case KING: cardWorth = 10;
        break;
        case ACE: cardWorth = 11;
        break;
        default: cardWorth = 0;
      }
      score += cardWorth;
    }
    player.setScore(score);
    
    for(Card card : player.showHand()) {
      if(card.getValue() == CardValue.ACE) {
        if(player.getScore() > 21) {
          System.out.println("Aces low!");
          player.setScore(player.getScore()-10);
        }
      }
    }
    
    return player.getScore();
  }

  public void bustCheck(CardPlayer player){
    if(calcScore(player) > 21) {
      showHand(player);
      System.out.println(player.getName() + " is bust!");
      System.out.println(player.getScore());
    }
  }

  public void winCheck() {
    for (CardPlayer player : allPlayers) {
      calcScore(player);
      System.out.println(player.getName() + " scores " + player.getScore());
    }

    System.out.println("*~*~*~*~*");


    if (allPlayers.get(0).getScore() > allPlayers.get(1).getScore()) {
      System.out.println(allPlayers.get(0).getName() + " wins!");
    } 
    else if (allPlayers.get(0).getScore() < allPlayers.get(1).getScore()) {
      System.out.println(allPlayers.get(1).getName() + " wins!");
    } 
    else {
      System.out.println("It's a draw!");
    }

  }


}