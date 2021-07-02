package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.dto;

import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.BusinessYear;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.Company;

import java.io.Serializable;

public class BusinessYearDTO implements Serializable {

    private Integer id;
    private String year;
    private boolean closed;
    private Company company;

    public BusinessYearDTO(Integer id, String year, boolean closed, Company company) {
        this.id = id;
        this.year = year;
        this.closed = closed;
        this.company = company;
    }

    public BusinessYearDTO(BusinessYear businessYear){
        this(businessYear.getId(), businessYear.getYear(), businessYear.isClosed(), businessYear.getCompany());
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
}
