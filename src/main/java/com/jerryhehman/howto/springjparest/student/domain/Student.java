package com.jerryhehman.howto.springjparest.student.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="STUDENT")
@SuppressWarnings("serial")
public class Student implements java.io.Serializable {

private Integer studentId;
private String firstName;
private String lastName;
private Set<StudentAddress> studentAddresses = new HashSet<StudentAddress>(0);
private Set<Course> courses = new HashSet<Course>(0);

public Student() {
}

public Student(Integer studentId, String firstName, String lastName, Set<StudentAddress> studentAddresses,
		Set<Course> courses) {
	super();
	this.studentId = studentId;
	this.firstName = firstName;
	this.lastName = lastName;
	this.studentAddresses = studentAddresses;
	this.courses = courses;
}


@Id 
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="STUDENT_ID", nullable=false)
public Integer getStudentId() {
	return studentId;
}

public void setStudentId(Integer studentId) {
	this.studentId = studentId;
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

@OneToMany(fetch=FetchType.LAZY, mappedBy="student")
//@JsonManagedReference
public Set<StudentAddress> getStudentAddresses() {
	return studentAddresses;
}

public void setStudentAddresses(Set<StudentAddress> studentAddresses) {
	this.studentAddresses = studentAddresses;
}

@ManyToMany
@JoinTable(name = "STUDENT_COURSE", joinColumns = { @JoinColumn(name = "student_id") }, inverseJoinColumns = { @JoinColumn(name = "course_id") })
public Set<Course> getCourses() {
	return courses;
}

public void setCourses(Set<Course> courses) {
	this.courses = courses;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
	result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
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
	Student other = (Student) obj;
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
	if (studentId == null) {
		if (other.studentId != null)
			return false;
	} else if (!studentId.equals(other.studentId))
		return false;
	return true;
}

@Override
public String toString() {
	return "Student [studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName
			+ ", courses=" + courses + "]";
}


}
