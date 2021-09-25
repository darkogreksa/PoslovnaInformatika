package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.dto.ProductDTO;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "name", columnDefinition = "VARCHAR(60)", length = 60, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "groupOfProducts_id", referencedColumnName = "groupOfProducts_id")
    @JsonBackReference(value="Product-GroupOfProducts")
    private GroupOfProducts groupOfProducts;

    @ManyToOne
    @JoinColumn(name = "unit_id", referencedColumnName = "unit_id")
    @JsonBackReference(value="Product-Unit")
    private Unit unit;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    @JsonManagedReference(value="Product-ProductCard")
    private Set<ProductCard> productCards = new HashSet<ProductCard>();

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
    @JsonManagedReference(value="InvoiceLineItem-product")
    private Set<InvoiceLineItem> invoiceLineItems = new HashSet<InvoiceLineItem>();

    public Product() {
    }

    public Product(Integer id, String name, GroupOfProducts groupOfProducts, Unit unit, Set<ProductCard> productCards, Set<InvoiceLineItem> invoiceLineItems) {
        this.id = id;
        this.name = name;
        this.groupOfProducts = groupOfProducts;
        this.unit = unit;
        this.productCards = productCards;
        this.invoiceLineItems = invoiceLineItems;
    }

    public Product(ProductDTO productDTO) {
        this(productDTO.getId(), productDTO.getName(), productDTO.getGroupOfProductsId(), new Unit(productDTO.getUnitDTO()));
    }

    public Product(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Product(Integer id, String name, Integer groupOfProductsId, Unit unit) {
        this.id = id;
        this.name = name;
        this.groupOfProducts = groupOfProducts;
        this.unit = unit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GroupOfProducts getGroupOfProducts() {
        return groupOfProducts;
    }

    public void setGroupOfProducts(GroupOfProducts groupOfProducts) {
        this.groupOfProducts = groupOfProducts;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public Set<ProductCard> getProductCards() {
        return productCards;
    }

    public void setProductCards(Set<ProductCard> productCards) {
        this.productCards = productCards;
    }

    public Set<InvoiceLineItem> getInvoiceLineItems() {
        return invoiceLineItems;
    }

    public void setInvoiceLineItems(Set<InvoiceLineItem> invoiceLineItems) {
        this.invoiceLineItems = invoiceLineItems;
    }

//    @Override
//    public String toString() {
//        return "Product{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", groupOfProducts=" + groupOfProducts +
//                ", unit=" + unit +
//                ", productCards=" + productCards +
//                ", invoiceLineItems=" + invoiceLineItems +
//                '}';
//    }

    public void setSimpleDataFromDTO(ProductDTO productDTO) {
        this.setId(productDTO.getId());
        this.setName(productDTO.getName());
    }
}
