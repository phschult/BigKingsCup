package bigkingscup.controller.impl;

import bigkingscup.controller.IGameState;
import bigkingscup.model.Deck;
import bigkingscup.model.Player;
import bigkingscup.util.observer.Observable;

/**
 *
 * @author philippschultheiss
 */
public class Controller extends Observable{

    private final Deck deck;
    private final Ringbuffer rBuffer;
    private IGameState currentState = null;

    public Controller() {
        this.deck = new Deck();
        this.rBuffer = new Ringbuffer();
    }
    
    public void addPlayer(Player player) {
        rBuffer.put(player);
    }
    
    public Player getPlayer() {
        return rBuffer.get();
    }
    
    public Deck getDeck() {
        return deck;
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