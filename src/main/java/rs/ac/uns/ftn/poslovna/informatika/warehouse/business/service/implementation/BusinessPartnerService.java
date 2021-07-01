package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.BusinessPartner;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.repository.BusinessPartnerRepository;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.service.BusinessPartnerServiceInterface;

import java.util.List;

@Service
public class BusinessPartnerService implements BusinessPartnerServiceInterface {

    @Autowired
    BusinessPartnerRepository businessPartnerRepository;

    @Override
    public BusinessPartner findOne(Integer id) {
        return businessPartnerRepository.findById(id).get();
    }

    @Override
    public List<BusinessPartner> findAll() {
        return businessPartnerRepository.findAll();
    }

    @Override
    public BusinessPartner save(BusinessPartner businessPartner) {
        return businessPartnerRepository.save(businessPartner);
    }

    @Override
    public void delete(Integer id){
        businessPartnerRepository.deleteById(id);
    }

    @Override
    public List<BusinessPartner> orderByName() {
        return businessPartnerRepository.findAllByOrderByNameDesc();
    }

    @Override
    public List<BusinessPartner> findByName(String name) {
        return businessPartnerRepository.findAllByNameContaining(name);
    }
}
