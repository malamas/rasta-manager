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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
 *
 * @author Apostolis Iakovakis
 * @author Nikos Karagiannis
 * @author Nikos Krommydas
 * @author Malamas Malamidis
 */
@Entity
@Table(name = "ARTIST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Artist.findAll", query = "SELECT a FROM Artist a"),
    @NamedQuery(name = "Artist.findByArtistid", query = "SELECT a FROM Artist a WHERE a.artistid = :artistid"),
    @NamedQuery(name = "Artist.findByFirstname", query = "SELECT a FROM Artist a WHERE a.firstname = :firstname"),
    @NamedQuery(name = "Artist.findByLastname", query = "SELECT a FROM Artist a WHERE a.lastname = :lastname"),
    @NamedQuery(name = "Artist.findByArtisticname", query = "SELECT a FROM Artist a WHERE a.artisticname = :artisticname"),
    @NamedQuery(name = "Artist.findBySex", query = "SELECT a FROM Artist a WHERE a.sex = :sex"),
    @NamedQuery(name = "Artist.findByBirthday", query = "SELECT a FROM Artist a WHERE a.birthday = :birthday"),
    @NamedQuery(name = "Artist.findByBirthplace", query = "SELECT a FROM Artist a WHERE a.birthplace = :birthplace")})
public class Artist implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ARTISTID")
    private Long artistid;
    @Column(name = "LASTNAME")
    private String lastname;
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Column(name = "ARTISTICNAME")
    private String artisticname;
    @Basic(optional = false)
    @Column(name = "SEX")
    private String sex;
    @Column(name = "BIRTHDAY")
    @Temporal(TemporalType.DATE)
    private Date birthday;
    @Column(name = "BIRTHPLACE")
    private String birthplace;
    @ManyToMany(mappedBy = "artistList")
    private List<Musicgroup> musicgroupList;
    @JoinColumn(name = "MUSCIGENREID", referencedColumnName = "MUSICGENREID")
    @ManyToOne(optional = false)
    private Musicgenre muscigenreid;
    @OneToMany(mappedBy = "artistartistid")
    private List<Album> albumList;

    public Artist() {
    }

    public Artist(Long artistid) {
        this.artistid = artistid;
    }

    public Artist(Long artistid, String firstname, String lastname, String artisticname, String sex) {
        this.artistid = artistid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.artisticname = artisticname;
        this.sex = sex;
    }

    public Long getArtistid() {
        return artistid;
    }

    public void setArtistid(Long artistid) {
        Long oldArtistid = this.artistid;
        this.artistid = artistid;
        changeSupport.firePropertyChange("artistid", oldArtistid, artistid);
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        String oldFirstname = this.firstname;
        this.firstname = firstname;
        changeSupport.firePropertyChange("firstname", oldFirstname, firstname);
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        String oldLastname = this.lastname;
        this.lastname = lastname;
        changeSupport.firePropertyChange("lastname", oldLastname, lastname);
    }

    public String getArtisticname() {
        return artisticname;
    }

    public void setArtisticname(String artisticname) {
        String oldArtisticname = this.artisticname;
        this.artisticname = artisticname;
        changeSupport.firePropertyChange("artisticname", oldArtisticname, artisticname);
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        String oldSex = this.sex;
        this.sex = sex;
        changeSupport.firePropertyChange("sex", oldSex, sex);
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        Date oldBirthday = this.birthday;
        this.birthday = birthday;
        changeSupport.firePropertyChange("birthday", oldBirthday, birthday);
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        String oldBirthplace = this.birthplace;
        this.birthplace = birthplace;
        changeSupport.firePropertyChange("birthplace", oldBirthplace, birthplace);
    }

    @XmlTransient
    public List<Musicgroup> getMusicgroupList() {
        return musicgroupList;
    }

    public void setMusicgroupList(List<Musicgroup> musicgroupList) {
        this.musicgroupList = musicgroupList;
    }

    public Musicgenre getMuscigenreid() {
        return muscigenreid;
    }

    public void setMuscigenreid(Musicgenre muscigenreid) {
        Musicgenre oldMuscigenreid = this.muscigenreid;
        this.muscigenreid = muscigenreid;
        changeSupport.firePropertyChange("muscigenreid", oldMuscigenreid, muscigenreid);
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
        hash += (artistid != null ? artistid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Artist)) {
            return false;
        }
        Artist other = (Artist) object;
        if ((this.artistid == null && other.artistid != null) || (this.artistid != null && !this.artistid.equals(other.artistid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getScreenName();
        // return "eap.pli24.rastaman.entities.Artist[ artistid=" + artistid + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

    public String getScreenName() {
        if (artisticname == null && lastname == null) {
            return null;
        }
        return ((artisticname != null) && !artisticname.equals("") ) ? artisticname : (firstname + " " + lastname);
    }
}
