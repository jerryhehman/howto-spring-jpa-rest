package com.jerryhehman.howto.springjparest.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LOOKUP_MARITAL_STATUS"
)
@SuppressWarnings("serial")
public class LookupMaritalStatus implements java.io.Serializable {


    private String marStatusCd;
    private String marStatusTx;

   public LookupMaritalStatus() {
   }

	
public LookupMaritalStatus(String marStatusCd, String marStatusTx) {
	super();
	this.marStatusCd = marStatusCd;
	this.marStatusTx = marStatusTx;
}


@Id 
@Column(name="MAR_STATUS_CD", nullable=false, length=1)
public String getMarStatusCd() {
	return marStatusCd;
}

public void setMarStatusCd(String marStatusCd) {
	this.marStatusCd = marStatusCd;
}

@Column(name="MAR_STATUS_TX", nullable=false, length=32)
public String getMarStatusTx() {
	return marStatusTx;
}

public void setMarStatusTx(String marStatusTx) {
	this.marStatusTx = marStatusTx;
}


@Override
public String toString() {
	return "LookupMaritalStatus [marStatusCd=" + marStatusCd + ", marStatusTx=" + marStatusTx + "]";
}


@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((marStatusCd == null) ? 0 : marStatusCd.hashCode());
	result = prime * result + ((marStatusTx == null) ? 0 : marStatusTx.hashCode());
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
	LookupMaritalStatus other = (LookupMaritalStatus) obj;
	if (marStatusCd == null) {
		if (other.marStatusCd != null)
			return false;
	} else if (!marStatusCd.equals(other.marStatusCd))
		return false;
	if (marStatusTx == null) {
		if (other.marStatusTx != null)
			return false;
	} else if (!marStatusTx.equals(other.marStatusTx))
		return false;
	return true;
}




}
