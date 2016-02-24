package com.jerryhehman.howto.springjparest.eval.repository.auto;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.jerryhehman.howto.springjparest.eval.domain.LookupRatingLevel;
import com.jerryhehman.howto.springjparest.eval.repository.BasePagingAndSortingReadOnlyRepository;

/**
 * Repository for Rating Levels
 * 
 * @author Jerry Hehman
 *
 */
@RepositoryRestResource(path="ratingLevels")
public interface RatingLevelRepository extends BasePagingAndSortingReadOnlyRepository<LookupRatingLevel, Short> {

}
