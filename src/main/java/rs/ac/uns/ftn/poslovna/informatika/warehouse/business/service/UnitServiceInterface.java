package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.service;

import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.Unit;

import java.util.List;

public interface UnitServiceInterface {

    Unit findOne(Integer id);

    List<Unit> findAll();

    Unit save(Unit unit);

    void remove(Integer id);
}
