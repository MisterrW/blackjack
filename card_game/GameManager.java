package card_game;
import java.util.*;    

public class GameManager {
  private Deck deck;
  private ArrayList<CardPlayer> allPlayers;

  public GameManager(){
    this.deck = new Deck();
    this.allPlayers = new ArrayList<CardPlayer>();
  }

  public void play(){
    setup();
    deal();
    winCheck();
  }

  public void setup(){
    this.deck.fillDeck();
    this.deck.shuffleCards();

    Player player1 = new Player("Will", new Hand());
    Dealer dealer = new Dealer("Des the Dodgy Dealer", new Hand());

    this.allPlayers.add(allPlayers.size(), player1);
    this.allPlayers.add(allPlayers.size(), dealer);

  }

  public void deal(){
    for (CardPlayer player : this.allPlayers) {
      player.receiveCard(deck.dealCard());
      player.receiveCard(deck.dealCard());
    }
  }

  public void winCheck(){
    WinCheck winCheck = new WinCheck(this.allPlayers);
    winCheck.showAllHands();
    winCheck.winCheck();
  }

}