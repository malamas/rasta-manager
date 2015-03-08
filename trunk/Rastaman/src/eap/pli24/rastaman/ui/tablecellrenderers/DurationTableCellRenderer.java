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
package eap.pli24.rastaman.ui.tablecellrenderers;

import java.text.DecimalFormat;
import javax.swing.SwingConstants;

/**
 * Υποκλάση της {@code GenericTableCellRenderer} που εμφανίζει στο περιεχόμενο
 * του κελιού χρονικές διάρκειες στη μορφή [ω:]λλ:δδ.
 *
 * @author Apostolis Iakovakis
 * @author Nikos Karagiannis
 * @author Nikos Krommydas
 * @author Malamas Malamidis
 */
public class DurationTableCellRenderer extends GenericTableCellRenderer {

    private final DecimalFormat dcf = new DecimalFormat("#00");

    /**
     * Δημιουργεί έναν {@code DurationTableCellRenderer}.
     */
    public DurationTableCellRenderer() {
        super();
        // δεξιά στοίχιση
        this.setHorizontalAlignment(SwingConstants.RIGHT);
    }

    /**
     * Καθορίζει το string που θα απεικονιστεί στο κελί που σχεδιάζεται
     * (διάρκεια σε μορφή [ω:]λλ:δδ).
     *
     * @param value η ημερομηνία που θα απεικονιστεί
     */
    @Override
    protected void setValue(Object value) {
        if (value == null) {
            setText(null);
        } else {
            int d = (int) value;
            int h = d / 3600;
            d = d % 3600;
            // αν η διάρκεια υπερβαίνει τα 60 λεπτά τότε εμφανίζονται ώρες, αλλιώς μόνο λλ:δδ
            setText(((h > 0) ? h + ":" : "") + dcf.format(d / 60) + ":" + dcf.format(d % 60));
        }
    }
}
