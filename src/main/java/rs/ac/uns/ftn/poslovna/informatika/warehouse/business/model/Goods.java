package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "goods")
public class Goods {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "goods_id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "name", columnDefinition = "VARCHAR(60)", length = 60, nullable = false)
    private String name;

    @ManyToOne // Goods 0..n -> 1..1 Group of goods
    @JoinColumn(name = "groupOfGoods_id", referencedColumnName = "groupOfGoods_id")
    private GroupOfGoods groupOfGoods;

    @ManyToOne // Goods 0..n -> 1..1 Unit
    @JoinColumn(name = "unit_id", referencedColumnName = "unit_id")
    private Unit unit;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "goods") // Goods 1..1  -> 0..n Goods card
    private Set<GoodsCard> goodsCards = new HashSet<GoodsCard>();

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "goods") // Goods 1..1 -> 0..n Document items
    private Set<DocumentItem> documentItems = new HashSet<DocumentItem>();

    public Goods() {
    }

    public Goods(Integer id, String name, GroupOfGoods groupOfGoods, Unit unit, Set<GoodsCard> goodsCards, Set<DocumentItem> documentItems) {
        this.id = id;
        this.name = name;
        this.groupOfGoods = groupOfGoods;
        this.unit = unit;
        this.goodsCards = goodsCards;
        this.documentItems = documentItems;
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

    public GroupOfGoods getGroupOfMerchandise() {
        return groupOfGoods;
    }

    public void setGroupOfMerchandise(GroupOfGoods groupOfGoods) {
        this.groupOfGoods = groupOfGoods;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public Set<GoodsCard> getMerchandiseCards() {
        return goodsCards;
    }

    public void setMerchandiseCards(Set<GoodsCard> goodsCards) {
        this.goodsCards = goodsCards;
    }

    public Set<DocumentItem> getDocumentItems() {
        return documentItems;
    }

    public void setDocumentItems(Set<DocumentItem> documentItems) {
        this.documentItems = documentItems;
    }

    @Override
    public String toString() {
        return "Merchandise{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", groupOfMerchandise=" + groupOfGoods +
                ", unit=" + unit +
                ", merchandiseCards=" + goodsCards +
                ", documentItems=" + documentItems +
                '}';
    }
}
