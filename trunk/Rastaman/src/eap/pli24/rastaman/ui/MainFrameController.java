package eap.pli24.rastaman.ui;

import eap.pli24.rastaman.Rastaman;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

/**
 *
 * @author Malamas Malamidis
 */
public class MainFrameController implements Runnable {

    private static final Logger LOGGER = Logger.getLogger(MainFrameController.class.getName());
    MainFrame mainFrame;

    @Override
    public void run() {
        initLookAndFeel();
        initMainFrame();
    }

    /**
     * Αρχικοποιεί το Swing L&F για την εφαρμογή, επιλέγοντας το L&F του
     * συστήματος. Πρέπει να κλήθεί πριν τη δημιουργία οποιουδήποτε αντικειμένου
     * UI.
     */
    private void initLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }

    private void initMainFrame() {
        mainFrame = new MainFrame();
        RootMenuPanel rmp = new RootMenuPanel();
        SideBarPanel sbp = new SideBarPanel();

        // Πέρασμα αναφοράς αυτού του ελεγκτή στο παράθυρο, για callbacks
        mainFrame.setController(this);

        // Ορισμός διαστάσεων παραθύρου
        mainFrame.setSize(900, 600);

        // Τοποθέτηση του παραθύρου στο κέντρο της οθόνης
        Point screenCenter = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        mainFrame.setLocation(screenCenter.x - mainFrame.getWidth() / 2, screenCenter.y - mainFrame.getHeight() / 2);

        // Απενεργοποίηση αυτόματου κλεισίματος παραθύρου.
        // Ο χειρισμός του κλεισίματος γίνεται με ειδικό listener,
        // ώστε να καλείται η μέθοδος shutdown() του ελεγκτή (για ελέγχους κλπ.)
        mainFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        mainFrame.setTitle("Rastaman");

        // Φόρτωση και ορισμός εικονιδίου 
        java.net.URL imageURL = Rastaman.class.getResource("resources/images/rastaman_32x32.png");
        if (imageURL != null) {
            ImageIcon icon = new ImageIcon(imageURL);
            mainFrame.setIconImage(icon.getImage());
        }

        mainFrame.setLayout(new BorderLayout());

        sbp.setPreferredSize(new Dimension(224, 0));
        sbp.setBackground(new Color(102, 102, 0));
        mainFrame.add(sbp, BorderLayout.LINE_START);

        rmp.setBackground(new Color(255, 255, 204));
        mainFrame.add(rmp, BorderLayout.CENTER);

        // Εμφάνιση παραθύρου
        mainFrame.setVisible(true);

    }

    public void shutdown() {
        mainFrame.dispose();
    }
}
