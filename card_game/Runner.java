package card_game;
import java.util.*;

class Runner {

  public static void main(String[] args) {
    setup();
  }

  public static void setup() {
    ArrayList<CardPlayer> allPlayers = new ArrayList<CardPlayer>();
    ArrayList<CardPlayer> initialPlayers = new ArrayList<CardPlayer>();

    Gambler player1 = new Gambler("Will", new Hand());
    Dealer dealer = new Dealer("Des the Dealer", new Hand(), new Deck());

    allPlayers.add(allPlayers.size(), player1);
    allPlayers.add(allPlayers.size(), dealer);
    initialPlayers.add(initialPlayers.size(), player1);
    initialPlayers.add(initialPlayers.size(), dealer);

    GameManager game = new GameManager(allPlayers, initialPlayers, dealer);
    game.play();
  }
}