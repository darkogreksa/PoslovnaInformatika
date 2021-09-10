package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.dto;

import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.Company;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.Employee;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.Warehouse;

import java.io.Serializable;

public class WarehouseDTO implements Serializable {

    private Integer id;
    private String name;
    private EmployeeDTO employee;
    private CompanyDTO company;

    public WarehouseDTO(Integer id, String name, CompanyDTO company) {
        this.id = id;
        this.name = name;
//        this.employee = employee;
        this.company = company;
    }

//    public WarehouseDTO(Warehouse warehouse) {
//        this(warehouse.getId(), warehouse.getName(), new EmployeeDTO(warehouse.getEmployee()), new CompanyDTO(warehouse.getCompany()));
//    }

    public WarehouseDTO(Warehouse warehouse) {
        this(warehouse.getId(), warehouse.getName(), new CompanyDTO(warehouse.getCompany()));
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

    public EmployeeDTO getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDTO employee) {
        this.employee = employee;
    }

    public CompanyDTO getCompany() {
        return company;
    }

    public void setCompany(CompanyDTO company) {
        this.company = company;
    }
}
