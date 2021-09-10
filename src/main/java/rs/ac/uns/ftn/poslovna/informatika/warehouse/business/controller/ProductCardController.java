package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.dto.ProductCardDTO;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.dto.ProductDTO;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.Product;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.ProductCard;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.Warehouse;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.service.BusinessYearServiceInterface;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.service.ProductServiceInterface;
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

    @Autowired
    BusinessYearServiceInterface businessYearServiceInterface;

    @Autowired
    ProductServiceInterface productServiceInterface;

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

    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity<List<ProductCardDTO>> getAll(){
        List<ProductCard> productCards = productCardService.findAll();
        List<ProductCardDTO> productCardDTOS = new ArrayList<>();
        for (ProductCard productCard : productCards){
            productCardDTOS.add(new ProductCardDTO(productCard));
        }
        if (productCardDTOS == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productCardDTOS, HttpStatus.OK);
    }

    @GetMapping(value = {"", "/"}, params = {"page", "size"})
    public ResponseEntity<Page<ProductCardDTO>> getAllPaged(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        Page<ProductCard> productCards = (Page<ProductCard>) productCardService.findAllPaged(page, size);
        Page<ProductCardDTO> productCardDTOS = productCards.map(ProductCardDTO::new);

        return new ResponseEntity<Page<ProductCardDTO>>(productCardDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/business-year")
    public ResponseEntity<List<ProductCardDTO>> getAllByOrderByBusinessYearDesc(){
        List<ProductCard> productCards = productCardService.findAllByOrderByBusinessYearDesc();
        List<ProductCardDTO> productCardDTOS = new ArrayList<ProductCardDTO>();
        for (ProductCard productCard : productCards) {
            productCardDTOS.add(new ProductCardDTO(productCard));
        }
        return new ResponseEntity<List<ProductCardDTO>>(productCardDTOS, HttpStatus.OK);
    }

    @PostMapping(value = "/add", consumes = "application/json")
    public ResponseEntity<ProductCardDTO> addProductCard(@RequestBody ProductCardDTO productCardDTO){
        ProductCard productCard = new ProductCard();
        productCard.setPrice(productCardDTO.getPrice());
        productCard.setInitialStateQuantity(productCardDTO.getInitialStateQuantity());
        productCard.setInitialStateValue(productCardDTO.getInitialStateValue());
        productCard.setInboundTrafficQuantity(productCardDTO.getInboundTrafficQuantity());
        productCard.setInboundTrafficValue(productCardDTO.getInboundTrafficValue());
        productCard.setOutgoingTrafficQuantity(productCardDTO.getOutgoingTrafficQuantity());
        productCard.setOutgoingTrafficValue(productCardDTO.getOutgoingTrafficValue());
        productCard.setTotalAmount(productCardDTO.getTotalAmount());
        productCard.setTotalValue(productCardDTO.getTotalValue());
        productCard.setBusinessYear(businessYearServiceInterface.findOne(productCardDTO.getBusinessYear().getId()));
        productCard.setProduct(productServiceInterface.findOne(productCardDTO.getProduct().getId()));
        productCard.setWarehouse(warehouseService.findOne(productCardDTO.getWarehouse().getId()));

        productCard = productCardService.save(productCard);

        return new ResponseEntity<ProductCardDTO>(new ProductCardDTO(productCard), HttpStatus.CREATED);
    }

    @PutMapping(value = "/update/{id}", consumes = "application/json")
    public ResponseEntity<ProductCardDTO> updateProductCard(@RequestBody ProductCardDTO productCardDTO, @PathVariable("id") Integer id){
        ProductCard productCard = productCardService.findOne(id);
        if(productCard == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        productCard.setId(productCardDTO.getId());
        productCard.setPrice(productCardDTO.getPrice());
        productCard.setInitialStateQuantity(productCardDTO.getInitialStateQuantity());
        productCard.setInitialStateValue(productCardDTO.getInitialStateValue());
        productCard.setInboundTrafficQuantity(productCardDTO.getInboundTrafficQuantity());
        productCard.setInboundTrafficValue(productCardDTO.getInboundTrafficValue());
        productCard.setOutgoingTrafficQuantity(productCardDTO.getOutgoingTrafficQuantity());
        productCard.setOutgoingTrafficValue(productCardDTO.getOutgoingTrafficValue());
        productCard.setTotalAmount(productCardDTO.getTotalAmount());
        productCard.setTotalValue(productCardDTO.getTotalValue());
        productCard.setBusinessYear(businessYearServiceInterface.findOne(productCardDTO.getBusinessYear().getId()));

        productCard = productCardService.save(productCard);

        return new ResponseEntity<ProductCardDTO>(new ProductCardDTO(productCard), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        ProductCard productCard = productCardService.findOne(id);
        if(productCard == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        productCardService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PostMapping(value = "/{id}/nivelacija")
    public ResponseEntity<Boolean> nivelacija(@PathVariable("id") Integer id) {
        return new ResponseEntity<Boolean>(this.productCardService.nivelacija(id), HttpStatus.OK);
    }

}
