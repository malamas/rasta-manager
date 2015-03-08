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

import java.util.EnumMap;
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

    public enum Skins {

        JAMAICA("Jamaica"),
        SERIOUS("Σοβαρότης"),
        SERIOUS_WIDE("Σοβαρότης (wide)"),
        CABERNET("Καμπερνέ (wide)");

        private final String name;

        Skins(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    private static final SkinProvider INSTANCE = new SkinProvider();
    private Skins activeSkin;
    private Set<SkinObserver> observers;
    private EnumMap<Skins, Skin> skinMap;

    private SkinProvider() {
        initialize();

    }

    public static SkinProvider getInstance() {
        return INSTANCE;
    }

    private void initialize() {
        observers = new HashSet<>();
        initSkinMap();
        activeSkin = Skins.JAMAICA;
    }

    private void initSkinMap() {
        skinMap = new EnumMap<>(Skins.class);
        skinMap.put(Skins.JAMAICA, new JamaicaSkin());
        skinMap.put(Skins.SERIOUS, new SeriousSkin());
        skinMap.put(Skins.SERIOUS_WIDE, new SeriousWideSkin());
        skinMap.put(Skins.CABERNET, new CabernetSkin());
    }

    public Skin getSkin() {
        return skinMap.get(activeSkin);
    }

    public Skins getActiveSkin() {
        return activeSkin;
    }

    public void setActiveSkin(Skins skin) {
        if (activeSkin != skin) {
            activeSkin = skin;
            for (SkinObserver ob : observers) {
                ob.update();
            }
        }
    }

    public void addObserver(SkinObserver ob) {
        observers.add(ob);
    }

}
