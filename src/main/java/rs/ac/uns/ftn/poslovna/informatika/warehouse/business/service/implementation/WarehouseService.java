package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.Warehouse;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.repository.WarehouseRepository;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.service.WarehouseServiceInterface;

import java.util.List;

@Service
public class WarehouseService implements WarehouseServiceInterface {

    @Autowired
    WarehouseRepository warehouseRepository;

    @Override
    public Warehouse findOne(Integer id) {
        return warehouseRepository.getOne(id);
    }

    @Override
    public List<Warehouse> findAll() {
        return warehouseRepository.findAll();
    }

    @Override
    public Warehouse save(Warehouse w) {
        return warehouseRepository.save(w);
    }

    @Override
    public void remove(Integer id) {
        warehouseRepository.deleteById(id);
    }

    public void removeById(Integer id) {
        warehouseRepository.deleteById(id);
    }

    //	@Override
    public List<Warehouse> findByCompany_Id(Integer id) {
        return warehouseRepository.findByCompany_Id(id);
    }

    public List<Warehouse> findAllByName(String name) {
        return warehouseRepository.findAllByNameContaining(name);
    }
}
