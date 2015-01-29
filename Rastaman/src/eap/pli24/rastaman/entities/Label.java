/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eap.pli24.rastaman.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "LABEL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Label.findAll", query = "SELECT l FROM Label l"),
    @NamedQuery(name = "Label.findById", query = "SELECT l FROM Label l WHERE l.id = :id"),
    @NamedQuery(name = "Label.findByLabelName", query = "SELECT l FROM Label l WHERE l.labelName = :labelName"),
    @NamedQuery(name = "Label.findByAddress", query = "SELECT l FROM Label l WHERE l.address = :address"),
    @NamedQuery(name = "Label.findByTelephone", query = "SELECT l FROM Label l WHERE l.telephone = :telephone")})
public class Label implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "LABEL_NAME")
    private String labelName;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "TELEPHONE")
    private String telephone;
    @OneToMany(mappedBy = "labelId")
    private List<Album> albumList;

    public Label() {
    }

    public Label(Integer id) {
        this.id = id;
    }

    public Label(Integer id, String labelName) {
        this.id = id;
        this.labelName = labelName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
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
        if (!(object instanceof Label)) {
            return false;
        }
        Label other = (Label) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "eap.pli24.rastaman.entities.Label[ id=" + id + " ]";
    }
    
}
