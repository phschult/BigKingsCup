package bigkingscup.model.impl;

import bigkingscup.model.ICard;
import bigkingscup.model.IDeck;
import bigkingscup.util.Rank;
import static bigkingscup.util.StaticCollection.*;
import bigkingscup.util.Suit;
import java.util.Random;

/**
 *
 * @author philippschultheiss
 */
public class Deck implements IDeck {

    private ICard[] deck;
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

    @Override
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
        this.deck = new ICard[this.numOfCards];
        //Creates Deck deck 
        createDeck(Suit.values(), Rank.values());
        //shuffles deck 
        shuffleCards(deck);

    }

     private void createDeck(Suit[] aSuit, Rank[] aRank) {
        for (Suit aSuit1 : aSuit) {
            for (Rank aRank1 : aRank) {
                this.deck[index] = new Card(aSuit1, aRank1);
                index++;
            }
        }
    }
     
    /**
     * Returns the deck.
     *
     * @return deck
     */
    @Override
    public ICard[] getDeck() {
        return deck;
    }

    /**
     * this method shuffles the cards and returns a mixed deck.
     *
     * @param myCards contains a ICard Array
     */
    private void shuffleCards(final ICard[] myCards) {
        ICard tmp;
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
    @Override
    public ICard dealCard() {
        //get the first card from top of the deck 
        ICard top = this.deck[ZERO];
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
