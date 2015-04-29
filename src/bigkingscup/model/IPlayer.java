package bigkingscup.model;

/**
 *
 * @author philipp Schultheiss
 */
public interface IPlayer {

    String getName();

    int getNumOfCards();

    String getGender();

    void clearHand();

    void addCard(final ICard card);

    void printPlayersHand();
}
