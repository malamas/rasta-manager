package eap.pli24.rastaman.ui;

import eap.pli24.rastaman.Rastaman;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.WindowConstants;

/**
 *
 * @author Malamas Malamidis
 */
public class MainFrameController implements Runnable {

    MainFrame mainFrame;

    @Override
    public void run() {
        initMainFrame();
    }

    private void initMainFrame() {
        mainFrame = new MainFrame();

        // Πέρασμα αναφοράς αυτού του ελεγκτή στο παράθυρο, για callbacks
        mainFrame.setController(this);

        // Ορισμός διαστάσεων παραθύρου
        mainFrame.setSize(900, 600);

        // Τοποθέτηση του παραθύρου στο κέντρο της οθόνης
        Point screenCenter = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        mainFrame.setLocation(screenCenter.x - mainFrame.getWidth() / 2, screenCenter.y - mainFrame.getHeight() / 2);

        // Απενεργοποίηση αυτόματου κλεισίματος παραθύρου, ο χειρισμός του κλεισίματος γίνεται με ειδικό listener
        mainFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        mainFrame.setTitle("Rastaman");

        // Φόρτωση και ορισμός εικονιδίου 
        java.net.URL imageURL = Rastaman.class.getResource("resources/images/rastaman_32x32.png");
        if (imageURL != null) {
            ImageIcon icon = new ImageIcon(imageURL);
            mainFrame.setIconImage(icon.getImage());
        }

        // Εμφάνιση παραθύρου
        mainFrame.setVisible(true);
    }

    public void shutdown() {
        mainFrame.dispose();
    }
}
