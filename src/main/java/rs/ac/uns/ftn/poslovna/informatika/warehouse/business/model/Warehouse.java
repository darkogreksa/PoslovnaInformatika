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
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "name", columnDefinition = "VARCHAR(50)", length = 50, nullable = false)
    private String name;

    //radnici u magacinu
    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "company_id")
    private Company company;

    @OneToMany(mappedBy = "warehouse")
//	@JoinColumn(name = "merchandiseCard_id", referencedColumnName = "id")
    private List<MerchandiseCard> merchandiseCards = new ArrayList<>();

    @OneToMany(mappedBy = "warehouse")
//	@JoinColumn(name = "trafficDocument_id", referencedColumnName = "id")
    private List<TrafficDocument> trafficDocuments = new ArrayList<>();

    public Warehouse() {
    }

    public Warehouse(Integer id, String name, Employee employee, Company company, List<MerchandiseCard> merchandiseCards, List<TrafficDocument> trafficDocuments) {
        this.id = id;
        this.name = name;
        this.employee = employee;
        this.company = company;
        this.merchandiseCards = merchandiseCards;
        this.trafficDocuments = trafficDocuments;
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

    public List<MerchandiseCard> getMerchandiseCards() {
        return merchandiseCards;
    }

    public void setMerchandiseCards(List<MerchandiseCard> merchandiseCards) {
        this.merchandiseCards = merchandiseCards;
    }

    public List<TrafficDocument> getTrafficDocuments() {
        return trafficDocuments;
    }

    public void setTrafficDocuments(List<TrafficDocument> trafficDocuments) {
        this.trafficDocuments = trafficDocuments;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employee=" + employee +
                ", company=" + company +
                ", merchandiseCards=" + merchandiseCards +
                ", trafficDocuments=" + trafficDocuments +
                '}';
    }
}
