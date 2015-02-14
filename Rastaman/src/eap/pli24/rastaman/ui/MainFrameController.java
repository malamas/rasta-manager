package eap.pli24.rastaman.ui;

import eap.pli24.rastaman.entities.Artist;
import java.awt.BorderLayout;
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
 * @author Apostolis Iakovakis
 */
public class MainFrameController implements Runnable {

    public enum Panel {

        ROOT_MENU,
        ARTIST_TABLE,
        GROUP_TABLE,
        ARTIST_ALBUM_TABLE,
        GROUP_ALBUM_TABLE,
    }

    private static final Logger LOGGER = Logger.getLogger(MainFrameController.class.getName());
    private MainFrame mainFrame;
    private RootMenuPanel rootMenuPanel;
    private SideBarPanel sbp;
    private JPanel activePanel;
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
        rootMenuPanel = new RootMenuPanel(this);
        ArtistTablePanel atp = new ArtistTablePanel(this);
        GroupTablePanel gtp = new GroupTablePanel(this);
        ArtistAlbumTablePanel aatp = new ArtistAlbumTablePanel(this);
        GroupAlbumTablePanel gatp = new GroupAlbumTablePanel(this);

        rootMenuPanel.setBackground(new Color(255, 255, 204));

        sbp = new SideBarPanel();
        sbp.setPreferredSize(new Dimension(224, 0));
        sbp.setBackground(new Color(102, 102, 0));

        panels.put(Panel.ROOT_MENU, rootMenuPanel);
        panels.put(Panel.ARTIST_TABLE, atp);
        panels.put(Panel.GROUP_TABLE, gtp);
        panels.put(Panel.ARTIST_ALBUM_TABLE, aatp);
        panels.put(Panel.GROUP_ALBUM_TABLE, gatp);
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
        mainFrame.add(rootMenuPanel, BorderLayout.CENTER);
        activePanel = rootMenuPanel;

        // Εμφάνιση παραθύρου
        mainFrame.setVisible(true);

    }

    public void shutdown() {
        mainFrame.dispose();
    }

    public void switchToPanel(Panel p) {
        JPanel panel = panels.get(p);
        switchTo(panel);
    }

    private void switchTo(JPanel panel) {
        activePanel.setVisible(false);
        mainFrame.add(panel, BorderLayout.CENTER);
        panel.setVisible(true);
        activePanel = panel;
    }

    public void showArtistEditor(Artist artist) {
        ArtistEditorPanel editor = new ArtistEditorPanel(this, artist);
        switchTo(editor);
    }
}
