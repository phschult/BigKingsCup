package bigkingscup.controller.impl;

import bigkingscup.model.impl.Player;

/**
 *
 * @author philippschultheiss
 */
public class CircularBuffer {

    private Player data[];
    private int head;
    private int tail;

    public CircularBuffer(Integer number) {
        data = new Player[number];
        head = 0;
        tail = 0;
    }

    public boolean store(Player player) {
        if (!bufferFull()) {
            data[tail++] = player;
            if (tail == data.length) {
                tail = 0;
            }
            return true;
        } else {
            return false;
        }
    }

    public Player read() {
        if (head != tail) {
            Player player = data[head++];
            if (head == data.length) {
                head = 0;
            }
            return player;
        } else {
            return null;
        }
    }

    private boolean bufferFull() {
        if (tail + 1 == head) {
            return true;
        }
        if (tail == (data.length - 1) && head == 0) {
            return true;
        }
        return false;
    }
}
