package card_game;
import java.util.*;

class Runner {

  public static void main(String[] args) {
    setup();
  }

  public static void setup() {
    GameManager game = new GameManager();
    game.play();
  }
}