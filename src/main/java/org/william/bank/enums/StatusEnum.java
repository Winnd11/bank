package org.william.bank.enums;

public enum StatusEnum {
	BADREQUEST("Bad Request", 400),
	UNAUTHORIZED("Unauthorized", 401),
	NOTFOUND("Not Found", 404),
	OK("OK", 200),
	ACCEPTED("Accepted", 202);
	
	private String name;
	private int code;
	
	StatusEnum(String name, int code) {
		this.name = name;
		this.code = code;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getCode() {
		return this.code;
	}
	
}
