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
package eu.malamas.rastaman.model;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Η κλάση {@code MusicGenre} παριστάνει ένα είδος μουσικής. Είναι κλάση
 * οντότητας JPA.
 *
 * @author Apostolis Iakovakis
 * @author Malamas Malamidis
 */
@Entity
@Table(name = "MUSIC_GENRE")
public class MusicGenre implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MUSIC_GENRE_ID")
    private Integer musicGenreId;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "muscigenreid")
    private List<Artist> artistList;

    public MusicGenre() {
    }

    public MusicGenre(Integer musicGenreId) {
        this.musicGenreId = musicGenreId;
    }

    public MusicGenre(Integer musicGenreId, String name) {
        this.musicGenreId = musicGenreId;
        this.name = name;
    }

    public Integer getMusicGenreId() {
        return musicGenreId;
    }

    public void setMusicGenreId(Integer musicGenreId) {
        Integer oldMusicGenreId = this.musicGenreId;
        this.musicGenreId = musicGenreId;
        changeSupport.firePropertyChange("musicgenreid", oldMusicGenreId, musicGenreId);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }

    public List<Artist> getArtistList() {
        return artistList;
    }

    public void setArtistList(List<Artist> artistList) {
        this.artistList = artistList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (musicGenreId != null ? musicGenreId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MusicGenre)) {
            return false;
        }
        MusicGenre other = (MusicGenre) object;
        if ((this.musicGenreId == null && other.musicGenreId != null) || (this.musicGenreId != null && !this.musicGenreId.equals(other.musicGenreId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name;
        //return "eap.pli24.rastaman.entities.MusicGenre[ musicGenreId=" + musicGenreId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
}
