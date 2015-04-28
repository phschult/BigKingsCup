package bigkingscup.controller.impl;

import bigkingscup.controller.IGameState;
import bigkingscup.model.ICard;
import bigkingscup.model.IDeck;
import bigkingscup.model.impl.Deck;
import bigkingscup.model.impl.Player;
import bigkingscup.util.observer.Observable;
import static bigkingscup.util.StaticCollection.*;

/**
 *
 * @author philippschultheiss
 */
public class Controller extends Observable {

    private final IDeck deck;
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

    public IDeck getDeck() {
        return deck;
    }
    
    public void checkDeckState() {
        if(this.getDeck().getNumOfCards() == 0) {
            System.out.println("Game Over. There are no more cards on the Stack");
            System.exit(1);
        }
    }
    private void setStatusFlag(String flag) {
        this.statusFlag = flag;
        notifyObservers();
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

    public void doTask(ICard card) {
        String value = card.toString();

        String[] parts = value.split("Of");
        String temp = parts[0]; 
        
        switch (temp) {
            case "Two":
                System.out.println("Kategorie");
                setStatusFlag("Kategorie");
                break;
            case "Three":
                System.out.println("Reim");
                setStatusFlag("Reim");
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
                System.out.println("Partner");
                setStatusFlag("Partner");
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
                System.out.println("Bube");
                setStatusFlag("Bube");
                break;
            case "Queen":
                System.out.println("Königin");
                setStatusFlag("Königin");
                break;
            case "King":
                System.out.println("König");
                setStatusFlag("König");
                break;
            case "Ace":
                System.out.println("Alle müssen trinken");
                setStatusFlag("Alle müssen trinken");
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
