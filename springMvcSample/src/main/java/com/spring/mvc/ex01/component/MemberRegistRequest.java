package com.spring.mvc.ex01.component;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class MemberRegistRequest {

	private String email;
	private String name;
	private String password;
	private String confirmPassword;
	private boolean allowNoti;
	private Address address;
	private Date birthday;

	public String getEmail() {
		System.out.println("MemberRegistRequest getter1");
		return email;
	}

	public void setEmail(String email) {
		System.out.println("MemberRegistRequest setter1");
		this.email = email;
	}

	public String getName() {
		System.out.println("MemberRegistRequest getter2");
		return name;
	}

	public void setName(String name) {
		System.out.println("MemberRegistRequest setter2");
		this.name = name;
	}

	public String getPassword() {
		System.out.println("MemberRegistRequest getter3");
		return password;
	}

	public void setPassword(String password) {
		System.out.println("MemberRegistRequest setter3");
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public boolean isAllowNoti() {
		return allowNoti;
	}

	public void setAllowNoti(boolean allowNoti) {
		this.allowNoti = allowNoti;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public boolean isSamePasswordConfirmPassword() {
		if (password == null || confirmPassword == null)
			return false;
		return password.equals(confirmPassword);
	}

	public boolean hasPassword() {
		return password != null && password.trim().length() > 0;
	}

	public Date getBirthday() {
		return birthday;
	}

	@DateTimeFormat(pattern="yyyyMMdd")
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "MemberRegistRequest [email=" + email + ", name=" + name + ", password=" + password + ", confirmPassword=" + confirmPassword + ", allowNoti="
				+ allowNoti + "]";
	}

}
