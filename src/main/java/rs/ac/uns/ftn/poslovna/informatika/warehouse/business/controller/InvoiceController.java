package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.dto.InvoiceDTO;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.dto.InvoiceLineItemDTO;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.dto.WarehouseDTO;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.Invoice;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.service.implementation.InvoiceService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/invoices")
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @GetMapping
    public ResponseEntity<List<InvoiceDTO>> getAll() {
        List<Invoice> invoices = invoiceService.getInvoices();
        List<InvoiceDTO> invoiceDTOS = new ArrayList<InvoiceDTO>();

        for (Invoice invoice : invoices) {
            invoiceDTOS.add(new InvoiceDTO(invoice));
        }

        return new ResponseEntity<List<InvoiceDTO>>(invoiceDTOS, HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping(value = "/invoice/{id}")
    public ResponseEntity<InvoiceDTO> getDokument(@PathVariable("id") Integer id) {
        Invoice invoice = invoiceService.findOne(id);
        if (invoice == null)
            return new ResponseEntity<InvoiceDTO>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<InvoiceDTO>(new InvoiceDTO(invoice), HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping(value = "/invoice/{id}/lineitems")
    public ResponseEntity<List<InvoiceLineItemDTO>> getInvoiceLineItems(@PathVariable("id") Integer id) {
        List<InvoiceLineItemDTO> invoiceLineItems = invoiceService.getInvoiceLineItems(id);
        if (invoiceLineItems == null)
            return new ResponseEntity<List<InvoiceLineItemDTO>>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<List<InvoiceLineItemDTO>>(invoiceLineItems, HttpStatus.OK);
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Invoice addInvoice(@RequestBody InvoiceDTO invoiceDTO) throws IOException {
        Invoice invoice = invoiceService.addInvoice(invoiceDTO);
        if (invoice != null) {
            return invoice;
        }
        return null;
    }



}
