package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "merchandise")
public class Merchandise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", columnDefinition = "VARCHAR(60)", length = 60, nullable = false)
    private String name;

    @ManyToOne // Merchandise 0..n -> 1..1 Group of merchandise
    @JoinColumn(name = "groupOfMerchandise_id", referencedColumnName = "id")
    private GroupOfMerchandise groupOfMerchandise;

    @ManyToOne // Merchandise 0..n -> 1..1 Unit
    @JoinColumn(name = "unit_id", referencedColumnName = "id")
    private Unit unit;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "merchandise") // Merchandise 1..1  -> 0..n Merchandise card
    private Set<MerchandiseCard> merchandiseCards = new HashSet<MerchandiseCard>();

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "merchandise") // Merchandise 1..1 -> 0..n Document items
    private Set<DocumentItem> documentItems = new HashSet<DocumentItem>();

    public Merchandise() {
    }

    public Merchandise(Integer id, String name, GroupOfMerchandise groupOfMerchandise, Unit unit, Set<MerchandiseCard> merchandiseCards, Set<DocumentItem> documentItems) {
        this.id = id;
        this.name = name;
        this.groupOfMerchandise = groupOfMerchandise;
        this.unit = unit;
        this.merchandiseCards = merchandiseCards;
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

    public GroupOfMerchandise getGroupOfMerchandise() {
        return groupOfMerchandise;
    }

    public void setGroupOfMerchandise(GroupOfMerchandise groupOfMerchandise) {
        this.groupOfMerchandise = groupOfMerchandise;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public Set<MerchandiseCard> getMerchandiseCards() {
        return merchandiseCards;
    }

    public void setMerchandiseCards(Set<MerchandiseCard> merchandiseCards) {
        this.merchandiseCards = merchandiseCards;
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
                ", groupOfMerchandise=" + groupOfMerchandise +
                ", unit=" + unit +
                ", merchandiseCards=" + merchandiseCards +
                ", documentItems=" + documentItems +
                '}';
    }
}
