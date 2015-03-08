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
 * Η κλάση {@code SkinProvider} παριστάνει το διαχειριστή θέματος εμφάνισης
 * (skin) της εφαρμογής. Επιτρέπει να δημιουργείται μόνο ένα στιγμιότυπό της
 * (singleton pattern).
 *
 * @author Apostolis Iakovakis
 * @author Nikos Karagiannis
 * @author Nikos Krommydas
 * @author Malamas Malamidis
 */
public class SkinProvider {

    /**
     * Το enum {@code Skins} περιέχει σταθερές για κάθε ένα διαθέσιμο και
     * εγκατεστημένο θέμα εμφάνισης.
     */
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

    // ιδιωτικός δημιουργός για την εξασφάλιση του singleton pattern
    private SkinProvider() {
        initialize();

    }

    /**
     * Επιστρέφει το μοναδικό στιγμιότυπο της κλάσης, και ταυτόχρονα αποτελεί
     * ευπρόσιτο σημείο πρόσβασης για αυτό.
     *
     * @return το μοναδικό στιγμιότυπο της κλάσης
     */
    public static SkinProvider getInstance() {
        return INSTANCE;
    }

    /**
     * Αρχικοποιεί το μοναδικό στιγμιότυπο της κλάσης.
     */
    private void initialize() {
        observers = new HashSet<>();
        initSkinMap();
        activeSkin = Skins.JAMAICA;
    }

    /**
     * Αρχικοποιεί τον πίνακα (@code skinMap} με τα διαθέσιμα skin,
     * δημιουργώντας ένα στιγμιότυπο του καθενός.
     */
    private void initSkinMap() {
        skinMap = new EnumMap<>(Skins.class);
        skinMap.put(Skins.JAMAICA, new JamaicaSkin());
        skinMap.put(Skins.SERIOUS, new SeriousSkin());
        skinMap.put(Skins.SERIOUS_WIDE, new SeriousWideSkin());
        skinMap.put(Skins.CABERNET, new CabernetSkin());
    }

    /**
     * Επιστρέφει το ενεργό {@code Skin}, ώστε ο καλών να αποκτήσει πρόσβαση
     * στις ιδιότητες που αυτό παρέχει.
     *
     * @return το ενεργό {@code Skin}
     */
    public Skin getSkin() {
        return skinMap.get(activeSkin);
    }

    /**
     * Επιστρέφει το μέλος του enum {@code Skins} που αντιστοιχεί στο ενεργό
     * skin.
     *
     * @return η σταθερά (enum {@code Skins}) του ενεργού skin
     */
    public Skins getActiveSkin() {
        return activeSkin;
    }

    /**
     * Ορίζει ως ενεργό θέμα εμφάνισης της εφαρμογής το skin που αντιστοιχεί στη
     * σταθερά {@code skin} του enum {@code Skins}.
     *
     * @param skin το θέμα που ορίζεται ως ενεργό
     */
    public void setActiveSkin(Skins skin) {
        if (activeSkin != skin) {
            activeSkin = skin;

            // αλλαγή ενεργού skin, πρέπει να ενημερωθούν οι παρατηρητές
            for (SkinObserver ob : observers) {
                ob.update();
            }
        }
    }

    /**
     * Προσθέτει έναν {@code SkinObserver} στη λίστα των παρατηρητών αυτού του
     * {@code SkinProvider}.
     *
     * @param ob ο παρατηρητής που προστίθεται
     */
    public void addObserver(SkinObserver ob) {
        observers.add(ob);
    }
}
