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
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Η κλάση {@code Musicgroup} παριστάνει ένα μουσικό συγκρότημα. Είναι κλάση
 * οντότητας JPA.
 *
 * @author Apostolis Iakovakis
 * @author Malamas Malamidis
 */
@Entity
@Table(name = "MUSICGROUP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Musicgroup.findAll", query = "SELECT m FROM Musicgroup m"),
    @NamedQuery(name = "Musicgroup.findByMusicgroupid", query = "SELECT m FROM Musicgroup m WHERE m.musicgroupid = :musicgroupid"),
    @NamedQuery(name = "Musicgroup.findByName", query = "SELECT m FROM Musicgroup m WHERE m.name = :name"),
    @NamedQuery(name = "Musicgroup.findByFormationdate", query = "SELECT m FROM Musicgroup m WHERE m.formationdate = :formationdate")})
public class Musicgroup implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MUSICGROUPID")
    private Long musicgroupid;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Column(name = "FORMATIONDATE")
    @Temporal(TemporalType.DATE)
    private Date formationdate;
    @JoinTable(name = "ARTIST_GROUP", joinColumns = {
        @JoinColumn(name = "GROUP_ID", referencedColumnName = "MUSICGROUPID")}, inverseJoinColumns = {
        @JoinColumn(name = "ARTIST_ID", referencedColumnName = "ARTISTID")})
    @ManyToMany
    private List<Artist> artistList;
    @OneToMany(mappedBy = "group")
    private List<Album> albumList;

    public Musicgroup() {
    }

    public Musicgroup(Long musicgroupid) {
        this.musicgroupid = musicgroupid;
    }

    public Musicgroup(Long musicgroupid, String name) {
        this.musicgroupid = musicgroupid;
        this.name = name;
    }

    public Long getMusicgroupid() {
        return musicgroupid;
    }

    public void setMusicgroupid(Long musicgroupid) {
        Long oldMusicgroupid = this.musicgroupid;
        this.musicgroupid = musicgroupid;
        changeSupport.firePropertyChange("musicgroupid", oldMusicgroupid, musicgroupid);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }

    public Date getFormationdate() {
        return formationdate;
    }

    public void setFormationdate(Date formationdate) {
        Date oldFormationdate = this.formationdate;
        this.formationdate = formationdate;
        changeSupport.firePropertyChange("formationdate", oldFormationdate, formationdate);
    }

    @XmlTransient
    public List<Artist> getArtistList() {
        return artistList;
    }

    public void setArtistList(List<Artist> artistList) {
        this.artistList = artistList;
    }

    @XmlTransient
    public List<Album> getAlbumList() {
        return albumList;
    }

    public void setAlbumList(List<Album> albumList) {
        this.albumList = albumList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (musicgroupid != null ? musicgroupid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Musicgroup)) {
            return false;
        }
        Musicgroup other = (Musicgroup) object;
        if ((this.musicgroupid == null && other.musicgroupid != null) || (this.musicgroupid != null && !this.musicgroupid.equals(other.musicgroupid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name;
        //return "eap.pli24.rastaman.entities.Musicgroup[ musicgroupid=" + musicgroupid + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
}
