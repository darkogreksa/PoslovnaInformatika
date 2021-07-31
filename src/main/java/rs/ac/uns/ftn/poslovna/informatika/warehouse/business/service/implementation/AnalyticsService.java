package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.ProductCard;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.WarehouseCardAnalytics;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.repository.AnalyticsRepository;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.service.AnalyticsServiceInterface;

import java.util.List;

@Service
public class AnalyticsService implements AnalyticsServiceInterface {

    @Autowired
    AnalyticsRepository analyticsRepository;

    public Long count() {
        return analyticsRepository.count();
    }

    public List<WarehouseCardAnalytics> findAll() {
        return analyticsRepository.findAll();
    }

    public WarehouseCardAnalytics findOne(Integer id) {
        return analyticsRepository.getOne(id);
    }

    public WarehouseCardAnalytics create(WarehouseCardAnalytics warehouseCardAnalytics) {
        return analyticsRepository.save(warehouseCardAnalytics);
    }

    public WarehouseCardAnalytics update(WarehouseCardAnalytics warehouseCardAnalytics) {
        return analyticsRepository.save(warehouseCardAnalytics);
    }

    public void delete(Integer id) {
        analyticsRepository.deleteById(id);
    }

    public Page<WarehouseCardAnalytics> findAllPaged(Integer page, Integer size) {
        PageRequest pageReq = PageRequest.of(page, size);
        Page<WarehouseCardAnalytics> warehouseCardAnalytics = analyticsRepository.findAll(pageReq);

        return warehouseCardAnalytics;
    }

    public List<WarehouseCardAnalytics> findAllPagedAndSorted(Integer page, Integer size, String sortDirection, String sort) {
        PageRequest pageReq = PageRequest.of(page, size, Sort.Direction.fromString(sortDirection), sort);
        Page<WarehouseCardAnalytics> warehouseCardAnalytics = analyticsRepository.findAll(pageReq);

        return warehouseCardAnalytics.getContent();
    }

    public List<WarehouseCardAnalytics> findAllForProductCardByProductCardId(Integer productCardId) {
        return analyticsRepository.findAllByProductCard_Id(productCardId);
    }

    public Page<WarehouseCardAnalytics> findAllForProductCardByProductCardIdPaged(Integer productCardId, Integer page, Integer size) {
        PageRequest pageReq = PageRequest.of(page, size);
        Page<WarehouseCardAnalytics> warehouseCardAnalytics = analyticsRepository.findAllByProductCard_Id(productCardId, pageReq);

        return warehouseCardAnalytics;
    }

    public List<WarehouseCardAnalytics> findAllForProductCardByProductCardIdPagedAndSorted(Integer productCardId, Integer page, Integer size, String sortDirection, String sort) {
        return null;
    }

    public List<WarehouseCardAnalytics> findAllForRobnaKartica(ProductCard productCard) {
        return analyticsRepository.findAllByProductCard(productCard);
    }

}
