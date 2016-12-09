package card_game;
import java.util.*;    

public class GameManager {

  public void newGame(){


    Deck deck = new Deck();
    deck.fillDeck();
    deck.shuffleCards();
    Hand hand = new Hand();
    hand.receiveCard(deck.dealCard());
    hand.receiveCard(deck.dealCard());

    ArrayList<CardPlayer> allPlayers = new ArrayList<CardPlayer>();
    
    Player player1 = new Player("Will", new Hand());
    Dealer dealer = new Dealer("Des the Dodgy Dealer", new Hand());
    allPlayers.add(allPlayers.size(), player1);
    allPlayers.add(allPlayers.size(), dealer);

    for (CardPlayer player : allPlayers) {

      player.receiveCard(deck.dealCard());
      player.receiveCard(deck.dealCard());

    }

    WinCheck winCheck = new WinCheck(allPlayers);
    winCheck.showAllHands();
    winCheck.winCheck();
  }
}