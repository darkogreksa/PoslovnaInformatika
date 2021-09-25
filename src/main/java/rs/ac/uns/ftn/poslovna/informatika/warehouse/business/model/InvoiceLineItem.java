package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "invoiceLineItem")
public class InvoiceLineItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoiceLineItem_id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "quantity", nullable = false)
    private Double quantity;

    @Column(name = "price" , nullable = false, columnDefinition = "Decimal(10,2)")
    private Double price;

    @Column(name = "value", nullable = false, columnDefinition = "Decimal(20,2)")
    private Double value;

    @ManyToOne
    @JoinColumn(name = "invoice_id", referencedColumnName = "invoice_id")
    @JsonBackReference(value="Invoice-InvoiceLineItem")
    private Invoice invoice;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    @JsonBackReference(value="InvoiceLineItem-product")
    private Product product;

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "invoiceLineItem")
    @OneToMany(mappedBy = "invoiceLineItem")
    @JsonManagedReference(value="WarehouseCardAnalytics-InvoiceLineItem")
    private Set<WarehouseCardAnalytics> warehouseCardAnalytics = new HashSet<>();

    public InvoiceLineItem() {
    }

    public InvoiceLineItem(Integer id, Double quantity, Double price, Double value, Invoice invoice, Product product, Set<WarehouseCardAnalytics> warehouseCardAnalytics) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.value = value;
        this.invoice = invoice;
        this.product = product;
        this.warehouseCardAnalytics = warehouseCardAnalytics;
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

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Set<WarehouseCardAnalytics> getWarehouseCardAnalytics() {
        return warehouseCardAnalytics;
    }

    public void setWarehouseCardAnalytics(Set<WarehouseCardAnalytics> warehouseCardAnalytics) {
        this.warehouseCardAnalytics = warehouseCardAnalytics;
    }

//    @Override
//    public String toString() {
//        return "InvoiceLineItem{" +
//                "id=" + id +
//                ", quantity=" + quantity +
//                ", price=" + price +
//                ", value=" + value +
//                ", invoice=" + invoice +
//                ", product=" + product +
//                ", warehouseCardAnalytics=" + warehouseCardAnalytics +
//                '}';
//    }
}
