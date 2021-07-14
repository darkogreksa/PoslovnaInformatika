package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.dto.ProductCardDTO;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.dto.WarehouseDTO;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.Company;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.ProductCard;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.Warehouse;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.service.implementation.CompanyService;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.service.implementation.ProductCardService;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.service.implementation.WarehouseService;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/warehouse")
public class WarehouseController {

    @Autowired
    WarehouseService warehouseService;

    @Autowired
    ProductCardService productCardService;

    @Autowired
    CompanyService companyService;

    @GetMapping
    public ResponseEntity<List<WarehouseDTO>> getAll(){
        List<Warehouse> warehouses = warehouseService.findAll();
        List<WarehouseDTO> warehousesDTO = new ArrayList<WarehouseDTO>();

        for(Warehouse w : warehouses) {
            warehousesDTO.add(new WarehouseDTO(w));
        }
        return new ResponseEntity<List<WarehouseDTO>>(warehousesDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<WarehouseDTO> getOne(@PathVariable("id") Integer id){
        Warehouse warehouse = warehouseService.findOne(id);
        return new ResponseEntity<WarehouseDTO>(new WarehouseDTO(warehouse), HttpStatus.OK);
    }

    @PostMapping(value = "/create", consumes = "application/json")
    public ResponseEntity<WarehouseDTO> create(@RequestBody WarehouseDTO warehouseDTO){
        Warehouse warehouse = new Warehouse();
        warehouse.setName(warehouseDTO.getName());
        warehouse.setCompany(warehouseDTO.getCompany());

        warehouse = warehouseService.save(warehouse);
        return new ResponseEntity<WarehouseDTO>(new WarehouseDTO(warehouse), HttpStatus.CREATED);
    }


    @PutMapping(value = "/update/{id}", consumes = "application/json")
    public ResponseEntity<WarehouseDTO> update(@RequestBody WarehouseDTO wDTO, @PathVariable("id") Integer id){
        Warehouse w = warehouseService.findOne(id);
        w.setName(wDTO.getName());
        w.setCompany(wDTO.getCompany());

        w = warehouseService.save(w);
        return new ResponseEntity<WarehouseDTO>(new WarehouseDTO(w), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        Warehouse w = warehouseService.findOne(id);
        warehouseService.remove(id);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping(value = "/company/{id}/warehouse")
    public ResponseEntity<List<WarehouseDTO>> getAllByCompany(@PathVariable("id") Integer id){
        Company c = companyService.findOne(id);
        List<WarehouseDTO> wDTO = new ArrayList<>();
        List<Warehouse> w = warehouseService.findByCompany_Id(id);

        for(Warehouse m : w) {
            wDTO.add(new WarehouseDTO(m));
        }
        return new ResponseEntity<List<WarehouseDTO>>(wDTO, HttpStatus.OK);
    }
}
