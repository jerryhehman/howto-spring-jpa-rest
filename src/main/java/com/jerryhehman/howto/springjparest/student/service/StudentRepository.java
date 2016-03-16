package com.jerryhehman.howto.springjparest.student.service;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.jerryhehman.howto.springjparest.student.domain.Student;

@RepositoryRestResource
public interface StudentRepository extends PagingAndSortingRepository<Student, Integer> {

}
