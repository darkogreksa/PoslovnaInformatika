package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.dto.ProductDTO;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.Product;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.repository.GroupOfProductsRepository;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.service.ProductServiceInterface;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.service.UnitServiceInterface;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/product", produces = "application/json")
public class ProductController {

    @Autowired
    ProductServiceInterface productServiceInterface;

    @Autowired
    UnitServiceInterface unitServiceInterface;

    @Autowired
    GroupOfProductsRepository groupOfProductsRepository;

    @GetMapping(value = "/count")
    public ResponseEntity<Long> getCount() {
        Long count = productServiceInterface.count();

        return new ResponseEntity<Long>(count, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = {"", "/"})
    public ResponseEntity<List<ProductDTO>> getAll(){
        List<Product> products = productServiceInterface.findAll();
        List<ProductDTO> productDTOList = new ArrayList<ProductDTO>();

        for (Product p : products) {
            productDTOList.add(new ProductDTO(p));
        }
        return new ResponseEntity<List<ProductDTO>>(productDTOList, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> getById(@PathVariable("id") Integer id) {
        Product product = productServiceInterface.findOne(id);
        if (product == null) {
            return new ResponseEntity<ProductDTO>(HttpStatus.NOT_FOUND);
        }
        ProductDTO productDTO = new ProductDTO(product);

        return new ResponseEntity<ProductDTO>(productDTO, HttpStatus.OK);
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<ProductDTO> create(@RequestBody ProductDTO productDTO) {
        Product product = new Product();
        product.setSimpleDataFromDTO(productDTO);
        product.setUnit(unitServiceInterface.findOne(productDTO.getUnitDTO().getId()));
        product.setGroupOfProducts(groupOfProductsRepository.getOne(productDTO.getGroupOfProductsId()));

        Product saved = productServiceInterface.create(product);
        ProductDTO savedDTO = new ProductDTO(saved);

        return new ResponseEntity<ProductDTO>(savedDTO, HttpStatus.OK);
    }

    @PutMapping(consumes = "application/json")
    public ResponseEntity<ProductDTO> update(@RequestBody ProductDTO productDTO) {

        Product existing = productServiceInterface.findOne(productDTO.getId());

        if (existing == null) {
            return new ResponseEntity<ProductDTO>(HttpStatus.BAD_REQUEST);
        }

        existing.setSimpleDataFromDTO(productDTO);
        existing.setUnit(unitServiceInterface.findOne(productDTO.getUnitDTO().getId()));

        Product updated = productServiceInterface.update(existing);

        ProductDTO updatedProductDTO = new ProductDTO(updated);
        return new ResponseEntity<ProductDTO>(updatedProductDTO, HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        Product product = productServiceInterface.findOne(id);
        if (product != null) {
            productServiceInterface.removeById(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = {"", "/"}, params = "name")
    public ResponseEntity<List<ProductDTO>> getByName(@RequestParam("name") String name) {
        List<Product> goods = productServiceInterface.findByName(name);
        List<ProductDTO> productDTOList = new ArrayList<ProductDTO>();
        for (Product product1 : goods) {
            productDTOList.add(new ProductDTO(product1));
        }

        return new ResponseEntity<List<ProductDTO>>(productDTOList, HttpStatus.OK);
    }
}
