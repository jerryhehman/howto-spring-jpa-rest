package com.jerryhehman.howto.springjparest.repository.customimpl;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import com.jerryhehman.howto.springjparest.domain.Person;


/**
 * Defines methods that contain custom-implementations of School requests. To be found by Spring, the Repository interface
 * should extend this interface. The Implementation class should implement this interface and should be named using the
 * name of the interface (e.g. PersonRepository) + "Impl".
 * @author Jerry Hehman
 *
 */
public interface PersonRepositoryCustom {
	
	/**
	 * Retrieve list of Schools by ZIP code prefix. Finds all schools whose ZIP code begins with zipCdPrefix
	 * @param zipCdPrefix - ZIP Code prefix. Must be 3-5 digits long.
	 * @param pageable
	 * @return - List of Schools
	 */
	List<Person> searchZipCdPrefix(@Param("zipCdPrefix") String zipCdPrefix, Pageable pageable);
}
