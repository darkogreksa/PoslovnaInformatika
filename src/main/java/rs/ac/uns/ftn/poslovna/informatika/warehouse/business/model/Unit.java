package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "unit")
public class Unit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "unit_id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "name", columnDefinition = "VARCHAR(20)", length = 20, nullable = false)
    private String name;

    @OneToMany(mappedBy = "unit")
    private List<Goods> goods = new ArrayList<>();

    public Unit() {
    }

    public Unit(Integer id, String name, List<Goods> goods) {
        this.id = id;
        this.name = name;
        this.goods = goods;
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

    public List<Goods> getMerchandise() {
        return goods;
    }

    public void setMerchandise(List<Goods> goods) {
        this.goods = goods;
    }

    @Override
    public String toString() {
        return "Unit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", merchandise=" + goods +
                '}';
    }
}
