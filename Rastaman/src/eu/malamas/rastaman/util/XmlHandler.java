/*
 * Copyright (c) 2015 Apostolis Iakovakis & Malamas Malamidis.
 * All rights reserved.
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
package eu.malamas.rastaman.util;

import eu.malamas.rastaman.model.Playlist;
import eu.malamas.rastaman.model.PlaylistSong;
import eu.malamas.rastaman.model.Song;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Η κλάση {@code XmlHandler} περιέχει βοηθητικές μεθόδους για τη δημιουργία xml
 * {@code Document} από {@code Playlist} και αντίστροφα. Είναι static final
 * (utility) class.
 *
 * @author Malamas Malamidis
 */
public final class XmlHandler {

    private static final Logger LOGGER = Logger.getLogger(XmlHandler.class.getName());
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", new Locale("el", "GR"));

    // ιδιωτικός δημιουργός που εξασφαλίζει ότι δεν μπορεί να υπάρξει κανένα στιγμιότυπο της κλάσης
    private XmlHandler() {
    }

    /**
     * Δημιουργεί xml {@code Document} από μία {@code Playlist}.
     *
     * @param pl η λίστα αναπαραγωγής
     * @return το xml Document που δημιουργήθηκε
     * @throws ParserConfigurationException
     */
    public static Document buildDocumentFromPlaylist(Playlist pl) throws ParserConfigurationException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.newDocument();

        // Ρίζα δένδρου xml
        Element playlistEl = doc.createElement("playlist");
        doc.appendChild(playlistEl);

        // Όνομα λίστας
        Element nameEl = doc.createElement("name");
        nameEl.appendChild(doc.createTextNode(pl.getName()));
        playlistEl.appendChild(nameEl);

        // Ημερομηνία δημιουργίας
        Element creationDateEl = doc.createElement("creationdate");
        creationDateEl.appendChild(doc.createTextNode(sdf.format(pl.getCreationDate())));
        playlistEl.appendChild(creationDateEl);

        // Λίστα τραγουδιών
        Element songlistEl = doc.createElement("songlist");

        for (PlaylistSong ps : pl.getPlaylistSongList()) {
            Song s = ps.getSong();
            // στοιχείο για κάθε τραγούδι
            Element songEl = doc.createElement("song");

            // Στοιχείο με το id του τραγουδιού στη ΒΔ.
            Element idEl = doc.createElement("id");
            idEl.appendChild(doc.createTextNode(Long.toString(s.getId())));
            songEl.appendChild(idEl);

            // Τίτλος τραγουδιού
            Element titleEl = doc.createElement("title");
            titleEl.appendChild(doc.createTextNode(s.getTitle()));
            songEl.appendChild(titleEl);

            // Ερμηνευτής (καλλιτέχνης ή συγκρότημα
            Element performerEl = doc.createElement("performer");
            performerEl.appendChild(doc.createTextNode(s.getAlbum().getPerformerScreenName()));
            songEl.appendChild(performerEl);

            songlistEl.appendChild(songEl);
        }

        playlistEl.appendChild(songlistEl);
        return doc;
    }

    /**
     * Δημιουργεί μία {@code Playlist} από ένα xml {@code Document}.
     *
     * @param doc το xml Document
     * @param em EntityManager για έλεγχους στη ΒΔ
     * @return η δημιουργηθείσα λίστα αναπαραγωγής
     */
    public static Playlist buildPlaylistFromDocument(Document doc, EntityManager em) {
        doc.getDocumentElement().normalize();

        Playlist playlist = new Playlist();

        Node nameNode = doc.getElementsByTagName("name").item(0);
        if (nameNode == null) {
            return null;
        }
        String name = nameNode.getTextContent();
        playlist.setName(name);

        Node dateNode = doc.getElementsByTagName("creationdate").item(0);
        if (dateNode == null) {
            return null;
        }
        String date = dateNode.getTextContent();
        try {
            playlist.setCreationDate(sdf.parse(date));
        } catch (ParseException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
            return null;
        }

        NodeList nl = doc.getElementsByTagName("song");

        List<Song> songList = new ArrayList<>();
        List<PlaylistSong> psList = new ArrayList<>();

        // δημιουργία λίστας με τα προς εισαγωγή τραγούδια, ώστε να αποφευχθούν διπλοεισαγωγές
        for (int i = 0; i < nl.getLength(); i++) {
            Node n = nl.item(i);
            try {
                long songId = Long.parseLong(((Element) n).getElementsByTagName("id").item(0).getTextContent());
                Song song = em.find(Song.class, songId);
                if (song != null && !songList.contains(song)) {
                    songList.add(song);
                }
            } catch (Exception ex) {
                return null;
            }
        }

        // δημιουργία Playlist
        for (int i = 0; i < songList.size(); i++) {
            Song song = songList.get(i);
            PlaylistSong ps = new PlaylistSong();
            ps.setPlaylist(playlist);
            ps.setSlot(i + 1);
            ps.setSong(song);
            psList.add(ps);
        }

        playlist.setPlaylistSongList(psList);
        return playlist;
    }
}
