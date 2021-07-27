package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.dto;

import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.InvoiceLineItem;

import java.io.Serializable;

public class InvoiceLineItemDTO  implements Serializable {

    private Integer id;
    private Double quantity;
    private Double price;
    private Double value;
    private InvoiceDTO invoiceDTO;
    private ProductDTO productDTO;

    public InvoiceLineItemDTO() {
    }

    public InvoiceLineItemDTO(Integer id, Double quantity, Double price, Double value, InvoiceDTO invoiceDTO, ProductDTO productDTO) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.value = value;
        this.invoiceDTO = invoiceDTO;
        this.productDTO = productDTO;
    }

    public InvoiceLineItemDTO(InvoiceLineItem invoiceLineItem) {

        this(invoiceLineItem.getId(), invoiceLineItem.getQuantity(), invoiceLineItem.getPrice(), invoiceLineItem.getValue(), new InvoiceDTO(invoiceLineItem.getInvoice()), new ProductDTO(invoiceLineItem.getProduct()));
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

    public ProductDTO getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }
}
