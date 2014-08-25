

package invsystem.entities;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author saul
 */
@Entity
@Table(name = "report")
@XmlRootElement

public class ReportEntityClass implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idproduct")
    private int idproduct;
    @Column(name = "prodname")
    private String prodname;
    @Column(name = "onstock")
    private Integer onstock;
    @Column(name = "sold")
    private Integer sold;
    @Column(name = "totalqty")
    private Integer totalqty;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    public ReportEntityClass() {
    }

    public int getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(int idproduct) {
        this.idproduct = idproduct;
    }

    public String getProdname() {
        return prodname;
    }

    public void setProdname(String prodname) {
        this.prodname = prodname;
    }

    public Integer getOnstock() {
        return onstock;
    }

    public void setOnstock(Integer onstock) {
        this.onstock = onstock;
    }

    public Integer getSold() {
        return sold;
    }

    public void setSold(Integer sold) {
        this.sold = sold;
    }

    public Integer getTotalqty() {
        return totalqty;
    }

    public void setTotalqty(Integer totalqty) {
        this.totalqty = totalqty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
