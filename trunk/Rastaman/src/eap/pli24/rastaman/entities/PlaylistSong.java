/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eap.pli24.rastaman.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author malamas
 */
@Entity
@Table(name = "PLAYLIST_SONG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlaylistSong.findAll", query = "SELECT p FROM PlaylistSong p"),
    @NamedQuery(name = "PlaylistSong.findByPlaylistplaylistid", query = "SELECT p FROM PlaylistSong p WHERE p.playlistSongPK.playlistplaylistid = :playlistplaylistid"),
    @NamedQuery(name = "PlaylistSong.findByPlayorder", query = "SELECT p FROM PlaylistSong p WHERE p.playorder = :playorder"),
    @NamedQuery(name = "PlaylistSong.findBySongsongid", query = "SELECT p FROM PlaylistSong p WHERE p.playlistSongPK.songsongid = :songsongid")})
public class PlaylistSong implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PlaylistSongPK playlistSongPK;
    @Basic(optional = false)
    @Column(name = "PLAYORDER")
    private int playorder;
    @JoinColumn(name = "PLAYLISTPLAYLISTID", referencedColumnName = "PLAYLISTID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Playlist playlist;
    @JoinColumn(name = "SONGSONGID", referencedColumnName = "SONGID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Song song;

    public PlaylistSong() {
    }

    public PlaylistSong(PlaylistSongPK playlistSongPK) {
        this.playlistSongPK = playlistSongPK;
    }

    public PlaylistSong(PlaylistSongPK playlistSongPK, int playorder) {
        this.playlistSongPK = playlistSongPK;
        this.playorder = playorder;
    }

    public PlaylistSong(long playlistplaylistid, long songsongid) {
        this.playlistSongPK = new PlaylistSongPK(playlistplaylistid, songsongid);
    }

    public PlaylistSongPK getPlaylistSongPK() {
        return playlistSongPK;
    }

    public void setPlaylistSongPK(PlaylistSongPK playlistSongPK) {
        this.playlistSongPK = playlistSongPK;
    }

    public int getPlayorder() {
        return playorder;
    }

    public void setPlayorder(int playorder) {
        this.playorder = playorder;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (playlistSongPK != null ? playlistSongPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlaylistSong)) {
            return false;
        }
        PlaylistSong other = (PlaylistSong) object;
        if ((this.playlistSongPK == null && other.playlistSongPK != null) || (this.playlistSongPK != null && !this.playlistSongPK.equals(other.playlistSongPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "eap.pli24.rastaman.entities.PlaylistSong[ playlistSongPK=" + playlistSongPK + " ]";
    }
    
}
