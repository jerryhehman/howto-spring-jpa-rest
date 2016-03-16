package com.jerryhehman.howto.springjparest.student.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="STATE"
)
@SuppressWarnings("serial")
public class State implements java.io.Serializable {

private String stateCd;
private String stateNm;

public State() {
}

public State(String stateCd, String stateNm) {
	super();
	this.stateCd = stateCd;
	this.stateNm = stateNm;
}

@Id 
@Column(name="STATE_CD", nullable=false, length=2)
public String getStateCd() {
	return stateCd;
}

public void setStateCd(String stateCd) {
	this.stateCd = stateCd;
}

@Column(name="STATE_NM", nullable=false, length=50)
public String getStateNm() {
	return stateNm;
}

public void setStateNm(String stateNm) {
	this.stateNm = stateNm;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((stateCd == null) ? 0 : stateCd.hashCode());
	result = prime * result + ((stateNm == null) ? 0 : stateNm.hashCode());
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
	State other = (State) obj;
	if (stateCd == null) {
		if (other.stateCd != null)
			return false;
	} else if (!stateCd.equals(other.stateCd))
		return false;
	if (stateNm == null) {
		if (other.stateNm != null)
			return false;
	} else if (!stateNm.equals(other.stateNm))
		return false;
	return true;
}

@Override
public String toString() {
	return "State [stateCd=" + stateCd + ", stateNm=" + stateNm + "]";
}



}
