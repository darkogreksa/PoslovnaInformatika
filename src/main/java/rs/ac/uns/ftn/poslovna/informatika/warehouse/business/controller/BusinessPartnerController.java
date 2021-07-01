package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.dto.BusinessPartnerDTO;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.BusinessPartner;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.service.implementation.BusinessPartnerService;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/business-partner", produces = "application/json")
public class BusinessPartnerController {

    @Autowired
    BusinessPartnerService businessPartnerService;

    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<BusinessPartnerDTO>> getAll(){
        List<BusinessPartner> businessPartners = businessPartnerService.findAll();
        List<BusinessPartnerDTO> businessPartnerDTOS = new ArrayList<>();
        for (BusinessPartner businessPartner : businessPartners){
            businessPartnerDTOS.add(new BusinessPartnerDTO(businessPartner));
        }
        if (businessPartners == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(businessPartnerDTOS, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/{id}")
    public ResponseEntity<BusinessPartnerDTO> getById(@PathVariable("id") Integer id){
        BusinessPartner businessPartner = businessPartnerService.findOne(id);
        if (businessPartner == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<BusinessPartnerDTO>(new BusinessPartnerDTO(businessPartner), HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<BusinessPartnerDTO> create(@RequestBody BusinessPartnerDTO businessPartnerDTO){
        BusinessPartner businessPartner = new BusinessPartner();
        businessPartner.setName(businessPartnerDTO.getName());
        businessPartner.setPIB(businessPartnerDTO.getPIB());
        businessPartner.setAddress(businessPartnerDTO.getAddress());

        businessPartner = businessPartnerService.save(businessPartner);

        return new ResponseEntity<BusinessPartnerDTO>(new BusinessPartnerDTO(businessPartner), HttpStatus.CREATED);
    }

    @CrossOrigin
    @PutMapping(value = "/update/{id}", consumes = "application/json")
    public ResponseEntity<BusinessPartnerDTO> update(@RequestBody BusinessPartnerDTO businessPartnerDTO, @PathVariable("id") Integer id){
        BusinessPartner businessPartner = businessPartnerService.findOne(id);
        if(businessPartner == null){
            return new ResponseEntity<BusinessPartnerDTO>(HttpStatus.NOT_FOUND);
        }

        businessPartner.setName(businessPartnerDTO.getName());
        businessPartner.setPIB(businessPartnerDTO.getPIB());
        businessPartner.setAddress(businessPartnerDTO.getAddress());

        businessPartner = businessPartnerService.save(businessPartner);

        return new ResponseEntity<BusinessPartnerDTO>(new BusinessPartnerDTO(businessPartner), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        BusinessPartner businessPartner = businessPartnerService.findOne(id);
        if(businessPartner == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        businessPartnerService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping(value = "/order")
    public ResponseEntity<List<BusinessPartnerDTO>> orderBy(){
        List<BusinessPartner> businessPartners = businessPartnerService.orderByName();
        List<BusinessPartnerDTO> businessPartnerDTOS = new ArrayList<>();
        for (BusinessPartner businessPartner : businessPartners){
            businessPartnerDTOS.add(new BusinessPartnerDTO(businessPartner));
        }
        if (businessPartners == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(businessPartnerDTOS, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/name/{name}")
    public ResponseEntity<List<BusinessPartnerDTO>> findByName(@PathVariable("name") String name){
        List<BusinessPartner> businessPartners = businessPartnerService.findByName(name);
        List<BusinessPartnerDTO> businessPartnerDTOS = new ArrayList<>();
        for (BusinessPartner businessPartner : businessPartners){
            businessPartnerDTOS.add(new BusinessPartnerDTO(businessPartner));
        }
        if (businessPartners == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(businessPartnerDTOS, HttpStatus.OK);
    }


}
