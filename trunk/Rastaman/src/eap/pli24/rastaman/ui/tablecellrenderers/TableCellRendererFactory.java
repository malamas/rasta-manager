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

import java.util.EnumMap;
import javax.swing.table.TableCellRenderer;

/**
 * Η κλάση {@code TableCellRendererFactory} διατηρεί από ένα στιγμιότυπο της
 * κλάσης {@code GenericTableCellRenderer} και των υποκλάσεών της, και τα
 * παρέχει στα {@code JTable} που τα ζητούν. Είναι static final (utility) class.
 *
 * @author Apostolis Iakovakis
 * @author Nikos Karagiannis
 * @author Nikos Krommydas
 * @author Malamas Malamidis
 */
public final class TableCellRendererFactory {

    /**
     * enum με σταθερές για κάθε τύπο renderer που χρησιμοποιεί η εφαρμογή.
     */
    public static enum RendererType {

        GENERIC,
        GENERIC_RIGHT_ALIGNED,
        DATE,
        SEX,
        DURATION
    }
    private static final TableCellRenderer genericTableCellRenderer = new GenericTableCellRenderer();
    private static final TableCellRenderer rightAlignedTableCellRenderer = new RightAlignedTableCellRenderer();
    private static final TableCellRenderer dateTableCellRenderer = new DateTableCellRenderer();
    private static final TableCellRenderer sexTableCellRenderer = new SexTableCellRenderer();
    private static final TableCellRenderer durationTableCellRenderer = new DurationTableCellRenderer();
    private static final EnumMap<RendererType, TableCellRenderer> renderers = new EnumMap<>(RendererType.class);

    // στατική αρχικοποίηση EnumMap με τα στιγμιότυπα των renderer
    static {
        renderers.put(RendererType.GENERIC, genericTableCellRenderer);
        renderers.put(RendererType.GENERIC_RIGHT_ALIGNED, rightAlignedTableCellRenderer);
        renderers.put(RendererType.DATE, dateTableCellRenderer);
        renderers.put(RendererType.SEX, sexTableCellRenderer);
        renderers.put(RendererType.DURATION, durationTableCellRenderer);
    }

    // ιδιωτικός δημιουργός που εξασφαλίζει ότι δεν μπορεί να υπάρξει κανένα στιγμιότυπο της κλάσης
    private TableCellRendererFactory() {
    }

    /**
     * Επιστρέφει το στιγμιότυπο {@code TableCellRenderer} που ζητείται.
     *
     * @param type ο τύπος renderer που ζητείται ({@code RendererType})
     * @return ο ζητούμενος renderer
     */
    public static TableCellRenderer getTableCellRenderer(RendererType type) {
        return renderers.get(type);
    }
}
