package bigkingscup.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author philippschultheiss
 */
public class Player {

    private String name;
    private String gender;
    private int countCards;
    private final List<String> hand = new ArrayList<String>();
    private Map stat = new TreeMap();

    public Player() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    /**
     * Saves the cards drawn by the player.
     * @param card 
     */
    public void setHand(String card) {
        hand.add(card);
    }
    
    /**
     * returns the players hand.
     * @return hand 
     */
    public List<String> getHand() {
        return hand;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }
    
    /**
     * Shows which playing cards of the players as often has drawn.
     */ 
    public void statisticCounter(){
        for (int i = 0; i < hand.size(); i++) {
            for (int j = 0; j < hand.size(); j++) {
                if(hand.get(i).equals(hand.get(j))){
                    countCards++;
                    stat.put(hand.get(i), countCards);
                }
            }
        }
    }
}
