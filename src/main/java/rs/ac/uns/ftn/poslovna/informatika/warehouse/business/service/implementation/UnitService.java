package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.Unit;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.repository.UnitRepository;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.service.UnitServiceInterface;

import java.util.List;

@Service
public class UnitService implements UnitServiceInterface {

    @Autowired
    UnitRepository unitRepository;

    @Override
    public List<Unit> findAll() {
        return unitRepository.findAll();
    }

    @Override
    public Unit findOne(Integer id) {
        return unitRepository.findById(id).orElse(null);
    }

    @Override
    public Unit save(Unit unit) {
        return unitRepository.save(unit);
    }

    @Override
    public void remove(Integer id) {
        unitRepository.deleteById(id);
    }

    public Page<Unit> findAllPaged(Integer page, Integer size) {
        PageRequest pr = PageRequest.of(page, size);
        Page<Unit> units = unitRepository.findAll(pr);
        return units;
    }
}
