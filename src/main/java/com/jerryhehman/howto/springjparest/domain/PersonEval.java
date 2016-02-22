package com.jerryhehman.howto.springjparest.domain;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="PERSON_EVAL"
)
@SuppressWarnings("serial")
public class PersonEval implements java.io.Serializable {


    private PersonEvalId id;
    private Person person;
    private LookupRatingLevel lookupRatingLevel;
    private String otherTx;
    private String createBy;
    private Date createDt;
    private String modBy;
    private Date modDt;

   public PersonEval() {
   }

	
   public PersonEval(PersonEvalId id, Person person, String createBy, Date createDt) {
       this.id = id;
       this.person = person;
       this.createBy = createBy;
       this.createDt = createDt;
   }
   public PersonEval(PersonEvalId id, Person person, LookupRatingLevel lookupRatingLevel, String otherTx, String createBy, Date createDt, String modBy, Date modDt) {
      this.id = id;
      this.person = person;
      this.lookupRatingLevel = lookupRatingLevel;
      this.otherTx = otherTx;
      this.createBy = createBy;
      this.createDt = createDt;
      this.modBy = modBy;
      this.modDt = modDt;
   }
  
    @EmbeddedId

   
   @AttributeOverrides( {
       @AttributeOverride(name="personId", column=@Column(name="PERSON_ID", nullable=false, length=12) ), 
       @AttributeOverride(name="personEvalId", column=@Column(name="PERSON_EVAL_ID", nullable=false) ) } )
   public PersonEvalId getId() {
       return this.id;
   }
   
   public void setId(PersonEvalId id) {
       this.id = id;
   }

   @JsonIgnore
@ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="PERSON_ID", nullable=false, insertable=false, updatable=false)
   public Person getPerson() {
       return this.person;
   }
   
   public void setPerson(Person person) {
       this.person = person;
   }

@ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="RATING_CD")
   public LookupRatingLevel getLookupRatingLevel() {
       return this.lookupRatingLevel;
   }
   
   public void setLookupRatingLevel(LookupRatingLevel lookupRatingLevel) {
       this.lookupRatingLevel = lookupRatingLevel;
   }
   
   @Column(name="OTHER_TX", length=1024)
   public String getOtherTx() {
       return this.otherTx;
   }
   
   public void setOtherTx(String otherTx) {
       this.otherTx = otherTx;
   }

   
   @Column(name="CREATE_BY", nullable=false, length=30)
   public String getCreateBy() {
       return this.createBy;
   }
   
   public void setCreateBy(String createBy) {
       this.createBy = createBy;
   }

   @Temporal(TemporalType.TIMESTAMP)
   @Column(name="CREATE_DT", nullable=false, length=23)
   public Date getCreateDt() {
       return this.createDt;
   }
   
   public void setCreateDt(Date createDt) {
       this.createDt = createDt;
   }

   
   @Column(name="MOD_BY", length=30)
   public String getModBy() {
       return this.modBy;
   }
   
   public void setModBy(String modBy) {
       this.modBy = modBy;
   }

   @Temporal(TemporalType.TIMESTAMP)
   @Column(name="MOD_DT", length=23)
   public Date getModDt() {
       return this.modDt;
   }
   
   public void setModDt(Date modDt) {
       this.modDt = modDt;
   }

   /**
    * toString
    * @return String
    */
    @Override
    public String toString() {
	  StringBuilder buffer = new StringBuilder();

     buffer.append(getClass().getName()).append("@").append(Integer.toHexString(hashCode())).append(" [");
     buffer.append("id").append("='").append(getId()).append("' ");			
     buffer.append("otherTx").append("='").append(getOtherTx()).append("' ");			
     buffer.append("createBy").append("='").append(getCreateBy()).append("' ");			
     buffer.append("createDt").append("='").append(getCreateDt()).append("' ");			
     buffer.append("modBy").append("='").append(getModBy()).append("' ");			
     buffer.append("modDt").append("='").append(getModDt()).append("' ");			
     buffer.append("]");
     
     return buffer.toString();
    }

   @Override
   public boolean equals(Object other) {
        if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof PersonEval) ) return false;
		 PersonEval castOther = ( PersonEval ) other; 
        
		 return ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) )
&& ( (this.getOtherTx()==castOther.getOtherTx()) || ( this.getOtherTx()!=null && castOther.getOtherTx()!=null && this.getOtherTx().equals(castOther.getOtherTx()) ) )
&& ( (this.getCreateBy()==castOther.getCreateBy()) || ( this.getCreateBy()!=null && castOther.getCreateBy()!=null && this.getCreateBy().equals(castOther.getCreateBy()) ) )
&& ( (this.getCreateDt()==castOther.getCreateDt()) || ( this.getCreateDt()!=null && castOther.getCreateDt()!=null && this.getCreateDt().equals(castOther.getCreateDt()) ) )
&& ( (this.getModBy()==castOther.getModBy()) || ( this.getModBy()!=null && castOther.getModBy()!=null && this.getModBy().equals(castOther.getModBy()) ) )
&& ( (this.getModDt()==castOther.getModDt()) || ( this.getModDt()!=null && castOther.getModDt()!=null && this.getModDt().equals(castOther.getModDt()) ) );
  }
  
   @Override
  public int hashCode() {
        int result = 17;
        
        result = 37 * result + ( getId() == null ? 0 : this.getId().hashCode() );
        
        
        result = 37 * result + ( getOtherTx() == null ? 0 : this.getOtherTx().hashCode() );
        result = 37 * result + ( getCreateBy() == null ? 0 : this.getCreateBy().hashCode() );
        result = 37 * result + ( getCreateDt() == null ? 0 : this.getCreateDt().hashCode() );
        result = 37 * result + ( getModBy() == null ? 0 : this.getModBy().hashCode() );
        result = 37 * result + ( getModDt() == null ? 0 : this.getModDt().hashCode() );
        return result;
  }   

}


