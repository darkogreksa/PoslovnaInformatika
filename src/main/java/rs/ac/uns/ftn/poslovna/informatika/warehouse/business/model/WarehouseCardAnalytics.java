package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model;

import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.dto.AnalyticsDTO;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "warehouseCardAnalytics")
public class WarehouseCardAnalytics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "warehouseCardAnalytics_id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "ordinalNumber", nullable = true)
    private Integer ordinalNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "trafficType", nullable = false, length = 2, columnDefinition = "Char(2)")
    private TrafficType trafficType;

    @Enumerated(EnumType.STRING)
    @Column(name = "trafficDirection", nullable = false, length = 1, columnDefinition = "Char(1)")
    private TrafficDirection trafficDirection;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "price" , nullable = false, columnDefinition = "Decimal(10,2)")
    private BigDecimal price;

    @Column(name = "value", nullable = false, columnDefinition = "Decimal(19,2)")
    private BigDecimal value;

    @ManyToOne()
    @JoinColumn(name = "productCard_id", referencedColumnName = "productCard_id", nullable = false)
    private ProductCard productCard;

    @ManyToOne()
    @JoinColumn(name = "invoiceLineItem_id", referencedColumnName = "invoiceLineItem_id", nullable = true)
    private InvoiceLineItem invoiceLineItem;

    public WarehouseCardAnalytics() {
    }

    public WarehouseCardAnalytics(Integer id, Integer ordinalNumber, TrafficType trafficType, TrafficDirection trafficDirection, Integer quantity, BigDecimal price, BigDecimal value, ProductCard productCard, InvoiceLineItem invoiceLineItem) {
        this.id = id;
        this.ordinalNumber = ordinalNumber;
        this.trafficType = trafficType;
        this.trafficDirection = trafficDirection;
        this.quantity = quantity;
        this.price = price;
        this.value = value;
        this.productCard = productCard;
        this.invoiceLineItem = invoiceLineItem;
    }

    public void setSimpleDataFromDTO(AnalyticsDTO analyticsDTO) {
        this.setOrdinalNumber(analyticsDTO.getOrdinalNumber());
        this.setTrafficType(analyticsDTO.getTrafficType());
        this.setTrafficDirection(analyticsDTO.getTrafficDirection());
        this.setQuantity(analyticsDTO.getQuantity());
        this.setPrice(analyticsDTO.getPrice());
        this.setValue(analyticsDTO.getValue());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrdinalNumber() {
        return ordinalNumber;
    }

    public void setOrdinalNumber(Integer ordinalNumber) {
        this.ordinalNumber = ordinalNumber;
    }

    public TrafficType getTrafficType() {
        return trafficType;
    }

    public void setTrafficType(TrafficType trafficType) {
        this.trafficType = trafficType;
    }

    public TrafficDirection getTrafficDirection() {
        return trafficDirection;
    }

    public void setTrafficDirection(TrafficDirection trafficDirection) {
        this.trafficDirection = trafficDirection;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public ProductCard getProductCard() {
        return productCard;
    }

    public void setProductCard(ProductCard productCard) {
        this.productCard = productCard;
    }

    public InvoiceLineItem getInvoiceLineItem() {
        return invoiceLineItem;
    }

    public void setInvoiceLineItem(InvoiceLineItem invoiceLineItem) {
        this.invoiceLineItem = invoiceLineItem;
    }

    @Override
    public String toString() {
        return "WarehouseCardAnalytics{" +
                "id=" + id +
                ", ordinalNumber=" + ordinalNumber +
                ", trafficType=" + trafficType +
                ", trafficDirection=" + trafficDirection +
                ", quantity=" + quantity +
                ", price=" + price +
                ", value=" + value +
                ", productCard=" + productCard +
                ", invoiceLineItem=" + invoiceLineItem +
                '}';
    }
}
