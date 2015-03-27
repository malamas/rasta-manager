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
import javax.persistence.Transient;

/**
 * Η κλάση {@code Album} παριστάνει ένα μουσικό άλμπουμ. Είναι κλάση οντότητας
 * JPA.
 *
 * @author Malamas Malamidis
 */
@Entity
@Table(name = "Album")
@NamedQueries({
    @NamedQuery(name = "Album.findAll", query = "SELECT a FROM Album a"),
    @NamedQuery(name = "Album.findAllArtistAlbums", query = "SELECT a FROM Album a WHERE a.artist IS NOT NULL"),
    @NamedQuery(name = "Album.findAllMusicgroupAlbums", query = "SELECT a FROM Album a WHERE a.musicGroup IS NOT NULL")})
public class Album implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @Basic(optional = false)
    @Column(name = "title")
    private String title;

    @Column(name = "release_date")
    @Temporal(TemporalType.DATE)
    private Date releaseDate;

    @Basic(optional = false)
    @Column(name = "type")
    private String type;

    @Basic(optional = false)
    @Column(name = "disk_no")
    private int diskNo;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "album")
    private List<Song> songList;

    @JoinColumn(name = "artist_id", referencedColumnName = "id")
    @ManyToOne
    private Artist artist;

    @JoinColumn(name = "label_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Label label;

    @JoinColumn(name = "music_group_id", referencedColumnName = "id")
    @ManyToOne
    private Musicgroup musicGroup;

    public Album() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        Long oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        String oldTitle = this.title;
        this.title = title;
        changeSupport.firePropertyChange("title", oldTitle, title);
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        Date oldReleaseDate = this.releaseDate;
        this.releaseDate = releaseDate;
        changeSupport.firePropertyChange("releaseDate", oldReleaseDate, releaseDate);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        String oldType = this.type;
        this.type = type;
        changeSupport.firePropertyChange("type", oldType, type);
    }

    public int getDiskNo() {
        return diskNo;
    }

    public void setDiskNo(int diskNo) {
        int oldDiskNo = this.diskNo;
        this.diskNo = diskNo;
        changeSupport.firePropertyChange("diskNo", oldDiskNo, diskNo);
    }

    public List<Song> getSongList() {
        return songList;
    }

    public void setSongList(List<Song> songList) {
        this.songList = songList;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        Artist oldArtist = this.artist;
        this.artist = artist;
        changeSupport.firePropertyChange("artist", oldArtist, artist);
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        Label oldLabel = this.label;
        this.label = label;
        changeSupport.firePropertyChange("label", oldLabel, label);
    }

    public Musicgroup getMusicGroup() {
        return musicGroup;
    }

    public void setMusicGroup(Musicgroup musicGroup) {
        Musicgroup oldMusicGroup = this.musicGroup;
        this.musicGroup = musicGroup;
        changeSupport.firePropertyChange("musicGroup", oldMusicGroup, musicGroup);
    }

    /**
     * Επιστρέφει όνομα δημιουργού (ερμηνευτή) γι' αυτό το {@code Album}, με
     * ενιαίο τρόπο, ανεξάρτητα αν αυτό ανήκει σε καλλιτέχνη ή σε συγκρότημα.
     *
     * @return το όνομα δημιουργού του άλμπουμ
     */
    public String getPerformerScreenName() {
        return (artist != null) ? artist.getScreenName() : musicGroup.getName();
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
        return "eu.malamas.rastaman.model.Album[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
}
