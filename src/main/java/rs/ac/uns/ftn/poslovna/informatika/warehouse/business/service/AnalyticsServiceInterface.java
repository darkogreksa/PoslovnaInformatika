package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.service;

import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.WarehouseCardAnalytics;

import java.util.List;

public interface AnalyticsServiceInterface {

    Long count();

    List<WarehouseCardAnalytics> findAll();

    WarehouseCardAnalytics findOne(Integer id);

    WarehouseCardAnalytics create(WarehouseCardAnalytics warehouseCardAnalytics);

    WarehouseCardAnalytics update(WarehouseCardAnalytics warehouseCardAnalytics);

    void delete(Integer id);
}
