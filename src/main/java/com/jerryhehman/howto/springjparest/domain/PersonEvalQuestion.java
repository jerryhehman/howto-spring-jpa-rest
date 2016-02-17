package com.jerryhehman.howto.springjparest.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="PERSON_EVAL_QUESTION"
)
@SuppressWarnings("serial")
public class PersonEvalQuestion implements java.io.Serializable {


    private Integer persEvalQuestionId;
    private String questionName;
    private String questionTx;
    private Integer questionOrder;
    private Date questionBegDt;
    private Date questionEndDt;

   public PersonEvalQuestion() {
   }

	
  
    public PersonEvalQuestion(Integer persEvalQuestionId, String questionName, String questionTx, Integer questionOrder,
		Date questionBegDt, Date questionEndDt) {
	super();
	this.persEvalQuestionId = persEvalQuestionId;
	this.questionName = questionName;
	this.questionTx = questionTx;
	this.questionOrder = questionOrder;
	this.questionBegDt = questionBegDt;
	this.questionEndDt = questionEndDt;
}



	@Id 
	@Column(name="PERS_EVAL_QUESTION_ID", nullable=false)
	public Integer getPersEvalQuestionId() {
		return persEvalQuestionId;
	}

	public void setPersEvalQuestionId(Integer persEvalQuestionId) {
		this.persEvalQuestionId = persEvalQuestionId;
	}

   @Column(name="QUESTION_NAME", nullable=false, length=32)
   public String getQuestionName() {
       return this.questionName;
   }
   
   public void setQuestionName(String questionName) {
       this.questionName = questionName;
   }

   
   @Column(name="QUESTION_TX", nullable=false)
   public String getQuestionTx() {
       return this.questionTx;
   }
   
   public void setQuestionTx(String questionTx) {
       this.questionTx = questionTx;
   }

   
   @Column(name="QUESTION_ORDER", nullable=false)
   public Integer getQuestionOrder() {
       return this.questionOrder;
   }
   
   public void setQuestionOrder(Integer questionOrder) {
       this.questionOrder = questionOrder;
   }

   @Temporal(TemporalType.DATE)
   @Column(name="QUESTION_BEG_DT", nullable=false, length=10)
   public Date getQuestionBegDt() {
       return this.questionBegDt;
   }
   
   public void setQuestionBegDt(Date questionBegDt) {
       this.questionBegDt = questionBegDt;
   }

   @Temporal(TemporalType.DATE)
   @Column(name="QUESTION_END_DT", nullable=false, length=10)
   public Date getQuestionEndDt() {
       return this.questionEndDt;
   }
   
   public void setQuestionEndDt(Date questionEndDt) {
       this.questionEndDt = questionEndDt;
   }

   

   /**
    * toString
    * @return String
    */
    @Override
    public String toString() {
	  StringBuilder buffer = new StringBuilder();

     buffer.append(getClass().getName()).append("@").append(Integer.toHexString(hashCode())).append(" [");
     buffer.append("schEvalQuestionId").append("='").append(getPersEvalQuestionId()).append("' ");			
     buffer.append("questionName").append("='").append(getQuestionName()).append("' ");			
     buffer.append("questionTx").append("='").append(getQuestionTx()).append("' ");			
     buffer.append("questionOrder").append("='").append(getQuestionOrder()).append("' ");			
     buffer.append("questionBegDt").append("='").append(getQuestionBegDt()).append("' ");			
     buffer.append("questionEndDt").append("='").append(getQuestionEndDt()).append("' ");			
     buffer.append("]");
     
     return buffer.toString();
    }

   @Override
   public boolean equals(Object other) {
        if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof PersonEvalQuestion) ) return false;
		 PersonEvalQuestion castOther = ( PersonEvalQuestion ) other; 
        
		 return ( (this.getPersEvalQuestionId()==castOther.getPersEvalQuestionId()) || ( this.getPersEvalQuestionId()!=null && castOther.getPersEvalQuestionId()!=null && this.getPersEvalQuestionId().equals(castOther.getPersEvalQuestionId()) ) )
&& ( (this.getQuestionName()==castOther.getQuestionName()) || ( this.getQuestionName()!=null && castOther.getQuestionName()!=null && this.getQuestionName().equals(castOther.getQuestionName()) ) )
&& ( (this.getQuestionTx()==castOther.getQuestionTx()) || ( this.getQuestionTx()!=null && castOther.getQuestionTx()!=null && this.getQuestionTx().equals(castOther.getQuestionTx()) ) )
&& ( (this.getQuestionOrder()==castOther.getQuestionOrder()) || ( this.getQuestionOrder()!=null && castOther.getQuestionOrder()!=null && this.getQuestionOrder().equals(castOther.getQuestionOrder()) ) )
&& ( (this.getQuestionBegDt()==castOther.getQuestionBegDt()) || ( this.getQuestionBegDt()!=null && castOther.getQuestionBegDt()!=null && this.getQuestionBegDt().equals(castOther.getQuestionBegDt()) ) )
&& ( (this.getQuestionEndDt()==castOther.getQuestionEndDt()) || ( this.getQuestionEndDt()!=null && castOther.getQuestionEndDt()!=null && this.getQuestionEndDt().equals(castOther.getQuestionEndDt()) ) );

  }
  
   @Override
  public int hashCode() {
        int result = 17;
        
        result = 37 * result + ( getPersEvalQuestionId() == null ? 0 : this.getPersEvalQuestionId().hashCode() );
        result = 37 * result + ( getQuestionName() == null ? 0 : this.getQuestionName().hashCode() );
        result = 37 * result + ( getQuestionTx() == null ? 0 : this.getQuestionTx().hashCode() );
        result = 37 * result + ( getQuestionOrder() == null ? 0 : this.getQuestionOrder().hashCode() );
        result = 37 * result + ( getQuestionBegDt() == null ? 0 : this.getQuestionBegDt().hashCode() );
        result = 37 * result + ( getQuestionEndDt() == null ? 0 : this.getQuestionEndDt().hashCode() );
        return result;
  }   


}


