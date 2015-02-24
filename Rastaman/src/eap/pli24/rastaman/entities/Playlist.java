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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "playlist")
    @OrderBy("playorder ASC")
    private List<PlaylistSong> playlistSongList;
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
    @ManyToMany(mappedBy = "playlistList")
    private List<Song> songList;

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
    public List<Song> getSongList() {
        return songList;
    }

    public void setSongList(List<Song> songList) {
        this.songList = songList;
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

    @XmlTransient
    public List<PlaylistSong> getPlaylistSongList() {
        return playlistSongList;
    }

    public void setPlaylistSongList(List<PlaylistSong> playlistSongList) {
        this.playlistSongList = playlistSongList;
    }
    
}
