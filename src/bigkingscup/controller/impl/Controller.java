package bigkingscup.controller.impl;

import bigkingscup.controller.IGameState;
import bigkingscup.model.Card;
import bigkingscup.model.Deck;
import bigkingscup.model.Player;
import bigkingscup.util.observer.Observable;

/**
 *
 * @author philippschultheiss
 */
public class Controller extends Observable {

    private final Deck deck;
    private final Ringbuffer rBuffer;
    private IGameState currentState = null;

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

    public String printPlayers() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 12; i++) {
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
        String temp = null;
        if (value.charAt(2) == 'o') {
            temp = value.substring(0, 2);
        } else if (value.charAt(4) == 'o') {
            temp = value.substring(0, 3);
        } else if (value.charAt(6) == 'o') {
            temp = value.substring(0, 6);
        }
        switch (temp) {
            case "Two":
            case "Three":
            case "Four":
            case "Five":
            case "Six":
            case "Seven":
            case "Eight":
            case "Nine":
            case "Ten":
            case "Jack":
            case "Queen":
            case "King":
            case "Ace":
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
