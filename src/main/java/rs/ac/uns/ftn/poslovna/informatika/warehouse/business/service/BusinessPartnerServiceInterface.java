package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.service;

import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.BusinessPartner;

import java.util.List;

public interface BusinessPartnerServiceInterface {

    BusinessPartner findOne(Integer id);

    List<BusinessPartner> findAll();

    BusinessPartner save(BusinessPartner businessPartner);

    void delete(Integer id);

    List<BusinessPartner> orderByName();

    List<BusinessPartner> findByName(String name);
}
