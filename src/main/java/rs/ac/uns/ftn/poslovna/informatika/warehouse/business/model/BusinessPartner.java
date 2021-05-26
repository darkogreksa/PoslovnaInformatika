package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "businessPartner")
public class BusinessPartner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "name", unique = false, nullable = false, columnDefinition = "VARCHAR(50)", length = 50)
    private String name;

    @Column(name = "pib", unique = true, nullable = false, columnDefinition = "VARCHAR(12)", length = 12)
    private String PIB;

    @Column(name = "address", unique = false, nullable = false, columnDefinition = "VARCHAR(50)", length = 50)
    private String address;

    @ManyToOne()
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;

    @ManyToOne()
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "businessPartner")
    private Set<TrafficDocument> documents = new HashSet<TrafficDocument>();

    public BusinessPartner() {
    }

    public BusinessPartner(Integer id, String name, String PIB, String address, Company company, Location location, Set<TrafficDocument> documents) {
        this.id = id;
        this.name = name;
        this.PIB = PIB;
        this.address = address;
        this.company = company;
        this.location = location;
        this.documents = documents;
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

    public String getPIB() {
        return PIB;
    }

    public void setPIB(String PIB) {
        this.PIB = PIB;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Set<TrafficDocument> getDocuments() {
        return documents;
    }

    public void setDocuments(Set<TrafficDocument> documents) {
        this.documents = documents;
    }

    @Override
    public String toString() {
        return "BusinessPartner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", PIB='" + PIB + '\'' +
                ", address='" + address + '\'' +
                ", company=" + company +
                ", location=" + location +
                ", documents=" + documents +
                '}';
    }
}
