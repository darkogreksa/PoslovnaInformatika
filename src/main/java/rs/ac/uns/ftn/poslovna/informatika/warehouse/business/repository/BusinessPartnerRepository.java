package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.BusinessPartner;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
public interface BusinessPartnerRepository extends JpaRepository<BusinessPartner, Integer> {
    List<BusinessPartner> findAllByNameContaining(String name);
    List<BusinessPartner> findAllByOrderByNameDesc();
    List<BusinessPartner> findAllByOrderByNameAsc();
}
