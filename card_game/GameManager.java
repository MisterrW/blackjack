package card_game;
import java.util.*;    

public class GameManager {
  private ArrayList<CardPlayer> allPlayers;
  private ArrayList<CardPlayer> initialPlayers;
  private Dealer dealer;
  private WinCheck winCheck;

  public GameManager(){
    this.allPlayers = new ArrayList<CardPlayer>();
    this.initialPlayers = new ArrayList<CardPlayer>();
    this.winCheck = new WinCheck(this.allPlayers);
  }

  public void play(){
    setup();
    initialDeal();
    turnHandler();
  }

  public void setup(){
    Gambler player1 = new Gambler("Will", new Hand());
    Dealer dealer = new Dealer("Des the Dealer", new Hand(), new Deck());
    this.dealer = dealer;
    
    dealer.fillDeck();
    dealer.shuffleCards();

    this.allPlayers.add(allPlayers.size(), player1);
    this.allPlayers.add(allPlayers.size(), dealer);
    this.initialPlayers.add(initialPlayers.size(), player1);
    this.initialPlayers.add(initialPlayers.size(), dealer);
  }

  public ArrayList<CardPlayer> checkInitialPlayers(){
    return this.initialPlayers;
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
    if (this.allPlayers.size() == 2) {
      this.winCheck.showAllHands();
      ArrayList<String> choices = new ArrayList<String>();
      for (CardPlayer player : this.allPlayers){
        System.out.println("You're up, " + player.getName() + ". Stick or twist?");
        String choice = System.console().readLine().toLowerCase();
        choices.add(choices.size(), choice);
        System.out.println("You have chosen to " + choice + ".");
        if(choice.equals("twist")) {
          deal(player);
          this.winCheck.bustCheck(player);
        }
      }
      String choice1 = choices.get(0);
      String choice2 = choices.get(1);

      System.out.println("*~*~*~*~*");

      if( choice1.equals("stick") && choice2.equals("stick") ) {
       winCheck();
     } else {
       turnHandler();     
     }
   }
 }

 public void winCheck(){
  this.winCheck.showAllHands();
  this.winCheck.winCheck();
}

public static void endGame(){
  System.out.println("Thanks for playing!");
  System.out.println("Type P to play again, or anything else to quit.");
  String choice = System.console().readLine().toLowerCase();
  if (choice.equals("p")) {
    Runner.setup();
  } else {
    System.exit(0);
  }
}

}