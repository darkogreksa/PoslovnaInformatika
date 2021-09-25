package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "groupOfProducts")
public class GroupOfProducts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "groupOfProducts_id", nullable = false, unique = true)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "company_id", nullable = false)
    @JsonBackReference(value="GroupOfProducts-Company")
    private Company company;

    public GroupOfProducts() {
    }

    public GroupOfProducts(int id, String name, Company company) {
        this.id = id;
        this.name = name;
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

//    @Override
//    public String toString() {
//        return "GroupOfProducts{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", company=" + company +
//                '}';
//    }
}
