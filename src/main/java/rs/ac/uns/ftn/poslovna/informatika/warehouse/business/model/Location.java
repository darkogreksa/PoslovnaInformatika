package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model;

import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.dto.LocationDTO;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    private Integer id;

    @Column(name = "name", columnDefinition = "VARCHAR(50)", length = 50, unique = true, nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "location") // Mesto 1..1 -> 0..n Preduzece
    private Set<Company> companies = new HashSet<Company>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "location") // Mesto 0..1 -> 0..n Poslovni partner
    private Set<BusinessPartner> businessPartners = new HashSet<BusinessPartner>();

    public Location() {
    }

    public Location(Integer id, String name, Set<Company> companies, Set<BusinessPartner> businessPartners) {
        this.id = id;
        this.name = name;
        this.companies = companies;
        this.businessPartners = businessPartners;
    }

    public void setSimpleDataFromDTO(LocationDTO locationDTO) {
        this.setId(locationDTO.getId());
        this.setName(locationDTO.getName());
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

    public Set<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(Set<Company> companies) {
        this.companies = companies;
    }

    public Set<BusinessPartner> getBusinessPartners() {
        return businessPartners;
    }

    public void setBusinessPartners(Set<BusinessPartner> businessPartners) {
        this.businessPartners = businessPartners;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", companies=" + companies +
                ", businessPartners=" + businessPartners +
                '}';
    }
}
