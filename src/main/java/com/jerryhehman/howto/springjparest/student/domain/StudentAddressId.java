package com.jerryhehman.howto.springjparest.student.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@SuppressWarnings("serial")
public class StudentAddressId implements java.io.Serializable {
private Integer studentId;
private String addressTypeCd;
public StudentAddressId() {
}
public StudentAddressId(Integer studentId, String addressTypeCd) {
	super();
	this.studentId = studentId;
	this.addressTypeCd = addressTypeCd;
}
@Column(name="STUDENT_ID", nullable=false)
public Integer getStudentId() {
	return studentId;
}
public void setStudentId(Integer studentId) {
	this.studentId = studentId;
}
@Column(name="ADDRESS_TYPE_CD", nullable=false, length=2)
public String getAddressTypeCd() {
	return addressTypeCd;
}
public void setAddressTypeCd(String addressTypeCd) {
	this.addressTypeCd = addressTypeCd;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((addressTypeCd == null) ? 0 : addressTypeCd.hashCode());
	result = prime * result + ((studentId == null) ? 0 : studentId.hashCode());
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
	StudentAddressId other = (StudentAddressId) obj;
	if (addressTypeCd == null) {
		if (other.addressTypeCd != null)
			return false;
	} else if (!addressTypeCd.equals(other.addressTypeCd))
		return false;
	if (studentId == null) {
		if (other.studentId != null)
			return false;
	} else if (!studentId.equals(other.studentId))
		return false;
	return true;
}
@Override
public String toString() {
	//return "StudentAddressId [studentId=" + studentId + ", addressTypeCd=" + addressTypeCd + "]";
	return studentId + "_" + addressTypeCd; // Customized so that the REST URL has a simple representation of this composite ID 
}

}
