package bigkingscup.controller.impl;

import bigkingscup.controller.IGameState;

/**
 *
 * @author philippschultheiss
 */
public class StateInGame implements IGameState{
    private final Controller controller;
    
    StateInGame(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void change() {
      
    }
    
}
