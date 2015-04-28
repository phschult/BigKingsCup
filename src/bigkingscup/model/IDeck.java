package bigkingscup.model;

/**
 *
 * @author philippschultheiss
 */
public interface IDeck {

    int getNumOfCards();

    ICard[] getDeck();

    ICard dealCard();
}
