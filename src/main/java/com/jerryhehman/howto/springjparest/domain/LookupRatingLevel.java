package com.jerryhehman.howto.springjparest.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LOOKUP_RATING_LEVEL"
)
@SuppressWarnings("serial")
public class LookupRatingLevel implements java.io.Serializable {


    private Short ratingCd;
    private String ratingTx;

   public LookupRatingLevel() {
   }

	
public LookupRatingLevel(Short ratingCd, String ratingTx) {
	super();
	this.ratingCd = ratingCd;
	this.ratingTx = ratingTx;
}


@Id 
@Column(name="RATING_CD", nullable=false)
public Short getRatingCd() {
	return ratingCd;
}

public void setRatingCd(Short ratingCd) {
	this.ratingCd = ratingCd;
}

@Column(name="RATING_TX", nullable=false, length=32)
public String getRatingTx() {
	return ratingTx;
}

public void setRatingTx(String ratingTx) {
	this.ratingTx = ratingTx;
}


@Override
public String toString() {
	return "LookupRating [ratingCd=" + ratingCd + ", ratingTx=" + ratingTx + "]";
}


@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((ratingCd == null) ? 0 : ratingCd.hashCode());
	result = prime * result + ((ratingTx == null) ? 0 : ratingTx.hashCode());
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
	LookupRatingLevel other = (LookupRatingLevel) obj;
	if (ratingCd == null) {
		if (other.ratingCd != null)
			return false;
	} else if (!ratingCd.equals(other.ratingCd))
		return false;
	if (ratingTx == null) {
		if (other.ratingTx != null)
			return false;
	} else if (!ratingTx.equals(other.ratingTx))
		return false;
	return true;
}




}
