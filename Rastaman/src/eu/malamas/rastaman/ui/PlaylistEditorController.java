/*
 * Copyright (c) 2015 Apostolis Iakovakis, Nikos Karagiannis,
 * Nikos Krommydas & Malamas Malamidis. All rights reserved.
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

import eu.malamas.rastaman.model.Playlist;
import eu.malamas.rastaman.model.PlaylistSong;
import eu.malamas.rastaman.model.Song;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Malamas Malamidis
 */
public class PlaylistEditorController {

    private final Comparator<Song> songTitleComparator = (Song s1, Song s2) -> (s1.getTitle().compareTo(s2.getTitle()));
    private final MainFrameController controller;
    private final EntityManager em;
    private final Playlist playlist;
    private final PlaylistEditorPanel panel;
    private Predicate<Song> titleOrPerformerContains;
    private List<Song> availableSongList;
    private List<Song> selectedSongList;
    private List<Song> filteredList;
    private String filterString;

    public PlaylistEditorController(MainFrameController controller, EntityManager em, Playlist playlist) {
        this.controller = controller;
        this.em = em;
        this.playlist = playlist;
        this.filterString = "";
        initLists();
        this.panel = new PlaylistEditorPanel(this);
    }

    public String getPlaylistName() {
        return playlist.getName();
    }

    public Date getPlaylistCreationDate() {
        return new Date(playlist.getCreationDate().getTime());
    }

    public PlaylistEditorPanel getPanel() {
        return panel;
    }

    public int getAvailableSongCount() {
        return availableSongList.size();
    }

    public List<Song> getSelectedSongList() {
        return Collections.unmodifiableList(selectedSongList);
    }

    public List<Song> getFilteredSongList() {
        return Collections.unmodifiableList(filteredList);
    }

    /**
     * Προσθέτει το επιλεγμένο στον πίνακα διαθέσιμων τραγούδι στη λίστα των
     * επιλεγμένων και το αφαιρεί από τη λίστα των διαθέσιμων.
     *
     * @param avSel
     * @param s
     * @return
     */
    public int addSongToList(int avSel, int s) {
        Song song = filteredList.remove(avSel);
        availableSongList.remove(song);

        // η προσθήκη γίνεται στην επιλεγμένη σειρά του πίνακα επιλεγμένων,
        // ή στο τέλος της λίστας (και του πίνακα) αν δεν υπάρχει επιλογή
        int e = selectedSongList.size();
        int ins = ((s == -1) ? e : s);
        selectedSongList.add(ins, song);

        return ins;
    }

    /**
     * Αφαιρεί το επιλεγμένο στον πίνακα των επιλεγμένων τραγούδι από τη λίστα
     * των επιλεγμένων, και το προσθέτει στη λίστα των διαθέσιμων.
     *
     * @param sel
     * @return
     */
    public int removeSongFromList(int sel) {
        Song song = selectedSongList.remove(sel);
        availableSongList.add(song);
        availableSongList.sort(songTitleComparator);
        filteredList = getFilteredList();

        int newSel = -1;
        if (!selectedSongList.isEmpty()) {
            newSel = ((sel < selectedSongList.size()) ? sel : sel - 1);
        }

        return newSel;
    }

    /**
     * Καλείται για να ανανεώσει τα σχετικά στοιχεία του ui σε κάθε μεταβολή του
     * κειμένου του φίλτρου.
     *
     * @param ft
     */
    public void updateForFilterChange(String ft) {
        filterString = ft;
        filteredList = getFilteredList();
    }

    /**
     * Επιστρέφει τη συνολική διάρκεια των επιλεγμένων τραγουδιών σε
     * δευτερόλεπτα.
     *
     * @return η συνολική διάρκεια
     */
    public int getSelectedTotalDuration() {
        return selectedSongList
                .stream()
                .mapToInt(s -> s.getDuration())
                .sum();
    }

    /**
     * Επιστρέφει {@code List<Song>} που περιέχει εκείνα τα στοιχεία της λίστας
     * διαθέσιμων που περιέχουν το {@code filterString} είτε στον τίτλο είτε στο
     * όνομα του ερμηνευτή.
     *
     * @return η φιλτραρισμένη λίστα
     */
    private List<Song> getFilteredList() {
        return availableSongList
                .stream()
                .filter(titleOrPerformerContains)
                .collect(Collectors.toList());
    }

    public void goBack() {
        controller.switchToPanel(MainFrameController.PanelType.PLAYLIST_TABLE);
    }

    /**
     * Αρχικοποίεί τις λίστες επιλεγμένων και διαθέσιμων τραγουδιών.
     */
    private void initLists() {
        // αρχικοποίηση λιστών (επιλεγμένων και διαθέσιμων)
        selectedSongList = new ArrayList<>();
        availableSongList = new ArrayList<>();

        // τα διαθέσιμα προέρχονται από τη ΒΔ
        availableSongList.addAll(em.createNamedQuery("Song.findAll", Song.class).getResultList());

        // Προσθήκη τραγουδιών λίστας σε επιλεγμένα και αφαίρεση από τα διαθέσιμα
        for (PlaylistSong ps : playlist.getPlaylistSongList()) {
            availableSongList.remove(ps.getSong());
            selectedSongList.add(ps.getSong());
        }

        // αλφαβητική ταξινόμηση λίστας διαθέσιμων
        availableSongList.sort(songTitleComparator);

        // αρχικοποίηση λίστας φίλτρου
        filteredList = new ArrayList<>(availableSongList);

        // Δημιουργία Predicate<Song> για έλεγχο εμφάνισης κειμένου φίλτρου σε τίτλο ή ερμηνευτή (Java 8 feature)
        Predicate<Song> titleContains = (Song t) -> t.getTitle().toLowerCase().contains(filterString);
        Predicate<Song> performerContains = (Song t) -> t.getAlbumId().getPerformerScreenName().toLowerCase().contains(filterString);
        titleOrPerformerContains = titleContains.or(performerContains);
    }

    /**
     * Επιχειρεί αποθήκευση της λίστας. Πραγματοποιεί ελέγχους νομιμότητας της
     * λίστας, και επιστρέφει true/false αν η αποθήκευση ήταν επιτυχής ή όχι
     * αντίστοιχα.
     *
     * @return true για επιτυχή αποθήκευση, false διαφορετικά
     */
    public boolean save() {
        // έλεγχος ονόματος λίστας
        String newName = panel.getNameTextFieldText();
        if (newName.equals("")) {
            JOptionPane.showMessageDialog(panel, "Το όνομα της λίστας είναι κενό!", "Αδυναμία αποθήκευσης", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        List<Playlist> playlistList = em.createQuery("SELECT p FROM Playlist p", Playlist.class).getResultList();
        playlistList.remove(playlist);
        for (Playlist p : playlistList) {
            if (newName.toLowerCase().equals(p.getName().toLowerCase())) {
                JOptionPane.showMessageDialog(panel, "Υπάρχει ήδη λίστα με αυτό το όνομα!", "Αδυναμία αποθήκευσης", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        }

        // έλεγχος διάρκειας λίστας
        if (getSelectedTotalDuration() < 1800) {
            JOptionPane.showMessageDialog(panel, "Η λίστα πρέπει να έχει διάρκεια τουλάχιστον 30 λεπτών!", "Αδυναμία αποθήκευσης", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        playlist.setName(panel.getNameTextFieldText());

        // ορισμός ημερομηνίας δημιουργίας λίστας
        if (panel.getDateChangeComboBoxSelectedIndex() == 1) {
            playlist.setCreationDate(new Date());
        }

        // αφαίρεση των τραγουδιών που τυχόν περιείχε η λίστα
        em.getTransaction().begin();
        for (PlaylistSong ps : playlist.getPlaylistSongList()) {
            ps.getSong().getPlaylistSongList().remove(ps);
            em.remove(ps);
        }
        playlist.getPlaylistSongList().clear();
        em.getTransaction().commit();

        // δημιουργία νέας λίστας (<PlaylistSong>) τραγουδιών
        List<PlaylistSong> psl = new ArrayList<>();
        for (int i = 0; i < selectedSongList.size(); i++) {
            PlaylistSong ps = new PlaylistSong();
            ps.setSlot(i + 1);
            ps.setPlaylist(playlist);
            ps.setSong(selectedSongList.get(i));
            ps.getSong().getPlaylistSongList().add(ps);
            psl.add(ps);
        }

        playlist.setPlaylistSongList(psl);

        em.getTransaction().begin();
        em.persist(playlist);
        em.getTransaction().commit();

        em.clear();

        return true;
    }

    public void swapSongs(int s1, int s2) {
        Collections.swap(selectedSongList, s1, s2);
    }
}
