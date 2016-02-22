package com.jerryhehman.howto.springjparest.dao;

import java.util.List;

import com.jerryhehman.howto.springjparest.domain.Person;

public interface PersonDAO {

public List<Person> findByNamedQueryAndNamedParam(String queryName, String paramName, Object paramValue);
}
