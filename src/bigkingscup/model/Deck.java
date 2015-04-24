package bigkingscup.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author philippschultheiss
 */
public class Deck {

    // create possible card combinations
    private final String[] SUITS = {"HEARTS", "DIAMONDS", "CLUPS", "SPADES"};
    private final String[] RANKS = {"ASS", "KING", "QUEEN", "JACK", "10", "9", "8", "7", "6", "5", "4", "3", "2"};

    // maximum number of cards
    private int deckLength = SUITS.length * RANKS.length;
    private final List<String> fullDeck = new ArrayList<>();

    /**
     * Constructor creates a new Deck
     */
    public Deck() {
        createDeck();
        shuffle();
    }

    /**
     * creates Cards
     */
    private void createDeck() {
        for (int i = 0; i < SUITS.length; i++) {
            for (int j = 0; j < RANKS.length; j++) {
                this.fullDeck.add(RANKS[j] + "of" + SUITS[i]);
            }
        }
    }

    /**
     * this method shuffles the cards and returns a mixed deck.
     *
     * @param fullDeck
     * @return
     */
    private List<String> shuffle() {
        Collections.shuffle(this.fullDeck);
        return this.fullDeck;
    }

    /**
     * displays the shuffeld Deck
     */
    public void showDeck() {
        for (int i = 0; i < deckLength; i++) {
            System.out.printf("%s ", this.fullDeck.get(i));
        }
    }

    public int getNumOfCards() {
        return deckLength;
    }

    /**
     * checks if deck is empty
     *
     * @return
     */
    public boolean deckIsNotEmpty() {
        return !fullDeck.isEmpty();
    }

    /**
     * deals first card of the deck
     *
     * @return
     */
    public String dealCard() {
        String result = fullDeck.get(0);
        fullDeck.remove(0);
        deckLength--;
        return result;
    }
}
