package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.dto.LocationDTO;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.Location;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.service.implementation.LocationService;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/api/location", produces = "application/json")
public class LocationController {

    @Autowired
    LocationService locationService;

    @GetMapping(value = "/count")
    public ResponseEntity<Long> getCount() {
        return new ResponseEntity<Long>(locationService.count(), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = {"", "/"})
    public ResponseEntity<List<LocationDTO>> getAll(){
        List<Location> locations = locationService.findAll();
        List<LocationDTO> locationDTOS = new ArrayList<LocationDTO>();

        for (Location l : locations) {
            locationDTOS.add(new LocationDTO(l));
        }

        return new ResponseEntity<List<LocationDTO>>(locationDTOS, HttpStatus.OK);
    }

    @PostMapping(value = "/create", consumes = "application/json")
    public ResponseEntity<LocationDTO> create(@RequestBody LocationDTO locationDTO) {
        Location location = new Location();
        location.setName(locationDTO.getName());

        location = locationService.save(location);

        return new ResponseEntity<LocationDTO>(new LocationDTO(), HttpStatus.CREATED);
    }

    @PutMapping(value = "/update/{id}", consumes = "application/json")
    public ResponseEntity<LocationDTO> update(@PathVariable("id") Integer id, @RequestBody LocationDTO locationDTO) {
        Location location = locationService.findOne(id);

        location.setName(locationDTO.getName());
        location = locationService.save(location);
        return new ResponseEntity<LocationDTO>(new LocationDTO(location), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        Location location = locationService.findOne(id);
        if (location == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        locationService.removeById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = {"", "/"}, params = {"page", "size"})
    public ResponseEntity<List<LocationDTO>> getAllPaged(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        List<Location> locations = locationService.findAllPaged(page, size);
        List<LocationDTO> locationDTOS = new ArrayList<LocationDTO>();

        for (Location location : locations) {
            locationDTOS.add(new LocationDTO(location));
        }

        return new ResponseEntity<List<LocationDTO>>(locationDTOS, HttpStatus.OK);
    }

    @GetMapping(value = {"", "/"}, params = {"page", "size", "sortDir", "sort"})
    public ResponseEntity<List<LocationDTO>> getAllPagedAndSorted(@RequestParam("page") Integer page, @RequestParam("size") Integer size, @RequestParam("sortDir") String sortDir, @RequestParam("sort") String sort) {
        List<Location> locations = locationService.findAllPagedAndSorted(page, size, sortDir, sort);
        List<LocationDTO> locationDTOS = new ArrayList<LocationDTO>();

        for (Location location : locations) {
            locationDTOS.add(new LocationDTO(location));
        }

        return new ResponseEntity<List<LocationDTO>>(locationDTOS, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/name/{name}")
    public ResponseEntity<List<LocationDTO>> getByName(@PathVariable("name") String name) {
        List<Location> locations = locationService.findAllByName(name);
        List<LocationDTO> locationDTOS = new ArrayList<LocationDTO>();
        for (Location location: locations) {
            locationDTOS.add(new LocationDTO(location));
        }
        if (locations == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<LocationDTO>>(locationDTOS, HttpStatus.OK);
    }

    @GetMapping(value = {"", "/"}, params = {"name", "page", "size"})
    public ResponseEntity<List<LocationDTO>> getByNamePaged(@RequestParam("name") String name, @RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        List<Location> locations = locationService.findAllByNamePaged(name, page, size);
        List<LocationDTO> locationDTOS = new ArrayList<LocationDTO>();
        for (Location location: locations) {
            locationDTOS.add(new LocationDTO(location));
        }

        return new ResponseEntity<List<LocationDTO>>(locationDTOS, HttpStatus.OK);
    }

    @GetMapping(value = {"", "/"}, params = {"name", "page", "size", "sortDir", "sort"})
    public ResponseEntity<List<LocationDTO>> getByNamePagedAndSorted(@RequestParam("name") String name, @RequestParam("page") Integer page, @RequestParam("size") Integer size, @RequestParam("sortDir") String sortDir, @RequestParam("sort") String sort) {
        List<Location> locations = locationService.findAllByNamePagedAndSorted(name, page, size, sortDir, sort);
        List<LocationDTO> locationDTOS = new ArrayList<LocationDTO>();
        for (Location location: locations) {
            locationDTOS.add(new LocationDTO(location));
        }

        return new ResponseEntity<List<LocationDTO>>(locationDTOS, HttpStatus.OK);
    }
}
