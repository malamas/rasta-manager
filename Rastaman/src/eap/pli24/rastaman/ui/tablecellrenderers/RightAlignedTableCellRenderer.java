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

import javax.swing.SwingConstants;

/**
 * Υποκλάση της {@code GenericTableCellRenderer} που προσθέτει επιπλέον δεξιά
 * στοίχιση στο περιεχόμενο του κελιού.
 *
 * @author Apostolis Iakovakis
 * @author Nikos Karagiannis
 * @author Nikos Krommydas
 * @author Malamas Malamidis
 */
public class RightAlignedTableCellRenderer extends GenericTableCellRenderer {

    /**
     * Δημιουργεί έναν {@code RightAlignedTableCellRenderer}.
     */
    public RightAlignedTableCellRenderer() {
        super();
        this.setHorizontalAlignment(SwingConstants.RIGHT);
    }
}
