package io.mk.jwt.model;

import java.io.Serializable;

public class StudentResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private final String jwttoken;

	public StudentResponse(String jwttoken) {
		super();
		this.jwttoken = jwttoken;
	}

	public String getJwttoken() {
		return jwttoken;
	}

}
