/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eap.pli24.rastaman.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author malamas
 */
@Embeddable
public class PlaylistSongPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "PLAYLISTPLAYLISTID")
    private long playlistplaylistid;
    @Basic(optional = false)
    @Column(name = "SONGSONGID")
    private long songsongid;

    public PlaylistSongPK() {
    }

    public PlaylistSongPK(long playlistplaylistid, long songsongid) {
        this.playlistplaylistid = playlistplaylistid;
        this.songsongid = songsongid;
    }

    public long getPlaylistplaylistid() {
        return playlistplaylistid;
    }

    public void setPlaylistplaylistid(long playlistplaylistid) {
        this.playlistplaylistid = playlistplaylistid;
    }

    public long getSongsongid() {
        return songsongid;
    }

    public void setSongsongid(long songsongid) {
        this.songsongid = songsongid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) playlistplaylistid;
        hash += (int) songsongid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlaylistSongPK)) {
            return false;
        }
        PlaylistSongPK other = (PlaylistSongPK) object;
        if (this.playlistplaylistid != other.playlistplaylistid) {
            return false;
        }
        if (this.songsongid != other.songsongid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "eap.pli24.rastaman.entities.PlaylistSongPK[ playlistplaylistid=" + playlistplaylistid + ", songsongid=" + songsongid + " ]";
    }
    
}
