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
    @NamedQuery(name = "Album.findById", query = "SELECT a FROM Album a WHERE a.id = :id"),
    @NamedQuery(name = "Album.findByAlbumTitle", query = "SELECT a FROM Album a WHERE a.albumTitle = :albumTitle"),
    @NamedQuery(name = "Album.findByReleaseDate", query = "SELECT a FROM Album a WHERE a.releaseDate = :releaseDate"),
    @NamedQuery(name = "Album.findByAlbumType", query = "SELECT a FROM Album a WHERE a.albumType = :albumType"),
    @NamedQuery(name = "Album.findByDiskNo", query = "SELECT a FROM Album a WHERE a.diskNo = :diskNo")})
public class Album implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "ALBUM_TITLE")
    private String albumTitle;
    @Column(name = "RELEASE_DATE")
    @Temporal(TemporalType.DATE)
    private Date releaseDate;
    @Column(name = "ALBUM_TYPE")
    private String albumType;
    @Column(name = "DISK_NO")
    private Integer diskNo;
    @OneToMany(mappedBy = "albumId")
    private List<Song> songList;
    @JoinColumn(name = "ARTIST_ID", referencedColumnName = "ID")
    @ManyToOne
    private Artist artistId;
    @JoinColumn(name = "LABEL_ID", referencedColumnName = "ID")
    @ManyToOne
    private Label labelId;
    @JoinColumn(name = "GROUP_ID", referencedColumnName = "ID")
    @ManyToOne
    private MusicGroup groupId;

    public Album() {
    }

    public Album(Integer id) {
        this.id = id;
    }

    public Album(Integer id, String albumTitle) {
        this.id = id;
        this.albumTitle = albumTitle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getAlbumType() {
        return albumType;
    }

    public void setAlbumType(String albumType) {
        this.albumType = albumType;
    }

    public Integer getDiskNo() {
        return diskNo;
    }

    public void setDiskNo(Integer diskNo) {
        this.diskNo = diskNo;
    }

    @XmlTransient
    public List<Song> getSongList() {
        return songList;
    }

    public void setSongList(List<Song> songList) {
        this.songList = songList;
    }

    public Artist getArtistId() {
        return artistId;
    }

    public void setArtistId(Artist artistId) {
        this.artistId = artistId;
    }

    public Label getLabelId() {
        return labelId;
    }

    public void setLabelId(Label labelId) {
        this.labelId = labelId;
    }

    public MusicGroup getGroupId() {
        return groupId;
    }

    public void setGroupId(MusicGroup groupId) {
        this.groupId = groupId;
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
        if (!(object instanceof Album)) {
            return false;
        }
        Album other = (Album) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "eap.pli24.rastaman.entities.Album[ id=" + id + " ]";
    }
    
}
