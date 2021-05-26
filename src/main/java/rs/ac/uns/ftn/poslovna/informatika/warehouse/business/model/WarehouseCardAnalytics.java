package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "warehouseCardAnalytics")
public class WarehouseCardAnalytics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne() // Warehouse card analytics 0..n -> 1..1 Merchandise card
    @JoinColumn(name = "merchandiseCard_id", referencedColumnName = "id", nullable = false)
    private MerchandiseCard merchandiseCard;

    @ManyToOne()
    @JoinColumn(name = "documentItem_id", referencedColumnName = "id", nullable = true)
    private DocumentItem documentItem;

    public WarehouseCardAnalytics() {
    }

    public WarehouseCardAnalytics(Integer id, Integer ordinalNumber, TrafficType trafficType, TrafficDirection trafficDirection, Integer quantity, BigDecimal price, BigDecimal value, MerchandiseCard merchandiseCard, DocumentItem documentItem) {
        this.id = id;
        this.ordinalNumber = ordinalNumber;
        this.trafficType = trafficType;
        this.trafficDirection = trafficDirection;
        this.quantity = quantity;
        this.price = price;
        this.value = value;
        this.merchandiseCard = merchandiseCard;
        this.documentItem = documentItem;
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

    public MerchandiseCard getMerchandiseCard() {
        return merchandiseCard;
    }

    public void setMerchandiseCard(MerchandiseCard merchandiseCard) {
        this.merchandiseCard = merchandiseCard;
    }

    public DocumentItem getDocumentItem() {
        return documentItem;
    }

    public void setDocumentItem(DocumentItem documentItem) {
        this.documentItem = documentItem;
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
                ", merchandiseCard=" + merchandiseCard +
                ", documentItem=" + documentItem +
                '}';
    }
}
