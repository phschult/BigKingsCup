package bigkingscup.controller.impl;

import bigkingscup.model.impl.Player;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 *
 * @author philippschultheiss
 */
public class Ringbuffer {

    private final LinkedList<Player> buffer;
    private int index = 0;
    private Player actualPlayer;

    public Ringbuffer() {
        this.buffer = new LinkedList<>();
    }
    
    public void put(Player player) {
         buffer.add(player);
    }
    
    public void removePlayer(String player) {
        for (int i = 0; i <= buffer.size(); i++) {
            if(player.equals(buffer.get(i).getName())) {
                buffer.remove(i);
            } 
        }
    }
    /**
     * Iterates + 1 through the buffer. Wenn einmal durchiteriert wurde 
     * soll wieder von vorne angefangen werden.
     * @return 
     */
    public Player nextPlayer() {
        ListIterator<Player> listIterator = buffer.listIterator();
        if (listIterator.hasNext()) {
            actualPlayer = listIterator.next();
        } else {
            actualPlayer = buffer.getFirst();
        }
        return actualPlayer;
    }
    
    public Player get() throws IndexOutOfBoundsException {
        //return actualPlayer;
        Player foo = buffer.get(index);
        index = index +1;
        index = index % buffer.size();
        return foo;
    }

    public int getSize() {
        return buffer.size();
    }

    public boolean isEmpty() {
        return buffer.isEmpty();
    }
}

