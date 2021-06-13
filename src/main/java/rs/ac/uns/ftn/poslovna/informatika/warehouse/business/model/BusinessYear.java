package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "businessYear")
public class BusinessYear implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "businessYear_id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "year", columnDefinition = "VARCHAR(4)", length = 4, nullable = false)
    private String year;

    @Column(name = "closed", unique = false, nullable = false)
    private boolean closed;

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "company_id")
    private Company company;

    //veza sa robnom karticom
    @OneToMany(mappedBy = "businessYear")
    private List<ProductCard> productCards = new ArrayList<>();

    //veza sa prometnim dokumentom
    @OneToMany(mappedBy = "businessYear")
    private List<Invoice> invoices = new ArrayList<>();

    public BusinessYear() {
    }

    public BusinessYear(Integer id, String year, boolean closed, Company company, List<ProductCard> productCards, List<Invoice> invoices) {
        this.id = id;
        this.year = year;
        this.closed = closed;
        this.company = company;
        this.productCards = productCards;
        this.invoices = invoices;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<ProductCard> getProductCards() {
        return productCards;
    }

    public void setProductCards(List<ProductCard> productCards) {
        this.productCards = productCards;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    @Override
    public String toString() {
        return "BusinessYear{" +
                "id=" + id +
                ", year='" + year + '\'' +
                ", closed=" + closed +
                ", company=" + company +
                ", productCards=" + productCards +
                ", invoices=" + invoices +
                '}';
    }
}
