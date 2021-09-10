package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.dto;

import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.Location;

import java.io.Serializable;

public class LocationDTO implements Serializable {

    private Integer id;
    private String name;

    public LocationDTO() {
    }

    public LocationDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public LocationDTO(Location location) {
        this(location.getId(), location.getName());
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

//    @Override
//    public String toString() {
//        return "LocationDTO{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                '}';
//    }
}
