package eap.pli24.rastaman.ui;

import eap.pli24.rastaman.entities.Album;
import eap.pli24.rastaman.entities.Artist;
import eap.pli24.rastaman.entities.Musicgroup;
import eap.pli24.rastaman.entities.Playlist;
import java.awt.BorderLayout;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
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

        ROOT_MENU("Βασικό μενού"),
        ARTIST_TABLE("Καλλιτέχνες"),
        GROUP_TABLE("Συγκροτήματα"),
        ARTIST_ALBUM_TABLE("Άλμπουμ καλλιτεχνών"),
        GROUP_ALBUM_TABLE("Άλμπουμ συγκροτημάτων"),
        PLAYLIST_TABLE("Λίστες τραγουδιών");

        private final String headerText;

        PanelType(String headerText) {
            this.headerText = headerText;
        }
    }

    private static final Logger LOGGER = Logger.getLogger(MainFrameController.class.getName());
    private EntityManager em;
    private MainFrame mainFrame;
    private HeaderPanel headerPanel;
    private JPanel centerPanel;
    private JPanel activePanel;
    private ImageIcon optionPaneIcon;

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
        mainFrame.setSize(UIProperties.MAIN_FRAME_INIT_SIZE);
        mainFrame.setMinimumSize(UIProperties.MAIN_FRAME_MIN_SIZE);

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

        centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());

        headerPanel = new HeaderPanel();

        mainFrame.setLayout(new BorderLayout());
        mainFrame.add(new SideBarPanel(), BorderLayout.LINE_START);
        mainFrame.add(centerPanel, BorderLayout.CENTER);

        centerPanel.add(headerPanel, BorderLayout.PAGE_START);
        JPanel startPanel = createPanel(PanelType.ROOT_MENU);
        centerPanel.add(startPanel, BorderLayout.CENTER);
        headerPanel.setHeaderLabel("Βασικό μενού");
        activePanel = startPanel;

        // Εμφάνιση παραθύρου
        mainFrame.setVisible(true);

    }

    public void shutdown() {
        // lazy init of the dialog icon
        if (optionPaneIcon == null) {
            java.net.URL imageURL = getClass().getResource("/eap/pli24/rastaman/resources/images/rastaman_48x48.png");
            optionPaneIcon = new ImageIcon(imageURL);
        }
        Object[] options = {"Ναι", "Όχι"};
        int selectedOption = JOptionPane.showOptionDialog(mainFrame, "Να τερματιστεί η εφαρμογή;", "Exodus...", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, optionPaneIcon, options, options[0]);
        if (selectedOption == JOptionPane.YES_OPTION) {
            mainFrame.dispose();
        }
    }

    public void switchToPanel(PanelType p) {
        displayPanel(createPanel(p));
        headerPanel.setHeaderLabel(p.headerText);
    }

    public void showArtistEditor(Artist artist) {
        ArtistEditorPanel editor = new ArtistEditorPanel(this, em, artist);
        displayPanel(editor);
        headerPanel.setHeaderLabel("Επεξεργασία καλλιτέχνη: " + ((artist.getScreenName() != null) ? artist.getScreenName() : "Νέος καλλιτέχνης"));
    }

    public void showGroupEditor(Musicgroup group) {
        GroupEditorPanel editor = new GroupEditorPanel(this, em, group);
        displayPanel(editor);
        headerPanel.setHeaderLabel("Επεξεργασία συγκροτήματος: " + ((group.getName() != null) ? group.getName() : "Νέο συγκρότημα"));
    }

    public void showArtistAlbumEditor(Album album) {
        ArtistAlbumEditorPanel editor = new ArtistAlbumEditorPanel(this, em, album);
        displayPanel(editor);
        headerPanel.setHeaderLabel("Επεξεργασία άλμπουμ: " + ((album.getTitle() != null) ? album.getTitle() : "Νέο άλμπουμ"));
    }

    public void showGroupAlbumEditor(Album album) {
        GroupAlbumEditorPanel editor = new GroupAlbumEditorPanel(this, em, album);
        displayPanel(editor);
        headerPanel.setHeaderLabel("Επεξεργασία άλμπουμ: " + ((album.getTitle() != null) ? album.getTitle() : "Νέο άλμπουμ"));
    }
    
    public void showPlaylistEditor(Playlist playlist) {
        PlaylistEditorPanel editor = new PlaylistEditorPanel(this, em, playlist);
        displayPanel(editor);
        headerPanel.setHeaderLabel("Επεξεργασία λίστας: " + ((playlist.getName() != null) ? playlist.getName() : "Νέα λίστα"));
    }

    private void displayPanel(JPanel panel) {
        centerPanel.remove(activePanel);
        centerPanel.add(panel, BorderLayout.CENTER);
        panel.setVisible(true);
        centerPanel.validate();
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
