package com.jerryhehman.howto.springjparest.eval.repository.controllerfirst;


import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jerryhehman.howto.springjparest.eval.domain.PersonEvalQuestion;


@Repository
public interface EvaluationQuestionRepository extends JpaRepository<PersonEvalQuestion, Integer> {

Page<PersonEvalQuestion> findByQuestionBegDtBeforeAndQuestionEndDtAfter(Date questionBegDt, Date questionEndDt, Pageable pageable);
}
