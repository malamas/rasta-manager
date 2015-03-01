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
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@Table(name = "PLAYLIST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Playlist.findAll", query = "SELECT p FROM Playlist p"),
    @NamedQuery(name = "Playlist.findByPlaylistid", query = "SELECT p FROM Playlist p WHERE p.playlistid = :playlistid"),
    @NamedQuery(name = "Playlist.findByName", query = "SELECT p FROM Playlist p WHERE p.name = :name"),
    @NamedQuery(name = "Playlist.findByCreationdate", query = "SELECT p FROM Playlist p WHERE p.creationdate = :creationdate")})
public class Playlist implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PLAYLISTID")
    private Long playlistid;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @Column(name = "CREATIONDATE")
    @Temporal(TemporalType.DATE)
    private Date creationdate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "playlist")
    @OrderBy("playorder ASC")
    private List<PlaylistSong> playlistSongList;

    public Playlist() {
    }

    public Playlist(Long playlistid) {
        this.playlistid = playlistid;
    }

    public Playlist(Long playlistid, String name, Date creationdate) {
        this.playlistid = playlistid;
        this.name = name;
        this.creationdate = creationdate;
    }

    public Long getPlaylistid() {
        return playlistid;
    }

    public void setPlaylistid(Long playlistid) {
        Long oldPlaylistid = this.playlistid;
        this.playlistid = playlistid;
        changeSupport.firePropertyChange("playlistid", oldPlaylistid, playlistid);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        Date oldCreationdate = this.creationdate;
        this.creationdate = creationdate;
        changeSupport.firePropertyChange("creationdate", oldCreationdate, creationdate);
    }

    @XmlTransient
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
    @XmlTransient
    public int getSongCount() {
        return playlistSongList.size();
    }

    /**
     * Επιστρέφει τη συνολική διάρκεια σε δευτερόλεπτα των τραγουδιών αυτής της
     * {@code Playlist}.
     *
     * @return η διάρκεια σε δευτερόλεπτα.
     */
    @XmlTransient
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
        hash += (playlistid != null ? playlistid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Playlist)) {
            return false;
        }
        Playlist other = (Playlist) object;
        if ((this.playlistid == null && other.playlistid != null) || (this.playlistid != null && !this.playlistid.equals(other.playlistid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "eap.pli24.rastaman.entities.Playlist[ playlistid=" + playlistid + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
}
