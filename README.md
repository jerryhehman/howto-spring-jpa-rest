# howto-spring-jpa-rest
How to build RESTful services using Spring Boot, Data, JPA, REST and Hibernate. Includes a variety of scenarios.

## Techniques
There are several techniques that can be used to expose REST services using Spring:

### Repository Interface
The simplest approach is to create a Repository interface and declare methods.
- Have the interface extend one of the Spring Repository interfaces or a custom, base interface. The base interface is typically declared with a generic type that matches the '@Entity' class that is managed by this repository.
- Annotate the interface with `@RepositoryRestResource`
- Declare methods according to Spring's rules.
- Spring will auto-generate the JPA functionality needed for each method.
- Spring will make available each method, and the methods of the base interfaces, as REST endpoints.
- Spring will publish each REST endpoint with HATEOAS links.
- Since the methods are declared only in an interface, no custom business logic can be added, so you are limited to the functionality that Spring makes available.

See 'com.jerryhehman.howto.springjparest.repository.auto' for examples.

## References
- [RESTful URI Design](http://blog.2partsmagic.com/restful-uri-design/)
- [Formatting in Markdown](https://help.github.com/articles/basic-writing-and-formatting-syntax/)
