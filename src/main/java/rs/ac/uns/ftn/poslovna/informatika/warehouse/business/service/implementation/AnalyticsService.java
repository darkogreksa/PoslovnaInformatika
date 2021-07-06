package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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


}
