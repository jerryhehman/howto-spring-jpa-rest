package com.jerryhehman.howto.springjparest.domain;


import java.math.BigDecimal;
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
@Table(name="PERSON_ADDRESS"
)
@SuppressWarnings("serial")
public class PersonAddress implements java.io.Serializable {


    private PersonAddressId id;
    private Person person;
    private String streetLine1Tx;
    private String streetLine2Tx;
    private String cityTx;
    private String stateAb;
    private String zipCd;
    private String zipSfxCd;
    private String fipsCd;
    private String cntryCd;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private String createBy;
    private Date createDt;
    private String modBy;
    private Date modDt;

   public PersonAddress() {
   }

	
   public PersonAddress(PersonAddressId id, Person person, String cntryCd) {
       this.id = id;
       this.person = person;
       this.cntryCd = cntryCd;
   }
   public PersonAddress(PersonAddressId id, Person person, String streetLine1Tx, String streetLine2Tx, String cityTx, String stateAb, String zipCd, String zipSfxCd, String fipsCd, String cntryCd, BigDecimal latitude, BigDecimal longitude, String createBy, Date createDt, String modBy, Date modDt) {
      this.id = id;
      this.person = person;
      this.streetLine1Tx = streetLine1Tx;
      this.streetLine2Tx = streetLine2Tx;
      this.cityTx = cityTx;
      this.stateAb = stateAb;
      this.zipCd = zipCd;
      this.zipSfxCd = zipSfxCd;
      this.fipsCd = fipsCd;
      this.cntryCd = cntryCd;
      this.latitude = latitude;
      this.longitude = longitude;
      this.createBy = createBy;
      this.createDt = createDt;
      this.modBy = modBy;
      this.modDt = modDt;
   }
  
    @EmbeddedId

   
   @AttributeOverrides( {
       @AttributeOverride(name="personId", column=@Column(name="PERSON_ID", nullable=false, length=12) ), 
       @AttributeOverride(name="addrUsgCd", column=@Column(name="ADDR_USG_CD", nullable=false, length=1) ) } )
   public PersonAddressId getId() {
       return this.id;
   }
   
   public void setId(PersonAddressId id) {
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

   
   @Column(name="STREET_LINE1_TX", length=60)
   public String getStreetLine1Tx() {
       return this.streetLine1Tx;
   }
   
   public void setStreetLine1Tx(String streetLine1Tx) {
       this.streetLine1Tx = streetLine1Tx;
   }

   
   @Column(name="STREET_LINE2_TX", length=60)
   public String getStreetLine2Tx() {
       return this.streetLine2Tx;
   }
   
   public void setStreetLine2Tx(String streetLine2Tx) {
       this.streetLine2Tx = streetLine2Tx;
   }

   
   @Column(name="CITY_TX", length=30)
   public String getCityTx() {
       return this.cityTx;
   }
   
   public void setCityTx(String cityTx) {
       this.cityTx = cityTx;
   }

   
   @Column(name="STATE_AB", length=2)
   public String getStateAb() {
       return this.stateAb;
   }
   
   public void setStateAb(String stateAb) {
       this.stateAb = stateAb;
   }

   
   @Column(name="ZIP_CD", length=5)
   public String getZipCd() {
       return this.zipCd;
   }
   
   public void setZipCd(String zipCd) {
       this.zipCd = zipCd;
   }

   
   @Column(name="ZIP_SFX_CD", length=4)
   public String getZipSfxCd() {
       return this.zipSfxCd;
   }
   
   public void setZipSfxCd(String zipSfxCd) {
       this.zipSfxCd = zipSfxCd;
   }

   
   @Column(name="FIPS_CD", length=5)
   public String getFipsCd() {
       return this.fipsCd;
   }
   
   public void setFipsCd(String fipsCd) {
       this.fipsCd = fipsCd;
   }

   
   @Column(name="CNTRY_CD", nullable=false, length=2)
   public String getCntryCd() {
       return this.cntryCd;
   }
   
   public void setCntryCd(String cntryCd) {
       this.cntryCd = cntryCd;
   }

   
   @Column(name="LATITUDE", precision=10, scale=5)
   public BigDecimal getLatitude() {
       return this.latitude;
   }
   
   public void setLatitude(BigDecimal latitude) {
       this.latitude = latitude;
   }

   
   @Column(name="LONGITUDE", precision=10, scale=5)
   public BigDecimal getLongitude() {
       return this.longitude;
   }
   
   public void setLongitude(BigDecimal longitude) {
       this.longitude = longitude;
   }

   
   @Column(name="CREATE_BY", length=30)
   public String getCreateBy() {
       return this.createBy;
   }
   
   public void setCreateBy(String createBy) {
       this.createBy = createBy;
   }

   @Temporal(TemporalType.TIMESTAMP)
   @Column(name="CREATE_DT", length=23)
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
     buffer.append("streetLine1Tx").append("='").append(getStreetLine1Tx()).append("' ");			
     buffer.append("streetLine2Tx").append("='").append(getStreetLine2Tx()).append("' ");			
     buffer.append("cityTx").append("='").append(getCityTx()).append("' ");			
     buffer.append("stateAb").append("='").append(getStateAb()).append("' ");			
     buffer.append("zipCd").append("='").append(getZipCd()).append("' ");			
     buffer.append("zipSfxCd").append("='").append(getZipSfxCd()).append("' ");			
     buffer.append("fipsCd").append("='").append(getFipsCd()).append("' ");			
     buffer.append("cntryCd").append("='").append(getCntryCd()).append("' ");			
     buffer.append("latitude").append("='").append(getLatitude()).append("' ");			
     buffer.append("longitude").append("='").append(getLongitude()).append("' ");			
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
		 if ( !(other instanceof PersonAddress) ) return false;
		 PersonAddress castOther = ( PersonAddress ) other; 
        
		 return ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) )
&& ( (this.getStreetLine1Tx()==castOther.getStreetLine1Tx()) || ( this.getStreetLine1Tx()!=null && castOther.getStreetLine1Tx()!=null && this.getStreetLine1Tx().equals(castOther.getStreetLine1Tx()) ) )
&& ( (this.getStreetLine2Tx()==castOther.getStreetLine2Tx()) || ( this.getStreetLine2Tx()!=null && castOther.getStreetLine2Tx()!=null && this.getStreetLine2Tx().equals(castOther.getStreetLine2Tx()) ) )
&& ( (this.getCityTx()==castOther.getCityTx()) || ( this.getCityTx()!=null && castOther.getCityTx()!=null && this.getCityTx().equals(castOther.getCityTx()) ) )
&& ( (this.getStateAb()==castOther.getStateAb()) || ( this.getStateAb()!=null && castOther.getStateAb()!=null && this.getStateAb().equals(castOther.getStateAb()) ) )
&& ( (this.getZipCd()==castOther.getZipCd()) || ( this.getZipCd()!=null && castOther.getZipCd()!=null && this.getZipCd().equals(castOther.getZipCd()) ) )
&& ( (this.getZipSfxCd()==castOther.getZipSfxCd()) || ( this.getZipSfxCd()!=null && castOther.getZipSfxCd()!=null && this.getZipSfxCd().equals(castOther.getZipSfxCd()) ) )
&& ( (this.getFipsCd()==castOther.getFipsCd()) || ( this.getFipsCd()!=null && castOther.getFipsCd()!=null && this.getFipsCd().equals(castOther.getFipsCd()) ) )
&& ( (this.getCntryCd()==castOther.getCntryCd()) || ( this.getCntryCd()!=null && castOther.getCntryCd()!=null && this.getCntryCd().equals(castOther.getCntryCd()) ) )
&& ( (this.getLatitude()==castOther.getLatitude()) || ( this.getLatitude()!=null && castOther.getLatitude()!=null && this.getLatitude().equals(castOther.getLatitude()) ) )
&& ( (this.getLongitude()==castOther.getLongitude()) || ( this.getLongitude()!=null && castOther.getLongitude()!=null && this.getLongitude().equals(castOther.getLongitude()) ) )
&& ( (this.getCreateBy()==castOther.getCreateBy()) || ( this.getCreateBy()!=null && castOther.getCreateBy()!=null && this.getCreateBy().equals(castOther.getCreateBy()) ) )
&& ( (this.getCreateDt()==castOther.getCreateDt()) || ( this.getCreateDt()!=null && castOther.getCreateDt()!=null && this.getCreateDt().equals(castOther.getCreateDt()) ) )
&& ( (this.getModBy()==castOther.getModBy()) || ( this.getModBy()!=null && castOther.getModBy()!=null && this.getModBy().equals(castOther.getModBy()) ) )
&& ( (this.getModDt()==castOther.getModDt()) || ( this.getModDt()!=null && castOther.getModDt()!=null && this.getModDt().equals(castOther.getModDt()) ) );
  }
  
   @Override
  public int hashCode() {
        int result = 17;
        
        result = 37 * result + ( getId() == null ? 0 : this.getId().hashCode() );
        
        result = 37 * result + ( getStreetLine1Tx() == null ? 0 : this.getStreetLine1Tx().hashCode() );
        result = 37 * result + ( getStreetLine2Tx() == null ? 0 : this.getStreetLine2Tx().hashCode() );
        result = 37 * result + ( getCityTx() == null ? 0 : this.getCityTx().hashCode() );
        result = 37 * result + ( getStateAb() == null ? 0 : this.getStateAb().hashCode() );
        result = 37 * result + ( getZipCd() == null ? 0 : this.getZipCd().hashCode() );
        result = 37 * result + ( getZipSfxCd() == null ? 0 : this.getZipSfxCd().hashCode() );
        result = 37 * result + ( getFipsCd() == null ? 0 : this.getFipsCd().hashCode() );
        result = 37 * result + ( getCntryCd() == null ? 0 : this.getCntryCd().hashCode() );
        result = 37 * result + ( getLatitude() == null ? 0 : this.getLatitude().hashCode() );
        result = 37 * result + ( getLongitude() == null ? 0 : this.getLongitude().hashCode() );
        result = 37 * result + ( getCreateBy() == null ? 0 : this.getCreateBy().hashCode() );
        result = 37 * result + ( getCreateDt() == null ? 0 : this.getCreateDt().hashCode() );
        result = 37 * result + ( getModBy() == null ? 0 : this.getModBy().hashCode() );
        result = 37 * result + ( getModDt() == null ? 0 : this.getModDt().hashCode() );
        return result;
  }   


}


