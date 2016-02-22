package com.jerryhehman.howto.springjparest.repository.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.data.rest.webmvc.RepositorySearchesResource;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.LinkBuilder;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jerryhehman.howto.springjparest.dao.PersonDAO;
import com.jerryhehman.howto.springjparest.domain.Person;

/**
 * This class provides custom functionality for the School REST endpoints that cannot be provided by the Spring-generated functionality of SchoolRepository.
 * 
 *  The class annotation @RequestMapping, along with the BasePathAwareController annotation, ensures that the functionality in this class is available
 *  as REST endpoints in the same path as the Spring-generated endpoints for SchoolRepository.
 *  
 *  This class implements the ResourceProcessor interface and implements the declared method process(), which enables this class to add the endpoints for
 *  the methods in this class to the HATEOAS links.
 *  
 *  This class implements ResourceAssembler and its method, toResource(), which converts the base data to Resource or Resources.
 *  
 *  The REST response for these methods does not include links. It appears we would need to return ResourceSupport subclasses in order for that to happen.
 *  
 *  TODO: Implement pagination and sorting. Should we use PagedResourcesAssembler?
 *  
 *  TODO: Implement support of Projections.
 *  
 * @author Jerry Hehman
 *
 */
@BasePathAwareController
@RequestMapping(value = "persons/search")
public class PersonController implements ResourceProcessor<RepositorySearchesResource>
                                       , ResourceAssembler<List<Person>, Resources<Person>> {

	@Autowired
	private PersonDAO personDAO;
	
	@Autowired
	private EntityLinks entityLinks;
	
	@RequestMapping(value="searchByZipCodePrefix", method = RequestMethod.GET)
	public ResponseEntity<Resources<Person>> searchByZipCodePrefix(@RequestParam("zipCdPrefix") String zipCdPrefix) {
		if (zipCdPrefix == null) throw new IllegalArgumentException("zipCdPrefix cannot be null");

		if (zipCdPrefix.length()<3 || zipCdPrefix.length() > 5) throw new IllegalArgumentException("zipCdPrefix must be between 3 and 5 digits");
		
		if (!zipCdPrefix.matches("\\d+")) throw new IllegalArgumentException("zipCdPrefix must be numeric");

		List<Person> schools = personDAO.findByNamedQueryAndNamedParam("Person.zipCdPrefixSearch", "zipCdPrefix", zipCdPrefix + "%");
		Resources<Person> resource = toResource(schools);
		
		return new ResponseEntity<Resources<Person>>(resource, HttpStatus.OK);
	}

	@Override
	public Resources<Person> toResource(List<Person> persons) {
		Resources<Person> resource = new Resources<Person>(persons);

		return resource;
	}

	@Override
	public RepositorySearchesResource process(RepositorySearchesResource resource) {
		
		LinkBuilder lb = entityLinks.linkFor(Person.class, "zipCdPrefix");
		resource.add(new Link(lb.toString() + "/search/searchByZipCodePrefix{?zipCdPrefix}", "searchByZipCodePrefix"));

		return resource;
	}

}
