package com.jerryhehman.howto.springjparest.eval.domain;

import javax.persistence.Column;

import javax.persistence.Embeddable;

@Embeddable
@SuppressWarnings("serial")
public class PersonEvalId implements java.io.Serializable { 

    private String personId;
    private Integer personEvalId;

   public PersonEvalId() {
   }

   public PersonEvalId(String personId, Integer personEvalId) {
      this.personId = personId;
      this.personEvalId = personEvalId;
   }
  


   @Column(name="PERSON_ID", nullable=false, length=12)
   public String getPersonId() {
       return this.personId;
   }
   
   public void setPersonId(String personId) {
       this.personId = personId;
   }


   @Column(name="PERSON_EVAL_ID", nullable=false)
   public Integer getPersonEvalId() {
       return this.personEvalId;
   }
   
   public void setPersonEvalId(Integer personEvalId) {
       this.personEvalId = personEvalId;
   }

   /**
    * toString
    * @return String
    */
    @Override
    public String toString() {
	  StringBuilder buffer = new StringBuilder();

     buffer.append(getClass().getName()).append("@").append(Integer.toHexString(hashCode())).append(" [");
     buffer.append("personId").append("='").append(getPersonId()).append("' ");			
     buffer.append("personEvalId").append("='").append(getPersonEvalId()).append("' ");			
     buffer.append("]");
     
     return buffer.toString();
    }

   @Override
   public boolean equals(Object other) {
        if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof PersonEvalId) ) return false;
		 PersonEvalId castOther = ( PersonEvalId ) other; 
        
		 return ( (this.getPersonId()==castOther.getPersonId()) || ( this.getPersonId()!=null && castOther.getPersonId()!=null && this.getPersonId().equals(castOther.getPersonId()) ) )
&& ( (this.getPersonEvalId()==castOther.getPersonEvalId()) || ( this.getPersonEvalId()!=null && castOther.getPersonEvalId()!=null && this.getPersonEvalId().equals(castOther.getPersonEvalId()) ) );
  }
  
   @Override
  public int hashCode() {
        int result = 17;
        
        result = 37 * result + ( getPersonId() == null ? 0 : this.getPersonId().hashCode() );
        result = 37 * result + ( getPersonEvalId() == null ? 0 : this.getPersonEvalId().hashCode() );
        return result;
  }   

}


