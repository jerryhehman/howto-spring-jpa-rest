package com.jerryhehman.howto.springjparest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.DefaultConversionService;

import com.jerryhehman.howto.springjparest.eval.domain.LookupMaritalStatus;
import com.jerryhehman.howto.springjparest.eval.domain.LookupRatingLevel;
import com.jerryhehman.howto.springjparest.eval.domain.Person;
import com.jerryhehman.howto.springjparest.eval.domain.PersonAddress;
import com.jerryhehman.howto.springjparest.eval.domain.PersonEval;
import com.jerryhehman.howto.springjparest.eval.domain.PersonEvalQuestion;
import com.jerryhehman.howto.springjparest.student.service.StringToStudentAddressIdConverter;

/**
 * Changed class to extend WebMvcConfigurerAdapter in order to support configuration of ConversionService. The RepositoryRestConfigurer doesn't need it.
 *
 */
@Configuration
public class SpringJpaRestConfiguration extends WebMvcConfigurerAdapter
{

	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(new StringToStudentAddressIdConverter());
	}

	/**
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
	
	/**
	 * Configure the conversion service.
	 * 
	 * See - http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#core-convert
	 *     - http://patrickgrimard.com/tag/conversion-service/
	 */
	/*
	@Bean
    public ConversionService conversionService() {
        ConversionServiceFactoryBean bean = new ConversionServiceFactoryBean();
        
        @SuppressWarnings("rawtypes")
		Set<Converter> converters = new HashSet<Converter>();
        converters.add(new StringToStudentAddressIdConverter());
        
        bean.setConverters(converters);
        bean.afterPropertiesSet();
        return bean.getObject();
    }
    */
	
	/*
	@Bean
	public ConversionService conversionService(List<Converter> converters)
    { 
         DefaultConversionService conversionService = new DefaultConversionService();
         for (Converter converter: converters)
         {
             conversionService.addConverter(converter);
         }
         return conversionService;
    }
    */
}
