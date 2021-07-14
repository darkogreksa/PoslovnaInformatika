package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "warehouse")
public class Warehouse implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "warehouse_id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "name", columnDefinition = "VARCHAR(50)", length = 50, nullable = false)
    private String name;

    //radnici u magacinu
    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "company_id")
    private Company company;

    @OneToMany(mappedBy = "warehouse")
    private List<ProductCard> productCards = new ArrayList<>();

    @OneToMany(mappedBy = "warehouse")
    private List<Invoice> invoices = new ArrayList<>();

    public Warehouse() {
    }

    public Warehouse(Integer id, String name, Employee employee, Company company, List<ProductCard> productCards, List<Invoice> invoices) {
        this.id = id;
        this.name = name;
        this.employee = employee;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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

//    @Override
//    public String toString() {
//        return "Warehouse{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", employee=" + employee +
//                ", company=" + company +
//                ", productCards=" + productCards +
//                ", invoices=" + invoices +
//                '}';
//    }
}
