package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.Company;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.repository.CompanyRepository;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.service.CompanyServiceInterface;

import java.util.List;

@Service
public class CompanyService implements CompanyServiceInterface {

    @Autowired
    CompanyRepository companyRepository;

    @Override
    public Company findOne(Integer id) {
        return companyRepository.findById(id).get();
    }

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public Company save(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public void delete(Integer id) {
        companyRepository.deleteById(id);
    }

    @Override
    public List<Company> orderByName() {
        return companyRepository.findAllByOrderByNameDesc();
    }

}
