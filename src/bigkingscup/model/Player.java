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
    private final List<String> hand = new ArrayList<>();
    private final List<String> number = new ArrayList<>();
    private final Map<String, Integer> stat = new TreeMap<>();

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
     *
     * @param card
     */
    public void setHand(String card) {
        this.hand.add(card);
    }

    /**
     * returns the players hand.
     *
     * @return hand
     */
    public List<String> getHand() {
        return this.hand;
    }

    public String getName() {
        return this.name;
    }

    public String getGender() {
        return this.gender;
    }

    /**
     * Shows which playing cards of the players as often has drawn.
     */
    public void statisticCounter() {
        for (int i = 0; i < hand.size(); i++) {
            //Idee: iteriere durch liste und schneide alles Hinter Zahl ab um
            //gleiche Karten zählen zu können.
            if (hand.get(i).charAt(1) == 'o') {
                //abeschneiden und in extraliste schreiben.
                number.add(hand.get(i).substring(0,1));
            } else if (hand.get(i).charAt(3) == 'o') {
                number.add(hand.get(i).substring(0,3));
            } else if (hand.get(i).charAt(4) == 'o') {
                number.add(hand.get(i).substring(0,4));
            } else if (hand.get(i).charAt(5) == 'o') {
                number.add(hand.get(i).substring(0,5));
            }

            for (String temp : number) {
                Integer count = stat.get(temp);
                stat.put(temp, count + 1);
            }
        }
//        for (int i = 0; i < hand.size(); i++) {
//            for (int j = 0; j < hand.size(); j++) {
//                if (hand.get(i).equals(hand.get(j))) {
//                    countCards++;
//                    stat.put(hand.get(i), countCards);
//                }
//            }
//        }
    }
}
