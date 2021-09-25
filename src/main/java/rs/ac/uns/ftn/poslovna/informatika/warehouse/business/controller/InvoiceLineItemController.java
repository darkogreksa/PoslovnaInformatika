package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.dto.InvoiceDTO;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.dto.InvoiceLineItemDTO;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.Invoice;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.InvoiceLineItem;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.Product;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.service.InvoiceLineItemServiceInterface;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.service.implementation.InvoiceLineItemService;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.service.implementation.InvoiceService;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/invoice-line-items")
public class InvoiceLineItemController {

    @Autowired
    InvoiceLineItemServiceInterface invoiceLineItemServiceInterface;

    @Autowired
    InvoiceService invoiceService;

    @GetMapping
    public ResponseEntity<List<InvoiceLineItemDTO>> getAll(){
        List<InvoiceLineItem> invoiceLineItems = invoiceLineItemServiceInterface.findAll();
        List<InvoiceLineItemDTO> invoiceLineItemDTOS = new ArrayList<InvoiceLineItemDTO>();

        for(InvoiceLineItem invoiceLineItem : invoiceLineItems) {
            invoiceLineItemDTOS.add(new InvoiceLineItemDTO(invoiceLineItem));
        }

        return new ResponseEntity<List<InvoiceLineItemDTO>>(invoiceLineItemDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<InvoiceLineItemDTO> getOne(@PathVariable("id") Integer id){
        InvoiceLineItem invoiceLineItem = invoiceLineItemServiceInterface.findOne(id);
        return new ResponseEntity<InvoiceLineItemDTO>(new InvoiceLineItemDTO(invoiceLineItem), HttpStatus.OK);
    }

    @PostMapping(value = "/create", consumes = "application/json")
    public ResponseEntity<InvoiceLineItemDTO> create(@RequestBody InvoiceLineItemDTO invoiceLineItemDTO){
        InvoiceLineItem invoiceLineItem = new InvoiceLineItem();
        invoiceLineItem.setQuantity(invoiceLineItemDTO.getQuantity());
        invoiceLineItem.setPrice(invoiceLineItemDTO.getPrice());
        invoiceLineItem.setValue(invoiceLineItemDTO.getValue());
        invoiceLineItem.setInvoice(new Invoice(invoiceLineItemDTO.getInvoiceDTO()));
        invoiceLineItem.setProduct(invoiceLineItemDTO.getProduct());

        invoiceLineItem = invoiceLineItemServiceInterface.save(invoiceLineItem);

        return new ResponseEntity<InvoiceLineItemDTO>(new InvoiceLineItemDTO(invoiceLineItem), HttpStatus.CREATED);
    }

    @PutMapping(value = "/update/{id}", consumes = "application/json")
    public ResponseEntity<InvoiceLineItemDTO> update(@RequestBody InvoiceLineItemDTO invoiceLineItemDTO, @PathVariable("id") Integer id){
        InvoiceLineItem invoiceLineItem = invoiceLineItemServiceInterface.findOne(id);
        invoiceLineItem.setQuantity(invoiceLineItemDTO.getQuantity());
        invoiceLineItem.setPrice(invoiceLineItemDTO.getPrice());
        invoiceLineItem.setValue(invoiceLineItemDTO.getValue());

        invoiceLineItem = invoiceLineItemServiceInterface.save(invoiceLineItem);

        return new ResponseEntity<InvoiceLineItemDTO>(new InvoiceLineItemDTO(invoiceLineItem), HttpStatus.OK);
    }


    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        InvoiceLineItem invoiceLineItem = invoiceLineItemServiceInterface.findOne(id);
        invoiceLineItemServiceInterface.remove(invoiceLineItem.getId());
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
