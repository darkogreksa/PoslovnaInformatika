package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.dto;

import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.BusinessYear;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.ProductCard;

import java.io.Serializable;
import java.math.BigInteger;

public class ProductCardDTO implements Serializable {

    private Integer id;
    private BigInteger price;
    private Integer initialStateQuantity;
    private double initialStateValue;
    private Integer inboundTrafficQuantity;
    private double inboundTrafficValue;
    private Integer outgoingTrafficQuantity;
    private double outgoingTrafficValue;
    private double totalAmount;
    private double totalValue;
    private BusinessYearDTO businessYear;
    private ProductDTO product;
    private WarehouseDTO warehouse;

    public ProductCardDTO() {
    }

    public ProductCardDTO(Integer id, BigInteger price, Integer initialStateQuantity, double initialStateValue, Integer inboundTrafficQuantity, double inboundTrafficValue, Integer outgoingTrafficQuantity, double outgoingTrafficValue, double totalAmount, double totalValue, BusinessYearDTO businessYear, ProductDTO product, WarehouseDTO warehouse) {
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
    }

    public ProductCardDTO(ProductCard productCard) {
        this(productCard.getId(), productCard.getPrice(), productCard.getInitialStateQuantity(), productCard.getInitialStateValue(), productCard.getInboundTrafficQuantity(), productCard.getInboundTrafficValue(), productCard.getOutgoingTrafficQuantity(), productCard.getOutgoingTrafficValue(), productCard.getTotalAmount(), productCard.getTotalValue(), new BusinessYearDTO(productCard.getBusinessYear()), new ProductDTO(productCard.getProduct()), new WarehouseDTO(productCard.getWarehouse()));
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

    public BusinessYearDTO getBusinessYear() {
        return businessYear;
    }

    public void setBusinessYear(BusinessYearDTO businessYear) {
        this.businessYear = businessYear;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public WarehouseDTO getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(WarehouseDTO warehouse) {
        this.warehouse = warehouse;
    }
}
