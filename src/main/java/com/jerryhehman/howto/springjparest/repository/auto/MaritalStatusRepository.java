package com.jerryhehman.howto.springjparest.repository.auto;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.jerryhehman.howto.springjparest.domain.LookupMaritalStatus;
import com.jerryhehman.howto.springjparest.repository.BasePagingAndSortingReadOnlyRepository;

/**
 * Repository for Marital Status Lookup.
 * 
 * @author Jerry Hehman
 *
 */
/*
 * The following shows the customization ability of the @RepositoryRestResource annotation.
 *   path -- defines the URI path these resources will exist under.
 *   collectionResourceRel -- defines the element name/key in the JSON under which all resources will be placed
 *   itemResourceRel -- defines the element name/key in the JSON under which a single resource's URI is specified.
 * In the a nutshell, a client would use the path to make the request, the collectionResourceRel to find the collection
 * of resources in the JSON response, and the itemResourceRel to find the URI of a single resource.
 * Example of JSON for http://localhost:8080/lookupMaritalStatuses, with 
 *    @RepositoryRestResource(path="maritalStatuses",collectionResourceRel="statuses",itemResourceRel="maritalStatus")
 * 
{
  "_embedded" : {
    "statuses" : [ {
      "marStatusCd" : "A",
      "marStatusTx" : "Marriage Annuled",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/maritalStatuses/A"
        },
        "maritalStatus" : {
          "href" : "http://localhost:8080/maritalStatuses/A"
        }
      }
    }, {
      "marStatusCd" : "D",
      "marStatusTx" : "Divorced",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/maritalStatuses/D"
        },
        "maritalStatus" : {
          "href" : "http://localhost:8080/maritalStatuses/D"
        }
      }
    },
  "page" : {
    "size" : 20,
    "totalElements" : 2,
    "totalPages" : 1,
    "number" : 0
  }
}
    ...
    
 */
@RepositoryRestResource(path="maritalStatuses",collectionResourceRel="statuses",itemResourceRel="maritalStatus")
public interface MaritalStatusRepository extends BasePagingAndSortingReadOnlyRepository<LookupMaritalStatus, Short> {

}
