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

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Apostolis Iakovakis
 * @author Nikos Karagiannis
 * @author Nikos Krommydas
 * @author Malamas Malamidis
 */
@Entity
@Table(name = "SONG")
public class Song implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SONG_ID")
    private Long songId;
    @Basic(optional = false)
    @Column(name = "TITLE")
    private String title;
    @Basic(optional = false)
    @Column(name = "DURATION")
    private int duration;
    @Basic(optional = false)
    @Column(name = "TRACK_NO")
    private int trackNo;
    @JoinColumn(name = "ALBUM_ID", referencedColumnName = "ALBUMID")
    @ManyToOne(optional = false)
    private Album albumId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "song")
    private List<PlaylistSong> playlistSongList;

    public Song() {
    }

    public Song(Long songid) {
        this.songId = songid;
    }

    public Song(Long songid, String title, int duration, int trackNo) {
        this.songId = songid;
        this.title = title;
        this.duration = duration;
        this.trackNo = trackNo;
    }

    public Long getSongId() {
        return songId;
    }

    public void setSongId(Long songId) {
        Long oldSongid = this.songId;
        this.songId = songId;
        changeSupport.firePropertyChange("songid", oldSongid, songId);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        String oldTitle = this.title;
        this.title = title;
        changeSupport.firePropertyChange("title", oldTitle, title);
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        int oldDuration = this.duration;
        this.duration = duration;
        changeSupport.firePropertyChange("duration", oldDuration, duration);
    }

    public int getTrackNo() {
        return trackNo;
    }

    public void setTrackNo(int trackNo) {
        int oldTracknr = this.trackNo;
        this.trackNo = trackNo;
        changeSupport.firePropertyChange("tracknr", oldTracknr, trackNo);
    }

    public Album getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Album albumId) {
        Album oldAlbumid = this.albumId;
        this.albumId = albumId;
        changeSupport.firePropertyChange("albumid", oldAlbumid, albumId);
    }

    public List<PlaylistSong> getPlaylistSongList() {
        return playlistSongList;
    }

    public void setPlaylistSongList(List<PlaylistSong> playlistSongList) {
        this.playlistSongList = playlistSongList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (songId != null ? songId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Song)) {
            return false;
        }
        Song other = (Song) object;
        if ((this.songId == null && other.songId != null) || (this.songId != null && !this.songId.equals(other.songId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "eap.pli24.rastaman.entities.Song[ songId=" + songId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
}
