package bigkingscup.model;

import bigkingscup.util.Suit;
import bigkingscup.util.Rank;

/**
 *
 * @author philippschultheiss
 */
public interface ICard {

    Suit getSuit();

    Rank getRank();

    @Override
    String toString();
}
