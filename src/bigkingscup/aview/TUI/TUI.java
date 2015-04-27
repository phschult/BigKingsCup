package bigkingscup.aview.TUI;

import bigkingscup.controller.impl.Controller;
import bigkingscup.model.Card;
import java.util.Scanner;

/**
 *
 * @author philippschultheiss
 */
public class TUI {

    public static Scanner scanner = new Scanner(System.in);
    private Card actualCard;
    private boolean status = true;

    public TUI() throws Exception {
        System.out.println("---------------- Welcome to Big Kings Cup ----------------\n");
        Controller controller = new Controller();
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------

        System.out.println("---------------- HELP ----------------");
        System.out.println("d - deal card\n" + "n - number of remaining cards\n"
                + "p - add a player\n" + "h - display Gamers\n" + "q - quit game\n");
        System.out.print("--> ");

        String choice = scanner.next();
        while (status) {
            switch (choice) {
                case "d":
                    actualCard = controller.getDeck().dealCard();
                    controller.getPlayer().add(actualCard);
                    System.out.println(actualCard);
                    break;
                case "n":
                    System.out.println("There are [" + controller.getDeck().getNumOfCards() + "] Cards left!");
                    break;
                case "p":
                    System.out.print("Name: ");
                    String name = scanner.next();
                    System.out.print("Gender [M/W]: ");
                    String gender = scanner.next();
                    controller.addPlayer(name, gender);
                    break;
                case "h":
                    controller.getPlayer().printPlayersHand();
                    break;
                case "q":
                    status = false;
                    System.out.println("Goodbye!");
                    System.exit(1);
                    break;
                default:
                    System.out.println("Wrong entry , please try again!");
                    break;
            }
            System.out.println("---------------- HELP ----------------");
            System.out.println("d - deal card\n" + "n - number of remaining cards\n"
                    + "p - add a player\n" + "h - display Gamers\n" + "q - quit game\n");
            System.out.print("--> ");
            choice = scanner.next();
        }
    }
}
