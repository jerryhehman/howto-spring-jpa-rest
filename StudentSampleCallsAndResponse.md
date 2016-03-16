# StudentRepository is the only Repository
## Collection Resource
### Create Student

- URL: `http://localhost:8080/students`
- Method: `POST`
- Header: `Content-Type: application/json;charset=UTF-8`
- Request:
```JSON
{
  "firstName": "Jude",
  "lastName": "Lennon",
  "studentAddresses": [],
  "courses": []
}
```

- Response Code: `201 Created`
- Response Body:
```JSON
{
  "firstName": "Jude",
  "lastName": "Lennon",
  "studentAddresses": [],
  "courses": [],
  "_links": {
    "self": {
      "href": "http://localhost:8080/students/2"
    },
    "student": [
      {
        "href": "http://localhost:8080/students/2"
      },
      {
        "href": "http://localhost:8080/students/2/student"
      }
    ]
  }
}
```
### GET - List Students
- URL: `http://localhost:8080/students`
- Method: `GET`
- Response Code: `200`
- Response Body:
```JSON
{
  "_embedded": {
    "students": [
      {
        "firstName": "Max",
        "lastName": "Edison",
        "studentAddresses": [
          {
            "streetAddress": "123 Main St.",
            "cityTx": "Newport",
            "state": {
              "stateNm": "Kentucky"
            },
            "zipCd": "41071"
          },
          {
            "streetAddress": "P.O. Box 683",
            "cityTx": "Newport",
            "state": {
              "stateNm": "Kentucky"
            },
            "zipCd": "41071"
          }
        ],
        "courses": [],
        "_links": {
          "self": {
            "href": "http://localhost:8080/students/1"
          },
          "student": [
            {
              "href": "http://localhost:8080/students/1"
            },
            {
              "href": "http://localhost:8080/students/1/student"
            }
          ]
        }
      },
      {
        "firstName": "Jude",
        "lastName": "Lennon",
        "studentAddresses": [],
        "courses": [],
        "_links": {
          "self": {
            "href": "http://localhost:8080/students/2"
          },
          "student": [
            {
              "href": "http://localhost:8080/students/2"
            },
            {
              "href": "http://localhost:8080/students/2/student"
            }
          ]
        }
      }
    ]
  },
  "_links": {
    "self": {
      "href": "http://localhost:8080/students"
    },
    "profile": {
      "href": "http://localhost:8080/profile/students"
    }
  },
  "page": {
    "size": 20,
    "totalElements": 2,
    "totalPages": 1,
    "number": 0
  }
}
```
## Item Resource
### GET - Read Student

- URL: `http://localhost:8080/students/1`
- Method: `GET`
- Response Code: `200`
- Response Body:
```JSON
{
  "firstName": "Max",
  "lastName": "Edison",
  "studentAddresses": [
    {
      "streetAddress": "123 Main St.",
      "cityTx": "Newport",
      "state": {
        "stateNm": "Kentucky"
      },
      "zipCd": "41071"
    },
    {
      "streetAddress": "P.O. Box 683",
      "cityTx": "Newport",
      "state": {
        "stateNm": "Kentucky"
      },
      "zipCd": "41071"
    }
  ],
  "courses": [],
  "_links": {
    "self": {
      "href": "http://localhost:8080/students/1"
    },
    "student": [
      {
        "href": "http://localhost:8080/students/1"
      },
      {
        "href": "http://localhost:8080/students/1/student"
      }
    ]
  }
}
```

### PUT - Update Student

- URL: `http://localhost:8080/students/2`
- Method: `PUT`
- Header: `Content-Type: application/json;charset=UTF-8`
- Request:
```JSON
      {
        "firstName": "Jude",
        "lastName": "Harrison"
      }
```

- Response Code: `201 Created`
- Response Body:
```JSON
{
  "firstName": "Jude",
  "lastName": "Harrison",
  "studentAddresses": [],
  "courses": [],
  "_links": {
    "self": {
      "href": "http://localhost:8080/students/2"
    },
    "student": [
      {
        "href": "http://localhost:8080/students/2"
      },
      {
        "href": "http://localhost:8080/students/2/student"
      }
    ]
  }
}
```

### PATCH - Partially Update Student

- URL: `http://localhost:8080/students/2`
- Method: `PATCH`
- Header: `Content-Type: application/json;charset=UTF-8`
- Request:
```JSON
      {
        "firstName": "Julia"
      }
```

- Response Code: `201 Created`
- Response Body:
```JSON
{
  "firstName": "Julia",
  "lastName": "Harrison",
  "studentAddresses": [],
  "courses": [],
  "_links": {
    "self": {
      "href": "http://localhost:8080/students/2"
    },
    "student": [
      {
        "href": "http://localhost:8080/students/2"
      },
      {
        "href": "http://localhost:8080/students/2/student"
      }
    ]
  }
}
```

### DELETE - Delete Student

- URL: `http://localhost:8080/students/2`
- Method: `DELETE`

- Response Code: `204`

The above was done with only the StudentRepository existing. No other repositories existed.

- Read `http://blog.codeleak.pl/2014/10/exposing-spring-data-repositories-over-rest.html`
- Read `http://stackoverflow.com/questions/16180147/composite-key-resource-rest-service`
- Read `http://stackoverflow.com/questions/26249506/how-to-expose-embeddedid-converters-in-spring-data-rest`

# Added StudentAddressRepository
With a repository for StudentAddress, the REST responses have changed with respect to the StreetAddress representation. In addition to a root level URI, `/studentAddresses`, the representation of studentAddresses within Student request is different. Before, the studentAddresses were a collection within the Student JSON and, if there were entries in the table, the addresses would appear. Now, with the StudentAddressRepository, the addresses are represented as a rel and a separate request needs to be made to retrieve the addresses. For example:
### GET - Read a student
- URL: `http://localhost:8080/students/1`
- Method: `GET`
- Response Code: `200`
- Response Body:
```JSON
{
  "firstName": "Max",
  "lastName": "Edison",
  "courses": [],
  "_links": {
    "self": {
      "href": "http://localhost:8080/students/1"
    },
    "student": {
      "href": "http://localhost:8080/students/1"
    },
    "studentAddresses": {
      "href": "http://localhost:8080/students/1/studentAddresses"
    }
  }
}
```
### GET - List student addresses for a student
- URL: `http://localhost:8080/students/1/studentAddresses`
- Method: `GET`
- Response Code: `200`
- Response Body:
```JSON
{
  "_embedded": {
    "studentAddresses": [
      {
        "streetAddress": "123 Main St.",
        "cityTx": "Newport",
        "state": {
          "stateNm": "Kentucky"
        },
        "zipCd": "41071",
        "_links": {
          "self": {
            "href": "http://localhost:8080/studentAddresses/StudentAddressId%20%5BstudentId=1,%20addressTypeCd=D%5D"
          },
          "studentAddress": {
            "href": "http://localhost:8080/studentAddresses/StudentAddressId%20%5BstudentId=1,%20addressTypeCd=D%5D"
          },
          "student": {
            "href": "http://localhost:8080/studentAddresses/StudentAddressId%20%5BstudentId=1,%20addressTypeCd=D%5D/student"
          }
        }
      },
      {
        "streetAddress": "P.O. Box 683",
        "cityTx": "Newport",
        "state": {
          "stateNm": "Kentucky"
        },
        "zipCd": "41071",
        "_links": {
          "self": {
            "href": "http://localhost:8080/studentAddresses/StudentAddressId%20%5BstudentId=1,%20addressTypeCd=M%5D"
          },
          "studentAddress": {
            "href": "http://localhost:8080/studentAddresses/StudentAddressId%20%5BstudentId=1,%20addressTypeCd=M%5D"
          },
          "student": {
            "href": "http://localhost:8080/studentAddresses/StudentAddressId%20%5BstudentId=1,%20addressTypeCd=M%5D/student"
          }
        }
      }
    ]
  },
  "_links": {
    "self": {
      "href": "http://localhost:8080/students/1/studentAddresses"
    }
  }
}
```
Notice the unfriendly URLs. This is because Spring uses the toString() of the entity's ID class as the link. Since StudentAddress has a composite ID, the default toString() is not conducive to a friendly URL. There is not a lot of good information on the internet about how to fix this issue. The overwhelming recommendation is to use single-column keys. A recommended practice is to only use GUIDs.

At this point, changed the StreetAddressId.toString() method to this: return studentId + "_" + addressTypeCd; The same request as above now includes this in the links section:
```
        "_links": {
          "self": {
            "href": "http://localhost:8080/studentAddresses/1_D"
          },
          "studentAddress": {
            "href": "http://localhost:8080/studentAddresses/1_D"
          },
          "student": {
            "href": "http://localhost:8080/studentAddresses/1_D/student"
          }
        }
```
GET on `http://localhost:8080/students/1/studentAddresses/1_D` works as expected.
PATCH on `http://localhost:8080/students/1/studentAddresses/1_D` does not

The URL `http://localhost:8080/studentAddresses/1_D` does not work for any HTTP verb. It gives this error, `org.springframework.core.convert.ConverterNotFoundException: No converter found capable of converting from type [java.lang.String] to type [com.jerryhehman.howto.springjparest.student.domain.StudentAddressId]`, which seems odds since the URL nested under /students/ was able to convert it properly.

# Switch to a single ID.
At this point, decided to make all entities a single ID column in order to simplify this effort.



