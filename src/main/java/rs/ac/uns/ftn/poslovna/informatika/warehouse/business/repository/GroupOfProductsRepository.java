package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.GroupOfProducts;

public interface GroupOfProductsRepository extends JpaRepository<GroupOfProducts, Integer> {
}
