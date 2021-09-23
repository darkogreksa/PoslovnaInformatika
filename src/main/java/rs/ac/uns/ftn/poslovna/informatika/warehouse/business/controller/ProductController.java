package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

@CrossOrigin(origins = "http://localhost:4200")
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

    @CrossOrigin
    @GetMapping(value = "/name/{name}")
    public ResponseEntity<List<ProductDTO>> getByName(@RequestParam("name") String name) {
        List<Product> goods = productServiceInterface.findByName(name);
        List<ProductDTO> productDTOList = new ArrayList<ProductDTO>();
        for (Product product1 : goods) {
            productDTOList.add(new ProductDTO(product1));
        }

        return new ResponseEntity<List<ProductDTO>>(productDTOList, HttpStatus.OK);
    }

    @GetMapping(value = {"", "/"}, params = {"page", "size"})
    public ResponseEntity<Page<ProductDTO>> getAllPaged(@RequestParam("page") Integer page, @RequestParam("size") Integer size){
        Page<Product> products = productServiceInterface.findAllPagedp(page, size);
        Page<ProductDTO> productDTOS = products.map(ProductDTO::new);

        return new ResponseEntity<Page<ProductDTO>>(productDTOS, HttpStatus.OK);
    }

    @GetMapping(value = {"", "/"}, params = {"page", "size", "sortDir","sort"})
    public ResponseEntity<Page<ProductDTO>> getAllPagedAndSortedp(@RequestParam("page") Integer page, @RequestParam("size") Integer size, @RequestParam("sortDir") String sortDir, @RequestParam("sort") String sort){
        Page<Product> roba = productServiceInterface.findAllPagedAndSortedp(page, size, sortDir, sort);
        Page<ProductDTO> robaDTOs = roba.map(ProductDTO::new);

        return new ResponseEntity<Page<ProductDTO>>(robaDTOs, HttpStatus.OK);
    }

    @GetMapping(value = {"", "/"}, params = {"name", "page", "size"})
    public ResponseEntity<List<ProductDTO>> getByNamePaged(@RequestParam("name") String name, @RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        List<Product> products = productServiceInterface.findByNamePaged(name, page, size);
        List<ProductDTO> productDTOS = new ArrayList<ProductDTO>();
        for (Product product: products) {
            productDTOS.add(new ProductDTO(product));
        }

        return new ResponseEntity<List<ProductDTO>>(productDTOS, HttpStatus.OK);
    }

    @GetMapping(value = {"", "/"}, params = {"name", "page", "size", "sortDir", "sort"})
    public ResponseEntity<List<ProductDTO>> getByNamePagedAndSorted(@RequestParam("name") String name, @RequestParam("page") Integer page, @RequestParam("size") Integer size, @RequestParam("sortDir") String sortDir, @RequestParam("sort") String sort) {
        List<Product> products = productServiceInterface.findByNamePagedAndSorted(name, page, size, sortDir, sort);
        List<ProductDTO> productDTOS = new ArrayList<ProductDTO>();
        for (Product product: products) {
            productDTOS.add(new ProductDTO(product));
        }

        return new ResponseEntity<List<ProductDTO>>(productDTOS, HttpStatus.OK);
    }
}
