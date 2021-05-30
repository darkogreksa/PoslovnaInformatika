package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.dto;

import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.BusinessYear;

import java.io.Serializable;

public class BusinessYearDTO implements Serializable {

    private Integer id;
    private String year;
    private boolean closed;
    private CompanyDTO companyDTO;

    public BusinessYearDTO(Integer id, String year, boolean closed, CompanyDTO companyDTO) {
        this.id = id;
        this.year = year;
        this.closed = closed;
        this.companyDTO = companyDTO;
    }

    public BusinessYearDTO(BusinessYear businessYear){
        this(businessYear.getId(), businessYear.getYear(), businessYear.isClosed(), new CompanyDTO(businessYear.getCompany()));
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

    public CompanyDTO getCompanyDTO() {
        return companyDTO;
    }

    public void setCompany(CompanyDTO companyDTO) {
        this.companyDTO = companyDTO;
    }
}
