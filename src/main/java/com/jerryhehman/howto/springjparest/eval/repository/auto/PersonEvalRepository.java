package com.jerryhehman.howto.springjparest.eval.repository.auto;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.jerryhehman.howto.springjparest.eval.domain.PersonEval;
import com.jerryhehman.howto.springjparest.eval.domain.PersonEvalId;

/**
 * Repository for Person Evaluation.
 * 
 * @author Jerry Hehman
 *
 */
@RepositoryRestResource
public interface PersonEvalRepository extends CrudRepository<PersonEval, PersonEvalId> {

}
