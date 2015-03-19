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
package eu.malamas.rastaman.ui.playlist;

import eu.malamas.rastaman.model.Playlist;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Η κλάση {@code PlaylistTableModel} είναι μοντέλο δεδομένων για ένα
 * {@code JTable} που περιέχει εγγραφές με δεδομένα από στιγμιότυπα της
 * οντότητας {@code Playlist}.
 *
 * @author Malamas Malamidis
 */
public class PlaylistTableModel extends AbstractTableModel {

    private static final int COLUMN_COUNT = 4;
    private List<Playlist> playlists;

    /**
     * Δημιουργεί ένα {@code PlaylistTableModel} που αντλεί δεδομένα από τη
     * λίστα playlist {@code playlists}.
     *
     * @param playlists η λίστα playlist που ορίζεται ως πηγή δεδομένων
     */
    public PlaylistTableModel(List<Playlist> playlists) {
        super();
        this.playlists = playlists;
    }

    /**
     * Επιστρέφει το πλήθος σειρών αυτού του πίνακα.
     *
     * @return το πλήθος σειρών του πίνακα
     */
    @Override
    public int getRowCount() {
        return ((playlists == null) ? 0 : playlists.size());
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
     * τη στήλη {@code columnIndex}. Οι στήλες κατά σειρά περιέχουν όνομα,
     * ημερομηνία δημιουργίας, πλήθος τραγουδιών και ολική διάρκεια της λίστας.
     *
     * @param rowIndex η γραμμή για την οποία ζητείται η τιμή
     * @param columnIndex η στήλη για την οποία ζητείται η τιμή
     * @return το αντίκειμενο προς εμφάνιση στο ζητούμενο κελί
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object value;
        Playlist p = playlists.get(rowIndex);
        switch (columnIndex) {
            case 0:
                value = p.getName();
                break;
            case 1:
                value = p.getCreationDate();
                break;
            case 2:
                value = p.getSongCount();
                break;
            case 3:
                value = p.getDuration();
                break;
            default:
                value = null;
                break;
        }
        return value;
    }

    /**
     * Ορίζει τη λίστα {@code playlists} ως τη λίστα από την οποία αντλεί
     * δεδομένα αυτό το {@code PlaylistTableModel}.
     *
     * @param playlists η λίστα playlist που ορίζεται ως πηγή δεδομένων
     */
    public void setPlaylists(List<Playlist> playlists) {
        this.playlists = playlists;
    }
}
