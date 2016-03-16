package com.jerryhehman.howto.springjparest.student.domain.projection;

import java.util.Set;

import org.springframework.data.rest.core.config.Projection;

import com.jerryhehman.howto.springjparest.student.domain.Student;
import com.jerryhehman.howto.springjparest.student.domain.StudentAddress;


/**
 * Projection of {@link Student} which includes only the name, id, and addresses.
 * @author Jerry Hehman
 *
 */
@Projection( name = "nameAddress", types = {Student.class})
public interface StudentNameAddress {
	String getStudentId();
	String getFirstName();
	String getLastName();
	Set<StudentAddress> getStudentAddresses();
}
