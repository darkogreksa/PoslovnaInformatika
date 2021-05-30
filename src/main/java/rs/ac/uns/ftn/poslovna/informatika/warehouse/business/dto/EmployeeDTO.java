package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.dto;

import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.Employee;

import java.io.Serializable;

public class EmployeeDTO implements Serializable {

    private int id;
    private String fullName;
    private String username;
    private String password;
    private CompanyDTO companyDTO;

    public EmployeeDTO(int id, String fullName, String username, String password, CompanyDTO companyDTO) {
        this.id = id;
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.companyDTO = companyDTO;
    }

    public EmployeeDTO(Employee employee) {
        this(employee.getId(), employee.getFullName(), employee.getUsername(), employee.getPassword(), new CompanyDTO(employee.getCompany()));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public CompanyDTO getCompanyDTO() {
        return companyDTO;
    }

    public void setCompanyDTO(CompanyDTO companyDTO) {
        this.companyDTO = companyDTO;
    }
}
