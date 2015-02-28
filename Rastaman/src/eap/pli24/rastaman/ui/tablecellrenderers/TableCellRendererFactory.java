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
 *
 * @author Apostolis Iakovakis
 * @author Nikos Karagiannis
 * @author Nikos Krommydas
 * @author Malamas Malamidis
 */
public class TableCellRendererFactory {

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

    static {
        renderers.put(RendererType.GENERIC, genericTableCellRenderer);
        renderers.put(RendererType.GENERIC_RIGHT_ALIGNED, rightAlignedTableCellRenderer);
        renderers.put(RendererType.DATE, dateTableCellRenderer);
        renderers.put(RendererType.SEX, sexTableCellRenderer);
        renderers.put(RendererType.DURATION, durationTableCellRenderer);
    }

    private TableCellRendererFactory() {
    }

    public static TableCellRenderer getTableCellRenderer(RendererType type) {
        return renderers.get(type);
    }
}
