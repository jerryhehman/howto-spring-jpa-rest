package com.jerryhehman.howto.springjparest.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@SuppressWarnings("serial")
public class PersEvalAnswerId implements java.io.Serializable {


    private String personId;
    private Integer personEvalId;
    private Integer persEvalQuestionId;

   public PersEvalAnswerId() {
   }

   public PersEvalAnswerId(String personId, Integer personEvalId, Integer persEvalQuestionId) {
      this.personId = personId;
      this.personEvalId = personEvalId;
      this.persEvalQuestionId = persEvalQuestionId;
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


   @Column(name="PERS_EVAL_QUESTION_ID", nullable=false)
   public Integer getPersEvalQuestionId() {
       return this.persEvalQuestionId;
   }
   
   public void setPersEvalQuestionId(Integer persEvalQuestionId) {
       this.persEvalQuestionId = persEvalQuestionId;
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
     buffer.append("persEvalQuestionId").append("='").append(getPersEvalQuestionId()).append("' ");			
     buffer.append("]");
     
     return buffer.toString();
    }

   @Override
   public boolean equals(Object other) {
        if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof PersEvalAnswerId) ) return false;
		 PersEvalAnswerId castOther = ( PersEvalAnswerId ) other; 
        
		 return ( (this.getPersonId()==castOther.getPersonId()) || ( this.getPersonId()!=null && castOther.getPersonId()!=null && this.getPersonId().equals(castOther.getPersonId()) ) )
&& ( (this.getPersonEvalId()==castOther.getPersonEvalId()) || ( this.getPersonEvalId()!=null && castOther.getPersonEvalId()!=null && this.getPersonEvalId().equals(castOther.getPersonEvalId()) ) )
&& ( (this.getPersEvalQuestionId()==castOther.getPersEvalQuestionId()) || ( this.getPersEvalQuestionId()!=null && castOther.getPersEvalQuestionId()!=null && this.getPersEvalQuestionId().equals(castOther.getPersEvalQuestionId()) ) );
  }
  
   @Override
  public int hashCode() {
        int result = 17;
        
        result = 37 * result + ( getPersonId() == null ? 0 : this.getPersonId().hashCode() );
        result = 37 * result + ( getPersonEvalId() == null ? 0 : this.getPersonEvalId().hashCode() );
        result = 37 * result + ( getPersEvalQuestionId() == null ? 0 : this.getPersEvalQuestionId().hashCode() );
        return result;
  }   


}
