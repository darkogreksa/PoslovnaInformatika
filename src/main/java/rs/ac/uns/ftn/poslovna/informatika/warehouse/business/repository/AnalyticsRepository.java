package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.ProductCard;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.WarehouseCardAnalytics;

import java.util.List;

public interface AnalyticsRepository extends JpaRepository<WarehouseCardAnalytics, Integer> {
    List<WarehouseCardAnalytics> findAllByProductCard(ProductCard productCard);
    Page<WarehouseCardAnalytics> findAllByProductCard(ProductCard productCard, Pageable pageable);
    List<WarehouseCardAnalytics> findAllByProductCard_Id(Integer id);
    Page<WarehouseCardAnalytics> findAllByProductCard_Id(Integer id, Pageable pageable);
}
