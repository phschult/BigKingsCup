package bigkingscup.controller.impl;

import bigkingscup.model.impl.Player;
import java.util.LinkedList;

/**
 *
 * @author philippschultheiss
 */
public class Ringbuffer {


    LinkedList<Player> ring;
    private int index = 0;

    public Ringbuffer() {
        this.ring = new LinkedList<>();
    }

    public void put(Player player) {
         ring.add(player);
    }

    public Player get() throws IndexOutOfBoundsException {
        Player foo = ring.get(index);
        index = index +1;
        index = index % ring.size();
        return foo;
    }

    public int getSize() {
        return ring.size();
    }

    public boolean isEmpty() {
        return ring.isEmpty();
    }
}

