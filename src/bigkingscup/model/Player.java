package bigkingscup.model;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author philippschultheiss
 */
public class Player {

    private String name;
    private String gender;
    private List<Card> playerHand = new LinkedList<>();

    public Player() {
        //this.playerHand = new Card[MAXCARDS];
        this.playerHand = new LinkedList<>();
    }

    public Player(String name, String gender) {
        //this.playerHand = new Card[MAXCARDS];
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
    
    public String getName() {
        return this.name;
    }
    
    public int getNumOfCards() {
        return playerHand.size();
    }
    public String getGender() {
        return this.gender;
    }

    /**
     * Reset players hand.
     */
    public void clearHand() {
        this.playerHand = new LinkedList<>();
    }

    public void add(final Card card) {
        playerHand.add(card);
    }

    public void printPlayersHand() {
        System.out.println(playerHand);
    }

}
