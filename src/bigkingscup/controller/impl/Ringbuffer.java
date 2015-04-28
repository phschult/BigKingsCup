package bigkingscup.controller.impl;

import bigkingscup.model.impl.Player;
import java.util.LinkedList;

/**
 *
 * @author philippschultheiss
 */
public class Ringbuffer {

    private final LinkedList<Player> buffer;
    private int index = 0;

    public Ringbuffer() {
        this.buffer = new LinkedList<>();
    }

    public void put(Player player) {
         buffer.add(player);
    }

    public Player get() throws IndexOutOfBoundsException {
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

