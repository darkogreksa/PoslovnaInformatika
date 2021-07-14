package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
}
