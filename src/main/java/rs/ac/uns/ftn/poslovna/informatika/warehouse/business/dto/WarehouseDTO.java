package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.dto;

import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.Company;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.Employee;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.Warehouse;

public class WarehouseDTO {

    private Integer id;
    private String name;
    private Employee employee;
    private Company company;

    public WarehouseDTO(Integer id, String name, Employee employee, Company company) {
        this.id = id;
        this.name = name;
        this.employee = employee;
        this.company = company;
    }

    public WarehouseDTO(Warehouse warehouse) {
        this(warehouse.getId(), warehouse.getName(), warehouse.getEmployee(), warehouse.getCompany());
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
}
