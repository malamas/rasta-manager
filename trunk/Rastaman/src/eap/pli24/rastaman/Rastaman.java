package eap.pli24.rastaman;

import eap.pli24.rastaman.ui.MainFrameController;

/**
 *
 * @author Malamas Malamidis
 */
public class Rastaman {

    /**
     * Το σημείο εισόδου της εφαρμογής.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new MainFrameController());
    }
}
