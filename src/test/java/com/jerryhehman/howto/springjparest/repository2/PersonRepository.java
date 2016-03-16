package com.jerryhehman.howto.springjparest.repository2;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.jerryhehman.howto.springjparest.eval.domain.Person;

/**
 * Repository For Person requests.
 * @author Jerry Hehman
 *
 */
@RepositoryRestResource
public interface PersonRepository extends Repository<Person, String>//, PersonRepositoryCustom
{	

	/**
	 * Returns the Person and only the delivery school address.
	 * @param personId - The school ID of the desired school.
	 * @return - Person object with a single entry, for the Delivery address, in the Person.personAddresses property. 
	 */
	//@Query("SELECT p FROM Person p JOIN FETCH p.personAddresses pa WHERE pa.id.addrUsgCd = 'D' AND p.personId = :personId")
	//Person findDeliveryAddressByPersonId(@Param("personId") String personId);
	
	/**
	 * Returns Persons that match the given ZIP Code prefix
	 * @param zipCdPrefix - The ZIP code prefix. Should be between 3 and 5 digits.
	 * @return - Person object with a single entry, for the Delivery address, in the Person.personAddresses property. 
	 */
	//@Query("SELECT p FROM Person p JOIN FETCH p.personAddresses pa WHERE pa.id.addrUsgCd = 'D' AND pa.zipCd like :zipCdPrefix%")
	//List<Person> findDeliveryAddressByZipPrefix(@Param("zipCdPrefix") String zipCdPrefix);

	//@Query("SELECT p FROM Person p JOIN FETCH p.personAddresses pa WHERE pa.id.addrUsgCd = 'D' AND pa.zipCd like :zipCdPrefix%")
	//Page<Person> findDeliveryAddressByZipPrefix(@Param("zipCdPrefix") String zipCdPrefix, Pageable pageable);

	/**
	 * Retrieve list of Schools by ZIP code prefix. Spring Data auto-generates the query based on the name of the method.
	 * @param zipCd - a full ZIP code or ZIP code prefix. For example, if zipCd=1234, the method will return all schools with a ZIP code that begins with 1234. 
	 * @return - List of Schools matching the given ZIP code prefix
	 */
	//Page<Person> findByPersonAddressesZipCdLike(@Param("zipCd") String zipCd, Pageable pageable);

	/**
	 * Yet another method to return a list of Persons that match the given ZIP Code prefix. This method uses a Named Query -- the name
	 * of the method matches the name of the named query (following the object name "Person."): Person.zipCdPrefixSearch.
	 * @param zipCdPrefix
	 * @return
	 */
	//List<Person> zipCdPrefixSearch(@Param("zipCdPrefix") String zipCdPrefix);
}
