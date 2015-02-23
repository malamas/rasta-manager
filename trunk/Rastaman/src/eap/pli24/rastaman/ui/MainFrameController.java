package eap.pli24.rastaman.ui;

import eap.pli24.rastaman.entities.Album;
import eap.pli24.rastaman.entities.Artist;
import eap.pli24.rastaman.entities.Musicgroup;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
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

    public enum PanelType {

        ROOT_MENU,
        ARTIST_TABLE,
        GROUP_TABLE,
        ARTIST_ALBUM_TABLE,
        GROUP_ALBUM_TABLE,
        PLAYLIST_TABLE
    }

    private static final Logger LOGGER = Logger.getLogger(MainFrameController.class.getName());
    private EntityManager em;
    private MainFrame mainFrame;
    private JPanel activePanel;

    @Override
    public void run() {
        initLookAndFeel();
        initDatabase();
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

    private void initDatabase() {
        em = Persistence.createEntityManagerFactory("RastamanPU").createEntityManager();
    }

    private void initMainFrame() {
        mainFrame = new MainFrame();

        // Πέρασμα αναφοράς αυτού του ελεγκτή στο παράθυρο, για callbacks
        mainFrame.setController(this);

        // Ορισμός διαστάσεων παραθύρου
        mainFrame.setSize(1000, 700);
        mainFrame.setMinimumSize(new Dimension(900, 600));

        // Τοποθέτηση του παραθύρου στο κέντρο της οθόνης
        Point screenCenter = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        mainFrame.setLocation(screenCenter.x - mainFrame.getWidth() / 2, screenCenter.y - mainFrame.getHeight() / 2);

        // Απενεργοποίηση αυτόματου κλεισίματος παραθύρου.
        // Ο χειρισμός του κλεισίματος γίνεται με ειδικό listener,
        // ώστε να καλείται η μέθοδος shutdown() του ελεγκτή (για ελέγχους κλπ.)
        mainFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        mainFrame.setTitle("Rastaman!");

        // Φόρτωση και ορισμός εικονιδίου 
        java.net.URL imageURL = getClass().getResource("/eap/pli24/rastaman/resources/images/rastaman_32x32.png");
        if (imageURL != null) {
            ImageIcon icon = new ImageIcon(imageURL);
            mainFrame.setIconImage(icon.getImage());
        }

        mainFrame.setLayout(new BorderLayout());
        mainFrame.add(new SideBarPanel(), BorderLayout.LINE_START);

        JPanel startPanel = createPanel(PanelType.ROOT_MENU);
        mainFrame.add(startPanel, BorderLayout.CENTER);
        activePanel = startPanel;

        // Εμφάνιση παραθύρου
        mainFrame.setVisible(true);

    }

    public void shutdown() {
        mainFrame.dispose();
    }

    public void switchToPanel(PanelType p) {
        displayPanel(createPanel(p));
    }

    public void showArtistEditor(Artist artist) {
        ArtistEditorPanel editor = new ArtistEditorPanel(this, em, artist);
        displayPanel(editor);
    }

    public void showGroupEditor(Musicgroup group) {
        GroupEditorPanel editor = new GroupEditorPanel(this, em, group);
        displayPanel(editor);
    }

    public void showArtistAlbumEditor(Album album) {
        ArtistAlbumEditorPanel editor = new ArtistAlbumEditorPanel(this, em, album);
        displayPanel(editor);
    }

    private void displayPanel(JPanel panel) {
        mainFrame.remove(activePanel);
        mainFrame.add(panel, BorderLayout.CENTER);
        panel.setVisible(true);
        mainFrame.validate();
        activePanel = panel;
    }

    private JPanel createPanel(PanelType type) {
        JPanel p;
        switch (type) {
            case ARTIST_TABLE:
                p = new ArtistTablePanel(this, em);
                break;
            case GROUP_TABLE:
                p = new GroupTablePanel(this, em);
                break;
            case ARTIST_ALBUM_TABLE:
                p = new ArtistAlbumTablePanel(this, em);
                break;
            case GROUP_ALBUM_TABLE:
                p = new GroupAlbumTablePanel(this, em);
                break;
            case PLAYLIST_TABLE:
                p = new PlaylistTablePanel(this, em);
                break;
            case ROOT_MENU:
            default:
                p = new RootMenuPanel(this);
                break;
        }
        return p;
    }
}
