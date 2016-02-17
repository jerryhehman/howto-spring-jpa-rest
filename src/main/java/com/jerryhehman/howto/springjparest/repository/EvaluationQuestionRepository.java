package com.jerryhehman.howto.springjparest.repository;


import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.jerryhehman.howto.springjparest.domain.PersonEvalQuestion;


@RepositoryRestResource(path = "questions")
public interface EvaluationQuestionRepository extends BasePagingAndSortingReadOnlyRepository<PersonEvalQuestion, Integer> {

}
