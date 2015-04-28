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

    private String name;
    private String gender;
    private List<ICard> playerHand = new LinkedList<>();

    public Player() {
        this.playerHand = new LinkedList<>();
    }

    public Player(String name, String gender) {
        this.playerHand = new LinkedList<>();
        this.name = name;
        this.gender = gender;
    }
    
    private void setName(String name) {
        this.name = name;
    }
    
    private void setGender(String gender) {
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

    /**
     * Reset players hand.
     */
    @Override
    public void clearHand() {
        this.playerHand = new LinkedList<>();
    }

    @Override
    public void add(final ICard card) {
        playerHand.add(card);
    }

    @Override
    public void printPlayersHand() {
        System.out.println(playerHand);
    }

}
