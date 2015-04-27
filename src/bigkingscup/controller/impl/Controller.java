package bigkingscup.controller.impl;

import bigkingscup.controller.IGameState;
import bigkingscup.model.Card;
import bigkingscup.model.Deck;
import bigkingscup.model.Player;
import bigkingscup.util.observer.Observable;
import static bigkingscup.util.StaticCollection.*;

/**
 *
 * @author philippschultheiss
 */
public class Controller extends Observable {

    private final Deck deck;
    private final Ringbuffer rBuffer;
    private IGameState currentState = null;
    private String statusFlag;

    public Controller() {
        this.deck = new Deck();
        this.rBuffer = new Ringbuffer();
    }

    public void addPlayer(final String name, final String gender) {
        rBuffer.put(new Player(name, gender));
    }

    public Player getPlayer() {
        return rBuffer.get();
    }

    public Deck getDeck() {
        return deck;
    }
    
    public void checkDeckState() {
        if(this.getDeck().getNumOfCards() == 0) {
            System.out.println("Game Over. There are no more cards on the Stack");
            System.exit(1);
        }
    }
    
    public String printPlayers() {
        StringBuilder sb = new StringBuilder();
        for (int i = ZERO; i < TWELVE; i++) {
            sb.append(rBuffer.get()).append(", ");
        }
        return sb.toString();
    }

    public void setCurrentState(final IGameState state) {
        this.currentState = state;
        notifyObservers();
    }

    public void doTask(Card card) {
        String value = card.toString();

        String[] parts = value.split("Of");
        String temp = parts[0]; 
        System.out.println(temp);
        
        switch (temp) {
            case "Two":
                System.out.println("Kategorie");
                break;
            case "Three":
                System.out.println("Reim");
                break;
            case "Four":
                System.out.println("Questionmaster");
                break;
            case "Five":
                System.out.println("Regel");
                break;
            case "Six":
                System.out.println("Ich habe noch nie...");
                break;
            case "Seven":
                System.out.println("Schlücke verteilen");
                break;
            case "Eight":
                System.out.println("Partner");
                break;
            case "Nine":
                System.out.println("Mädchen");
                break;
            case "Ten":
                System.out.println("Jungs");
                break;
            case "Jack":
                System.out.println("Bube");
                break;
            case "Queen":
                System.out.println("Königin");
                break;
            case "King":
                System.out.println("König");
                break;
            case "Ace":
                System.out.println("Alle müssen trinken");
                break;
            default:
        }
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
