# howto-spring-jpa-rest
This is a project showing how to build RESTful services using Spring Boot, Data, JPA, REST and Hibernate.

This is not a comprehensive, fully-functional application. It demonstrates a number of approaches, sometimes overlapping and redundant, to implement functionality that might be encountered in the implementation of "real" RESTful services.

Includes services for two, unrelated sets of services. One is for the evaluation of persons. The second is for Students and their courses. Both used highly simplistic data representations so that we can focus on the mechanics of using Spring to build RESTful services.

## Person Evaluation

### Techniques
There are several techniques that can be used to expose REST services using Spring:

#### Repository Interface
The simplest approach is to create a Repository interface and declare methods.
- Have the interface extend one of the Spring Repository interfaces or a custom, base interface. The base interface is typically declared with a generic type that matches the '@Entity' class that is managed by this repository.
- Annotate the interface with `@RepositoryRestResource`
- Declare methods according to Spring's rules.
- Spring will auto-generate the JPA functionality needed for each method.
- Spring will make available each method, and the methods of the base interfaces, as REST endpoints.
- Spring will publish each REST endpoint with HATEOAS links.
- Since the methods are declared only in an interface, no custom business logic can be added, so you are limited to the functionality that Spring makes available.

See 'com.jerryhehman.howto.springjparest.eval.repository.auto' for examples.

#### Customized implementation of Repository
TO-DO: Document this

#### Controller with Resource additions for HATEOAS support

#### Controller-first approach

#### Using a SQL View
In the database, created a database view, Person_Delivery_Address, which joins Person and Person_address. Created an Entity class, PersonDeliveryAddress, and an associated Repository interface.
As with other auto-generated Repositories, Spring automatically created the concrete implementation for the repository and the REST responses include HATEOAS information.

#### Using a DTO as the response class
Created the PersonSingleAddress class, which combines the fields from Person and PersonAddress and assumes only a single address type. 

## Student
The domain classes have these relationships:

*Student*
- A One to Many relationship with Student_Address
- A Many-to-Many relationship with Course via Student_Course

*Student_Address*
- A many-to-One relationship with State

*Course*
- A many-to-many relationship with Student via Student_Course

# Questions
[ ] When a Person is requested, the response includes all street address records. However, it does not include the person evaluation records, even though both associations are defined the same way.
[ ] Does an association get a link in the response when the associated Entity has a Repository? 

# References
[RESTful URI Design](http://blog.2partsmagic.com/restful-uri-design/)

[Formatting in Markdown](https://help.github.com/articles/basic-writing-and-formatting-syntax/)

Just something extra
