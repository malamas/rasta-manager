package eap.pli24.rastaman.ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.util.EnumMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

/**
 *
 * @author Malamas Malamidis
 */
public class MainFrameController implements Runnable {

    public enum Panel {

        ROOT_MENU,
        ARTIST_TABLE,
        EDIT_ARTIST_TABLE,   //********* Προσθήκη Αποστόλης
        GROUP_TABLE,
        EDIT_GROUP_TABLE
    }
   
    private static final Logger LOGGER = Logger.getLogger(MainFrameController.class.getName());
    private MainFrame mainFrame;
    private SideBarPanel sbp;
    private final EnumMap<Panel, JPanel> panels = new EnumMap(Panel.class);

    @Override
    public void run() {
        initLookAndFeel();
        initPanels();
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

    private void initPanels() {
        RootMenuPanel rmp = new RootMenuPanel();
        ArtistTablePanel atp = new ArtistTablePanel();
        EditArtistPanel eatp = new EditArtistPanel();   //********* Προσθήκη Αποστόλης
        GroupTablePanel gtp = new GroupTablePanel();
        EditGroupPanel egtp = new EditGroupPanel();

        rmp.setBackground(new Color(255, 255, 204));
        rmp.setController(this);

        sbp = new SideBarPanel();
        sbp.setPreferredSize(new Dimension(224, 0));
        sbp.setBackground(new Color(102, 102, 0));

        atp.setController(this);
        gtp.setController(this);
        eatp.setController(this);    //********* Προσθήκη Αποστόλης
        egtp.setController(this);    //********* Προσθήκη Αποστόλης
        
        panels.put(Panel.ROOT_MENU, rmp);
        panels.put(Panel.ARTIST_TABLE, atp);
        panels.put(Panel.EDIT_ARTIST_TABLE, eatp); //********* Προσθήκη Αποστόλης
        panels.put(Panel.GROUP_TABLE, gtp);
        panels.put(Panel.EDIT_GROUP_TABLE, egtp); //********* Προσθήκη Αποστόλης        
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

        // Απενεργοποίηση αυτόματου κλεισίματος παραθύρου.
        // Ο χειρισμός του κλεισίματος γίνεται με ειδικό listener,
        // ώστε να καλείται η μέθοδος shutdown() του ελεγκτή (για ελέγχους κλπ.)
        mainFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        mainFrame.setTitle("Rastaman");

        // Φόρτωση και ορισμός εικονιδίου 
        java.net.URL imageURL = getClass().getResource("/eap/pli24/rastaman/resources/images/rastaman_32x32.png");
        if (imageURL != null) {
            ImageIcon icon = new ImageIcon(imageURL);
            mainFrame.setIconImage(icon.getImage());
        }

        mainFrame.setLayout(new BorderLayout());
        mainFrame.add(sbp, BorderLayout.LINE_START);
        mainFrame.add(panels.get(Panel.ROOT_MENU), BorderLayout.CENTER);

        //clt.addLayoutComponent(rmp, "RootMenuPanel");
        //mainFrame.add(rmp, "RootMenuPanel");
        //mainFrame.add(gtp, "GroupTablePanel");
        // Εμφάνιση παραθύρου
        mainFrame.setVisible(true);

    }

    public void shutdown() {
        mainFrame.dispose();
    }

    public void hidePanel(JPanel panel) {
        panel.setVisible(false);
        JPanel p = panels.get(Panel.ROOT_MENU);
        mainFrame.add(p, BorderLayout.CENTER);
        p.setVisible(true);
    }

    public void showPanel(Panel p) {
        JPanel r = panels.get(Panel.ROOT_MENU);
        r.setVisible(false);
        JPanel pn = panels.get(p);
        mainFrame.add(pn, BorderLayout.CENTER);
        pn.setVisible(true);
    }
}
