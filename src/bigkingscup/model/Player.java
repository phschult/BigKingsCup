package bigkingscup.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author philippschultheiss
 */
public class Player {

    private String name;
    private String gender;
    private final List<String> hand = new ArrayList<String>();

    public Player() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setHand(String card) {
        hand.add(name);
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
                    
                }
            }
        }
    }
}
