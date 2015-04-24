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
    private final List<String> genHand = new ArrayList<>();
    private final List<Player> players = new ArrayList<>();

    private final Map<String, Integer> stat = new TreeMap<>();

    public Player(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    public void setPlayers(Player player) {
        this.players.add(player);
    }

    /**
     * Saves the cards drawn by the player.
     *
     * @param card
     */
    public void setHand(String card) {
        this.hand.add(card);
    }
    
    public List<Player> getPlayers() {
        return players;
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
     * Durchsucht die Karte auf ein 'o'. Wenn gefunden true 
     * und das Wort wird abgeschnitten 
     * @param card
     * @param index
     * @return 
     */
    private boolean compare(String card, int index) {
        return card.charAt(index) == 'o';
    }

    /**
     * Shows which playing cards of the players as often has drawn.
     */
    public void statisticCounter() {
        //Idee: iteriere durch liste und schneide alles hinter Zahl ab um
        //gleiche Karten zählen zu können.
        for (int i = 0; i < hand.size(); i++) {
            //Case Number
            if (compare(hand.get(i), 1)) {
                //abeschneiden und in extra Liste number schreiben.
                genHand.add(hand.get(i).substring(0, 1));
                //Case ASS
            } else if (compare(hand.get(i), 3)) {
                genHand.add(hand.get(i).substring(0, 3));
                //Case KING, JACK
            } else if (compare(hand.get(i), 4)) {
                genHand.add(hand.get(i).substring(0, 4));
                //Case QUEEN
            } else if (compare(hand.get(i), 5)) {
                genHand.add(hand.get(i).substring(0, 5));
            }
            //Vergleiche jede Karte auf der Hand mit den anderen und zähle wie
            //viele gleiche Karten sich auf der Hand befinden
            for (int j = 0; j < genHand.size(); j++) {
                for (int z = 0; z < genHand.size(); z++) {
                    if (genHand.get(j).equals(genHand.get(z))) {
                        stat.put(genHand.get(i), countCards);
                        countCards++;
                    }
                }
            }
        }
    }
}
