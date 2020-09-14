package com.spring.mvc.ex07;

public class Code {

	private String code;
	private String label;

	public Code(String code, String name) {
		this.code = code;
		this.label = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String name) {
		this.label = name;
	}

}
