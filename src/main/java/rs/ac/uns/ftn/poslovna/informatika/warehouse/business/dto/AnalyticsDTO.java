package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.dto;

import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.ProductCard;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.TrafficDirection;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.TrafficType;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.WarehouseCardAnalytics;

import java.io.Serializable;
import java.math.BigDecimal;

public class AnalyticsDTO implements Serializable {
    private Integer id;
    private Integer ordinalNumber;
    private TrafficType trafficType;
    private TrafficDirection trafficDirection;
    private Integer quantity;
    private BigDecimal price;
    private BigDecimal value;
    private ProductCardDTO productCard;

    public AnalyticsDTO() {
    }

    public AnalyticsDTO(Integer id, Integer ordinalNumber, TrafficType trafficType, TrafficDirection trafficDirection, Integer quantity, BigDecimal price, BigDecimal value, ProductCardDTO productCard) {
        this.id = id;
        this.ordinalNumber = ordinalNumber;
        this.trafficType = trafficType;
        this.trafficDirection = trafficDirection;
        this.quantity = quantity;
        this.price = price;
        this.value = value;
        this.productCard = productCard;
    }

    public AnalyticsDTO(WarehouseCardAnalytics warehouseCardAnalytics) {
        this(warehouseCardAnalytics.getId(), warehouseCardAnalytics.getOrdinalNumber(), warehouseCardAnalytics.getTrafficType(), warehouseCardAnalytics.getTrafficDirection(), warehouseCardAnalytics.getQuantity(), warehouseCardAnalytics.getPrice(), warehouseCardAnalytics.getValue(), new ProductCardDTO(warehouseCardAnalytics.getProductCard()));
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

    public ProductCardDTO getProductCard() {
        return productCard;
    }

    public void setProductCard(ProductCardDTO productCard) {
        this.productCard = productCard;
    }

    @Override
    public String toString() {
        return "AnalyticsDTO{" +
                "id=" + id +
                ", ordinalNumber=" + ordinalNumber +
                ", trafficType=" + trafficType +
                ", trafficDirection=" + trafficDirection +
                ", quantity=" + quantity +
                ", price=" + price +
                ", value=" + value +
                ", productCard=" + productCard +
                '}';
    }
}
