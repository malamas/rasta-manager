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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Η κλάση {@code PlaylistSong} παριστάνει ένα τραγούδι σε συγκεκριμένη θέση
 * λίστας αναπαραγωγής. Είναι κλάση οντότητας JPA.
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PLAYLIST_SONG_ID")
    private Long playlistSongId;
    @Basic(optional = false)
    @Column(name = "SLOT")
    private int slot;
    @JoinColumn(name = "PLAYLIST_ID", referencedColumnName = "PLAYLIST_ID")
    @ManyToOne(optional = false)
    private Playlist playlist;
    @JoinColumn(name = "SONG_ID", referencedColumnName = "SONG_ID")
    @ManyToOne(optional = false)
    private Song song;

    public PlaylistSong() {
    }

    public PlaylistSong(Long playlistSongId) {
        this.playlistSongId = playlistSongId;
    }

    public PlaylistSong(Long playlistSongId, int slot) {
        this.playlistSongId = playlistSongId;
        this.slot = slot;
    }

    public Long getPlaylistSongId() {
        return playlistSongId;
    }

    public void setPlaylistSongId(Long playlistSongId) {
        this.playlistSongId = playlistSongId;
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
        hash += (playlistSongId != null ? playlistSongId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlaylistSong)) {
            return false;
        }
        PlaylistSong other = (PlaylistSong) object;
        if ((this.playlistSongId == null && other.playlistSongId != null) || (this.playlistSongId != null && !this.playlistSongId.equals(other.playlistSongId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "eap.pli24.rastaman.entities.PlaylistSong[ playlistSongId=" + playlistSongId + " ]";
    }
}
