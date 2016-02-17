package com.jerryhehman.howto.springjparest.repository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.jerryhehman.howto.springjparest.domain.LookupMaritalStatus;

/**
 * Repository for Marital Status Lookup.
 * 
 * @author Jerry Hehman
 *
 */
@RepositoryRestResource(path="maritalStatuses")
public interface MaritalStatusRepository extends BasePagingAndSortingReadOnlyRepository<LookupMaritalStatus, Short> {

}
