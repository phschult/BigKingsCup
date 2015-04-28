package bigkingscup.model;

/**
 *
 * @author philippschultheiss
 */
public class Card {
    private final Suit suit;
    private final Rank rank;
    
     public Card(final Suit aSuit, final Rank aRank) {
        this.suit = aSuit;
        this.rank = aRank;
    }
     
    
    public Suit getSuit(){
        return this.suit;
    }
    
    @Override
    public String toString() {
        return rank.toString() + "Of" + suit.toString();
    }
}
