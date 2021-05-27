package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "documentItem")
public class DocumentItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "documentItem_id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "quantity", nullable = false)
    private Double quantity;

    @Column(name = "price" , nullable = false, columnDefinition = "Decimal(10,2)")
    private Double price;

    @Column(name = "value", nullable = false, columnDefinition = "Decimal(20,2)")
    private Double value;

    @ManyToOne
    @JoinColumn(name = "trafficDocument_id", referencedColumnName = "trafficDocument_id")
    private TrafficDocument trafficDocument;

    @ManyToOne
    @JoinColumn(name = "goods_id", referencedColumnName = "goods_id")
    private Goods goods;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "documentItem")
    private Set<WarehouseCardAnalytics> warehouseCardAnalytics = new HashSet<>();

    public DocumentItem() {
    }

    public DocumentItem(Integer id, Double quantity, Double price, Double value, TrafficDocument trafficDocument, Goods goods, Set<WarehouseCardAnalytics> warehouseCardAnalytics) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.value = value;
        this.trafficDocument = trafficDocument;
        this.goods = goods;
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

    public TrafficDocument getTrafficDocument() {
        return trafficDocument;
    }

    public void setTrafficDocument(TrafficDocument trafficDocument) {
        this.trafficDocument = trafficDocument;
    }

    public Goods getMerchandise() {
        return goods;
    }

    public void setMerchandise(Goods goods) {
        this.goods = goods;
    }

    public Set<WarehouseCardAnalytics> getWarehouseCardAnalytics() {
        return warehouseCardAnalytics;
    }

    public void setWarehouseCardAnalytics(Set<WarehouseCardAnalytics> warehouseCardAnalytics) {
        this.warehouseCardAnalytics = warehouseCardAnalytics;
    }

    @Override
    public String toString() {
        return "DocumentItem{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", price=" + price +
                ", value=" + value +
                ", trafficDocument=" + trafficDocument +
                ", merchandise=" + goods +
                ", warehouseCardAnalytics=" + warehouseCardAnalytics +
                '}';
    }
}
