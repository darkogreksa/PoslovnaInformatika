package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.dto;

import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.InvoiceLineItem;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.Product;

import java.io.Serializable;

public class InvoiceLineItemDTO  implements Serializable {

    private Integer id;
    private Double quantity;
    private Double price;
    private Double value;
    private InvoiceDTO invoiceDTO;
    private Product product;

    public InvoiceLineItemDTO() {
    }

    public InvoiceLineItemDTO(Integer id, Double quantity, Double price, Double value, InvoiceDTO invoiceDTO, Product product) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.value = value;
        this.invoiceDTO = invoiceDTO;
        this.product = product;
    }

    public InvoiceLineItemDTO(InvoiceLineItem invoiceLineItem) {
        this(invoiceLineItem.getId(), invoiceLineItem.getQuantity(), invoiceLineItem.getPrice(), invoiceLineItem.getValue(), new InvoiceDTO(invoiceLineItem.getInvoice()), invoiceLineItem.getProduct());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public InvoiceDTO getInvoiceDTO() {
        return invoiceDTO;
    }

    public void setInvoiceDTO(InvoiceDTO invoiceDTO) {
        this.invoiceDTO = invoiceDTO;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
