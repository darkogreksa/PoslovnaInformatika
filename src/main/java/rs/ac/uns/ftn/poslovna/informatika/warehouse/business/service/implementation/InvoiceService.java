package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.dto.InvoiceDTO;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.dto.InvoiceLineItemDTO;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.*;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.repository.InvoiceLineItemRepository;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.repository.InvoiceRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvoiceService {

    @Autowired
    InvoiceRepository invoiceRepository;

    @Autowired
    InvoiceLineItemRepository invoiceLineItemRepository;

    public List<Invoice> getInvoices() {
        return invoiceRepository.findAll();
    }

    public Invoice findOne(Integer id) {
        return invoiceRepository.getOne(id);
    }

    public List<InvoiceLineItemDTO> getInvoiceLineItems(Integer id) {
        List<InvoiceLineItemDTO> invoiceLineItemDTOS = invoiceLineItemRepository.findAll().stream().map(invoiceLineItem -> new InvoiceLineItemDTO(invoiceLineItem))
                .collect(Collectors.toList());
        List<InvoiceLineItemDTO> invoiceLineItemDTOS1 = new ArrayList<>();
        for (InvoiceLineItemDTO s : invoiceLineItemDTOS) {
            if (s.getInvoiceDTO().getId() == id) {
                invoiceLineItemDTOS1.add(s);
            }
        }
        return invoiceLineItemDTOS1;
    }

    public Invoice addInvoice(InvoiceDTO invoiceDTO) {
        Invoice invoice = new Invoice();
        invoice.setBusinessPartner(new BusinessPartner(invoiceDTO.getBusinessPartner()));
        invoice.setWarehouse(new Warehouse(invoiceDTO.getWarehouse()));
        invoice.setDateOfFormation(invoiceDTO.getDateOfFormation());
        invoice.setBusinessYear(new BusinessYear(invoiceDTO.getBusinessYear()));
        invoice.setStatus(invoiceDTO.getStatus());
        invoice.setDocumentType(invoiceDTO.getDocumentType());
        invoice = invoiceRepository.save(invoice);
        invoice.setOrdinalInvoiceNumber(invoice.getId());
        invoiceRepository.save(invoice);
        System.out.println("Invoice added confirmation: " + invoice);
        return invoice;
    }




}
