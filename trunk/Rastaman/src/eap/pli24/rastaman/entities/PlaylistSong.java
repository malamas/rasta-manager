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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Apostolis Iakovakis
 * @author Nikos Karagiannis
 * @author Nikos Krommydas
 * @author Malamas Malamidis
 */
@Entity
@Table(name = "PLAYLIST_SONG")
public class PlaylistSong implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PlaylistSongPK playlistSongPK;
    @Basic(optional = false)
    @Column(name = "SLOT")
    private int slot;
    @JoinColumn(name = "PLAYLIST_ID", referencedColumnName = "PLAYLIST_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Playlist playlist;
    @JoinColumn(name = "SONG_ID", referencedColumnName = "SONGID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Song song;

    public PlaylistSong() {
    }

    public PlaylistSong(PlaylistSongPK playlistSongPK) {
        this.playlistSongPK = playlistSongPK;
    }

    public PlaylistSong(PlaylistSongPK playlistSongPK, int playorder) {
        this.playlistSongPK = playlistSongPK;
        this.slot = playorder;
    }

    public PlaylistSong(long playlistplaylistid, long songsongid) {
        this.playlistSongPK = new PlaylistSongPK(playlistplaylistid, songsongid);
    }

    public PlaylistSongPK getPlaylistSongPK() {
        return playlistSongPK;
    }

    public void setPlaylistSongPK(PlaylistSongPK playlistSongPK) {
        this.playlistSongPK = playlistSongPK;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (playlistSongPK != null ? playlistSongPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlaylistSong)) {
            return false;
        }
        PlaylistSong other = (PlaylistSong) object;
        if ((this.playlistSongPK == null && other.playlistSongPK != null) || (this.playlistSongPK != null && !this.playlistSongPK.equals(other.playlistSongPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "eap.pli24.rastaman.entities.PlaylistSong[ playlistSongPK=" + playlistSongPK + " ]";
    }

}
