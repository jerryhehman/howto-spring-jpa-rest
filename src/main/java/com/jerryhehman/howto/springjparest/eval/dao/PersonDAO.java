package com.jerryhehman.howto.springjparest.eval.dao;

import java.util.List;

import com.jerryhehman.howto.springjparest.eval.domain.Person;

public interface PersonDAO {

public List<Person> findByNamedQueryAndNamedParam(String queryName, String paramName, Object paramValue);
}
