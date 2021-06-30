package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.Location;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.repository.LocationRepository;

import java.util.List;

@Service
public class LocationService {

    @Autowired
    LocationRepository locationRepository;

    public Long count() {
        return locationRepository.count();
    }

    public Location findOne(Integer id) {
        return locationRepository.getOne(id);
    }

    public Location create(Location location) {
        return locationRepository.save(location);
    }

    public Location update(Location location) {
        return locationRepository.save(location);
    }

    public void remove(Location location) {
        locationRepository.delete(location);
    }

    public void removeById(Integer id) {
        locationRepository.deleteById(id);
    }

    public List<Location> findAll() {
        return locationRepository.findAll();
    }
}
