package com.spring.mvc.ex08;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

@Controller
public class LocaleChangeController3 {
	@RequestMapping("/changeLanguage3")
	public String change(HttpServletRequest request, HttpServletResponse response) {
		return "locale/locale2";
	}
}
