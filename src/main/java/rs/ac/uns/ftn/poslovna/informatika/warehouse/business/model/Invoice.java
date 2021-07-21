package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "invoice")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_id")
    private int id;

    @Column(name = "documentType", nullable = false)
    private String documentType;

    //redni broj dokumenta
    @Column(name = "ordinalInvoiceNumber")
    private Integer ordinalInvoiceNumber;

    //datum formiranja
    @Column(name = "dateOfFormation")
    private Date dateOfFormation;

    //datum knjizenja
    @Column(name = "postingDate")
    private Date postingDate;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "businessPartner_id", referencedColumnName = "businessPartner_id", nullable = false)
    @JsonBackReference
    private BusinessPartner businessPartner;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "businessYear_id", referencedColumnName = "businessYear_id")
    @JsonBackReference
    private BusinessYear businessYear;

    @ManyToOne
    @JoinColumn(name = "warehouse_id", referencedColumnName = "warehouse_id")
    @JsonBackReference
    private Warehouse warehouse;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "invoice")
    @JsonManagedReference
    private Set<InvoiceLineItem> invoiceLineItems = new HashSet<>();

    public Invoice() {
    }

    public Invoice(int id, String documentType, Integer ordinalInvoiceNumber, Date dateOfFormation, Date postingDate, String status, BusinessPartner businessPartner, BusinessYear businessYear, Warehouse warehouse, Set<InvoiceLineItem> invoiceLineItems) {
        this.id = id;
        this.documentType = documentType;
        this.ordinalInvoiceNumber = ordinalInvoiceNumber;
        this.dateOfFormation = dateOfFormation;
        this.postingDate = postingDate;
        this.status = status;
        this.businessPartner = businessPartner;
        this.businessYear = businessYear;
        this.warehouse = warehouse;
        this.invoiceLineItems = invoiceLineItems;
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

    public BusinessPartner getBusinessPartner() {
        return businessPartner;
    }

    public void setBusinessPartner(BusinessPartner businessPartner) {
        this.businessPartner = businessPartner;
    }

    public BusinessYear getBusinessYear() {
        return businessYear;
    }

    public void setBusinessYear(BusinessYear businessYear) {
        this.businessYear = businessYear;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Set<InvoiceLineItem> getInvoiceLineItems() {
        return invoiceLineItems;
    }

    public void setInvoiceLineItems(Set<InvoiceLineItem> invoiceLineItems) {
        this.invoiceLineItems = invoiceLineItems;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", documentType='" + documentType + '\'' +
                ", ordinalInvoiceNumber=" + ordinalInvoiceNumber +
                ", dateOfFormation=" + dateOfFormation +
                ", postingDate=" + postingDate +
                ", status='" + status + '\'' +
                ", businessPartner=" + businessPartner +
                ", businessYear=" + businessYear +
                ", warehouse=" + warehouse +
                ", invoiceLineItems=" + invoiceLineItems +
                '}';
    }
}
