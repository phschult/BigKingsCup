package bigkingscup.aview.TUI;

import bigkingscup.controller.impl.Controller;
import static bigkingscup.util.StaticCollection.*;
import bigkingscup.util.observer.IObserver;

/**
 *
 * @author philippschultheiss
 */
public class TUI implements IObserver {

    private final Controller controller;
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
            switch (choice.toLowerCase()) {
                case "d":
                    if (controller.checkNumOfPlayers()) {
                        System.out.println("ERROR: You have to add a Player [p] first!");
                    } else {
                        controller.setActualCard(controller.getDeck().dealCard());
                        System.out.println("Player: " + controller.getBuffer().nextPlayer().getName());
                        System.out.println("Card: " + controller.getActualCard());
                        //controller.doTask(controller.getActualCard());
                        controller.getPlayer().addCard(controller.getActualCard());
                        System.out.println("Action: " + controller.checkGameState());
                    }
                    break;
                case "n":
                    System.out.println("There are [" + controller.getDeck().getNumOfCards() + "] Cards left!");
                    break;
                case "p":
                    System.out.print("Name: ");
                    String name = scanner.next();
                    System.out.print("Gender [M/W]: ");
                    String gender = scanner.next().toUpperCase();
                    if (gender.equals("M") || gender.equals("W")) {
                         controller.addPlayer(name, gender);
                         //controller.updateGenderMap();
                    } else {
                        System.out.println("ERROR: You have to add a [M] or a [W]!");
                    }
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
                case "s":
                    System.out.println(controller.printPlayersStatus());
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
            if (controller.getDeck().getNumOfCards() == 0) {
                System.out.println("\nGame Over. There are no more cards on the Stack.");
                System.out.println("\nDo you want to start a new round? [true / false]");
                System.out.print("--> ");
                controller.setRoundFlag(scanner.nextBoolean());
            }
            controller.checkDeckState();

            controller.printHelpMenue();
            System.out.print("--> ");
            choice = scanner.next();
        }
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
