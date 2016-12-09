package card_game;
import java.util.*;    

public class GameManager {
  private ArrayList<CardPlayer> allPlayers;
  private Dealer dealer;

  public GameManager(){
    this.allPlayers = new ArrayList<CardPlayer>();
  }

  public void play(){
    setup();
    deal();
    winCheck();
  }

  public void setup(){
    
    Gambler player1 = new Gambler("Will", new Hand());
    Dealer dealer = new Dealer("Des the Dodgy Dealer", new Hand(), new Deck());
    this.dealer = dealer;
    dealer.fillDeck();
    dealer.shuffleCards();

    this.allPlayers.add(allPlayers.size(), player1);
    this.allPlayers.add(allPlayers.size(), dealer);

  }

  public void deal(){
    for (CardPlayer player : this.allPlayers) {
      for(int i=1; i<=2; i++) {
      player.receiveCard(this.dealer.dealCard());
      }
    }
  }

  public void winCheck(){
    WinCheck winCheck = new WinCheck(this.allPlayers);
    winCheck.showAllHands();
    winCheck.winCheck();
  }

}