package bigkingscup.controller.impl;

import bigkingscup.controller.State;
import bigkingscup.model.ICard;
import bigkingscup.model.IDeck;
import bigkingscup.model.impl.Deck;
import bigkingscup.model.impl.Player;
import bigkingscup.util.observer.Observable;
import static bigkingscup.util.StaticCollection.*;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author philippschultheiss
 */
public class Controller extends Observable {

    private IDeck deck;
    private Ringbuffer rBuffer;
    private ICard actualCard;
    private State currentState;
    private String statusMessage = "Welcome to BigKingsCup!";
    private String ruleFlag;
    private boolean roundFlag = false;
    private List rules = new LinkedList();

    public Controller() {
        this.deck = new Deck();
        this.rBuffer = new Ringbuffer();
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
        notifyObservers();
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setRoundFlag(boolean flag) {
        this.roundFlag = flag;
    }

    public boolean getRoundFlag() {
        return roundFlag;
    }

    public void setStatusMessage(String message) {
        this.statusMessage = message;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public boolean checkNumOfPlayers() {
        return getBuffer().getSize() == 0;
    }

    public void newRound() {
        this.deck = new Deck();
        this.rules = new LinkedList();
        this.rBuffer = new Ringbuffer();
        this.actualCard = null;
        this.currentState = null;
        this.roundFlag = false;
        this.statusMessage = "Welcome to a new Round BigKingsCup!";
    }

    public void addRule(String rule) {
        this.rules.add(rule);
    }

    public void addPlayer(final String name, final String gender) {
        rBuffer.put(new Player(name, gender));
    }

    public ICard getActualCard() {
        return this.actualCard;
    }

    public Ringbuffer getBuffer() {
        return this.rBuffer;
    }

    public Player getPlayer() {
        return rBuffer.get();
    }

    public List getRules() {
        return this.rules;
    }

    public IDeck getDeck() {
        return deck;
    }

    public void checkDeckState() {
        if (this.getDeck().getNumOfCards() == 0 && getRoundFlag()) {
            if (getRoundFlag()) {
                newRound();
            } else {
                System.exit(1);
            }
        }
    }

    public void setActualCard(ICard card) {
        this.actualCard = card;
        notifyObservers();
    }

    public String printPlayersHand() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rBuffer.getSize(); i++) {
            sb.append(rBuffer.nextPlayer().getName()).append(": ").append(rBuffer.get().getPlayerhand()).append("\n");
        }
        return sb.toString();
    }

    public void printHelpMenue() {
        System.out.println("---------------- HELP ----------------");
        System.out.println("d - deal card\n" + "n - number of remaining cards\n"
                + "p - add a player\n" + "l - remove player\n"
                + "h - display players\n" + "r - rules\n" + "q - quit game\n");
    }

    public void change(ICard card) {
        String value = card.toString();

        String[] parts = value.split("Of");
        String temp = parts[0];

        if (temp.equals("Two")) {
            setCurrentState(State.TWO);
            setStatusMessage("Zwei Schlücke verteilen/selber trinken");
        } else if (temp.equals("Three")) {
            setCurrentState(State.THREE);
            setStatusMessage("Drei Schlücke verteilen/selber trinken");
        } else if (temp.equals("Four")) {
            setCurrentState(State.FOUR);
            setStatusMessage("Questionmaster");
        } else if (temp.equals("Five")) {
            setCurrentState(State.FIVE);
            setStatusMessage("Regel");
        } else if (temp.equals("Six")) {
            setCurrentState(State.SIX);
            setStatusMessage("Ich habe noch nie...");
        } else if (temp.equals("Seven")) {
            setCurrentState(State.SEVEN);
            setStatusMessage("Schlücke verteilen");
        } else if (temp.equals("Eight")) {
            setCurrentState(State.EIGHT);
            setStatusMessage("King Thumb");
        } else if (temp.equals("Nine")) {
            setCurrentState(State.NINE);
            setStatusMessage("Mädchen");
        } else if (temp.equals("Ten")) {
            setCurrentState(State.TEN);
            setStatusMessage("Jungs");
        } else if (temp.equals("Jack")) {
            setCurrentState(State.JACK);
            setStatusMessage("Augenkontakt");
        } else if (temp.equals("Queen")) {
            setCurrentState(State.QUEEN);
            setStatusMessage("Kategorie");
        } else if (temp.equals("King")) {
            setCurrentState(State.KING);
            setStatusMessage("Reim");
        } else if (temp.equals("Ace")) {
            setCurrentState(State.ACE);
            setStatusMessage("Alle müssen trinken");
        }
    }

    public String checkGameState() {
        change(actualCard);
        String temp = null;
        if (getCurrentState() == State.TWO) {
            temp = getStatusMessage();
        } else if (getCurrentState() == State.THREE) {
            temp = getStatusMessage();
        } else if (getCurrentState() == State.FOUR) {
            temp = getStatusMessage();
        } else if (getCurrentState() == State.FIVE) {
            temp = getStatusMessage();
            System.out.print("\n--> ");
            ruleFlag = scanner.next();
            addRule(ruleFlag);
        } else if (getCurrentState() == State.SIX) {
            temp = getStatusMessage();
        } else if (getCurrentState() == State.SEVEN) {
            temp = getStatusMessage();
        } else if (getCurrentState() == State.EIGHT) {
            temp = getStatusMessage();
        } else if (getCurrentState() == State.NINE) {
            temp = getStatusMessage();
        } else if (getCurrentState() == State.TEN) {
            temp = getStatusMessage();
        } else if (getCurrentState() == State.JACK) {
            temp = getStatusMessage();
        } else if (getCurrentState() == State.QUEEN) {
            temp = getStatusMessage();
        } else if (getCurrentState() == State.JACK) {
            temp = getStatusMessage();
        } else if (getCurrentState() == State.ACE) {
            temp = getStatusMessage();
        }
        return temp;
    }
}
