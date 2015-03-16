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

/**
 * Υποκλάση της {@code GenericTableCellRenderer} που εμφανίζει τα λεκτικά
 * "Άνδρας"/"Γυναίκα" στο περιεχόμενο του κελιού, αντικαθιστώντας αντίστοιχα τα
 * string "m"/"f".
 *
 * @author Apostolis Iakovakis
 * @author Nikos Karagiannis
 * @author Nikos Krommydas
 * @author Malamas Malamidis
 */
public class SexTableCellRenderer extends GenericTableCellRenderer {

    /**
     * Δημιουργεί έναν {@code SexTableCellRenderer}.
     */
    public SexTableCellRenderer() {
        super();
    }

    /**
     * Καθορίζει το string που θα απεικονιστεί στο κελί που σχεδιάζεται
     * ("Άνδρας"/"Γυναίκα" αντί "m"/"f" αντίστοιχα).
     *
     * @param value η τιμή εισόδου
     */
    @Override
    protected void setValue(Object value) {
        String v = (String) value;
        switch (v) {
            case "m":
                setText("Άνδρας");
                break;
            case "f":
                setText("Γυναίκα");
                break;
            default:
                setText(v);
                break;
        }
    }
}
