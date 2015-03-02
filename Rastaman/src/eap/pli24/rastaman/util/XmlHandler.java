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
package eap.pli24.rastaman.util;

import eap.pli24.rastaman.entities.Playlist;
import eap.pli24.rastaman.entities.PlaylistSong;
import eap.pli24.rastaman.entities.Song;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author Apostolis Iakovakis
 * @author Nikos Karagiannis
 * @author Nikos Krommydas
 * @author Malamas Malamidis
 */
public final class XmlHandler {

    private XmlHandler() {
    }

    public static Document buildDocumentFrom(Playlist pl) throws ParserConfigurationException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", new Locale("el", "GR"));

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
            idEl.appendChild(doc.createTextNode(Long.toString(s.getSongId())));
            songEl.appendChild(idEl);

            // Τίτλος τραγουδιού
            Element titleEl = doc.createElement("title");
            titleEl.appendChild(doc.createTextNode(s.getTitle()));
            songEl.appendChild(titleEl);

            // Ερμηνευτής (καλλιτέχνης ή συγκρότημα
            Element performerEl = doc.createElement("performer");
            performerEl.appendChild(doc.createTextNode(s.getAlbumId().getPerformerScreenName()));
            songEl.appendChild(performerEl);

            songlistEl.appendChild(songEl);
        }

        playlistEl.appendChild(songlistEl);
        return doc;
    }
}
