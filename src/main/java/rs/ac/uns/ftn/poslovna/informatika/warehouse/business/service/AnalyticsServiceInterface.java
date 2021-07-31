package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.service;

import org.springframework.data.domain.Page;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.ProductCard;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.WarehouseCardAnalytics;

import java.util.List;

public interface AnalyticsServiceInterface {

    Long count();

    List<WarehouseCardAnalytics> findAll();

    WarehouseCardAnalytics findOne(Integer id);

    WarehouseCardAnalytics create(WarehouseCardAnalytics warehouseCardAnalytics);

    WarehouseCardAnalytics update(WarehouseCardAnalytics warehouseCardAnalytics);

    void delete(Integer id);

    Page<WarehouseCardAnalytics> findAllPaged(Integer page, Integer size);

    List<WarehouseCardAnalytics> findAllPagedAndSorted(Integer page, Integer size, String sortDirection, String sort);

    List<WarehouseCardAnalytics> findAllForProductCardByProductCardId(Integer productCardId);

    Page<WarehouseCardAnalytics> findAllForProductCardByProductCardIdPaged(Integer productCardId, Integer page, Integer size);

    List<WarehouseCardAnalytics> findAllForProductCardByProductCardIdPagedAndSorted(Integer productCardId, Integer page, Integer size, String sortDirection, String sort);

    List<WarehouseCardAnalytics> findAllForRobnaKartica(ProductCard productCard);
}
