package bigkingscup.aview.TUI;

import bigkingscup.controller.impl.Controller;
import bigkingscup.model.ICard;
import java.util.Scanner;

/**
 *
 * @author philippschultheiss
 */
public class TUI {

    private final Controller controller;
    public static Scanner scanner = new Scanner(System.in);
    private ICard actualCard;
    private boolean status = true;

    public TUI() {
        this.controller = new Controller();
    }

    public void processInputLine() {
        System.out.println("------ Welcome to Big Kings Cup ------\n");

        System.out.println("---------------- HELP ----------------");
        System.out.println("d - deal card\n" + "n - number of remaining cards\n"
                + "p - add a player\n" + "h - display Gamers\n" + "q - quit game\n");
        System.out.print("--> ");

        String choice = scanner.next();
        while (status) {
            switch (choice) {
                case "d":
                    actualCard = controller.getDeck().dealCard();
                    System.out.println(actualCard);
                    controller.doTask(actualCard);
                    controller.getPlayer().add(actualCard);
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
            controller.checkDeckState();

            System.out.println("---------------- HELP ----------------");
            System.out.println("d - deal card\n" + "n - number of remaining cards\n"
                    + "p - add a player\n" + "h - display Gamers\n" + "q - quit game\n");
            System.out.print("--> ");
            choice = scanner.next();
        }
    }
}
