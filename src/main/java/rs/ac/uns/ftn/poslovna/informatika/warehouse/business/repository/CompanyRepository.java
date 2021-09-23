package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.Company;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
    List<Company> findAllByOrderByNameDesc();
    List<Company> findAllByOrderByNameAsc();
    List<Company> findAllByNameContaining(String name);
}
