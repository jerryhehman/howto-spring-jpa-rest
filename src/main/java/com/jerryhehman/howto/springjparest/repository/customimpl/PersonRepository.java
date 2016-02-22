package com.jerryhehman.howto.springjparest.repository.customimpl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.jerryhehman.howto.springjparest.domain.Person;
import com.jerryhehman.howto.springjparest.repository.BasePagingAndSortingReadOnlyRepository;

/**
 * Repository For Person requests.
 * @author Jerry Hehman
 *
 */
@RepositoryRestResource
public interface PersonRepository extends BasePagingAndSortingReadOnlyRepository<Person, String>, PersonRepositoryCustom {
	/**
	 * Returns the Person and only the delivery school address.
	 * @param personId - The school ID of the desired school.
	 * @return - Person object with a single entry, for the Delivery address, in the Person.personAddresses property. 
	 */
	@Query("SELECT p FROM Person p JOIN FETCH p.personAddresses pa WHERE pa.id.addrUsgCd = 'D' AND p.personId = :personId")
	Person findDeliveryAddressByPersonId(@Param("personId") String personId);
	
	/**
	 * Returns Persons that match the given ZIP Code prefix
	 * @param zipCdPrefix - The ZIP code prefix. Should be between 3 and 5 digits.
	 * @return - Person object with a single entry, for the Delivery address, in the Person.personAddresses property. 
	 */
	@Query(value = "SELECT p FROM Person p JOIN FETCH p.personAddresses pa WHERE pa.id.addrUsgCd = 'D' AND pa.zipCd like :zipCdPrefix%",
			countQuery = "SELECT COUNT(p) FROM Person p JOIN p.personAddresses pa WHERE pa.id.addrUsgCd = 'D' AND pa.zipCd like :zipCdPrefix%")
	Page<Person> findDeliveryAddressByZipPrefix(@Param("zipCdPrefix") String zipCdPrefix, Pageable pageable);

	/**
	 * Retrieve list of Schools by ZIP code prefix. Spring Data auto-generates the query based on the name of the method.
	 * 
	 * In addition to the problem with needing to include the "%" on the zipCdPrefix parameter, this method also has the problem
	 * of returning duplicate records if the person has multiple addresses that meet the criteria.
	 * 
	 * @param zipCdPrefix - a full ZIP code or ZIP code prefix. For example, if zipCd=1234, the method will return all schools with a ZIP 
	 * code that begins with 1234.The ZIP Code Prefix must end with a "%", e.g. zipCdPrefix=123%, or be a full 5 digits. We cannot add a "%" 
	 * after the parameter in the Named Query since that is an invalid character for a Named Query. If requested via a URL, such as a REST request,
	 * the "%" needs to be encoded as "%25". This requirement makes this method an undesirable solution.
	 * 
	 * @return - List of Schools matching the given ZIP code prefix
	 */
	Page<Person> findByPersonAddressesZipCdLike(@Param("zipCd") String zipCd, Pageable pageable);


	/**
	 * Yet another method to return a list of Persons that match the given ZIP Code prefix. This method uses a Named Query -- the name
	 * of the method matches the name of the named query (following the object name "Person."): Person.zipCdPrefixSearch.
	 * 
	 * @param zipCdPrefix - a full ZIP code or ZIP code prefix. For example, if zipCd=1234, the method will return all schools with a ZIP 
	 * code that begins with 1234.The ZIP Code Prefix must end with a "%", e.g. zipCdPrefix=123%, or be a full 5 digits. We cannot add a "%" 
	 * after the parameter in the Named Query since that is an invalid character for a Named Query. If requested via a URL, such as a REST request,
	 * the "%" needs to be encoded as "%25". This requirement makes this method an undesirable solution.
	 * 
	 * @return
	 */
	List<Person> zipCdPrefixSearch(@Param("zipCdPrefix") String zipCdPrefix);
}
