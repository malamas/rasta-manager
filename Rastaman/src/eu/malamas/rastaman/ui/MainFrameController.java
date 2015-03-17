/*
 * Copyright (c) 2015 Apostolis Iakovakis & Malamas Malamidis.
 * All rights reserved.
 *
 * This file is part of Rastaman.
 *
 * Rastaman is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * Rastaman is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Rastaman.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package eu.malamas.rastaman.ui;

import eu.malamas.rastaman.model.Album;
import eu.malamas.rastaman.model.Artist;
import eu.malamas.rastaman.model.Label;
import eu.malamas.rastaman.model.MusicGenre;
import eu.malamas.rastaman.model.Musicgroup;
import eu.malamas.rastaman.model.Playlist;
import eu.malamas.rastaman.ui.skins.SkinProvider;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

/**
 * Η κλάση {@code MainFrameController} παριστάνει τον ελεγκτή του κύριου
 * παραθύρου της εφαρμογής.
 *
 * @author Malamas Malamidis
 */
public class MainFrameController implements Runnable {

    /**
     * enum με σταθερές για τα διαφορετικά {@code JPanel} του UI.
     */
    public enum PanelType {

        ROOT_MENU("Αρχική"),
        ARTIST_TABLE("Καλλιτέχνες"),
        GROUP_TABLE("Συγκροτήματα"),
        ARTIST_ALBUM_TABLE("Άλμπουμ καλλιτεχνών"),
        GROUP_ALBUM_TABLE("Άλμπουμ συγκροτημάτων"),
        PLAYLIST_TABLE("Λίστες τραγουδιών"),
        LABEL_TABLE("Εταιρίες Παραγωγής"),
        GENRE_TABLE("Είδη Μουσικής");

        private final String headerText;

        PanelType(String headerText) {
            this.headerText = headerText;
        }
    }

    /**
     * enum με σταθερές για τα διαφορετικά editor {@code JPanel} του UI.
     */
    public enum EditorType {

        ARTIST_EDITOR,
        GROUP_EDITOR,
        ARTIST_ALBUM_EDITOR,
        GROUP_ALBUM_EDITOR,
        PLAYLIST_EDITOR,
        LABEL_EDITOR,
        GENRE_EDITOR
    }

    private static final Logger LOGGER = Logger.getLogger(MainFrameController.class.getName());
    private EntityManager em;
    private MainFrame mainFrame;
    private HeaderPanel headerPanel;
    private SideBarPanel sideBarPanel;
    private JPanel centerPanel;
    private JPanel activePanel;

    /**
     * Το σημείο εισόδου του ελεγκτή. Ο ελεγκτής υλοποιεί το interface
     * {@code Runnable}, ώστε η εκτέλεσή του να μπορεί να ξεκινήσει στο event
     * dispatch thread του Swing.
     */
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

    /**
     * Αρχικοποιεί τη σύνδεση με τη ΒΔ. Σταματά την εκτέλεση αφού εμφανίσει
     * μήνυμα αποτυχίας σε περίπτωση που η σύνδεση δεν είναι εφικτή.
     */
    private void initDatabase() {
        try {
            em = Persistence.createEntityManagerFactory("RastamanPU").createEntityManager();
        } catch (PersistenceException ex) {
            JOptionPane.showMessageDialog(null, "Η σύνδεση με τη βάση δεδομένων απέτυχε! Η εφαρμογή δεν μπορεί να ξεκινήσει...", "Rastaman", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }

    }

    /**
     * Αρχικοποιεί παραμέτρους εμφάνισης του παραθύρου.
     */
    private void initMainFrame() {
        // δημιουργία παραθύρου
        mainFrame = new MainFrame();

        // πέρασμα αναφοράς αυτού του ελεγκτή στο παράθυρο, για callbacks
        mainFrame.setController(this);

        // Ορισμός διαστάσεων παραθύρου
        mainFrame.setSize(SkinProvider.getInstance().getSkin().getMainFrameInitSize());
        mainFrame.setMinimumSize(SkinProvider.getInstance().getSkin().getMainFrameMinSize());

        // τοποθέτηση του παραθύρου στο κέντρο της οθόνης
        Point screenCenter = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        mainFrame.setLocation(screenCenter.x - mainFrame.getWidth() / 2, screenCenter.y - mainFrame.getHeight() / 2);

        // απενεργοποίηση αυτόματου κλεισίματος παραθύρου.
        // Ο χειρισμός του κλεισίματος γίνεται με ειδικό listener,
        // ώστε να καλείται η μέθοδος shutdown() του ελεγκτή (για ελέγχους κλπ.)
        mainFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        mainFrame.setTitle("Rastaman");

        // Φόρτωση και ορισμός εικονιδίου 
        java.net.URL imageURL = getClass().getResource("/eu/malamas/rastaman/resources/images/rastaman_32x32.png");
        if (imageURL != null) {
            ImageIcon icon = new ImageIcon(imageURL);
            mainFrame.setIconImage(icon.getImage());
        }

        mainFrame.setLayout(new BorderLayout());
        initPanels();

        // Εμφάνιση παραθύρου
        mainFrame.setVisible(true);
    }

    /**
     * Αρχικοποιεί τα panel που αποτελούν το ui της εφαρμογής.
     */
    private void initPanels() {
        centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());

        headerPanel = new HeaderPanel();
        sideBarPanel = new SideBarPanel();
        mainFrame.add(sideBarPanel, BorderLayout.LINE_START);
        mainFrame.add(centerPanel, BorderLayout.CENTER);

        centerPanel.add(headerPanel, BorderLayout.PAGE_START);
        JPanel startPanel = createPanel(PanelType.ROOT_MENU);
        centerPanel.add(startPanel, BorderLayout.CENTER);
        headerPanel.setHeaderLabel("Αρχική");
        activePanel = startPanel;
    }

    /**
     * Διαχειρίζεται τα αιτήματα για αλλαγή θέματος εμφάνισης (skin) της
     * εφαρμογής.
     *
     * @param newSkin το νέο θέμα (σταθερά του enum {@code SkinProvider.Skins})
     */
    public void switchToSkin(SkinProvider.Skins newSkin) {
        mainFrame.getContentPane().removeAll();
        SkinProvider.getInstance().setActiveSkin(newSkin);
        initPanels();
    }

    /**
     * Καλείται για τον τερματισμό της εφαρμογής. Εμφανίζει πλαίσιο διαλόγου για
     * επιβεβαίωση.
     */
    public void shutdown() {
        Object[] options = {"Ναι", "Όχι"};
        int selectedOption = JOptionPane.showOptionDialog(mainFrame, "Να τερματιστεί η εφαρμογή;", "Exodus...", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if (selectedOption == JOptionPane.YES_OPTION) {
            mainFrame.dispose();
        }
    }

    /**
     * Αντικαθιστά το τρέχον panel με νέο panel τύπου {@code p}.
     *
     * @param p ο τύπος του panel που θα καταλάβει τον κύριο χώρο στο παράθυρο
     */
    public void switchToPanel(PanelType p) {
        displayPanel(createPanel(p));
        headerPanel.setHeaderLabel(p.headerText);
    }

    /**
     * Αντικαθιστά το τρέχον panel με νέο editor panel τύπου {@code et}.
     *
     * @param et ο τύπος του editor που θα καταλάβει τον κύριο χώρο στο παράθυρο
     * @param o το αντικείμενο που προωθείται για επεξεργασία στον νέο editor
     */
    public void switchToEditor(EditorType et, Object o) {
        JPanel editor;
        switch (et) {
            case ARTIST_EDITOR:
                Artist artist = (Artist) o;
                editor = new ArtistEditorPanel(this, em, artist);
                displayPanel(editor);
                headerPanel.setHeaderLabel("Επεξεργασία καλλιτέχνη: " + ((artist.getScreenName() != null) ? artist.getScreenName() : "Νέος Καλλιτέχνης"));
                break;
            case GROUP_EDITOR:
                Musicgroup group = (Musicgroup) o;
                editor = new GroupEditorPanel(this, em, group);
                displayPanel(editor);
                headerPanel.setHeaderLabel("Επεξεργασία συγκροτήματος: " + ((group.getName() != null) ? group.getName() : "Νέο Συγκρότημα"));
                break;
            case ARTIST_ALBUM_EDITOR:
                Album album1 = (Album) o;
                editor = new ArtistAlbumEditorPanel(this, em, album1);
                displayPanel(editor);
                headerPanel.setHeaderLabel("Επεξεργασία άλμπουμ: " + ((album1.getTitle() != null) ? album1.getTitle() : "Νέο Άλμπουμ"));
                break;
            case GROUP_ALBUM_EDITOR:
                Album album2 = (Album) o;
                editor = new GroupAlbumEditorPanel(this, em, album2);
                displayPanel(editor);
                headerPanel.setHeaderLabel("Επεξεργασία άλμπουμ: " + ((album2.getTitle() != null) ? album2.getTitle() : "Νέο Άλμπουμ"));
                break;
            case PLAYLIST_EDITOR:
                Playlist playlist = (Playlist) o;
                PlaylistEditorController pec = new PlaylistEditorController(this, em, playlist);
                editor = pec.getPanel();
                displayPanel(editor);
                headerPanel.setHeaderLabel("Επεξεργασία λίστας: " + ((playlist.getName() != null) ? playlist.getName() : "Νέα λίστα"));
                break;
            case LABEL_EDITOR:
                Label label = (Label) o;
                editor = new LabelEditorPanel(this, em, label);
                displayPanel(editor);
                headerPanel.setHeaderLabel("Επεξεργασία Εταιρίας: " + ((label.getName() != null) ? label.getName() : "Νέα Εταιρία"));
                break;
            case GENRE_EDITOR:
                MusicGenre genre = (MusicGenre) o;
                editor = new GenreEditorPanel(this, em, genre);
                displayPanel(editor);
                headerPanel.setHeaderLabel("Επεξεργασία Είδους Μουσικής: " + ((genre.getName() != null) ? genre.getName() : "Νέο Είδος Μουσικής"));
                break;
        }

    }

    /**
     * Εμφανίζει το panel {@code panel} στο κύριο χώρο του παραθύρου,
     * αντικαθιστώντας το προηγούμενο ενεργό panel.
     *
     * @param panel το panel προς εμφάνιση
     */
    private void displayPanel(JPanel panel) {
        if (panel instanceof RootMenuPanel) {
            // στην αρχική οθόνη το sidebar εμφανίζεται πάντα
            sideBarPanel.setPreferredSize(new Dimension(SkinProvider.getInstance().getSkin().getSidebarWidth(), 0));
        } else if (!SkinProvider.getInstance().getSkin().getSidebarVisibleOnNonRoot()) {
            // στις υπόλοιπες, η εμφάνιση του sidebar καθορίζαται από το skin
            sideBarPanel.setPreferredSize(new Dimension(0, 0));
        }
        centerPanel.remove(activePanel);
        centerPanel.add(panel, BorderLayout.CENTER);
        panel.setVisible(true);
        centerPanel.validate();
        activePanel = panel;
    }

    /**
     * Δημιουργεί και επιστρέφει ένα panel τύπου {@code type}.
     *
     * @param type ο τύπος του panel
     * @return το panel που δημιουργήθηκε
     */
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
            case LABEL_TABLE:
                p = new LabelTablePanel(this, em);
                break;
            case GENRE_TABLE:
                p = new GenreTablePanel(this, em);
                break;
            case ROOT_MENU:
            default:
                p = new RootMenuPanel(this);
                break;
        }
        return p;
    }
}
