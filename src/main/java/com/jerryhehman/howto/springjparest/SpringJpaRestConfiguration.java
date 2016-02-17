package com.jerryhehman.howto.springjparest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

import com.jerryhehman.howto.springjparest.domain.LookupMaritalStatus;
import com.jerryhehman.howto.springjparest.domain.LookupRatingLevel;
import com.jerryhehman.howto.springjparest.domain.Person;
import com.jerryhehman.howto.springjparest.domain.PersonAddress;
import com.jerryhehman.howto.springjparest.domain.PersonEval;
import com.jerryhehman.howto.springjparest.domain.PersonEvalQuestion;

@Configuration
public class SpringJpaRestConfiguration
{

	/*
	 * Create a configuration bean as described in http://docs.spring.io/spring-data/rest/docs/current/reference/html/#getting-started.basic-settings
	 * The exposeIdsFor() method is not one that can be specified via the spring.data.rest properties, so will use the technique that was
	 * needed in Spring Boot 1.1 and earlier (or no Spring Boot).
	 */
	@Bean
	  public RepositoryRestConfigurer repositoryRestConfigurer() {

	    return new RepositoryRestConfigurerAdapter() {

	      @Override
	      public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
	  		/*
	  		 * By default, Spring Data REST does not expose properties tagged with @Id annotation in REST output.
	  		 * The thinking is that the Id shouldn't be exposed and it is available on the self link anyway.
	  		 * However, the Id is often needed for dropdowns or further processing and it just seems easier to have it 
	  		 * exposed. The following method tells Spring Data REST to expose the Id for each class listed.
	  		 * See: http://stackoverflow.com/questions/24839760/spring-boot-responsebody-doesnt-serialize-entity-id
	  		 * and http://stackoverflow.com/questions/30912826/expose-all-ids-when-using-spring-data-rest.
	  		 * 
	  		 * TODO: Determine if this is RESTful or if there is a convenient way to retrieve the ID from the self link in Angular.
	  		 * 
	  		 */
	          config.exposeIdsFor(LookupMaritalStatus.class,
						          LookupRatingLevel.class,
						          Person.class,
							      PersonAddress.class,
						          PersonEval.class,
						          PersonEvalQuestion.class);
	      }
	    };
	  }
}
