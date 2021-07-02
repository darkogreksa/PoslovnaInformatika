package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.service;

import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.Warehouse;

import java.util.List;

public interface WarehouseServiceInterface {

    Warehouse findOne(Integer id);

    List<Warehouse> findAll();

    List<Warehouse> findByCompany_Id(Integer id);

    Warehouse save(Warehouse w);

    void remove(Integer id);
}
