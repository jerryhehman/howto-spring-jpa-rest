package com.jerryhehman.howto.springjparest.repository.auto;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.jerryhehman.howto.springjparest.domain.LookupRatingLevel;
import com.jerryhehman.howto.springjparest.repository.BasePagingAndSortingReadOnlyRepository;

/**
 * Repository for Rating Levels
 * 
 * @author Jerry Hehman
 *
 */
@RepositoryRestResource(path="ratingLevels")
public interface RatingLevelRepository extends BasePagingAndSortingReadOnlyRepository<LookupRatingLevel, Short> {

}
