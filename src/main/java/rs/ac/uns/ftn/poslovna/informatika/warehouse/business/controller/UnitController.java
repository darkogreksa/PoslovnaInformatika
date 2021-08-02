package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.dto.UnitDTO;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.Unit;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.service.implementation.UnitService;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/unit")
public class UnitController {

    @Autowired
    UnitService unitService;

    @GetMapping
    public ResponseEntity<List<UnitDTO>> getAll(){
        List<Unit> units = unitService.findAll();
        List<UnitDTO> unitDTOS = new ArrayList<>();
        for(Unit unit : units) {
            unitDTOS.add(new UnitDTO(unit));
        }
        return new ResponseEntity<List<UnitDTO>>(unitDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UnitDTO> getOne(@PathVariable("id") Integer id){
        Unit unit = unitService.findOne(id);
        if(unit == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<UnitDTO>(new UnitDTO(unit), HttpStatus.OK);
    }

    @PostMapping(value = "/create", consumes = "application/json")
    public ResponseEntity<UnitDTO> create(@RequestBody UnitDTO unitDTO){
        Unit unit = new Unit();
        unit.setName(unitDTO.getName());

        unit = unitService.save(unit);
        return new ResponseEntity<UnitDTO>(new UnitDTO(), HttpStatus.CREATED);
    }


    @PutMapping(value = "/update/{id}", consumes = "application/json")
    public ResponseEntity<UnitDTO> update(@PathVariable("id") Integer id, @RequestBody UnitDTO unitDTO){
        Unit unit = unitService.findOne(id);
        if(unit == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        unit.setName(unitDTO.getName());
        unit = unitService.save(unit);
        return new ResponseEntity<UnitDTO>(new UnitDTO(unit), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        Unit unit = unitService.findOne(id);
        if(unit == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        unitService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = {"", "/"}, params = {"page", "size"})
    public ResponseEntity<Page<UnitDTO>> getAllPaged(@RequestParam("page") Integer page, @RequestParam("size") Integer size){
        Page<Unit> units = (Page<Unit>) unitService.findAllPaged(page, size);
        Page<UnitDTO> unitDTOS = units.map(UnitDTO::new);
        return new ResponseEntity<Page<UnitDTO>>(unitDTOS, HttpStatus.OK);
    }
}
