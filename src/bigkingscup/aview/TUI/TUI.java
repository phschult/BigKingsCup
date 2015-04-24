package bigkingscup.aview.TUI;

import bigkingscup.controller.Controller;
import bigkingscup.model.Deck;
import bigkingscup.model.Player;
import java.util.Scanner;

/**
 *
 * @author philippschultheiss
 */
public class TUI {

    public static Scanner scanner = new Scanner(System.in);
    private final int anzPlayers;
    private boolean status = true;

    public TUI() throws Exception {
        System.out.println("---------------- Welcome to Big Kings Cup ----------------\n");
        Controller controller = new Controller();

        System.out.println("How many People wanna play?");
        anzPlayers = scanner.nextInt();
        controller.createPlayers(anzPlayers);
        System.out.println("Select their Characteristics:");
        controller.setPlayersCharacteristics();

        System.out.println("---------------- HELP ----------------");
        System.out.println("c - deal card\n" + "n - number of remaining cards\n" + "p - add a player\n" + "q - quit game\n");
        System.out.print("--> ");

        String actualCard;
        String choice = scanner.next();
        while (status) {
            switch (choice) {
                case "c":
                    //check if Player get new card
                    if (controller.getDeck().deckIsNotEmpty()) {
                        actualCard = controller.getDeck().dealCard();
                        System.out.println(actualCard);
                    } else {
                        throw new Exception("Deck is empty!");
                    }
                    break;
                case "n":
                    System.out.println("There are [" + controller.getDeck().getNumOfCards() + "] Cards left!");
                    break;
                case "p":
                    System.out.print("Name: ");
                    String name = scanner.next();
                    System.out.print("Gender: ");
                    String gender = scanner.next();
                    controller.addPlayer(name, gender);
                case "q":
                    status = false;
                    System.out.println("Goodbye!");
                    System.exit(1);
                    break;
                default:
                    System.out.println("Wrong entry , please try again!");
            }
            System.out.println("---------------- HELP ----------------");
            System.out.println("c - deal card\n" + "n - number of remaining cards\n" + "p - add a player\n" + "q - quit game\n");
            System.out.print("--> ");
            choice = scanner.next();
        }
    }
}
