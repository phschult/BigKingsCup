package bigkingscup.controller;

import bigkingscup.model.Deck;
import bigkingscup.model.Player;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author philippschultheiss
 */
public class Controller {

    private final List<Player> players = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);
    private final Deck deck;

    public Controller() {
        this.deck = new Deck();
    }

    public Deck getDeck() {
        return deck;
    }

    public void createPlayers(int anz) {
        for (int i = 0; i < anz; i++) {
            players.add(new Player());
        }
    }

    public Player getPlayer(int i) {
        return players.get(i);
    }

    public void setPlayersCharacteristics() {
        for (int i = 0; i < players.size(); i++) {
            System.out.print("Name: ");
            String name = scanner.next();
            System.out.print("Gender: ");
            String gender = scanner.next();
            players.get(i).setCharacteristics(name, gender);
        }
    }
    
    public void addPlayer(String name, String gender) {
        players.add(new Player(name, gender));
    }

}
