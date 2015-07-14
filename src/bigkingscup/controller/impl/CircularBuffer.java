package bigkingscup.controller.impl;

import bigkingscup.model.impl.Player;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author philippschultheiss
 */
public class CircularBuffer {

    private final List<Player> buffer;
    private int index;
    private Player currentPlayer;

    public CircularBuffer() {
        this.buffer = new ArrayList<>();
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void addPlayer(Player player) {
        buffer.add(player);
    }

    public void removePlayer(String name) {
        for (int i = 0; i <= buffer.size() - 1; i++) {
            if (buffer.get(i).getName().equals(name)) {
                buffer.remove(i);
                index--;
            }
        }
    }
    
    public int getSize() {
        return buffer.size();
    }
    
    public Player getNextPlayer() {
        if (index == buffer.size()) {
            index = 0;
            currentPlayer = buffer.get(index);
        } else {
            currentPlayer = buffer.get(index);
        }
        index++;
        return currentPlayer;
    }
}
