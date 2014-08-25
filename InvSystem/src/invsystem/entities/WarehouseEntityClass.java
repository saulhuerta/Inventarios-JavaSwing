
package invsystem.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author saul
 */
@Entity
@TableGenerator(
    name="WarehouseIDGenerator", 
    table="SEQUENCE", 
    pkColumnName="SEQ_NAME", 
    valueColumnName="SEQ_COUNT", 
    pkColumnValue="W_GEN_TABLE", 
    allocationSize=1)  
@Table(name = "warehouse")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WarehouseEntityClass.findAll", query = "SELECT w FROM WarehouseEntityClass w"),
    @NamedQuery(name = "WarehouseEntityClass.findByIdWarehouse", query = "SELECT w FROM WarehouseEntityClass w WHERE w.idWarehouse = :idWarehouse"),
    @NamedQuery(name = "WarehouseEntityClass.findByName", query = "SELECT w FROM WarehouseEntityClass w WHERE w.name = :name"),
    @NamedQuery(name = "WarehouseEntityClass.findByMinProduct", query = "SELECT w FROM WarehouseEntityClass w WHERE w.minProduct = :minProduct"),
    @NamedQuery(name = "WarehouseEntityClass.findByMaxProduct", query = "SELECT w FROM WarehouseEntityClass w WHERE w.maxProduct = :maxProduct")})
public class WarehouseEntityClass implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue( strategy = javax.persistence.GenerationType.TABLE, generator="WarehouseIDGenerator" )
    @Column(name = "id_warehouse")
    private Integer idWarehouse;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "min_product")
    private int minProduct;
    @Basic(optional = false)
    @Column(name = "max_product")
    private int maxProduct;
    @OneToMany(mappedBy = "idWarehouse")
    private Collection<ProductsEntityClass> productsEntityClassCollection;
    
    public WarehouseEntityClass() {
    }

    public WarehouseEntityClass(Integer idWarehouse) {
        this.idWarehouse = idWarehouse;
    }

    public WarehouseEntityClass(Integer idWarehouse, String name, int minProduct, int maxProduct) {
        this.idWarehouse = idWarehouse;
        this.name = name;
        this.minProduct = minProduct;
        this.maxProduct = maxProduct;
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

    public int getMinProduct() {
        return minProduct;
    }

    public void setMinProduct(int minProduct) {
        this.minProduct = minProduct;
    }

    public int getMaxProduct() {
        return maxProduct;
    }

    public void setMaxProduct(int maxProduct) {
        this.maxProduct = maxProduct;
    }

    @XmlTransient
    public Collection<ProductsEntityClass> getProductsEntityClassCollection() {
        return productsEntityClassCollection;
    }

    public void setProductsEntityClassCollection(Collection<ProductsEntityClass> productsEntityClassCollection) {
        this.productsEntityClassCollection = productsEntityClassCollection;
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
        if (!(object instanceof WarehouseEntityClass)) {
            return false;
        }
        WarehouseEntityClass other = (WarehouseEntityClass) object;
        if ((this.idWarehouse == null && other.idWarehouse != null) || (this.idWarehouse != null && !this.idWarehouse.equals(other.idWarehouse))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "invsystem.entities.WarehouseEntityClass[ idWarehouse=" + idWarehouse + " ]";
    }
    
    public String toCombo(){
        return this.idWarehouse + "-" + this.name;
    }
}
