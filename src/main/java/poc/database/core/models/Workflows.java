package poc.database.core.models;
// Generated Aug 6, 2020, 8:53:46 PM by Hibernate Tools 5.2.0.Final


import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Clob;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Workflows generated by hbm2java
 */
@Entity
@Table(name="WORKFLOWS"
    ,schema="HIT_RESYNTHESIS"
)
public class Workflows  implements java.io.Serializable {


     private BigDecimal id;
     private Serializable createdAt;
     private BigDecimal createdBy;
     private Serializable updatedAt;
     private BigDecimal updatedBy;
     private Clob description;
     private Boolean isClone;
     private Boolean isDefault;
     private String name;
     private Set<Cycles> cycleses = new HashSet<Cycles>(0);

    public Workflows() {
    }

	
    public Workflows(BigDecimal id, String name) {
        this.id = id;
        this.name = name;
    }
    public Workflows(BigDecimal id, Serializable createdAt, BigDecimal createdBy, Serializable updatedAt, BigDecimal updatedBy, Clob description, Boolean isClone, Boolean isDefault, String name, Set<Cycles> cycleses) {
       this.id = id;
       this.createdAt = createdAt;
       this.createdBy = createdBy;
       this.updatedAt = updatedAt;
       this.updatedBy = updatedBy;
       this.description = description;
       this.isClone = isClone;
       this.isDefault = isDefault;
       this.name = name;
       this.cycleses = cycleses;
    }
   
     @Id 

    
    @Column(name="ID", unique=true, nullable=false, scale=0)
    public BigDecimal getId() {
        return this.id;
    }
    
    public void setId(BigDecimal id) {
        this.id = id;
    }

    
    @Column(name="CREATED_AT")
    public Serializable getCreatedAt() {
        return this.createdAt;
    }
    
    public void setCreatedAt(Serializable createdAt) {
        this.createdAt = createdAt;
    }

    
    @Column(name="CREATED_BY", scale=0)
    public BigDecimal getCreatedBy() {
        return this.createdBy;
    }
    
    public void setCreatedBy(BigDecimal createdBy) {
        this.createdBy = createdBy;
    }

    
    @Column(name="UPDATED_AT")
    public Serializable getUpdatedAt() {
        return this.updatedAt;
    }
    
    public void setUpdatedAt(Serializable updatedAt) {
        this.updatedAt = updatedAt;
    }

    
    @Column(name="UPDATED_BY", scale=0)
    public BigDecimal getUpdatedBy() {
        return this.updatedBy;
    }
    
    public void setUpdatedBy(BigDecimal updatedBy) {
        this.updatedBy = updatedBy;
    }

    
    @Column(name="DESCRIPTION")
    public Clob getDescription() {
        return this.description;
    }
    
    public void setDescription(Clob description) {
        this.description = description;
    }

    
    @Column(name="IS_CLONE", precision=1, scale=0)
    public Boolean getIsClone() {
        return this.isClone;
    }
    
    public void setIsClone(Boolean isClone) {
        this.isClone = isClone;
    }

    
    @Column(name="IS_DEFAULT", precision=1, scale=0)
    public Boolean getIsDefault() {
        return this.isDefault;
    }
    
    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    
    @Column(name="NAME", nullable=false, length=1020)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="workflows")
    public Set<Cycles> getCycleses() {
        return this.cycleses;
    }
    
    public void setCycleses(Set<Cycles> cycleses) {
        this.cycleses = cycleses;
    }




}


