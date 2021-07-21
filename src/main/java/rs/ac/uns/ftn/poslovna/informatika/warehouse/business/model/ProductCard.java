package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "productCard")
public class ProductCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productCard_id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "price", unique = false, nullable = false, columnDefinition = "Decimal(10,2)")
    private BigInteger price;

    //pocetno stanje kolicina
    @Column(name = "initialStateQuantity", unique = false, nullable = false)
    private Integer initialStateQuantity;

    //pocetno stanje vrednost
    @Column(name = "initialStateValue", unique = false, nullable = false, columnDefinition = "Decimal(10,2)")
    private double initialStateValue;

    //ulazni promet kolicina
    @Column(name = "inboundTrafficQuantity" , unique = false, nullable = true)
    private Integer inboundTrafficQuantity;

    //ulazni promet vrednost
    @Column(name = "inboundTrafficValue", unique = false, nullable = true, columnDefinition = "Decimal(10,2)")
    private double inboundTrafficValue;

    @Column(name = "outgoingTrafficQuantity", unique = false, nullable = true)
    private Integer outgoingTrafficQuantity;

    @Column(name = "outgoingTrafficValue", unique = false, nullable = true)
    private double outgoingTrafficValue;

    @Column(name = "totalAmount", unique = false, nullable = true)
    private double totalAmount;

    @Column(name = "totalValue", unique = false, nullable = true, columnDefinition = "Decimal(20,2)")
    private double totalValue;

    @ManyToOne()
    @JoinColumn(name = "businessYear_id", nullable = true, referencedColumnName = "businessYear_id")
    @JsonBackReference
    private BusinessYear businessYear;

    @ManyToOne()
    @JoinColumn(name = "product_id", nullable = true, referencedColumnName = "product_id")
    @JsonBackReference
    private Product product;

    @ManyToOne()
    @JoinColumn(name = "warehouse_id", nullable = true, referencedColumnName = "warehouse_id")
    @JsonBackReference
    private Warehouse warehouse;

    @OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "productCard")
    @JsonManagedReference
    private Set<WarehouseCardAnalytics> warehouseCardAnalytics = new HashSet<WarehouseCardAnalytics>();

    public ProductCard() {
    }

    public ProductCard(Integer id, BigInteger price, Integer initialStateQuantity, double initialStateValue, Integer inboundTrafficQuantity, double inboundTrafficValue, Integer outgoingTrafficQuantity, double outgoingTrafficValue, double totalAmount, double totalValue, BusinessYear businessYear, Product product, Warehouse warehouse, Set<WarehouseCardAnalytics> warehouseCardAnalytics) {
        this.id = id;
        this.price = price;
        this.initialStateQuantity = initialStateQuantity;
        this.initialStateValue = initialStateValue;
        this.inboundTrafficQuantity = inboundTrafficQuantity;
        this.inboundTrafficValue = inboundTrafficValue;
        this.outgoingTrafficQuantity = outgoingTrafficQuantity;
        this.outgoingTrafficValue = outgoingTrafficValue;
        this.totalAmount = totalAmount;
        this.totalValue = totalValue;
        this.businessYear = businessYear;
        this.product = product;
        this.warehouse = warehouse;
        this.warehouseCardAnalytics = warehouseCardAnalytics;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigInteger getPrice() {
        return price;
    }

    public void setPrice(BigInteger price) {
        this.price = price;
    }

    public Integer getInitialStateQuantity() {
        return initialStateQuantity;
    }

    public void setInitialStateQuantity(Integer initialStateQuantity) {
        this.initialStateQuantity = initialStateQuantity;
    }

    public double getInitialStateValue() {
        return initialStateValue;
    }

    public void setInitialStateValue(double initialStateValue) {
        this.initialStateValue = initialStateValue;
    }

    public Integer getInboundTrafficQuantity() {
        return inboundTrafficQuantity;
    }

    public void setInboundTrafficQuantity(Integer inboundTrafficQuantity) {
        this.inboundTrafficQuantity = inboundTrafficQuantity;
    }

    public double getInboundTrafficValue() {
        return inboundTrafficValue;
    }

    public void setInboundTrafficValue(double inboundTrafficValue) {
        this.inboundTrafficValue = inboundTrafficValue;
    }

    public Integer getOutgoingTrafficQuantity() {
        return outgoingTrafficQuantity;
    }

    public void setOutgoingTrafficQuantity(Integer outgoingTrafficQuantity) {
        this.outgoingTrafficQuantity = outgoingTrafficQuantity;
    }

    public double getOutgoingTrafficValue() {
        return outgoingTrafficValue;
    }

    public void setOutgoingTrafficValue(double outgoingTrafficValue) {
        this.outgoingTrafficValue = outgoingTrafficValue;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    public BusinessYear getBusinessYear() {
        return businessYear;
    }

    public void setBusinessYear(BusinessYear businessYear) {
        this.businessYear = businessYear;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Set<WarehouseCardAnalytics> getWarehouseCardAnalytics() {
        return warehouseCardAnalytics;
    }

    public void setWarehouseCardAnalytics(Set<WarehouseCardAnalytics> warehouseCardAnalytics) {
        this.warehouseCardAnalytics = warehouseCardAnalytics;
    }

    @Override
    public String toString() {
        return "ProductCard{" +
                "id=" + id +
                ", price=" + price +
                ", initialStateQuantity=" + initialStateQuantity +
                ", initialStateValue=" + initialStateValue +
                ", inboundTrafficQuantity=" + inboundTrafficQuantity +
                ", inboundTrafficValue=" + inboundTrafficValue +
                ", outgoingTrafficQuantity=" + outgoingTrafficQuantity +
                ", outgoingTrafficValue=" + outgoingTrafficValue +
                ", totalAmount=" + totalAmount +
                ", totalValue=" + totalValue +
                ", businessYear=" + businessYear +
                ", product=" + product +
                ", warehouse=" + warehouse +
                ", warehouseCardAnalytics=" + warehouseCardAnalytics +
                '}';
    }
}
