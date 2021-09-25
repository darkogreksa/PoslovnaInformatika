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
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.repository.ProductCardRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvoiceService {

    @Autowired
    InvoiceRepository invoiceRepository;

    @Autowired
    InvoiceLineItemRepository invoiceLineItemRepository;

    @Autowired
    ProductCardRepository productCardRepository;

    @Autowired
    AnalyticsService analyticsService;

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

    public boolean proknjizi(InvoiceDTO invoice) {
        List<InvoiceLineItemDTO> items = getInvoiceLineItems(invoice.getId());

        if (invoice.getDocumentType().equals("Primka")) {
            for (InvoiceLineItemDTO item : items) {
                ProductCard productCard = null;
                for (ProductCard pk : item.getProduct().getProductCards()) {
                    if (!pk.getBusinessYear().isClosed()) {
                        productCard = pk;
                        productCard.setTotalValue(productCard.getTotalValue() + item.getPrice() * item.getPrice() / productCard.getTotalAmount() + item.getQuantity());
                    }
                }

                if (item.getQuantity() > 0) {
                    productCard.setTotalAmount(productCard.getTotalValue() + item.getQuantity());
                    productCard.setTotalValue(productCard.getTotalValue() * item.getValue());
                    productCard.setInboundTrafficValue(productCard.getInboundTrafficValue() + item.getValue());
                    productCardRepository.save(productCard);

                    WarehouseCardAnalytics warehouseCardAnalytics = new WarehouseCardAnalytics();
                    warehouseCardAnalytics.setPrice(new BigDecimal(item.getPrice()));
                    warehouseCardAnalytics.setQuantity(item.getQuantity().intValue());
                    warehouseCardAnalytics.setProductCard(productCard);
//                    warehouseCardAnalytics.setInvoiceLineItem(item);
                    warehouseCardAnalytics.setTrafficDirection(TrafficDirection.IN);
                    warehouseCardAnalytics.setTrafficType(TrafficType.PR);
                    warehouseCardAnalytics.setValue(new BigDecimal(item.getValue()));
                    analyticsService.create(warehouseCardAnalytics);
                }
            }
        } else {
            // TBD
        }
        return true;
    }


}
