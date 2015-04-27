package bigkingscup.model;

/**
 *
 * @author philippschultheiss
 */
public class Player {

    private String name;
    private String gender;
    private int numOfCards;
    private Card[] playerHand;

    public Player() {
        this.playerHand = new Card[52];
    }

    public Player(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return this.name;
    }

    public String getGender() {
        return this.gender;
    }

    public void add(final Card card) {
        // add Card to Player 
        this.playerHand[this.numOfCards] = card;
        this.numOfCards++;
    }

    public String printPlayersHand() {
        if(playerHand.length == 0) {
            throw new IndexOutOfBoundsException("Spieler hat keine Karte auf der Hand!");
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getName()).append(": ");
        for (Card card : playerHand) {
            if (card == null) {
                break;
            }
              sb.append(card).append(" ");
        }
        return sb.toString();
    }

}
