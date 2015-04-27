package bigkingscup.model;

import static bigkingscup.util.util.StaticCollection.MAXCARDS;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author philippschultheiss
 */
public class Player {

    private String name;
    private String gender;
    private int numOfCards;
    private Card[] playerHand;
    private List<Card> playerHand1 = new LinkedList<>();

    public Player() {
        //this.playerHand = new Card[MAXCARDS];
        this.playerHand1 = new LinkedList<>();
    }

    public Player(String name, String gender) {
        //this.playerHand = new Card[MAXCARDS];
        this.playerHand1 = new LinkedList<>();
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return this.name;
    }
    
    public int getSizeHand() {
        return playerHand1.size();
    }
    public String getGender() {
        return this.gender;
    }

    /**
     * Reset players hand.
     */
    public void clearHand() {
        this.playerHand = new Card[MAXCARDS];
        this.numOfCards = 0;
    }

    public void add(final Card card) {
        playerHand1.add(card);
    }

    public void printPlayersHand() {
        System.out.println(playerHand1);
    }

}
