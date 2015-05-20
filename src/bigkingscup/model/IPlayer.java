package bigkingscup.model;

import java.util.List;

/**
 *
 * @author philipp Schultheiss
 */
public interface IPlayer {

    String getName();

    int getNumOfCards();

    String getGender();
    
    List getPlayerhand();

    void clearHand();

    void addCard(final ICard card);
}
