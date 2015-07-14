package bigkingscup.controller.impl;

import bigkingscup.controller.IController;
import bigkingscup.controller.State;
import bigkingscup.model.ICard;
import bigkingscup.model.IDeck;
import bigkingscup.model.impl.Deck;
import bigkingscup.model.impl.Player;
import bigkingscup.util.observer.Observable;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author philippschultheiss
 */
public class Controller extends Observable implements IController{

    private IDeck deck;
    private CircularBuffer buffer;
    private ICard actualCard;
    private State currentState;
    private String statusMessage = "Welcome to BigKingsCup!";
    private boolean roundFlag = false;
    private List rules = new LinkedList();

    public Controller() {
        this.deck = new Deck();
        this.buffer = new CircularBuffer();
    }
    
    @Override
    public void setCurrentState(State currentState) {
        this.currentState = currentState;
        notifyObservers();
    }

    @Override
    public State getCurrentState() {
        return currentState;
    }

    @Override
    public void setRoundFlag(boolean flag) {
        this.roundFlag = flag;
        notifyObservers();
    }

    @Override
    public boolean getRoundFlag() {
        return roundFlag;
    }

    @Override
    public void setStatusMessage(String message) {
        this.statusMessage = message;
        notifyObservers();
    }

    @Override
    public String getStatusMessage() {
        return statusMessage;
    }

    @Override
    public boolean checkNumOfPlayers() {
        return getBuffer().getSize() == 0;
    }

    @Override
    public void newRound() {
        this.deck = new Deck();
        this.rules = new LinkedList();
        this.buffer = new CircularBuffer();
        this.actualCard = null;
        this.currentState = null;
        this.roundFlag = false;
        this.statusMessage = "Welcome to a new round BigKingsCup!";
    }

    @Override
    public void addRule(String rule) {
        this.rules.add(rule);
    }

    @Override
    public void addPlayer(final String name, final String gender) {
        buffer.addPlayer(new Player(name, gender));
    }

    @Override
    public ICard getActualCard() {
        return this.actualCard;
    }

    @Override
      public CircularBuffer getBuffer() {
        return this.buffer;
    }
      
    @Override
    public Player getNextPlayer() {
        return buffer.getNextPlayer();
    }
    
    @Override
    public Player getCurrentPlayer() {
        return buffer.getCurrentPlayer();
    }

    @Override
    public List getRules() {
        return this.rules;
    }

    @Override
    public IDeck getDeck() {
        return deck;
    }

    @Override
    public void checkDeckState() {
        if (this.getDeck().getNumOfCards() == 0 && getRoundFlag()) {
            if (getRoundFlag()) {
                newRound();
            } else {
                System.exit(1);
            }
        }
    }

    @Override
    public void setActualCard(ICard card) {
        this.actualCard = card;
        notifyObservers();
    }

    @Override
    public String printPlayersHand() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < buffer.getSize(); i++) {
            sb.append(buffer.getNextPlayer().getName()).append(": ")
                    .append(buffer.getCurrentPlayer().getPlayerhand()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String printPlayersStatus() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < buffer.getSize(); i++) {
            sb.append(buffer.getNextPlayer().getName()).append(": ")
                    .append(buffer.getCurrentPlayer().getStatus()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public void printHelpMenue() {
        System.out.println("---------------- HELP ----------------");
        System.out.println("d - deal card\n" + "n - number of remaining cards\n"
                + "p - add a player\n" + "l - remove player\n"
                + "h - display players\n" + "r - rules\n" + "s - player status\n"
                + "q - quit game\n");
    }

    /**
     * State Maschine
     *
     * @param card
     */
    @Override
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
            setStatusMessage("Regel festlegen");
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

    /**
     * State Machine
     *
     * @return
     */
    @Override
    public String checkGameState() {
        change(actualCard);
        String temp = null;
        if (getCurrentState() == State.TWO) {
            temp = getStatusMessage();
        } else if (getCurrentState() == State.THREE) {
            temp = getStatusMessage();
        } else if (getCurrentState() == State.FOUR) {
            temp = getStatusMessage();
            this.getCurrentPlayer().setStatus(temp);
        } else if (getCurrentState() == State.FIVE) {
            temp = getStatusMessage();
        } else if (getCurrentState() == State.SIX) {
            temp = getStatusMessage();
        } else if (getCurrentState() == State.SEVEN) {
            temp = getStatusMessage();
        } else if (getCurrentState() == State.EIGHT) {
            temp = getStatusMessage();
            this.getCurrentPlayer().setStatus(temp);
        } else if (getCurrentState() == State.NINE) {
            temp = getStatusMessage();
        } else if (getCurrentState() == State.TEN) {
            temp = getStatusMessage();
        } else if (getCurrentState() == State.JACK) {
            temp = getStatusMessage();
            this.getCurrentPlayer().setStatus(temp);
        } else if (getCurrentState() == State.QUEEN) {
            temp = getStatusMessage();
        } else if (getCurrentState() == State.JACK) {
            temp = getStatusMessage();
            this.getCurrentPlayer().setStatus(temp);
        } else if(getCurrentState() == State.KING) {
            temp = getStatusMessage();
        } else if (getCurrentState() == State.ACE) {
            temp = getStatusMessage();
        }
        return temp;
    }
}
