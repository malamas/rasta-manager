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
 * @author apostolis
 */
@Entity
@Table(name = "LABEL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Label.findAll", query = "SELECT l FROM Label l"),
    @NamedQuery(name = "Label.findByLabelid", query = "SELECT l FROM Label l WHERE l.labelid = :labelid"),
    @NamedQuery(name = "Label.findByName", query = "SELECT l FROM Label l WHERE l.name = :name"),
    @NamedQuery(name = "Label.findByAddress", query = "SELECT l FROM Label l WHERE l.address = :address"),
    @NamedQuery(name = "Label.findByTelephone", query = "SELECT l FROM Label l WHERE l.telephone = :telephone")})
public class Label implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "LABELID")
    private Long labelid;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "TELEPHONE")
    private String telephone;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "labelid")
    private List<Album> albumList;

    public Label() {
    }

    public Label(Long labelid) {
        this.labelid = labelid;
    }

    public Label(Long labelid, String name) {
        this.labelid = labelid;
        this.name = name;
    }

    public Long getLabelid() {
        return labelid;
    }

    public void setLabelid(Long labelid) {
        this.labelid = labelid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        hash += (labelid != null ? labelid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Label)) {
            return false;
        }
        Label other = (Label) object;
        if ((this.labelid == null && other.labelid != null) || (this.labelid != null && !this.labelid.equals(other.labelid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "eap.pli24.rastaman.entities.Label[ labelid=" + labelid + " ]";
    }
    
}
