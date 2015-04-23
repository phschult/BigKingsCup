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

    public void setHand(String card) {
        hand.add(card);
    }

    public List<String> getHand() {
        return hand;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }
    
    public void statistic(){
        for (int i = 0; i <= hand.size(); i++) {
            for (int j = 0; j <= hand.size(); j++) {
                if(hand.get(i).equals(hand.get(j))){
                    countCards++;
                    stat.put(hand.get(i), countCards);
                }
            }
        }
    }
}
