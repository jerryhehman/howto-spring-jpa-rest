package com.jerryhehman.howto.springjparest.eval.repository.controllerfirst;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jerryhehman.howto.springjparest.eval.domain.PersonEvalQuestion;
import com.jerryhehman.howto.springjparest.eval.repository.resource.PersonController;

/**
 * A REST Controller for evaluation questions. Written using the style described in:
 *   http://patrickgrimard.com/2014/05/16/pagination-with-spring-data-and-hateoas-in-an-angularjs-app/
 *   
 * The methods in this controller support pagination, if Pageable is one of the arguments. Spring will inject it.
 * 
 * The PagedResourcesAssembler is used to convert the Page of PersonEvalQuestion entities into a PagedResources
 * instance which contains not only the underlying data, but also some metadata like the current page number, 
 * total number of pages, total number of records, page size, etc.  PagedResources will also contain links for 
 * previous and next pages if you desire to use them. 
 * 
 * The PersonEvalQuestionResourceAssembler is used to add links to the underlying resource objects.
 * 
 * ASSESSMENT: Not sure that this is any better than the {@link PersonController} solution when dealing with a single Entity type. This
 * solution may be needed when dealing with DTO responses. I do not like that the URI pattern ends up being different than for the
 * automatic repositories, which provide a list of search URIs when /{repository}/search is requested. This controller responds with a 404,
 * although that may be resolved with the addition of HATEOAS support. 
 * 
 * FIXME: At this point, Pagination does work
 * FIXME: The /questions/current URI is not part of the HATEOAS output that is produced when requesting the root URI. Perhaps we need to do what was done in PersonController.
 * 
 * @author Jerry Hehman
 *
 */
@RestController
@RequestMapping("/questions")
public class EvaluationQuestionController {

	@Autowired
	private EvaluationQuestionRepository evaluationQuestionRepository;
	
	@Autowired
	private PersonEvalQuestionResourceAssembler personEvalQuestionResourceAssembler;
	
	@RequestMapping("/search/current")
	private PagedResources<Resource<PersonEvalQuestion>> findCurrent(Pageable pageable, PagedResourcesAssembler<PersonEvalQuestion> assembler)
	{
		Page<PersonEvalQuestion> questions = evaluationQuestionRepository.findByQuestionBegDtBeforeAndQuestionEndDtAfter(new Date(), new Date(), pageable);
		return assembler.toResource(questions, personEvalQuestionResourceAssembler);
	}
	
	/**
	 * Without this method, nothing could respond to the /questions/{persEvalQuestionId} URI. The @RequestMapping and @PathVariable
	 * combine to direct those request to this method and to feed the ID specified on the URI to this method.
	 * @param persEvalQuestionId
	 * @return
	 */
	@RequestMapping("/{persEvalQuestionId}")
	private Resource<PersonEvalQuestion> findOne(@PathVariable Integer persEvalQuestionId)
	{
		PersonEvalQuestion question = evaluationQuestionRepository.findOne(persEvalQuestionId);
		return personEvalQuestionResourceAssembler.toResource(question);
	}
}
