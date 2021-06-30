package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.service;

import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.Location;

import java.util.List;

public interface LocationServiceInterface {

    Long count();

    Location findOne(Integer id);

    Location create(Location location);

    Location update(Location location);

    void remove(Location location);

    void removeById(Integer id);

    List<Location> findAll();
}
