package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.InvoiceLineItem;

public interface InvoiceLineItemRepository extends JpaRepository<InvoiceLineItem, Integer> {
}
