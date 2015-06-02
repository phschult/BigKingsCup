package bigkingscup.aview.TUI;

import bigkingscup.controller.impl.Controller;
import java.util.Scanner;

/**
 *
 * @author philippschultheiss
 */
public class TUI {

    private final Controller controller;
    public static Scanner scanner = new Scanner(System.in);
    //private static final Logger logger = Logger.getLogger("BigKingsCup");
    private boolean status = true;

    public TUI(Controller controller) {
        this.controller = controller;
    }

    public void processInputLine() {
        System.out.println("------ Welcome to Big Kings Cup ------\n");
        controller.printHelpMenue();
        System.out.print("--> ");

        String choice = scanner.next();
        while (status) {
            switch (choice) {
                case "d":
                    if (controller.checkNumOfPlayers()) {
                        System.out.println("ERROR: You have to add a Player [p] first!");
                    } else {
                        controller.setActualCard(controller.getDeck().dealCard());
                        System.out.println(controller.getBuffer().nextPlayer().getName());
                        System.out.println(controller.getActualCard());
                        controller.doTask(controller.getActualCard());
                        controller.getPlayer().addCard(controller.getActualCard());
                        if (controller.getStatusFlag().equals("Regel")) {
                            System.out.print("You can define a new rule:\n--> ");
                            String rule = scanner.next();
                            controller.addRule(rule);
                        }
                    }
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
                case "l":
                    if (controller.checkNumOfPlayers()) {
                        System.out.println("ERROR: You have to add a Player [p] first!");
                    } else {
                        System.out.print("Who want to leave the Round?\n--> ");
                        String player = scanner.next();
                        controller.getBuffer().removePlayer(player);
                    }
                    break;
                case "h":
                    if (controller.checkNumOfPlayers()) {
                        System.out.println("ERROR: You have to add a Player [p] first!");
                    } else {
                        System.out.println(controller.printPlayersHand());
                    }
                    break;
                case "r":
                    System.out.println(controller.getRules());
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

            controller.printHelpMenue();
            System.out.print("--> ");
            choice = scanner.next();
        }
    }
}
