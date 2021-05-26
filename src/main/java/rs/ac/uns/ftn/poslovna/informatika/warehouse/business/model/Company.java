package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "name", unique = false, nullable = false,  columnDefinition = "VARCHAR(50)", length = 50)
    private String name;

    @Column(name = "pib", unique = true, nullable = false,  columnDefinition = "VARCHAR(12)", length = 12)
    private String PIB;

    @Column(name = "address", unique = false, nullable = false,  columnDefinition = "VARCHAR(50)", length = 50)
    private String address;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
    private Set<Warehouse> warehouses = new HashSet<Warehouse>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
    private Set<Employee> employees = new HashSet<Employee>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
    private Set<GroupOfMerchandise> groupOfMerchandises = new HashSet<GroupOfMerchandise>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
    private Set<BusinessPartner> businessPartners = new HashSet<BusinessPartner>();

    @ManyToOne
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location;

    public Company() {
    }

    public Company(Integer id, String name, String PIB, String address, Set<Warehouse> warehouses, Set<Employee> employees, Set<GroupOfMerchandise> groupOfMerchandises, Set<BusinessPartner> businessPartners, Location location) {
        this.id = id;
        this.name = name;
        this.PIB = PIB;
        this.address = address;
        this.warehouses = warehouses;
        this.employees = employees;
        this.groupOfMerchandises = groupOfMerchandises;
        this.businessPartners = businessPartners;
        this.location = location;
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

    public Set<Warehouse> getWarehouses() {
        return warehouses;
    }

    public void setWarehouses(Set<Warehouse> warehouses) {
        this.warehouses = warehouses;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Set<GroupOfMerchandise> getGroupOfMerchandises() {
        return groupOfMerchandises;
    }

    public void setGroupOfMerchandises(Set<GroupOfMerchandise> groupOfMerchandises) {
        this.groupOfMerchandises = groupOfMerchandises;
    }

    public Set<BusinessPartner> getBusinessPartners() {
        return businessPartners;
    }

    public void setBusinessPartners(Set<BusinessPartner> businessPartners) {
        this.businessPartners = businessPartners;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", PIB='" + PIB + '\'' +
                ", address='" + address + '\'' +
                ", warehouses=" + warehouses +
                ", employees=" + employees +
                ", groupOfMerchandises=" + groupOfMerchandises +
                ", businessPartners=" + businessPartners +
                ", location=" + location +
                '}';
    }
}
