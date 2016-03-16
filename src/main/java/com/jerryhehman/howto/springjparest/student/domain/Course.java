package com.jerryhehman.howto.springjparest.student.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COURSE")
@SuppressWarnings("serial")
public class Course implements java.io.Serializable {

private Integer courseId;
private String courseNm;
public Course() {
}
public Course(Integer courseId, String courseNm) {
	super();
	this.courseId = courseId;
	this.courseNm = courseNm;
}

@Id 
@Column(name="COURSE_ID", nullable=false)
public Integer getCourseId() {
	return courseId;
}
public void setCourseId(Integer courseId) {
	this.courseId = courseId;
}

@Column(name="COURSE_NM", length=70)
public String getCourseNm() {
	return courseNm;
}
public void setCourseNm(String courseNm) {
	this.courseNm = courseNm;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((courseId == null) ? 0 : courseId.hashCode());
	result = prime * result + ((courseNm == null) ? 0 : courseNm.hashCode());
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
	Course other = (Course) obj;
	if (courseId == null) {
		if (other.courseId != null)
			return false;
	} else if (!courseId.equals(other.courseId))
		return false;
	if (courseNm == null) {
		if (other.courseNm != null)
			return false;
	} else if (!courseNm.equals(other.courseNm))
		return false;
	return true;
}
@Override
public String toString() {
	return "Course [courseId=" + courseId + ", courseNm=" + courseNm + "]";
}



}
