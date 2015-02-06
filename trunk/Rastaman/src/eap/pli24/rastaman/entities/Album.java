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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "ALBUM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Album.findAll", query = "SELECT a FROM Album a"),
    @NamedQuery(name = "Album.findByAlbumid", query = "SELECT a FROM Album a WHERE a.albumid = :albumid"),
    @NamedQuery(name = "Album.findByTitle", query = "SELECT a FROM Album a WHERE a.title = :title"),
    @NamedQuery(name = "Album.findByReleasedate", query = "SELECT a FROM Album a WHERE a.releasedate = :releasedate"),
    @NamedQuery(name = "Album.findByType", query = "SELECT a FROM Album a WHERE a.type = :type"),
    @NamedQuery(name = "Album.findByDisknumber", query = "SELECT a FROM Album a WHERE a.disknumber = :disknumber")})
public class Album implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ALBUMID")
    private Long albumid;
    @Basic(optional = false)
    @Column(name = "TITLE")
    private String title;
    @Column(name = "RELEASEDATE")
    @Temporal(TemporalType.DATE)
    private Date releasedate;
    @Basic(optional = false)
    @Column(name = "TYPE")
    private String type;
    @Basic(optional = false)
    @Column(name = "DISKNUMBER")
    private int disknumber;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "albumid")
    private List<Song> songList;
    @JoinColumn(name = "ARTISTARTISTID", referencedColumnName = "ARTISTID")
    @ManyToOne
    private Artist artistartistid;
    @JoinColumn(name = "LABELID", referencedColumnName = "LABELID")
    @ManyToOne(optional = false)
    private Label labelid;
    @JoinColumn(name = "MUSICGROUPMUSICGROUPID", referencedColumnName = "MUSICGROUPID")
    @ManyToOne
    private Musicgroup musicgroupmusicgroupid;

    public Album() {
    }

    public Album(Long albumid) {
        this.albumid = albumid;
    }

    public Album(Long albumid, String title, String type, int disknumber) {
        this.albumid = albumid;
        this.title = title;
        this.type = type;
        this.disknumber = disknumber;
    }

    public Long getAlbumid() {
        return albumid;
    }

    public void setAlbumid(Long albumid) {
        this.albumid = albumid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(Date releasedate) {
        this.releasedate = releasedate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDisknumber() {
        return disknumber;
    }

    public void setDisknumber(int disknumber) {
        this.disknumber = disknumber;
    }

    @XmlTransient
    public List<Song> getSongList() {
        return songList;
    }

    public void setSongList(List<Song> songList) {
        this.songList = songList;
    }

    public Artist getArtistartistid() {
        return artistartistid;
    }

    public void setArtistartistid(Artist artistartistid) {
        this.artistartistid = artistartistid;
    }

    public Label getLabelid() {
        return labelid;
    }

    public void setLabelid(Label labelid) {
        this.labelid = labelid;
    }

    public Musicgroup getMusicgroupmusicgroupid() {
        return musicgroupmusicgroupid;
    }

    public void setMusicgroupmusicgroupid(Musicgroup musicgroupmusicgroupid) {
        this.musicgroupmusicgroupid = musicgroupmusicgroupid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (albumid != null ? albumid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Album)) {
            return false;
        }
        Album other = (Album) object;
        if ((this.albumid == null && other.albumid != null) || (this.albumid != null && !this.albumid.equals(other.albumid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "eap.pli24.rastaman.entities.Album[ albumid=" + albumid + " ]";
    }
    
}
