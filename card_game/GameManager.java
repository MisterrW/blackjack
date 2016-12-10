package card_game;
import java.util.*;    

public class GameManager {
  private ArrayList<CardPlayer> allPlayers;
  private Dealer dealer;
  private WinCheck winCheck;

  public GameManager(){
    this.allPlayers = new ArrayList<CardPlayer>();
    this.winCheck = new WinCheck(this.allPlayers);
  }

  public void play(){
    setup();
    initialDeal();
    turnHandler();
    // winCheck();
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

  public void initialDeal(){
    for(int i=1; i<=2; i++) {
      dealAll();
    }
  }

  public void dealAll(){
    for (CardPlayer player : this.allPlayers) {
      deal(player);
    }
  }

  public void deal(CardPlayer player){
    player.receiveCard(this.dealer.dealCard());
  }

  public void turnHandler(){
    this.winCheck.showAllHands();
    ArrayList<String> choices = new ArrayList<String>();
    for (CardPlayer player : this.allPlayers){
      System.out.println("You're up, " + player.getName() + ". Stick or twist?");
      // int score = this.winCheck.calcScore(player);
      // if(score<=21)
      //   deal(player);
      String choice = System.console().readLine().toLowerCase();
      choices.add(choices.size(), choice);
      System.out.println("You have chosen to " + choice);
      if(choice.equals("twist")) {
        deal(player);
        this.winCheck.bustCheck(player);
      }
    }
    String choice1 = choices.get(0);
    String choice2 = choices.get(1);

    System.out.println(choice1);
    System.out.println(choice2);
    System.out.println(!choice1.equals("twist"));
    System.out.println(!choice2.equals("twist"));

    System.out.println("*~*~*~*~*");

    if( choice1.equals("stick") && choice2.equals("stick") ) {
       winCheck();
    } else {
       turnHandler();     
    }
  }

  public void winCheck(){
    this.winCheck.showAllHands();
    this.winCheck.winCheck();
  }

}