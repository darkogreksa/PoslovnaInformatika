package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.dto.ProductCardDTO;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.dto.ProductDTO;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.Product;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.ProductCard;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.Warehouse;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.service.implementation.ProductCardService;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.service.implementation.WarehouseService;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/product-card")
public class ProductCardController {

    @Autowired
    WarehouseService warehouseService;

    @Autowired
    ProductCardService productCardService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductCardDTO> getById(@PathVariable("id") Integer id) {
        ProductCard productCard = productCardService.findOne(id);
        if (productCard == null) {
            return new ResponseEntity<ProductCardDTO>(HttpStatus.NOT_FOUND);
        }
        ProductCardDTO productCardDTO = new ProductCardDTO(productCard);

        return new ResponseEntity<ProductCardDTO>(productCardDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}/warehouse")
    public ResponseEntity<List<ProductCardDTO>> getProductCardsByWarehouse(@PathVariable("id") Integer id){
        Warehouse w = warehouseService.findOne(id);
        List<ProductCardDTO> productCardDTOS = new ArrayList<>();
        List<ProductCard> productCards = productCardService.findByWarehouse_Id(id);
        for(ProductCard productCard : productCards) {
            productCardDTOS.add(new ProductCardDTO(productCard));
        }
        return new ResponseEntity<List<ProductCardDTO>>(productCardDTOS, HttpStatus.OK);
    }

}