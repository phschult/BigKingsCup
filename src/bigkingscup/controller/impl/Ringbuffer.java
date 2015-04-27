package bigkingscup.controller.impl;

import bigkingscup.model.Player;

/**
 *
 * @author philippschultheiss
 */
public class Ringbuffer {

    Player[] ring;
    private int usedSize = 0;
    //private int size = 0;
    private int getIndex = 0;
    private int putIndex = 0;
    final static int DEFAULTSIZE = 12;
    private int index;
    private int size;

    public Ringbuffer(int size) {
        this.size = size;
        ring = new Player[this.size];
    }

    public Ringbuffer() {
        this(DEFAULTSIZE);
    }

    public void put(Player player) throws IndexOutOfBoundsException {
        usedSize++;
        if (usedSize > size) {
            throw new IndexOutOfBoundsException("Ringbufferüberlauf");
        }
        ring[putIndex] = player;
        putIndex = (putIndex + 1) % size;
    }

    public Player get() throws IndexOutOfBoundsException {
        index = index + 1;
        index = index % size;
        return ring[index];

//        usedSize--;
//        if (usedSize < 0) {
//            throw new IndexOutOfBoundsException("Ringbuffer schon leer");
//        }
//        Player ret = ring[getIndex];
//        getIndex = (getIndex + 1) % size;
//        return ret;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return usedSize == 0;
    }
}
