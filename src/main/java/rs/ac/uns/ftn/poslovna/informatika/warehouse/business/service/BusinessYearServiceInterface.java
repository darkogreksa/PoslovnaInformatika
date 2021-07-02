package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.service;

import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.BusinessYear;

import java.util.List;

public interface BusinessYearServiceInterface {

    BusinessYear findOne(Integer id);

    List<BusinessYear> findAll();

    BusinessYear save(BusinessYear businessYear);

    void remove(Integer id);
}
