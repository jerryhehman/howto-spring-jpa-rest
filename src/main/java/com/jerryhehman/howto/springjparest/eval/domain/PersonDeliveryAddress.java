package com.jerryhehman.howto.springjparest.eval.domain;


import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entity object based on a view defined in the database.
 * @author Jerry Hehman
 *
 */
@Entity
@Table(name="PERSON_DELIVERY_ADDRESS"
)
@SuppressWarnings("serial")
public class PersonDeliveryAddress implements java.io.Serializable {


    private String personId;
    private String marStatusCd;
    private String firstName;
    private String lastName;
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

   public PersonDeliveryAddress() {
   }

	
   
   public PersonDeliveryAddress(String personId, String marStatusCd, String firstName, String lastName,
		String streetLine1Tx, String streetLine2Tx, String cityTx, String stateAb, String zipCd, String zipSfxCd,
		String fipsCd, String cntryCd, BigDecimal latitude, BigDecimal longitude) {
	super();
	this.personId = personId;
	this.marStatusCd = marStatusCd;
	this.firstName = firstName;
	this.lastName = lastName;
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
}


@Id
@Column(name="PERSON_ID")
public String getPersonId() {
	return personId;
}



public void setPersonId(String personId) {
	this.personId = personId;
}



@Column(name="MAR_STATUS_CD", length=1)
public String getMarStatusCd() {
	return marStatusCd;
}



public void setMarStatusCd(String marStatusCd) {
	this.marStatusCd = marStatusCd;
}



@Column(name="FIRST_NAME", length=30)
public String getFirstName() {
	return firstName;
}



public void setFirstName(String firstName) {
	this.firstName = firstName;
}



@Column(name="LAST_NAME", length=30)
public String getLastName() {
	return lastName;
}



public void setLastName(String lastName) {
	this.lastName = lastName;
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



@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((cityTx == null) ? 0 : cityTx.hashCode());
	result = prime * result + ((cntryCd == null) ? 0 : cntryCd.hashCode());
	result = prime * result + ((fipsCd == null) ? 0 : fipsCd.hashCode());
	result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
	result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
	result = prime * result + ((latitude == null) ? 0 : latitude.hashCode());
	result = prime * result + ((longitude == null) ? 0 : longitude.hashCode());
	result = prime * result + ((marStatusCd == null) ? 0 : marStatusCd.hashCode());
	result = prime * result + ((personId == null) ? 0 : personId.hashCode());
	result = prime * result + ((stateAb == null) ? 0 : stateAb.hashCode());
	result = prime * result + ((streetLine1Tx == null) ? 0 : streetLine1Tx.hashCode());
	result = prime * result + ((streetLine2Tx == null) ? 0 : streetLine2Tx.hashCode());
	result = prime * result + ((zipCd == null) ? 0 : zipCd.hashCode());
	result = prime * result + ((zipSfxCd == null) ? 0 : zipSfxCd.hashCode());
	return result;
}



@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	PersonDeliveryAddress other = (PersonDeliveryAddress) obj;
	if (cityTx == null) {
		if (other.cityTx != null)
			return false;
	} else if (!cityTx.equals(other.cityTx))
		return false;
	if (cntryCd == null) {
		if (other.cntryCd != null)
			return false;
	} else if (!cntryCd.equals(other.cntryCd))
		return false;
	if (fipsCd == null) {
		if (other.fipsCd != null)
			return false;
	} else if (!fipsCd.equals(other.fipsCd))
		return false;
	if (firstName == null) {
		if (other.firstName != null)
			return false;
	} else if (!firstName.equals(other.firstName))
		return false;
	if (lastName == null) {
		if (other.lastName != null)
			return false;
	} else if (!lastName.equals(other.lastName))
		return false;
	if (latitude == null) {
		if (other.latitude != null)
			return false;
	} else if (!latitude.equals(other.latitude))
		return false;
	if (longitude == null) {
		if (other.longitude != null)
			return false;
	} else if (!longitude.equals(other.longitude))
		return false;
	if (marStatusCd == null) {
		if (other.marStatusCd != null)
			return false;
	} else if (!marStatusCd.equals(other.marStatusCd))
		return false;
	if (personId == null) {
		if (other.personId != null)
			return false;
	} else if (!personId.equals(other.personId))
		return false;
	if (stateAb == null) {
		if (other.stateAb != null)
			return false;
	} else if (!stateAb.equals(other.stateAb))
		return false;
	if (streetLine1Tx == null) {
		if (other.streetLine1Tx != null)
			return false;
	} else if (!streetLine1Tx.equals(other.streetLine1Tx))
		return false;
	if (streetLine2Tx == null) {
		if (other.streetLine2Tx != null)
			return false;
	} else if (!streetLine2Tx.equals(other.streetLine2Tx))
		return false;
	if (zipCd == null) {
		if (other.zipCd != null)
			return false;
	} else if (!zipCd.equals(other.zipCd))
		return false;
	if (zipSfxCd == null) {
		if (other.zipSfxCd != null)
			return false;
	} else if (!zipSfxCd.equals(other.zipSfxCd))
		return false;
	return true;
}



@Override
public String toString() {
	return "PersonDeliveryAddress [personId=" + personId + ", marStatusCd=" + marStatusCd + ", firstName=" + firstName
			+ ", lastName=" + lastName + ", streetLine1Tx=" + streetLine1Tx + ", streetLine2Tx=" + streetLine2Tx
			+ ", cityTx=" + cityTx + ", stateAb=" + stateAb + ", zipCd=" + zipCd + ", zipSfxCd=" + zipSfxCd
			+ ", fipsCd=" + fipsCd + ", cntryCd=" + cntryCd + ", latitude=" + latitude + ", longitude=" + longitude
			+ "]";
}

   


}


