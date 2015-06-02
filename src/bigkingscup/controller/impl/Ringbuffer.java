package bigkingscup.controller.impl;

import bigkingscup.model.impl.Player;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 *
 * @author philippschultheiss
 */
public class Ringbuffer {

    private final LinkedList<Player> buffer;
    private ListIterator<Player> listIterator;
    private int index = 0;

    public Ringbuffer() {
        this.buffer = new LinkedList<>();
    }

    public void put(Player player) {
        buffer.add(player);
    }

    public void removePlayer(String player) {
        Iterator<Player> iter = buffer.iterator();
        while(iter.hasNext()) {
            Player str = iter.next();
            if (str.getName().equals(player)) {
                iter.remove();
            }
        }
    }
    
    /**
     * Iterates + 1 through the buffer. Wenn einmal durchiteriert wurde soll
     * wieder von vorne angefangen werden.
     *
     * @return
     */
    public Player nextPlayer() {
        if (listIterator == null || !listIterator.hasNext()) {
            listIterator = buffer.listIterator();
        }
        return listIterator.next();
    }

    public Player get() throws IndexOutOfBoundsException {
        Player player = buffer.get(index);
        index = index + 1;
        index = index % buffer.size();
        return player;
    }
  
    public int getSize() {
        return buffer.size();
    }

    public boolean isEmpty() {
        return buffer.isEmpty();
    }
}
