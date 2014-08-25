/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package invsystem;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author saul
 */
@Entity
@Table(name = "warehouse", catalog = "cellfusion", schema = "")
@NamedQueries({
    @NamedQuery(name = "Warehouse.findAll", query = "SELECT w FROM Warehouse w"),
    @NamedQuery(name = "Warehouse.findByIdWarehouse", query = "SELECT w FROM Warehouse w WHERE w.idWarehouse = :idWarehouse"),
    @NamedQuery(name = "Warehouse.findByName", query = "SELECT w FROM Warehouse w WHERE w.name = :name"),
    @NamedQuery(name = "Warehouse.findByMinProduct", query = "SELECT w FROM Warehouse w WHERE w.minProduct = :minProduct"),
    @NamedQuery(name = "Warehouse.findByMaxProduct", query = "SELECT w FROM Warehouse w WHERE w.maxProduct = :maxProduct")})
public class Warehouse implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_warehouse")
    private Integer idWarehouse;
    @Column(name = "name")
    private String name;
    @Column(name = "min_product")
    private String minProduct;
    @Column(name = "max_product")
    private String maxProduct;

    public Warehouse() {
    }

    public Warehouse(Integer idWarehouse) {
        this.idWarehouse = idWarehouse;
    }

    public Integer getIdWarehouse() {
        return idWarehouse;
    }

    public void setIdWarehouse(Integer idWarehouse) {
        this.idWarehouse = idWarehouse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMinProduct() {
        return minProduct;
    }

    public void setMinProduct(String minProduct) {
        this.minProduct = minProduct;
    }

    public String getMaxProduct() {
        return maxProduct;
    }

    public void setMaxProduct(String maxProduct) {
        this.maxProduct = maxProduct;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idWarehouse != null ? idWarehouse.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Warehouse)) {
            return false;
        }
        Warehouse other = (Warehouse) object;
        if ((this.idWarehouse == null && other.idWarehouse != null) || (this.idWarehouse != null && !this.idWarehouse.equals(other.idWarehouse))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "invsystem.Warehouse[ idWarehouse=" + idWarehouse + " ]";
    }
    
}
