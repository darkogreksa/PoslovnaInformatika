package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.service;

import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.InvoiceLineItem;

import java.util.List;

public interface InvoiceLineItemServiceInterface {

    InvoiceLineItem findOne(Integer id);

    List<InvoiceLineItem> findAll();

    InvoiceLineItem save(InvoiceLineItem invoiceLineItem);

    void remove(Integer id);
}
