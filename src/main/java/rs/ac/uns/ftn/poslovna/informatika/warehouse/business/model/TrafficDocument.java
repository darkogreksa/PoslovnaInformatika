package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "trafficDocument")
public class TrafficDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "documentType", nullable = false)
    private String documentType;

    //redni broj dokumenta
    @Column(name = "ordinalNumberOfDocument")
    private Integer ordinalNumberOfDocument;

    //datum formiranja
    @Column(name = "dateOfFormation")
    private Date dateOfFormation;

    //datum knjizenja
    @Column(name = "postingDate")
    private Date postingDate;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "businessPartner_id", referencedColumnName = "id", nullable = false)
    private BusinessPartner businessPartner;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "businessYear_id", referencedColumnName = "id")
    private BusinessYear businessYear;

    @ManyToOne
    @JoinColumn(name = "warehouse_id", referencedColumnName = "id")
    private Warehouse warehouse;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "trafficDocument")
    private Set<DocumentItem> documentItems = new HashSet<>();

    public TrafficDocument() {
    }

    public TrafficDocument(int id, String documentType, Integer ordinalNumberOfDocument, Date dateOfFormation, Date postingDate, String status, BusinessPartner businessPartner, BusinessYear businessYear, Warehouse warehouse, Set<DocumentItem> documentItems) {
        this.id = id;
        this.documentType = documentType;
        this.ordinalNumberOfDocument = ordinalNumberOfDocument;
        this.dateOfFormation = dateOfFormation;
        this.postingDate = postingDate;
        this.status = status;
        this.businessPartner = businessPartner;
        this.businessYear = businessYear;
        this.warehouse = warehouse;
        this.documentItems = documentItems;
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

    public Integer getOrdinalNumberOfDocument() {
        return ordinalNumberOfDocument;
    }

    public void setOrdinalNumberOfDocument(Integer ordinalNumberOfDocument) {
        this.ordinalNumberOfDocument = ordinalNumberOfDocument;
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

    public Set<DocumentItem> getDocumentItems() {
        return documentItems;
    }

    public void setDocumentItems(Set<DocumentItem> documentItems) {
        this.documentItems = documentItems;
    }

    @Override
    public String toString() {
        return "TrafficDocument{" +
                "id=" + id +
                ", documentType='" + documentType + '\'' +
                ", ordinalNumberOfDocument=" + ordinalNumberOfDocument +
                ", dateOfFormation=" + dateOfFormation +
                ", postingDate=" + postingDate +
                ", status='" + status + '\'' +
                ", businessPartner=" + businessPartner +
                ", businessYear=" + businessYear +
                ", warehouse=" + warehouse +
                ", documentItems=" + documentItems +
                '}';
    }
}
