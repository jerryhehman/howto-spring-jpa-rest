package com.jerryhehman.howto.springjparest.domain;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PERSON"
)
@NamedQueries({
	@NamedQuery(name="PERSON.zipCdPrefixSearch", 
			    query="SELECT s FROM Person s JOIN FETCH s.personAddresses sa where sa.id.addrUsgCd = 'D' and sa.zipCd like :zipCdPrefix")
})
@SuppressWarnings("serial")
public class Person implements java.io.Serializable {


    private String personId;
    private String marStatusCd;
    private String firstName;
    private String lastName;
    private Set<PersonAddress> personAddresses = new HashSet<PersonAddress>(0);

   public Person() {
   }

	
   public Person(String personId, String marStatusCd, String firstName, String lastName,
		Set<PersonAddress> personAddresses) {
	super();
	this.personId = personId;
	this.marStatusCd = marStatusCd;
	this.firstName = firstName;
	this.lastName = lastName;
	this.personAddresses = personAddresses;
}


@Id 
@Column(name="PERSON_ID", nullable=false, length=12)
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


@OneToMany(fetch=FetchType.LAZY, mappedBy="person")
public Set<PersonAddress> getPersonAddresses() {
	return personAddresses;
}


public void setPersonAddresses(Set<PersonAddress> personAddresses) {
	this.personAddresses = personAddresses;
}


@Override
public String toString() {
	return "Person [personId=" + personId + ", marStatusCd=" + marStatusCd + ", firstName=" + firstName + ", lastName="
			+ lastName + ", personAddresses=" + personAddresses + "]";
}


@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
	result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
	result = prime * result + ((marStatusCd == null) ? 0 : marStatusCd.hashCode());
	result = prime * result + ((personAddresses == null) ? 0 : personAddresses.hashCode());
	result = prime * result + ((personId == null) ? 0 : personId.hashCode());
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
	Person other = (Person) obj;
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
	if (marStatusCd == null) {
		if (other.marStatusCd != null)
			return false;
	} else if (!marStatusCd.equals(other.marStatusCd))
		return false;
	if (personAddresses == null) {
		if (other.personAddresses != null)
			return false;
	} else if (!personAddresses.equals(other.personAddresses))
		return false;
	if (personId == null) {
		if (other.personId != null)
			return false;
	} else if (!personId.equals(other.personId))
		return false;
	return true;
}


  


}


