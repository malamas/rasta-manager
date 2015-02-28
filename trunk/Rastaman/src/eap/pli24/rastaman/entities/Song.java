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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Apostolis Iakovakis
 * @author Nikos Karagiannis
 * @author Nikos Krommydas
 * @author Malamas Malamidis
 */
@Entity
@Table(name = "SONG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Song.findAll", query = "SELECT s FROM Song s"),
    @NamedQuery(name = "Song.findBySongid", query = "SELECT s FROM Song s WHERE s.songid = :songid"),
    @NamedQuery(name = "Song.findByTitle", query = "SELECT s FROM Song s WHERE s.title = :title"),
    @NamedQuery(name = "Song.findByDuration", query = "SELECT s FROM Song s WHERE s.duration = :duration"),
    @NamedQuery(name = "Song.findByTracknr", query = "SELECT s FROM Song s WHERE s.tracknr = :tracknr")})
public class Song implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "song")
    private List<PlaylistSong> playlistSongList;
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SONGID")
    private Long songid;
    @Basic(optional = false)
    @Column(name = "TITLE")
    private String title;
    @Basic(optional = false)
    @Column(name = "DURATION")
    private int duration;
    @Basic(optional = false)
    @Column(name = "TRACKNR")
    private int tracknr;
    @JoinTable(name = "PLAYLIST_SONG", joinColumns = {
        @JoinColumn(name = "SONGSONGID", referencedColumnName = "SONGID")}, inverseJoinColumns = {
        @JoinColumn(name = "PLAYLISTPLAYLISTID", referencedColumnName = "PLAYLISTID")})
    @ManyToMany
    private List<Playlist> playlistList;
    @JoinColumn(name = "ALBUMID", referencedColumnName = "ALBUMID")
    @ManyToOne(optional = false)
    private Album albumid;

    public Song() {
    }

    public Song(Long songid) {
        this.songid = songid;
    }

    public Song(Long songid, String title, int duration, int tracknr) {
        this.songid = songid;
        this.title = title;
        this.duration = duration;
        this.tracknr = tracknr;
    }

    public Long getSongid() {
        return songid;
    }

    public void setSongid(Long songid) {
        Long oldSongid = this.songid;
        this.songid = songid;
        changeSupport.firePropertyChange("songid", oldSongid, songid);
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

    public int getTracknr() {
        return tracknr;
    }

    public void setTracknr(int tracknr) {
        int oldTracknr = this.tracknr;
        this.tracknr = tracknr;
        changeSupport.firePropertyChange("tracknr", oldTracknr, tracknr);
    }

    @XmlTransient
    public List<Playlist> getPlaylistList() {
        return playlistList;
    }

    public void setPlaylistList(List<Playlist> playlistList) {
        this.playlistList = playlistList;
    }

    public Album getAlbumid() {
        return albumid;
    }

    public void setAlbumid(Album albumid) {
        Album oldAlbumid = this.albumid;
        this.albumid = albumid;
        changeSupport.firePropertyChange("albumid", oldAlbumid, albumid);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (songid != null ? songid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Song)) {
            return false;
        }
        Song other = (Song) object;
        if ((this.songid == null && other.songid != null) || (this.songid != null && !this.songid.equals(other.songid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "eap.pli24.rastaman.entities.Song[ songid=" + songid + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

    @XmlTransient
    public List<PlaylistSong> getPlaylistSongList() {
        return playlistSongList;
    }

    public void setPlaylistSongList(List<PlaylistSong> playlistSongList) {
        this.playlistSongList = playlistSongList;
    }

}
