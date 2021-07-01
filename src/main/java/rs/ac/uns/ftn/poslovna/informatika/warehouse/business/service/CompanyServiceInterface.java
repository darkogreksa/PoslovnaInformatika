package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.service;

import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.Company;

import java.util.List;

public interface CompanyServiceInterface {

    Company findOne(Integer id);

    List<Company> findAll();

    Company save(Company company);

    void delete(Integer id);

    List<Company> orderByName();
}
