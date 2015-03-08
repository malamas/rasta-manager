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
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * Η κλάση {@code Playlist} παριστάνει μια λίστα αναπαραγωγής. Είναι κλάση
 * οντότητας JPA.
 *
 * @author Apostolis Iakovakis
 * @author Nikos Karagiannis
 * @author Nikos Krommydas
 * @author Malamas Malamidis
 */
@Entity
@Table(name = "PLAYLIST")
public class Playlist implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PLAYLIST_ID")
    private Long playlistId;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @Column(name = "CREATION_DATE")
    @Temporal(TemporalType.DATE)
    private Date creationDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "playlist")
    @OrderBy("slot ASC")
    private List<PlaylistSong> playlistSongList;

    public Playlist() {
    }

    public Playlist(Long playlistId) {
        this.playlistId = playlistId;
    }

    public Playlist(Long playlistId, String name, Date creationDate) {
        this.playlistId = playlistId;
        this.name = name;
        this.creationDate = creationDate;
    }

    public Long getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(Long playlistId) {
        Long oldPlaylistid = this.playlistId;
        this.playlistId = playlistId;
        changeSupport.firePropertyChange("playlistId", oldPlaylistid, playlistId);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        Date oldCreationDate = this.creationDate;
        this.creationDate = creationDate;
        changeSupport.firePropertyChange("creationDate", oldCreationDate, creationDate);
    }

    public List<PlaylistSong> getPlaylistSongList() {
        return playlistSongList;
    }

    public void setPlaylistSongList(List<PlaylistSong> playlistSongList) {
        this.playlistSongList = playlistSongList;
    }

    /**
     * Επιστρέφει το πλήθος των τραγουδιών αυτής της {@code Playlist}.
     *
     * @return το πλήθος των τραγουδιών.
     */
    public int getSongCount() {
        return playlistSongList.size();
    }

    /**
     * Επιστρέφει τη συνολική διάρκεια σε δευτερόλεπτα των τραγουδιών αυτής της
     * {@code Playlist}.
     *
     * @return η διάρκεια σε δευτερόλεπτα.
     */
    public int getDuration() {
        int totalDuration = 0;
        for (PlaylistSong ps : playlistSongList) {
            totalDuration += ps.getSong().getDuration();
        }
        return totalDuration;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (playlistId != null ? playlistId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Playlist)) {
            return false;
        }
        Playlist other = (Playlist) object;
        if ((this.playlistId == null && other.playlistId != null) || (this.playlistId != null && !this.playlistId.equals(other.playlistId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "eap.pli24.rastaman.entities.Playlist[ playlistid=" + playlistId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
}
