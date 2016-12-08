import static org.junit.Assert.*;
import org.junit.*;

public class DeckTest {


  @Test
  public void checkDeckLength() {
    Deck deck = new Deck();
    deck.fillDeck();
    assertEquals(52, deck.getDeck().size());
  }

}