package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.dto;

import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.BusinessPartner;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.BusinessYear;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.Invoice;

import java.io.Serializable;
import java.util.Date;

public class InvoiceDTO implements Serializable {

    private int id;
    private String documentType;
    private Integer ordinalInvoiceNumber;
    private Date dateOfFormation;
    private Date postingDate;
    private String status;
    private BusinessPartnerDTO businessPartner;
    private BusinessYearDTO businessYear;
    private WarehouseDTO warehouse;

    public InvoiceDTO() {
    }

    public InvoiceDTO(int id, String documentType, Integer ordinalInvoiceNumber, Date dateOfFormation, Date postingDate, String status, BusinessPartnerDTO businessPartner, BusinessYearDTO businessYear, WarehouseDTO warehouse) {
        this.id = id;
        this.documentType = documentType;
        this.ordinalInvoiceNumber = ordinalInvoiceNumber;
        this.dateOfFormation = dateOfFormation;
        this.postingDate = postingDate;
        this.status = status;
        this.businessPartner = businessPartner;
        this.businessYear = businessYear;
        this.warehouse = warehouse;
    }

    public InvoiceDTO(Invoice invoice) {
        this(invoice.getId(), invoice.getDocumentType(),
                invoice.getOrdinalInvoiceNumber(),
                invoice.getDateOfFormation(),
                invoice.getPostingDate(),
                invoice.getStatus(),
                new BusinessPartnerDTO(invoice.getBusinessPartner()),
                new BusinessYearDTO(invoice.getBusinessYear()),
                new WarehouseDTO(invoice.getWarehouse()));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public Integer getOrdinalInvoiceNumber() {
        return ordinalInvoiceNumber;
    }

    public void setOrdinalInvoiceNumber(Integer ordinalInvoiceNumber) {
        this.ordinalInvoiceNumber = ordinalInvoiceNumber;
    }

    public Date getDateOfFormation() {
        return dateOfFormation;
    }

    public void setDateOfFormation(Date dateOfFormation) {
        this.dateOfFormation = dateOfFormation;
    }

    public Date getPostingDate() {
        return postingDate;
    }

    public void setPostingDate(Date postingDate) {
        this.postingDate = postingDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BusinessPartnerDTO getBusinessPartner() {
        return businessPartner;
    }

    public void setBusinessPartner(BusinessPartnerDTO businessPartner) {
        this.businessPartner = businessPartner;
    }

    public BusinessYearDTO getBusinessYear() {
        return businessYear;
    }

    public void setBusinessYear(BusinessYearDTO businessYear) {
        this.businessYear = businessYear;
    }

    public WarehouseDTO getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(WarehouseDTO warehouse) {
        this.warehouse = warehouse;
    }
}
