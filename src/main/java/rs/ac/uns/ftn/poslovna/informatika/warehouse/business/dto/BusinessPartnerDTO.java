package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.dto;

import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.BusinessPartner;

import java.io.Serializable;

public class BusinessPartnerDTO implements Serializable {

    private int id;
    private String name;
    private String PIB;
    private String address;

    public BusinessPartnerDTO() {

    }

    public BusinessPartnerDTO(int id, String name, String PIB, String address) {
        this.id = id;
        this.name = name;
        this.PIB = PIB;
        this.address = address;
    }

    public BusinessPartnerDTO(BusinessPartner partner){
        this(partner.getId(), partner.getName(), partner.getPIB(), partner.getAddress());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPIB() {
        return PIB;
    }

    public void setPIB(String PIB) {
        this.PIB = PIB;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
