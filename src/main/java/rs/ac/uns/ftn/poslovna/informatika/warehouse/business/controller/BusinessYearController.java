package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.dto.BusinessYearDTO;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.BusinessYear;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.service.implementation.BusinessYearService;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/business-year")
public class BusinessYearController {

    //Dodati jos @GetMapping(value = "/{id}/robne-kartice")

    @Autowired
    BusinessYearService businessYearService;

    @GetMapping
    public ResponseEntity<List<BusinessYearDTO>> getAll(){
        List<BusinessYear> businessYears = businessYearService.findAll();
        List<BusinessYearDTO> businessYearDTOS = new ArrayList<BusinessYearDTO>();
        for(BusinessYear businessYear : businessYears) {
            businessYearDTOS.add(new BusinessYearDTO(businessYear));
        }
        return new ResponseEntity<List<BusinessYearDTO>>(businessYearDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<BusinessYearDTO> getOne(@PathVariable("id") Integer id){
        BusinessYear businessYear = businessYearService.findOne(id);
        return new ResponseEntity<BusinessYearDTO>(new BusinessYearDTO(businessYear), HttpStatus.OK);
    }


    @PostMapping(value = "/create", consumes = "application/json")
    public ResponseEntity<BusinessYearDTO> create(@RequestBody BusinessYearDTO businessYearDTO){
        BusinessYear businessYear = new BusinessYear();
        businessYear.setYear(businessYearDTO.getYear());
        businessYear.setClosed(businessYearDTO.isClosed());
        businessYear.setCompany(businessYearDTO.getCompany());
        businessYear = businessYearService.save(businessYear);
        return new ResponseEntity<BusinessYearDTO>(new BusinessYearDTO(businessYear), HttpStatus.CREATED);
    }


    @PutMapping(value = "/update/{id}", consumes = "application/json")
    public ResponseEntity<BusinessYearDTO> update(@RequestBody BusinessYearDTO businessYearDTO, @PathVariable("id") Integer id){
        BusinessYear businessYear = businessYearService.findOne(id);
        businessYear.setYear(businessYearDTO.getYear());
        businessYear.setClosed(businessYearDTO.isClosed());
        businessYear.setCompany(businessYearDTO.getCompany());
        businessYear = businessYearService.save(businessYear);
        return new ResponseEntity<BusinessYearDTO>(new BusinessYearDTO(businessYear), HttpStatus.OK);
    }


    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id")Integer id){
        BusinessYear businessYear = businessYearService.findOne(id);
        businessYearService.remove(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
