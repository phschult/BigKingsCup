package bigkingscup.controller;

import bigkingscup.controller.impl.CircularBuffer;
import bigkingscup.model.ICard;
import bigkingscup.model.IDeck;
import bigkingscup.model.impl.Player;
import java.util.List;

/**
 *
 * @author philippschultheiss
 */
public interface IController {
    void setCurrentState(State currentState);
    
    State getCurrentState();
    
    void setRoundFlag(boolean flag);
    
    boolean getRoundFlag();
    
    void setStatusMessage(String message);
    
    String getStatusMessage();
    
    boolean checkNumOfPlayers();
    
    void newRound();
    
    void addRule(String rule);
    
    void addPlayer(final String name, final String gender);
    
    ICard getActualCard();
    
    CircularBuffer getBuffer();
    
    Player getNextPlayer();
    
    Player getCurrentPlayer();
    
    List getRules();
    
    IDeck getDeck();
    
    void checkDeckState();
    
    void setActualCard(ICard card);
    
    String printPlayersHand();
    
    String printPlayersStatus();
    
    void printHelpMenue();
    
    void change(ICard card);
    
    String checkGameState();
}