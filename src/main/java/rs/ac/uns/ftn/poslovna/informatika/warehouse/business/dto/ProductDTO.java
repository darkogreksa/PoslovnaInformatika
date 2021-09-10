package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.dto;

import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.Product;

import java.io.Serializable;

public class ProductDTO implements Serializable {

    private Integer id;
    private String name;
    private Integer groupOfProductsId;
    private UnitDTO unitDTO;

    public ProductDTO() {
    }

    public ProductDTO(Integer id, String name, Integer groupOfProductsId, UnitDTO unitDTO) {
        this.id = id;
        this.name = name;
        this.groupOfProductsId = groupOfProductsId;
        this.unitDTO = unitDTO;
    }

    public ProductDTO(Product product) {
        this(product.getId(), product.getName(), product.getGroupOfProducts().getId(), new UnitDTO(product.getUnit()));
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

    public Integer getGroupOfProductsId() {
        return groupOfProductsId;
    }

    public void setGroupOfProductsId(Integer groupOfProductsId) {
        this.groupOfProductsId = groupOfProductsId;
    }

    public UnitDTO getUnitDTO() {
        return unitDTO;
    }

    public void setUnitDTO(UnitDTO unitDTO) {
        this.unitDTO = unitDTO;
    }

//    @Override
//    public String toString() {
//        return "ProductDTO{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", groupOfProductsId=" + groupOfProductsId +
//                ", unitDTO=" + unitDTO +
//                '}';
//    }
}
