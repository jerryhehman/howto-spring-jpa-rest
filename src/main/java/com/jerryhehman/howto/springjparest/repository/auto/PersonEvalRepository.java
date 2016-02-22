package com.jerryhehman.howto.springjparest.repository.auto;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.jerryhehman.howto.springjparest.domain.LookupMaritalStatus;
import com.jerryhehman.howto.springjparest.domain.PersonEval;
import com.jerryhehman.howto.springjparest.domain.PersonEvalId;
import com.jerryhehman.howto.springjparest.repository.BasePagingAndSortingReadOnlyRepository;

/**
 * Repository for Person Evaluation.
 * 
 * @author Jerry Hehman
 *
 */
@RepositoryRestResource
public interface PersonEvalRepository extends BasePagingAndSortingReadOnlyRepository<PersonEval, PersonEvalId> {

}
