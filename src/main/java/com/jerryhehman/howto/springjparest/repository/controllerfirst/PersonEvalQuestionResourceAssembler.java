package com.jerryhehman.howto.springjparest.repository.controllerfirst;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import com.jerryhehman.howto.springjparest.domain.PersonEvalQuestion;

/**
 * A ResourceAssembler for PersonalEvalQuestion. Follows the example found at:
 *   http://patrickgrimard.com/2014/05/16/pagination-with-spring-data-and-hateoas-in-an-angularjs-app/
 * @author Jerry Hehman
 *
 */
@Component
public class PersonEvalQuestionResourceAssembler extends ResourceAssemblerSupport<PersonEvalQuestion, Resource<PersonEvalQuestion>> {

	public PersonEvalQuestionResourceAssembler() {
		super(EvaluationQuestionController.class, PersonEvalQuestionResourceAssembler.<Resource<PersonEvalQuestion>>castClass(Resource.class));
	}

	@Override
	public List<Resource<PersonEvalQuestion>> toResources(Iterable<? extends PersonEvalQuestion> questions) {
		List<Resource<PersonEvalQuestion>> resources = new ArrayList<Resource<PersonEvalQuestion>>();

        for(PersonEvalQuestion question : questions) {
        	resources.add(toResource(question));
        }

        return resources;
	}

	@Override
	public Resource<PersonEvalQuestion> toResource(PersonEvalQuestion question) {
		return new Resource<PersonEvalQuestion>(question, linkTo(EvaluationQuestionController.class).slash(question.getPersEvalQuestionId()).withSelfRel());
	}

	@SuppressWarnings("unchecked")
	private static <T> Class<T> castClass(Class<?> aClass) {
        return (Class<T>)aClass;
    }
}
