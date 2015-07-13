package bigkingscup;

import bigkingscup.aview.TUI.TUI;
import bigkingscup.controller.impl.CircularBuffer;
import bigkingscup.controller.impl.Controller;
import bigkingscup.model.impl.Player;

/**
 *
 * @author philippschultheiss
 */
public final class BigKingsCup {

    private static BigKingsCup instance = null;
    private static Controller controller;

    /**
     * Singleton.
     *
     * @return instance
     */
    public static BigKingsCup getInstance() {
        if (instance == null) {
            instance = new BigKingsCup();
        }
        return instance;
    }

    public BigKingsCup() {
        //create Controller
        controller = new Controller();
        //create Tui
        new TUI(controller).processInputLine();
    }

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        CircularBuffer c = new CircularBuffer(3);
        c.addPlayer(new Player("Philipp", "M"));
        c.addPlayer(new Player("Tobi", "M"));
        c.addPlayer(new Player("Adrian", "M"));
        
        System.out.println(c.getNextPlayer().getName());
        System.out.println(c.getNextPlayer().getName());
        System.out.println(c.getNextPlayer().getName());
        //c.removePlayer("Philipp");
        System.out.println(c.getNextPlayer().getName());
        System.out.println(c.getNextPlayer().getName());
        System.out.println(c.getNextPlayer().getName());
        
        
        //BigKingsCup.getInstance();
    }
}
