package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.dto;

import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.Warehouse;

public class WarehouseDTO {

    private Integer id;
    private String name;
    private EmployeeDTO employeeDTO;
    private CompanyDTO companyDTO;

    public WarehouseDTO(Integer id, String name, EmployeeDTO employeeDTO, CompanyDTO companyDTO) {
        this.id = id;
        this.name = name;
        this.employeeDTO = employeeDTO;
        this.companyDTO = companyDTO;
    }

    public WarehouseDTO(Warehouse warehouse) {
        this(warehouse.getId(), warehouse.getName(), new EmployeeDTO(warehouse.getEmployee()), new CompanyDTO(warehouse.getCompany()));
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

    public EmployeeDTO getEmployeeDTO() {
        return employeeDTO;
    }

    public void setEmployeeDTO(EmployeeDTO employeeDTO) {
        this.employeeDTO = employeeDTO;
    }

    public CompanyDTO getCompanyDTO() {
        return companyDTO;
    }

    public void setCompanyDTO(CompanyDTO companyDTO) {
        this.companyDTO = companyDTO;
    }
}
