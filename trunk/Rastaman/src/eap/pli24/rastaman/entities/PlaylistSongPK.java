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
package eap.pli24.rastaman.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Apostolis Iakovakis
 * @author Nikos Karagiannis
 * @author Nikos Krommydas
 * @author Malamas Malamidis
 */
@Embeddable
public class PlaylistSongPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "PLAYLISTPLAYLISTID")
    private long playlistplaylistid;
    @Basic(optional = false)
    @Column(name = "SONGSONGID")
    private long songsongid;

    public PlaylistSongPK() {
    }

    public PlaylistSongPK(long playlistplaylistid, long songsongid) {
        this.playlistplaylistid = playlistplaylistid;
        this.songsongid = songsongid;
    }

    public long getPlaylistplaylistid() {
        return playlistplaylistid;
    }

    public void setPlaylistplaylistid(long playlistplaylistid) {
        this.playlistplaylistid = playlistplaylistid;
    }

    public long getSongsongid() {
        return songsongid;
    }

    public void setSongsongid(long songsongid) {
        this.songsongid = songsongid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) playlistplaylistid;
        hash += (int) songsongid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlaylistSongPK)) {
            return false;
        }
        PlaylistSongPK other = (PlaylistSongPK) object;
        if (this.playlistplaylistid != other.playlistplaylistid) {
            return false;
        }
        if (this.songsongid != other.songsongid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "eap.pli24.rastaman.entities.PlaylistSongPK[ playlistplaylistid=" + playlistplaylistid + ", songsongid=" + songsongid + " ]";
    }

}
