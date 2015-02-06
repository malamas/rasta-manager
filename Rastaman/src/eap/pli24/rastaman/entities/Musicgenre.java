/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eap.pli24.rastaman.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author malamas
 */
@Entity
@Table(name = "MUSICGENRE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Musicgenre.findAll", query = "SELECT m FROM Musicgenre m"),
    @NamedQuery(name = "Musicgenre.findByMusicgenreid", query = "SELECT m FROM Musicgenre m WHERE m.musicgenreid = :musicgenreid"),
    @NamedQuery(name = "Musicgenre.findByName", query = "SELECT m FROM Musicgenre m WHERE m.name = :name")})
public class Musicgenre implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MUSICGENREID")
    private Integer musicgenreid;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "muscigenreid")
    private List<Artist> artistList;

    public Musicgenre() {
    }

    public Musicgenre(Integer musicgenreid) {
        this.musicgenreid = musicgenreid;
    }

    public Musicgenre(Integer musicgenreid, String name) {
        this.musicgenreid = musicgenreid;
        this.name = name;
    }

    public Integer getMusicgenreid() {
        return musicgenreid;
    }

    public void setMusicgenreid(Integer musicgenreid) {
        this.musicgenreid = musicgenreid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<Artist> getArtistList() {
        return artistList;
    }

    public void setArtistList(List<Artist> artistList) {
        this.artistList = artistList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (musicgenreid != null ? musicgenreid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Musicgenre)) {
            return false;
        }
        Musicgenre other = (Musicgenre) object;
        if ((this.musicgenreid == null && other.musicgenreid != null) || (this.musicgenreid != null && !this.musicgenreid.equals(other.musicgenreid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "eap.pli24.rastaman.entities.Musicgenre[ musicgenreid=" + musicgenreid + " ]";
    }
    
}
