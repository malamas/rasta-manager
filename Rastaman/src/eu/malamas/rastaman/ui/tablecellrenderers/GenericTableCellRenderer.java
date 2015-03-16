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
package eu.malamas.rastaman.ui.tablecellrenderers;

import eu.malamas.rastaman.ui.skins.SkinObserver;
import eu.malamas.rastaman.ui.skins.SkinProvider;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * Η κλάση {@code GenericTableCellRenderer} υλοποιεί έναν
 * {@code TableCellRenderer} με εναλλασσόμενα χρώματα σε διαδοχικές
 * (άρτιες/περιττές) γραμμές ενός {@code JTable}. Υλοιποιεί το interface
 * {@code SkinObserver} ώστε να ενημερώνεται σε περίπτωση αλλαγής του ενεργού
 * skin της εφαρμογής.
 *
 * @author Apostolis Iakovakis
 * @author Nikos Karagiannis
 * @author Nikos Krommydas
 * @author Malamas Malamidis
 */
public class GenericTableCellRenderer extends DefaultTableCellRenderer implements SkinObserver {

    private Color oddRowColor;
    private Color evenRowColor;
    private Color selectedColor;

    /**
     * Δημιουργεί έναν {@code GenericTableCellRenderer} και τον προσθέτει στη
     * λίστα παρατηρητών του {@code SkinProvider}.
     */
    public GenericTableCellRenderer() {
        super();
        retrieveColors();
        SkinProvider.getInstance().addObserver(this);
    }

    /**
     * Επιστρέφει το {@code Component} που θα χρησιμοποιηθεί σαν renderer.
     *
     * @param table ο πίνακας
     * @param value η τιμή που θα απεικονιστεί
     * @param isSelected true αν το κελί είναι επιλεγμένο
     * @param hasFocus true αν το κελί έχει το focus
     * @param row η σειρά του πίνακα
     * @param column η στήλη του πίνακα
     * @return το {@code Component} που θα χρησιμοποιηθεί σαν renderer
     */
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // επιλογή χρώματος ανάλογα με τη σειρά (άρτια/περιττή) που σχεδιάζεται
        this.setBackground((isSelected ? selectedColor : (row % 2 == 0) ? oddRowColor : evenRowColor));
        return this;
    }

    /**
     * Η μέθοδος που καλείται για ειδοποιήσει αυτόν τον renderer ότι το ενεργό
     * skin έχει αλλάξει.
     */
    @Override
    public void update() {
        retrieveColors();
    }

    /**
     * Ανακτά από τον {@code SkinProvider} τα χρώματα που θα χρησιμοποιηθούν.
     */
    private void retrieveColors() {
        oddRowColor = SkinProvider.getInstance().getSkin().getTableOddRowBackground();
        evenRowColor = SkinProvider.getInstance().getSkin().getTableEvenRowBackground();
        selectedColor = SkinProvider.getInstance().getSkin().getTableSelectedRowBackground();
    }
}
