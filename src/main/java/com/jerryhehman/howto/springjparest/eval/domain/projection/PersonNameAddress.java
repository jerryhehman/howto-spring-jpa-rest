package com.jerryhehman.howto.springjparest.eval.domain.projection;

import java.util.Set;

import org.springframework.data.rest.core.config.Projection;

import com.jerryhehman.howto.springjparest.eval.domain.Person;
import com.jerryhehman.howto.springjparest.eval.domain.PersonAddress;


/**
 * Projection of {@link Person} which includes only the name, id, and addresses.
 * @author Jerry Hehman
 *
 */
@Projection( name = "nameAddress", types = {Person.class})
public interface PersonNameAddress {
	String getPersonId();
	String getFirstName();
	String getLastName();
	Set<PersonAddress> getPersonAddresses();
}
