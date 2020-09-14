package com.spring.mvc.ex04.component;

import com.spring.mvc.ex03.MemberService;
import com.spring.mvc.ex03.component.MemberInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class Authenticator {
	@Autowired
	private MemberService memberService;

	public Auth authenticate(String email, String password) {
		MemberInfo mi = memberService.getMemberInfoByEmail(email);
		
		// null�̳� ��ġ�ϴ� ���� ������ Exception �߻�
		if (mi == null)
			throw new AuthenticationException();
		if (!mi.matchPassword(password))
			throw new AuthenticationException();

		return new Auth(mi.getId(), mi.getName());
	}
}
