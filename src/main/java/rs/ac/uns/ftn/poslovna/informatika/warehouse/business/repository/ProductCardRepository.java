package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.ProductCard;

import java.util.List;

public interface ProductCardRepository extends JpaRepository<ProductCard, Integer> {
    List<ProductCard> findAllByOrderByBusinessYearDesc();
    List<ProductCard> findAllByOrderByBusinessYearAsc();
    Page<ProductCard> findAllPagedById(Integer id, Pageable pageable);

    List<ProductCard> findByWarehouse_Id(Integer id);
    List<ProductCard> findByBusinessYear_Id(Integer id);
}
