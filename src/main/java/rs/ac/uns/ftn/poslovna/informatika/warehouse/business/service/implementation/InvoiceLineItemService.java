package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.InvoiceLineItem;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.repository.InvoiceLineItemRepository;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.service.InvoiceLineItemServiceInterface;

import java.util.List;

@Service
public class InvoiceLineItemService implements InvoiceLineItemServiceInterface {

    @Autowired
    InvoiceLineItemRepository invoiceLineItemRepository;

    @Override
    public InvoiceLineItem findOne(Integer id) {
        return invoiceLineItemRepository.getOne(id);
    }

    @Override
    public List<InvoiceLineItem> findAll() {
        return invoiceLineItemRepository.findAll();
    }

    @Override
    public InvoiceLineItem save(InvoiceLineItem invoiceLineItem) {
        return invoiceLineItemRepository.save(invoiceLineItem);
    }

    @Override
    public void remove(Integer id) {
        invoiceLineItemRepository.deleteById(id);
    }
}
