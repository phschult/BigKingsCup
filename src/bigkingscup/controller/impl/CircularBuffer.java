package bigkingscup.controller.impl;

import bigkingscup.model.impl.Player;

/**
 *
 * @author philippschultheiss
 */
public class CircularBuffer {

    private final Player[] buffer;
    private int size;
    private int indexAdd;
    private int indexNext;
    private Player currentPlayer;

    public CircularBuffer(Integer size) {
        this.size = size;
        this.buffer = new Player[size];
    }
    
    public Player getCurrentPlayer() {
        return currentPlayer;
    }
    public void addPlayer(Player player) {
        if (indexAdd <= size) {
                buffer[indexAdd] = player;
                indexAdd++;
        }
    }

    public void removePlayer(String name) {
        for (int i = 0; i <= size; i++) {
            if (buffer[i].getName().equals(name)) {
                buffer[i] = null;
            }
        }
    }

    public Player getNextPlayer() {
        if (indexNext == size) {
            indexNext = 0;
            currentPlayer = buffer[indexNext];
        } else {
            currentPlayer = buffer[indexNext];
        }
        indexNext++;
        return currentPlayer;
    }
}
