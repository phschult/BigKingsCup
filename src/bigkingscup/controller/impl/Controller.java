package bigkingscup.controller.impl;

import bigkingscup.controller.IGameState;
import bigkingscup.model.ICard;
import bigkingscup.model.IDeck;
import bigkingscup.model.impl.Deck;
import bigkingscup.model.impl.Player;
import bigkingscup.util.observer.Observable;
import static bigkingscup.util.StaticCollection.*;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author philippschultheiss
 */
public class Controller extends Observable {

    private final IDeck deck;
    private final Ringbuffer rBuffer;
    private ICard actualCard;
    private IGameState currentState = null;
    private String statusFlag;
    private final List rules = new LinkedList();

    public Controller() {
        this.deck = new Deck();
        this.rBuffer = new Ringbuffer();
    }

    public void setCurrentState(final IGameState state) {
        this.currentState = state;
        notifyObservers();
    }

    public IGameState getCurrentState() {
        return currentState;
    }

    public boolean checkNumOfPlayers() {
        return getBuffer().getSize() == 0;
    }
    
    public void checkGameState() {
        if (this.currentState == null) {
            this.setCurrentState(new StateInGame(this));
            this.currentState.change();
        } else {
            //check if GameState will change
            this.currentState.change();
        }
    }
    
    public void addRule (String rule) {
        this.rules.add(rule);
    }
    
    public void addPlayer(final String name, final String gender) {
        rBuffer.put(new Player(name, gender));
    }

    public ICard getActualCard() {
        return this.actualCard;
    }

    public Ringbuffer getBuffer() {
        return this.rBuffer;
    }

    public Player getPlayer() {
        return rBuffer.get();
    }
    
    public List getRules() {
        return this.rules;
    }

    public IDeck getDeck() {
        return deck;
    }

    public void checkDeckState() {
        if (this.getDeck().getNumOfCards() == 0) {
            System.out.println("Game Over. There are no more cards on the Stack");
            System.exit(1);
        }
    }

    public void setActualCard(ICard card) {
        this.actualCard = card;
        notifyObservers();
    }
    
    //if status then... 
    //Idee: Methode die je nach Status reagiert .. doTask() ersetzen
    //Idee: Methode die festhält wer momentan was ist.. daumenkönig, questionmaster
    public String getStatusFlag() {
        return this.statusFlag;
    }
    
    private void setStatusFlag(String flag) {
        this.statusFlag = flag;
        notifyObservers();
    } 
   
    public String printPlayersHand() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rBuffer.getSize(); i++) {
            sb.append(rBuffer.nextPlayer().getName()).append(": ").append(rBuffer.get().getPlayerhand()).append("\n");
        }
        return sb.toString();
    }
    
    public void printHelpMenue() {
        System.out.println("---------------- HELP ----------------");
        System.out.println("d - deal card\n" + "n - number of remaining cards\n"
                + "p - add a player\n" + "l - remove player\n"
                + "h - display players\n" + "r - rules\n" + "q - quit game\n");
    }

    public void doTask(ICard card) {
        String value = card.toString();

        String[] parts = value.split("Of");
        String temp = parts[0];

        switch (temp) {
            case "Two":
                System.out.println("Zwei Schlücke verteilen/selber trinken");
                setStatusFlag("Zwei Schlücke verteilen/selber trinken");
                break;
            case "Three":
                System.out.println("Drei Schlücke verteilen/selber trinken");
                setStatusFlag("Drei Schlücke verteilen/selber trinken");
                break;
            case "Four":
                System.out.println("Questionmaster");
                setStatusFlag("Questionmaster");
                break;
            case "Five":
                System.out.println("Regel");
                setStatusFlag("Regel");
                break;
            case "Six":
                System.out.println("Ich habe noch nie...");
                setStatusFlag("Ich habe noch nie...");
                break;
            case "Seven":
                System.out.println("Schlücke verteilen");
                setStatusFlag("Schlücke verteilen");
                break;
            case "Eight":
                System.out.println("King Thumb");
                setStatusFlag("King Thumb");
                break;
            case "Nine":
                System.out.println("Mädchen");
                setStatusFlag("Mädchen");
                break;
            case "Ten":
                System.out.println("Jungs");
                setStatusFlag("Jungs");
                break;
            case "Jack":
                System.out.println("Augenkontakt");
                setStatusFlag("Augenkontakt");
                break;
            case "Queen":
                System.out.println("Kategorie");
                setStatusFlag("Kategorie");
                break;
            case "King":
                System.out.println("Reim");
                setStatusFlag("Reim");
                break;
            case "Ace":
                System.out.println("Alle müssen trinken");
                setStatusFlag("Alle müssen trinken");
                break;
            default:
        }
    }

}
