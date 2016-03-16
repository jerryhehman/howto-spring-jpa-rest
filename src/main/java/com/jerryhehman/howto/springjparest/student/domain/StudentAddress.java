package com.jerryhehman.howto.springjparest.student.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="STUDENT_ADDRESS")
@SuppressWarnings("serial")
public class StudentAddress implements java.io.Serializable {

private StudentAddressId studentAddressId;
private Student student;
private String streetAddress;
private String cityTx;
private State state;
private String zipCd;

public StudentAddress() {
}

public StudentAddress(StudentAddressId studentAddressId, Student student, String streetAddress, String cityTx, State state,
		String zipCd) {
	super();
	this.studentAddressId = studentAddressId;
	this.student = student;
	this.streetAddress = streetAddress;
	this.cityTx = cityTx;
	this.state = state;
	this.zipCd = zipCd;
}

@EmbeddedId
@AttributeOverrides( {
   @AttributeOverride(name="studentId", column=@Column(name="STUDENT_ID", nullable=false) ), 
   @AttributeOverride(name="addressTypeCd", column=@Column(name="ADDRESS_TYPE_CD", nullable=false, length=2) ) } )
public StudentAddressId getStudentAddressId() {
	return studentAddressId;
}

public void setStudentAddressId(StudentAddressId studentAddressId) {
	this.studentAddressId = studentAddressId;
}

@JsonBackReference
@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="STUDENT_ID", nullable=false, insertable=false, updatable=false)
public Student getStudent() {
	return student;
}

public void setStudent(Student student) {
	this.student = student;
}

@Column(name="STREET_ADDRESS", length=50)
public String getStreetAddress() {
	return streetAddress;
}

public void setStreetAddress(String streetAddress) {
	this.streetAddress = streetAddress;
}

@Column(name="CITY_TX", length=50)
public String getCityTx() {
	return cityTx;
}

public void setCityTx(String cityTx) {
	this.cityTx = cityTx;
}

@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="STATE_CD")
public State getState() {
	return state;
}

public void setState(State state) {
	this.state = state;
}

@Column(name="ZIP_CD", length=5)
public String getZipCd() {
	return zipCd;
}

public void setZipCd(String zipCd) {
	this.zipCd = zipCd;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((cityTx == null) ? 0 : cityTx.hashCode());
	result = prime * result + ((state == null) ? 0 : state.hashCode());
	result = prime * result + ((streetAddress == null) ? 0 : streetAddress.hashCode());
	result = prime * result + ((studentAddressId == null) ? 0 : studentAddressId.hashCode());
	result = prime * result + ((zipCd == null) ? 0 : zipCd.hashCode());
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
	StudentAddress other = (StudentAddress) obj;
	if (cityTx == null) {
		if (other.cityTx != null)
			return false;
	} else if (!cityTx.equals(other.cityTx))
		return false;
	if (state == null) {
		if (other.state != null)
			return false;
	} else if (!state.equals(other.state))
		return false;
	if (streetAddress == null) {
		if (other.streetAddress != null)
			return false;
	} else if (!streetAddress.equals(other.streetAddress))
		return false;
	if (studentAddressId == null) {
		if (other.studentAddressId != null)
			return false;
	} else if (!studentAddressId.equals(other.studentAddressId))
		return false;
	if (zipCd == null) {
		if (other.zipCd != null)
			return false;
	} else if (!zipCd.equals(other.zipCd))
		return false;
	return true;
}

@Override
public String toString() {
	return "StudentAddress [studentAddressId=" + studentAddressId + ", streetAddress="
			+ streetAddress + ", cityTx=" + cityTx + ", state=" + state + ", zipCd=" + zipCd + "]";
}



}
