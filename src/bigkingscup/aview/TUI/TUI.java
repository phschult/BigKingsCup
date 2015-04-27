package bigkingscup.aview.TUI;

import bigkingscup.controller.impl.Controller;
import bigkingscup.model.Card;
import bigkingscup.model.Player;
import java.util.Scanner;

/**
 *
 * @author philippschultheiss
 */
public class TUI {

    public static Scanner scanner = new Scanner(System.in);
    private Card[] cactualCard;
    private boolean status = true;

    public TUI() throws Exception {
        System.out.println("---------------- Welcome to Big Kings Cup ----------------\n");
        Controller controller = new Controller();
        //----------------------------------------------------------------------
        controller.addPlayer(new Player("Philipp", "M"));
        controller.addPlayer(new Player("Hannes", "M"));
        controller.addPlayer(new Player("Anne", "W"));
        controller.addPlayer(new Player("Luzi", "W"));
        System.out.println(controller.getPlayer());
              
        //----------------------------------------------------------------------
        System.out.println("How many People wanna play?");

        System.out.println("---------------- HELP ----------------");
        System.out.println("c - deal card\n" + "n - number of remaining cards\n" + "p - add a player\n" + "q - quit game\n");
        System.out.print("--> ");

        String actualCard;
        String choice = scanner.next();
        while (status) {
            switch (choice) {
                case "c":
                    System.out.println(controller.getDeck().dealCard());
                    System.out.println();
                    break;
                case "n":
                    System.out.println("There are [" + controller.getDeck().getNumOfCards() + "] Cards left!");
                    break;
                case "p":
                    System.out.print("Name: ");
                    String name = scanner.next();
                    System.out.print("Gender: ");
                    String gender = scanner.next();
                    controller.addPlayer(new Player(name, gender));
                case "h":
                    controller.getPlayer().printPlayersHand();
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
