package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.dto;

import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.Unit;

import java.io.Serializable;

public class UnitDTO implements Serializable {

    private Integer id;
    private String name;

    public UnitDTO() {
        super();
    }

    public UnitDTO(Integer id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public UnitDTO(Unit unit) {
        this(unit.getId(), unit.getName());
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
}
