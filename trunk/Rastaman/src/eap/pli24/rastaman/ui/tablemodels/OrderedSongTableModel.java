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
package eap.pli24.rastaman.ui.tablemodels;

import eap.pli24.rastaman.entities.Song;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Η κλάση {@code OrderedSongTableModel} είναι μοντέλο δεδομένων για ένα
 * {@code JTable} που περιέχει εγγραφές με δεδομένα από στιγμιότυπα της
 * οντότητας {@code Song}. Το μοντέλο προσθέτει μια στήλη με την αρίθμηση των
 * σειρών (και συνεπώς και των εγγραφών).
 *
 * @author Apostolis Iakovakis
 * @author Nikos Karagiannis
 * @author Nikos Krommydas
 * @author Malamas Malamidis
 */
public class OrderedSongTableModel extends AbstractTableModel {

    private static final int COLUMN_COUNT = 4;
    private final List<Song> songList;

    /**
     * Δημιουργεί ένα {@code OrderedSongTableModel} που αντλεί δεδομένα από τη
     * λίστα τραγουδιών {@code songList}.
     *
     * @param songList η λίστα τραγουδιών που ορίζεται ως πηγή δεδομένων
     */
    public OrderedSongTableModel(List<Song> songList) {
        super();
        this.songList = songList;
    }

    /**
     * Επιστρέφει το πλήθος σειρών αυτού του πίνακα.
     *
     * @return το πλήθος σειρών του πίνακα
     */
    @Override
    public int getRowCount() {
        return ((songList == null) ? 1 : songList.size());
    }

    /**
     * Επιστρέφει το πλήθος στηλών αυτού του πίνακα.
     *
     * @return το πλήθος στηλών του πίνακα
     */
    @Override
    public int getColumnCount() {
        return COLUMN_COUNT;
    }

    /**
     * Επιστρέφει το αντικείμενο προς εμφάνιση στη γραμμή {@code rowIndex} και
     * τη στήλη {@code columnIndex}. Οι στήλες κατά σειρά περιέχουν αύξοντα
     * αριθμό (ξεκινώντας από το 1), τίτλο, όνομα ερμηνευτή και διάρκεια
     * τραγουδιού.
     *
     * @param rowIndex η γραμμή για την οποία ζητείται η τιμή
     * @param columnIndex η στήλη για την οποία ζητείται η τιμή
     * @return το αντίκειμενο προς εμφάνιση στο ζητούμενο κελί
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object value;
        Song song = songList.get(rowIndex);
        switch (columnIndex) {
            case 0:
                value = rowIndex + 1;
                break;
            case 1:
                value = song.getTitle();
                break;
            case 2:
                value = song.getAlbumId().getPerformerScreenName();
                break;
            case 3:
                value = song.getDuration();
                break;
            default:
                value = null;
                break;
        }
        return value;
    }
}
