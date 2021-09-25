package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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
    @JsonManagedReference(value="Product-Unit")
    private List<Product> products = new ArrayList<>();

    public Unit() {
    }

    public Unit(Integer id, String name, List<Product> products) {
        this.id = id;
        this.name = name;
        this.products = products;
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

//    @Override
//    public String toString() {
//        return "Unit{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", products=" + products +
//                '}';
//    }
}
