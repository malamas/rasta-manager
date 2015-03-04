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

import eap.pli24.rastaman.ui.skins.SkinProvider;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Apostolis Iakovakis
 * @author Nikos Karagiannis
 * @author Nikos Krommydas
 * @author Malamas Malamidis
 */
public class GenericTableCellRenderer extends DefaultTableCellRenderer {

    private Color oddRowColor;
    private Color evenRowColor;
    private Color selectedColor;

    public GenericTableCellRenderer() {
        super();
        retrieveColors();
        SkinProvider.getInstance().addObserver(this);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        this.setBackground((isSelected ? selectedColor : (row % 2 == 0) ? oddRowColor : evenRowColor));
        return this;
    }

    public void update() {
        retrieveColors();
    }

    private void retrieveColors() {
        oddRowColor = SkinProvider.getInstance().getSkin().getTableOddRowBackground();
        evenRowColor = SkinProvider.getInstance().getSkin().getTableEvenRowBackground();
        selectedColor = SkinProvider.getInstance().getSkin().getTableSelectedRowBackground();
    }
}
