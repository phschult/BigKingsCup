package bigkingscup.model.impl;

import bigkingscup.model.ICard;

/**
 *
 * @author philippschultheiss
 */
public class Card implements ICard{
    private final Suit suit;
    private final Rank rank;
    
     public Card(final Suit aSuit, final Rank aRank) {
        this.suit = aSuit;
        this.rank = aRank;
    }
     
    @Override
    public Suit getSuit(){
        return this.suit;
    }
    
    @Override
    public Rank getRank() {
        return this.rank;
    }
    
    @Override
    public String toString() {
        return rank.toString() + "Of" + suit.toString();
    }
}
