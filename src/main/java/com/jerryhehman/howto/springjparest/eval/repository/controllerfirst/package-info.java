/**
 * Implements REST services by using the Controller as the only entry point, while leveraging
 * the auto-generated code of the Repository interface. The repository is only a repository,
 * not a REST repository. However, even as a Repository, Spring creates REST endpoints.
 * Thus, this is not working as intended.
 * 
 * @author Jerry Hehman
 *
 */
package com.jerryhehman.howto.springjparest.eval.repository.controllerfirst;