package com.jerryhehman.howto.springjparest.eval.domain;

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
@Table(name="PERSON_EVAL"
)
@SuppressWarnings("serial")
public class PersonEval implements java.io.Serializable {


    private PersonEvalId id;
    private Person person;
    private LookupRatingLevel lookupRatingLevel;
    private String otherTx;
    private Short complete;

   public PersonEval() {
   }

	
   public PersonEval(PersonEvalId id, Person person) {
       this.id = id;
       this.person = person;
   }
   public PersonEval(PersonEvalId id, Person person, LookupRatingLevel lookupRatingLevel, String otherTx, Short complete, String createBy, Date createDt, String modBy, Date modDt) {
      this.id = id;
      this.person = person;
      this.lookupRatingLevel = lookupRatingLevel;
      this.otherTx = otherTx;
      this.complete = complete;
   }
  
    @EmbeddedId

   
   @AttributeOverrides( {
       @AttributeOverride(name="personId", column=@Column(name="PERSON_ID", nullable=false, length=12) ), 
       @AttributeOverride(name="personEvalId", column=@Column(name="PERSON_EVAL_ID", nullable=false) ) } )
   public PersonEvalId getId() {
       return this.id;
   }
   
   public void setId(PersonEvalId id) {
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

@ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="RATING_CD")
   public LookupRatingLevel getLookupRatingLevel() {
       return this.lookupRatingLevel;
   }
   
   public void setLookupRatingLevel(LookupRatingLevel lookupRatingLevel) {
       this.lookupRatingLevel = lookupRatingLevel;
   }
   
   @Column(name="OTHER_TX", length=1024)
   public String getOtherTx() {
       return this.otherTx;
   }
   
   public void setOtherTx(String otherTx) {
       this.otherTx = otherTx;
   }

   
   @Column(name="COMPLETE")
   public Short getComplete() {
	return complete;
}


public void setComplete(Short complete) {
	this.complete = complete;
}


@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((complete == null) ? 0 : complete.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((lookupRatingLevel == null) ? 0 : lookupRatingLevel.hashCode());
	result = prime * result + ((otherTx == null) ? 0 : otherTx.hashCode());
	result = prime * result + ((person == null) ? 0 : person.hashCode());
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
	PersonEval other = (PersonEval) obj;
	if (complete == null) {
		if (other.complete != null)
			return false;
	} else if (!complete.equals(other.complete))
		return false;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	if (lookupRatingLevel == null) {
		if (other.lookupRatingLevel != null)
			return false;
	} else if (!lookupRatingLevel.equals(other.lookupRatingLevel))
		return false;
	if (otherTx == null) {
		if (other.otherTx != null)
			return false;
	} else if (!otherTx.equals(other.otherTx))
		return false;
	if (person == null) {
		if (other.person != null)
			return false;
	} else if (!person.equals(other.person))
		return false;
	return true;
}


@Override
public String toString() {
	return "PersonEval [id=" + id + ", person=" + person + ", lookupRatingLevel=" + lookupRatingLevel + ", otherTx="
			+ otherTx + ", complete=" + complete + "]";
}


 

}


