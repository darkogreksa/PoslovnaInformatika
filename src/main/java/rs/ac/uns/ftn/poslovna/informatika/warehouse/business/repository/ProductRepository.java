package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    public List<Product> findByNameContains(String name);
    public Page<Product> findByNameContains(String name, Pageable pageable);
}
