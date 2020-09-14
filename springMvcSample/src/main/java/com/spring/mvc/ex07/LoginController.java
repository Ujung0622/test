package com.spring.mvc.ex07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.mvc.ex04.component.Auth;
import com.spring.mvc.ex04.component.AuthenticationException;
import com.spring.mvc.ex04.component.Authenticator;
import com.spring.mvc.ex04.component.LoginCommand;
import com.spring.mvc.ex04.component.LoginCommandValidator;
import com.spring.mvc.ex04.component.SecurityLevel;

@Controller("LoginController2")
@RequestMapping("/auth/login2")
public class LoginController {

	private static final String LOGIN_FORM = "auth/loginForm2";
	@Autowired
	private Authenticator authenticator;

	@ModelAttribute("jobCodes")
	public List<Code> jobCodes() {
		return Arrays.asList(
				new Code("1", "�����"),
				new Code("2", "���α׷���"),
				new Code("3", "������"),
				new Code("4", "�۰�")
				);
	}
	
	@ModelAttribute("loginTypes")
	protected List<String> referenceData() {
		List<String> loginTypes = new ArrayList<String>();
		loginTypes.add("�Ϲ�ȸ��");
		loginTypes.add("���ȸ��");
		loginTypes.add("�������ȸ��");
		return loginTypes;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String loginForm(LoginCommand loginCommand) {
		loginCommand.setSecurityLevel(SecurityLevel.HIGH);
		return LOGIN_FORM;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String login(@Valid LoginCommand loginCommand, Errors errors,
			HttpServletRequest request) {
		if (errors.hasErrors()) {
			return LOGIN_FORM;
		}
		try {
			Auth auth = authenticator.authenticate(loginCommand.getEmail(), loginCommand.getPassword());
			HttpSession session = request.getSession();
			session.setAttribute("auth", auth);
			return "redirect:/index.jsp";
		} catch (AuthenticationException ex) {
			errors.reject("invalidIdOrPassword");
			return LOGIN_FORM;
		}
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new LoginCommandValidator());
	}
}
