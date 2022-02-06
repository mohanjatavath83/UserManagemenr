package com.user.model;

public enum Gender {

	MALE("MALE"), FEMALE("FEMALE"), OTHER("OTHER");

	private String code;

	private Gender(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public static Gender getRoleType(String code) {

		for (Gender gender : Gender.values()) {
			if (gender.getCode().equalsIgnoreCase(code)) {
				return gender;
			}
		}
		throw new IllegalArgumentException("Gender [" + code + "] not supported.");
	}

}
