package card_game;
import java.util.*;

class Runner {

  public static void main(String[] args) {
    setup();
  }

  public static void setup() {
    ArrayList<CardPlayer> allPlayers = new ArrayList<CardPlayer>();
    ArrayList<CardPlayer> initialPlayers = new ArrayList<CardPlayer>();

    System.out.println("Welcome to Will's (Sort Of) Pontoon!");
    System.out.println("In this variant, all cards are visible to all players. It's a game for two players: a dealer and a gambler.");
    System.out.println("Choose a name for the dealer.");
    String dealerName = System.console().readLine();

    System.out.println("And a name for the gambler.");
    String gamblerName = System.console().readLine();

    Dealer dealer = new Dealer(dealerName, new Hand(), new Deck());
    Gambler player1 = new Gambler(gamblerName, new Hand());

    allPlayers.add(allPlayers.size(), player1);
    allPlayers.add(allPlayers.size(), dealer);
    initialPlayers.add(initialPlayers.size(), player1);
    initialPlayers.add(initialPlayers.size(), dealer);

    GameManager game = new GameManager(allPlayers, initialPlayers, dealer);
    game.play();
  }
}