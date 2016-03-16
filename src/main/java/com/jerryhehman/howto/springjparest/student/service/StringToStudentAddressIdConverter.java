package com.jerryhehman.howto.springjparest.student.service;

import org.springframework.core.convert.converter.Converter;

import com.jerryhehman.howto.springjparest.student.domain.StudentAddressId;

/**
 * Converts a string in the format "{studentId}_{addrTypeCd}" into a StudentAddressId object.
 * @author Jerry Hehman
 *
 */
public class StringToStudentAddressIdConverter implements Converter<String, StudentAddressId> {

	@Override
	public StudentAddressId convert(String source) {
		String[] tokens = source.split("_");
		
		if (tokens.length != 2) throw new IllegalArgumentException("String must be in the format {studentId}_{addrTypeCd}");
		
		Integer studentId;
		try {
			studentId = Integer.valueOf(tokens[0]);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("studentId must be a number");
		}

		return new StudentAddressId(studentId, tokens[1]);
	}

}
