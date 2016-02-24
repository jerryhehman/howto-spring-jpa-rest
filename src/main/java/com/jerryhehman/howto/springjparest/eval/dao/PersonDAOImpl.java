package com.jerryhehman.howto.springjparest.eval.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jerryhehman.howto.springjparest.eval.domain.Person;

@Repository
public class PersonDAOImpl implements PersonDAO {

	@Autowired
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> findByNamedQueryAndNamedParam(String namedQuery, String paramName, Object paramValue) {
		Query query = em.createNamedQuery(namedQuery);
		query.setParameter(paramName, paramValue);

		return query.getResultList();
	}

}
