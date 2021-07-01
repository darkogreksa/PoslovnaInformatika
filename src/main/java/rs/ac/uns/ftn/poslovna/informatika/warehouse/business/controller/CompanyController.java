package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.dto.CompanyDTO;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.Company;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.service.implementation.CompanyService;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/company", produces = "application/json")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @CrossOrigin
    @GetMapping(value = "/all")
    public ResponseEntity<List<CompanyDTO>> getAll(){
        List<Company> companies = companyService.findAll();
        List<CompanyDTO> companyDtos = new ArrayList<>();
        for (Company c : companies){
            companyDtos.add(new CompanyDTO(c));
        }
        if (companies == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(companyDtos, HttpStatus.OK);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<CompanyDTO> getById(@PathVariable("id") Integer id){
        Company company = companyService.findOne(id);
        if (company == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<CompanyDTO>(new CompanyDTO(company), HttpStatus.OK);
    }

    @PostMapping(value = "/add", consumes = "application/json")
    public ResponseEntity<CompanyDTO> addCompany(@RequestBody CompanyDTO companyDto){
        Company company = new Company();
        company.setId(companyDto.getId());
        company.setName(companyDto.getName());
        company.setPIB(companyDto.getPIB());
        company.setAddress(companyDto.getAddress());

        company = companyService.save(company);

        return new ResponseEntity<CompanyDTO>(new CompanyDTO(company), HttpStatus.CREATED);
    }


    @PutMapping(value = "/update/{id}", consumes = "application/json")
    public ResponseEntity<CompanyDTO> updateCompany(@RequestBody CompanyDTO companyDto, @PathVariable("id") Integer id){
        Company company = companyService.findOne(id);
        if(company == null){
            return new ResponseEntity<CompanyDTO>(HttpStatus.NOT_FOUND);
        }

        company.setId(companyDto.getId());
        company.setName(companyDto.getName());
        company.setPIB(companyDto.getPIB());
        company.setAddress(companyDto.getAddress());

        company = companyService.save(company);

        return new ResponseEntity<CompanyDTO>(new CompanyDTO(company), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        Company company = companyService.findOne(id);
        if(company == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        companyService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping(value = "/order")
    public ResponseEntity<List<CompanyDTO>> orderByName(){
        List<Company> companies = companyService.orderByName();
        List<CompanyDTO> companyDtos = new ArrayList<>();
        for (Company c : companies){
            companyDtos.add(new CompanyDTO(c));
        }
        if (companies == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(companyDtos, HttpStatus.OK);
    }


}
