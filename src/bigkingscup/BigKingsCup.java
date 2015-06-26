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
//        CircularBuffer c = new CircularBuffer(3);
//
//    System.out.println("Storing: 1");
//    c.store(new Player("Philipp", "M"));
//    System.out.println("Reading: " + c.read());
//    System.out.println("Storing: 2");
//    c.store(new Player("Anne", "W"));
//    System.out.println("Storing: 3");
//    c.store(new Player("Silke", "W"));
//    System.out.println("Storing: 4");
//    c.store(new Player("Hans", "M"));
//    System.out.println("Reading: " + c.read());
//    System.out.println("Reading: " + c.read());
//    System.out.println("Reading: " + c.read());
//    System.out.println("Reading: " + c.read());
//    System.out.println("Reading: " + c.read());
//    System.out.println("Reading: " + c.read());
//    System.out.println("Reading: " + c.read());
//    System.out.println("Reading: " + c.read());
//    System.out.println("Reading: " + c.read());
//    System.out.println("Reading: " + c.read());

        
        BigKingsCup.getInstance();
    }
}
