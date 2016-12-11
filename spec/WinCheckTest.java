import static org.junit.Assert.*;
import org.junit.*;
import card_game.*;
import java.util.*;

public class WinCheckTest {
  Gambler player;
  ArrayList<CardPlayer> allPlayers;
  WinCheck winCheck;

  @Before
  public void initialize() {
    player = new Gambler("Will", new Hand());
    allPlayers = new ArrayList<CardPlayer>();
    allPlayers.add(player);
    winCheck = new WinCheck(allPlayers);
  }

  @Test
  public void checkNormalScore(){
    Card card1 = new Card(CardSuit.DIAMONDS, CardValue.THREE);
    Card card2 = new Card(CardSuit.HEARTS, CardValue.SIX);
    player.receiveCard(card1);
    player.receiveCard(card2);
    
    winCheck.calcScore(player);
    assertEquals(9, player.getScore());
  }

  @Test
  public void testAcesLowIfOver21(){
    Card card1 = new Card(CardSuit.DIAMONDS, CardValue.NINE);
    Card card2 = new Card(CardSuit.HEARTS, CardValue.ACE);
    Card card3 = new Card(CardSuit.HEARTS, CardValue.EIGHT);
    player.receiveCard(card1);
    player.receiveCard(card2);
    player.receiveCard(card3);
    
    winCheck.calcScore(player);
    assertEquals(18, player.getScore());
  }

  @Test
  public void testPontoonStatement(){
    Card card1 = new Card(CardSuit.DIAMONDS, CardValue.JACK);
    Card card2 = new Card(CardSuit.HEARTS, CardValue.ACE);
    player.receiveCard(card1);
    player.receiveCard(card2);
    
    winCheck.calcScore(player);
    assertEquals("pontoon", player.getSpecialScore());
  }

  @Test
  public void test5CardTrickStatement(){
    Card card1 = new Card(CardSuit.HEARTS, CardValue.TWO);
    Card card2 = new Card(CardSuit.DIAMONDS, CardValue.TWO);
    Card card3 = new Card(CardSuit.CLUBS, CardValue.TWO);
    Card card4 = new Card(CardSuit.SPADES, CardValue.TWO);
    Card card5 = new Card(CardSuit.HEARTS, CardValue.THREE);
    player.receiveCard(card1);
    player.receiveCard(card2);
    player.receiveCard(card3);
    player.receiveCard(card4);
    player.receiveCard(card5);
    
    winCheck.calcScore(player);
    assertEquals("5 card trick", player.getSpecialScore());
  }

  // @Test
  // public void testBustCheck(){
  //   Card card1 = new Card(CardSuit.DIAMONDS, CardValue.JACK);
  //   Card card2 = new Card(CardSuit.HEARTS, CardValue.TEN);
  //   Card card3 = new Card(CardSuit.HEARTS, CardValue.EIGHT);
  //   player.receiveCard(card1);
  //   player.receiveCard(card2);
  //   player.receiveCard(card3);
    
  //   winCheck.bustCheck(player);
  //   assertEquals(0, allPlayers.size());
  // }


  
}
