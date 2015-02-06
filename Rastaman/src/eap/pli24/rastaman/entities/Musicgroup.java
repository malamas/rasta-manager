/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eap.pli24.rastaman.entities;

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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author malamas
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
    @JoinTable(name = "ARTIST_MUSICGROUP", joinColumns = {
        @JoinColumn(name = "MUSICGROUPMUSICGROUPID", referencedColumnName = "MUSICGROUPID")}, inverseJoinColumns = {
        @JoinColumn(name = "ARTISTARTISTID", referencedColumnName = "ARTISTID")})
    @ManyToMany
    private List<Artist> artistList;
    @OneToMany(mappedBy = "musicgroupmusicgroupid")
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
        this.musicgroupid = musicgroupid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getFormationdate() {
        return formationdate;
    }

    public void setFormationdate(Date formationdate) {
        this.formationdate = formationdate;
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
        return "eap.pli24.rastaman.entities.Musicgroup[ musicgroupid=" + musicgroupid + " ]";
    }
    
}
