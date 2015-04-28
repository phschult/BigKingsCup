package bigkingscup.model;

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
