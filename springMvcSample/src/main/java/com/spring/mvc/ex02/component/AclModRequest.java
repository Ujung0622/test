package com.spring.mvc.ex02.component;

import java.util.List;

public class AclModRequest {

	private List<AccessPerm> perms;

	public List<AccessPerm> getPerms() {
		System.out.println("AclModRequest getter");
		return perms;
	}

	public void setPerms(List<AccessPerm> permissions) {
		System.out.println("AclModRequest setter");
		this.perms = permissions;
	}

}
