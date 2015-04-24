package bigkingscup.controller;

import bigkingscup.model.Player;

/**
 *
 * @author philippschultheiss
 */
public class Controller {
    
    public Controller(){
        
    }
    
    private void initialPlayer(String name, String gender){
        
        Player player = new Player(name, gender);
        player.setPlayers(player);
    }
}
