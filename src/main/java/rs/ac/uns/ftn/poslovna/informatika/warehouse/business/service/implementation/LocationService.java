package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.Location;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.repository.LocationRepository;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.service.LocationServiceInterface;

import java.util.List;

@Service
public class LocationService implements LocationServiceInterface {

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

    public List<Location> findAllPaged(Integer page, Integer size) {
        PageRequest pageReq = PageRequest.of(page, size);
        Page<Location> locationPage = locationRepository.findAll(pageReq);

        return locationPage.getContent();
    }

    public List<Location> findAllPagedAndSorted(Integer page, Integer size, String sortDirection, String sort) {
        PageRequest pageReq = PageRequest.of(page, size, Sort.Direction.fromString(sortDirection), sort);
        Page<Location> locationPage = locationRepository.findAll(pageReq);

        return locationPage.getContent();
    }

    public List<Location> findAllByName(String name) {
        return locationRepository.findAllByNameContaining(name);
    }

    public List<Location> findAllByNamePaged(String name, Integer page, Integer size) {
        PageRequest pageReq = PageRequest.of(page, size);
        Page<Location> locationPage = locationRepository.findByNameContains(name, pageReq);

        return locationPage.getContent();
    }

    public List<Location> findAllByNamePagedAndSorted(String name, Integer page, Integer size, String sortDirection, String sort) {
        PageRequest pageReq = PageRequest.of(page, size, Sort.Direction.fromString(sortDirection), sort);
        Page<Location> locationPage = locationRepository.findByNameContains(name, pageReq);

        return locationPage.getContent();
    }
}
