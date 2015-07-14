package bigkingscup.controller;

import bigkingscup.model.impl.Player;

/**
 *
 * @author philippschultheiss
 */
public interface ICircularBuffer {
    Player getCurrentPlayer();
    
    void addPlayer(Player player);
    
    void removePlayer(String name);
    
    int getSize();
    
    Player getNextPlayer(); 
}
