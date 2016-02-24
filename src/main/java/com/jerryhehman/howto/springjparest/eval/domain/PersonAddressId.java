package com.jerryhehman.howto.springjparest.eval.domain;


import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@SuppressWarnings("serial")
public class PersonAddressId implements java.io.Serializable {


    private String personId;
    private Character addrUsgCd;

   public PersonAddressId() {
   }

   public PersonAddressId(String personId, Character addrUsgCd) {
      this.personId = personId;
      this.addrUsgCd = addrUsgCd;
   }
  


   @Column(name="SCH_ID", nullable=false, length=12)
   public String getPersonId() {
       return this.personId;
   }
   
   public void setPersonId(String personId) {
       this.personId = personId;
   }


   @Column(name="ADDR_USG_CD", nullable=false, length=1)
   public Character getAddrUsgCd() {
       return this.addrUsgCd;
   }
   
   public void setAddrUsgCd(Character addrUsgCd) {
       this.addrUsgCd = addrUsgCd;
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
     buffer.append("addrUsgCd").append("='").append(getAddrUsgCd()).append("' ");			
     buffer.append("]");
     
     return buffer.toString();
    }

   @Override
   public boolean equals(Object other) {
        if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof PersonAddressId) ) return false;
		 PersonAddressId castOther = ( PersonAddressId ) other; 
        
		 return ( (this.getPersonId()==castOther.getPersonId()) || ( this.getPersonId()!=null && castOther.getPersonId()!=null && this.getPersonId().equals(castOther.getPersonId()) ) )
&& ( (this.getAddrUsgCd()==castOther.getAddrUsgCd()) || ( this.getAddrUsgCd()!=null && castOther.getAddrUsgCd()!=null && this.getAddrUsgCd().equals(castOther.getAddrUsgCd()) ) );
  }
  
   @Override
  public int hashCode() {
        int result = 17;
        
        result = 37 * result + ( getPersonId() == null ? 0 : this.getPersonId().hashCode() );
        result = 37 * result + ( getAddrUsgCd() == null ? 0 : this.getAddrUsgCd().hashCode() );
        return result;
  }   


}


