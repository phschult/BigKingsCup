package bigkingscup.aview.TUI;

import bigkingscup.model.Deck;
import bigkingscup.model.Player;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 *
 * @author philippschultheiss
 */
public class TUI {

    public static Logger logger = Logger.getLogger("myLogger");
    public static Scanner scanner = new Scanner(System.in);
    private final int anzPlayers;
    private boolean status = true;

    public TUI() throws Exception {
        System.out.println("---------------- Welcome to Big Kings Cup ----------------\n");
        Deck deck = new Deck();
        Player player = new Player("Philipp", "male");

        System.out.println("How many People wanna play?");
        anzPlayers = scanner.nextInt();
        
        System.out.println("---------------- HELP ----------------");
        System.out.println("c - deal card\n" + "n - number of remaining cards\n" + "q - quit game\n");
        System.out.print("--> ");
        
        String actualCard;
        String choice = scanner.next();
        while (status) {
            switch (choice) {
                case "c":
                    //check if Player get new card
                    if (deck.deckIsNotEmpty()) {
                        actualCard = deck.dealCard();
                        System.out.println(actualCard);
                        player.setHand(actualCard);
                    } else {
                        throw new Exception("Deck is empty!");
                    }
                    break;
                case "n":
                   System.out.println("There are [" + deck.getNumOfCards() + "] Cards left!");
                    break;
                case "q":
                    status = false;
                    System.out.println("Goodbye!");
                    System.exit(1);
                    break;
                 default:
                    System.out.println("Wrong entry , please try again!");
            }
            System.out.println("---------------- HELP ----------------");
            System.out.println("c - deal card\n" + "n - number of remaining cards\n" + "q - quit game\n");
            System.out.print("--> ");
            choice = scanner.next();
        }
    }
}
