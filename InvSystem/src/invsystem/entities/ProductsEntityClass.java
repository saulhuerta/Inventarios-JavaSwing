

package invsystem.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author saul
 */
@Entity
@TableGenerator(
    name="ProductsIDGenerator", 
    table="SEQUENCE", 
    pkColumnName="SEQ_NAME", 
    valueColumnName="SEQ_COUNT", 
    pkColumnValue="P_GEN_TABLE", 
    allocationSize=1)  
@Table(name = "products")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductsEntityClass.findAll", query = "SELECT p FROM ProductsEntityClass p"),
    @NamedQuery(name = "ProductsEntityClass.findByIdProduct", query = "SELECT p FROM ProductsEntityClass p WHERE p.idProduct = :idProduct"),
    @NamedQuery(name = "ProductsEntityClass.findByName", query = "SELECT p FROM ProductsEntityClass p WHERE p.name = :name"),
    @NamedQuery(name = "ProductsEntityClass.findByTotalQty", query = "SELECT p FROM ProductsEntityClass p WHERE p.totalQty = :totalQty"),
    @NamedQuery(name = "ProductsEntityClass.findByRemainingQty", query = "SELECT p FROM ProductsEntityClass p WHERE p.remainingQty = :remainingQty")})
public class ProductsEntityClass implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue( strategy = javax.persistence.GenerationType.TABLE, generator="ProductsIDGenerator" )
    @Column(name = "id_product")
    private Integer idProduct;
    @Column(name = "name")
    private String name;
    @Column(name = "total_qty")
    private Integer totalQty;
    @Column(name = "remaining_qty")
    private Integer remainingQty;
    @JoinColumn(name = "id_warehouse", referencedColumnName = "id_warehouse")
    @ManyToOne
    private WarehouseEntityClass idWarehouse;

    public ProductsEntityClass() {
    }

    public ProductsEntityClass(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTotalQty() {
        return totalQty;
    }

    public void setTotalQty(Integer totalQty) {
        this.totalQty = totalQty;
    }

    public Integer getRemainingQty() {
        return remainingQty;
    }

    public void setRemainingQty(Integer remainingQty) {
        this.remainingQty = remainingQty;
    }

    public WarehouseEntityClass getIdWarehouse() {
        return idWarehouse;
    }

    public void setIdWarehouse(WarehouseEntityClass idWarehouse) {
        this.idWarehouse = idWarehouse;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProduct != null ? idProduct.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductsEntityClass)) {
            return false;
        }
        ProductsEntityClass other = (ProductsEntityClass) object;
        if ((this.idProduct == null && other.idProduct != null) || (this.idProduct != null && !this.idProduct.equals(other.idProduct))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "invsystem.entities.ProductsEntityClass[ idProduct=" + idProduct + " ]";
    }
    
}
