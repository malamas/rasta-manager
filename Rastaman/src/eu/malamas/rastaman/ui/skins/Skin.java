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
package eu.malamas.rastaman.ui.skins;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

/**
 * Το interface {@code Skin} προσδιορίζει τις μεθόδους που πρέπει να υλοποιούν
 * οι κλάσεις που παριστάνουν skins (θέματα εμφάνισης) της εφαρμογής.
 *
 * @author Apostolis Iakovakis
 * @author Nikos Karagiannis
 * @author Nikos Krommydas
 * @author Malamas Malamidis
 */
public interface Skin {

    Dimension getMainFrameInitSize();

    Dimension getMainFrameMinSize();

    int getSidebarWidth();

    Color getSidebarBackground();

    boolean getSidebarVisibleOnNonRoot();

    boolean getRastamanVisible();

    Color getRastamanForeground();

    Font getRastamanFont();

    Dimension getCreditsSize();

    Color getCreditsForeground();

    Font getCreditsFont();

    int getHeaderHeight();

    Color getHeaderBackground();

    Font getHeaderFont();

    Color getHeaderForeground();

    int getButtonPanelHeight();

    Color getTableOddRowBackground();

    Color getTableEvenRowBackground();

    Color getTableSelectedRowBackground();

}
