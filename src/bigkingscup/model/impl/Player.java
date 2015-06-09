package bigkingscup.model.impl;

import bigkingscup.model.ICard;
import bigkingscup.model.IPlayer;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author philippschultheiss
 */
public class Player implements IPlayer{

    private final String name;
    private final String gender;
    private final List<String> status = new LinkedList<>();
    private List<ICard> playerHand = new LinkedList<>();

    public Player(String name, String gender) {
        this.playerHand = new LinkedList<>();
        this.name = name;
        this.gender = gender;
    }
    
    @Override
    public String getName() {
        return this.name;
    }
    
    @Override
    public int getNumOfCards() {
        return playerHand.size();
    }
    @Override
    public String getGender() {
        return this.gender;
    }
    
    @Override
    public List getPlayerhand() {
        return this.playerHand;
    }
    
    @Override
    public void setStatus(String status) {
        this.status.add(status);
    }
    
    @Override
    public List getStatus() {
        return status;
    }
    /**
     * Reset players hand.
     */
    @Override
    public void clearHand() {
        this.playerHand = new LinkedList<>();
    }

    @Override
    public void addCard(final ICard card) {
        playerHand.add(card);
    }
}
