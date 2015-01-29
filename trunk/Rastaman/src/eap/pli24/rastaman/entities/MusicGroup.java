/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 *
 * @author malamas
 */
@Entity
@Table(name = "MUSIC_GROUP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MusicGroup.findAll", query = "SELECT m FROM MusicGroup m"),
    @NamedQuery(name = "MusicGroup.findById", query = "SELECT m FROM MusicGroup m WHERE m.id = :id"),
    @NamedQuery(name = "MusicGroup.findByGroupName", query = "SELECT m FROM MusicGroup m WHERE m.groupName = :groupName"),
    @NamedQuery(name = "MusicGroup.findByFormationDate", query = "SELECT m FROM MusicGroup m WHERE m.formationDate = :formationDate")})
public class MusicGroup implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "GROUP_NAME")
    private String groupName;
    @Column(name = "FORMATION_DATE")
    @Temporal(TemporalType.DATE)
    private Date formationDate;
    @JoinTable(name = "GROUP_ARTIST", joinColumns = {
        @JoinColumn(name = "GROUP_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "ARTIST_ID", referencedColumnName = "ID")})
    @ManyToMany
    private List<Artist> artistList;
    @OneToMany(mappedBy = "groupId")
    private List<Album> albumList;

    public MusicGroup() {
    }

    public MusicGroup(Integer id) {
        this.id = id;
    }

    public MusicGroup(Integer id, String groupName) {
        this.id = id;
        this.groupName = groupName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        String oldGroupName = this.groupName;
        this.groupName = groupName;
        changeSupport.firePropertyChange("groupName", oldGroupName, groupName);
    }

    public Date getFormationDate() {
        return formationDate;
    }

    public void setFormationDate(Date formationDate) {
        Date oldFormationDate = this.formationDate;
        this.formationDate = formationDate;
        changeSupport.firePropertyChange("formationDate", oldFormationDate, formationDate);
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MusicGroup)) {
            return false;
        }
        MusicGroup other = (MusicGroup) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "eap.pli24.rastaman.entities.MusicGroup[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
