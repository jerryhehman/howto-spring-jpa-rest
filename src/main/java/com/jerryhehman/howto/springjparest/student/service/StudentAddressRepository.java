package com.jerryhehman.howto.springjparest.student.service;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.jerryhehman.howto.springjparest.student.domain.StudentAddress;
import com.jerryhehman.howto.springjparest.student.domain.StudentAddressId;

public interface StudentAddressRepository extends PagingAndSortingRepository<StudentAddress, StudentAddressId> {


}
