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
package eap.pli24.rastaman.ui.skins;

import eap.pli24.rastaman.ui.tablecellrenderers.GenericTableCellRenderer;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Apostolis Iakovakis
 * @author Nikos Karagiannis
 * @author Nikos Krommydas
 * @author Malamas Malamidis
 */
public class SkinProvider {

    private static final SkinProvider INSTANCE = new SkinProvider();
    private Skin skin;
    private Set<GenericTableCellRenderer> observers;

    private SkinProvider() {
        initialize();

    }

    public static SkinProvider getInstance() {
        return INSTANCE;
    }

    private void initialize() {
        skin = new JamaicaSkin();
        observers = new HashSet<>();
    }

    public Skin getSkin() {
        return skin;
    }

    public void toggle() {
        skin = ((skin instanceof JamaicaSkin) ? new SeriousSkin() : new JamaicaSkin());
        if (observers != null) {
            for (GenericTableCellRenderer ob : observers) {
                ob.update();
            }
        }
    }

    public void addObserver(GenericTableCellRenderer gtr) {
        observers.add(gtr);
    }

}
