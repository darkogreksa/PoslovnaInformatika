package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
