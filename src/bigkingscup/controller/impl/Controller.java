package bigkingscup.controller.impl;

import bigkingscup.controller.IGameState;
import bigkingscup.model.Deck;
import bigkingscup.model.Player;
import bigkingscup.util.observer.Observable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author philippschultheiss
 */
public class Controller extends Observable{

    private final List<Player> players = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);
    private final Deck deck;
    private IGameState currentState = null;

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
    
     
    public void setCurrentState(final IGameState state) { 
         this.currentState = state; 
         notifyObservers(); 
    } 

//    public void checkGameState() {
//        if (this.currentState == null) {
//            this.setCurrentState(new StateInGame(this));
//            this.currentState.change();
//        } else {
//            //check if GameState will change
//            this.currentState.change();
//        }
}