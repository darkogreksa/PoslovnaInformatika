package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.BusinessYear;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.repository.BusinessYearRepository;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.service.BusinessYearServiceInterface;

import java.util.List;

@Service
public class BusinessYearService implements BusinessYearServiceInterface {

    @Autowired
    BusinessYearRepository businessYearRepository;

    @Override
    public BusinessYear findOne(Integer id) {
        return businessYearRepository.getOne(id);
    }

    @Override
    public List<BusinessYear> findAll() {
        return businessYearRepository.findAll();
    }

    @Override
    public BusinessYear save(BusinessYear businessYear) {
        return businessYearRepository.save(businessYear);
    }

    @Override
    public void remove(Integer id) {
        businessYearRepository.deleteById(id);
    }
}
