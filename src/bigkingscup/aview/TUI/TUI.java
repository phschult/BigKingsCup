package bigkingscup.aview.TUI;

import bigkingscup.model.Deck;
import bigkingscup.model.Player;
import java.util.logging.Logger;

/**
 *
 * @author philippschultheiss
 */
public class TUI {

    public static Logger logger = Logger.getLogger("myLogger");

    public TUI() throws Exception {
        Deck deck = new Deck();
        logger.info("Deck has been created!");
        logger.info("Deck shuffeld successfully!");

        deck.showDeck();
        System.out.println("");
        //check if Player get new card
        if (deck.deckIsNotEmpty()) {
            logger.info("Player get new card successfully!");
            System.out.println(deck.dealCard());
        } else {
            throw new Exception("Deck is empty!");
        }
        deck.showDeck();

        Player player = new Player("Philipp", "male");
        System.out.println("");
        player.setHand(deck.dealCard());
        player.setHand(deck.dealCard());
        player.setHand(deck.dealCard());
        player.setHand(deck.dealCard());
        player.setHand(deck.dealCard());
        player.setHand(deck.dealCard());
        player.setHand(deck.dealCard());

        player.statisticCounter();
        System.out.println("");
        deck.showDeck();
        System.out.println("");
    }
}
