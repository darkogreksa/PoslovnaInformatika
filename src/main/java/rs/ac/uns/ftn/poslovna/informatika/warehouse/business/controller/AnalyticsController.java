package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.dto.AnalyticsDTO;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.WarehouseCardAnalytics;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.service.implementation.AnalyticsService;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.service.implementation.ProductCardService;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/api/warehouse-card-analytics", produces = "application/json")
public class AnalyticsController {

    @Autowired
    AnalyticsService analyticsService;

    @Autowired
    ProductCardService productCardService;

    @GetMapping(value = "/count")
    public ResponseEntity<Long> getCount(){
        Long count = analyticsService.count();

        return new ResponseEntity<Long>(count, HttpStatus.OK);
    }

    @GetMapping(value = {"", "/"})
    public ResponseEntity<List<AnalyticsDTO>> getAll(){
        List<WarehouseCardAnalytics> warehouseCardAnalytics = analyticsService.findAll();
        List<AnalyticsDTO> analyticsDTOS = new ArrayList<AnalyticsDTO>();

        for (WarehouseCardAnalytics warehouseCardAnalytics1 : warehouseCardAnalytics) {
            analyticsDTOS.add(new AnalyticsDTO(warehouseCardAnalytics1));
        }

        return new ResponseEntity<List<AnalyticsDTO>>(analyticsDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AnalyticsDTO> getById(@PathVariable("id") Integer id) {
        WarehouseCardAnalytics warehouseCardAnalytics = analyticsService.findOne(id);
        if (warehouseCardAnalytics == null) {
            return new ResponseEntity<AnalyticsDTO>(HttpStatus.NOT_FOUND);
        }
        AnalyticsDTO analyticsDTO = new AnalyticsDTO(warehouseCardAnalytics);

        return new ResponseEntity<AnalyticsDTO>(analyticsDTO, HttpStatus.OK);
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<AnalyticsDTO> create(@RequestBody AnalyticsDTO analyticsDTO) {
        WarehouseCardAnalytics warehouseCardAnalytics = new WarehouseCardAnalytics();
        warehouseCardAnalytics.setSimpleDataFromDTO(analyticsDTO);
        warehouseCardAnalytics.setProductCard(productCardService.findOne(analyticsDTO.getId()));

        WarehouseCardAnalytics saved = analyticsService.create(warehouseCardAnalytics);
        AnalyticsDTO savedDTO = new AnalyticsDTO(saved);

        return new ResponseEntity<AnalyticsDTO>(savedDTO, HttpStatus.OK);
    }

    @PutMapping(consumes = "application/json")
    public ResponseEntity<AnalyticsDTO> update(@RequestBody AnalyticsDTO analyticsDTO) {
        WarehouseCardAnalytics current = analyticsService.findOne(analyticsDTO.getId());

        if (current == null) {
            return new ResponseEntity<AnalyticsDTO>(HttpStatus.BAD_REQUEST);
        }

        current.setSimpleDataFromDTO(analyticsDTO);
        current.setProductCard(productCardService.findOne(analyticsDTO.getId()));

        WarehouseCardAnalytics updated = analyticsService.update(current);

        AnalyticsDTO updatedDTO = new AnalyticsDTO(updated);
        return new ResponseEntity<AnalyticsDTO>(updatedDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        WarehouseCardAnalytics warehouseCardAnalytics = analyticsService.findOne(id);
        if (warehouseCardAnalytics != null) {
            analyticsService.delete(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
    }
}
