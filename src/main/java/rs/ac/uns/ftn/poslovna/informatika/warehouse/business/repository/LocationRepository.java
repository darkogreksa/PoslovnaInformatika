package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.Location;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Integer> {
    List<Location> findAllByNameContaining(String name);
    Page<Location> findByNameContains(String name, Pageable pageable);
}
