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
package eap.pli24.rastaman.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

/**
 * Η κλάση {@code UIProperties} παρέχει μια σειρά από σταθερές {@code public
 * static final} που ορίζουν ιδιότητες του user interface. Είναι {@code final}
 * ώστε να μην μπορεί να κληρονομηθεί, και έχει {@code private} δημιουργό, ώστε
 * να μη μπορούν να δημιουργηθούν στιγμιότυπά της.
 *
 * @author Apostolis Iakovakis
 * @author Nikos Karagiannis
 * @author Nikos Krommydas
 * @author Malamas Malamidis
 */
public final class UIProperties {

    public static final Dimension MAIN_FRAME_INIT_SIZE = new Dimension(1000, 700);
    public static final Dimension MAIN_FRAME_MIN_SIZE = new Dimension(900, 600);

    public static final int SIDEBAR_WIDTH = 240;
    public static final Color SIDEBAR_BACKGROUND = new Color(104, 104, 0);
    public static final Color RASTAMAN_FOREGROUND = new Color(240, 220, 48);
    public static final Font RASTAMAN_FONT = new Font("Tahoma", 1, 14);

    public static final Dimension CREDITS_SIZE = new Dimension(200, 150);
    public static final Color CREDITS_FOREGROUND = new Color(224, 224, 224);
    public static final Font CREDITS_FONT = new Font("Tahoma", 1, 11);

    public static final int HEADER_HEIGHT = 50;
    public static final Color HEADER_BACKGROUND = new Color(204, 208, 204);
    public static final Font HEADER_FONT = new Font("Tahoma", 1, 14);
    public static final Color HEADER_FOREGROUND = new Color(48, 48, 24);

    public static final int BUTTON_PANEL_HEIGHT = 42;

    public static final Color TABLE_ODD_ROW_BACKGROUND = new Color(255, 255, 255);
    public static final Color TABLE_EVEN_ROW_BACKGROUND = new Color(224, 232, 216);
    public static final Color TABLE_SELECTED_ROW_BACKGROUND = new Color(104, 104, 0);

    /*
     * {@code private} δημιουργός, ώστε να μη μπορούν να δημιουργηθούν στιγμιότυπα της κλάσης.
     */
    private UIProperties() {
    }
}
