package bigkingscup.model;

import static bigkingscup.util.StaticCollection.*;
import java.util.Random;

/**
 *
 * @author philippschultheiss
 */
public class Deck {

    private Card[] deck;
    /**
     * Number of cards currently in the deck.
     */
    private int numOfCards;
    /**
     * Card index.
     */
    private int index = ZERO;

    private final static Random rmd = new Random();

    public Deck() {
        buildDeck();
    }

    public void createDeck(Suit[] aSuit, Rank[] aRank) {
        for (int i = 0; i < aSuit.length; i++) {
            for (int j = 0; j < aRank.length; j++) {
                this.deck[index] = new Card(Suit.values()[i], Rank.values()[j]);
                index++;
            }
        }
    }

    public int getNumOfCards() {
        return numOfCards;
    }

    /**
     * this method initializes the deck attributes.
     */
    private void buildDeck() {
        //Initialise size of deck and number of cards 
        this.numOfCards = FIFTYTWO;
        //create new Deck Array 
        this.deck = new Card[this.numOfCards];
        //Creates Deck deck 
        createDeck(Suit.values(), Rank.values());
        //shuffles deck 
        shuffleCards(deck);

    }

    /**
     * Returns the deck.
     *
     * @return deck
     */
    public Card[] getDeck() {
        return deck;
    }

    /**
     * this method shuffles the cards and returns a mixed deck.
     *
     * @param myCards contains a ICard Array
     */
    private void shuffleCards(final Card[] myCards) {
        Card tmp;
        int rand;
        for (int i = ZERO; i < myCards.length; i++) {
            rand = rmd.nextInt(myCards.length);
            tmp = myCards[i];
            myCards[i] = myCards[rand];
            myCards[rand] = tmp;
        }
    }

    /**
     * Deal next card from the top of the deck.
     *
     * @return top Card of the deck
     */
    public Card dealCard() {
        //get the first card from top of the deck 
        Card top = this.deck[ZERO];
        //shift cards to the left, because we get the first one 
        for (int i = ONE; i < this.numOfCards; i++) {
            this.deck[i - ONE] = this.deck[i];
        }
        this.deck[this.numOfCards - ONE] = null;
        //decrement the number of cards currently in the deck 
        this.numOfCards--;

        return top;
    }

}
