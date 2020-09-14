package com.spring.ex02;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller("loginController")
public class LoginController {
	@RequestMapping(value= {"/test/loginForm.do", "/test/loginForm2.do"},
			method= {RequestMethod.GET})
	public ModelAndView loginForm(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("loginForm");
		return mav;
	}

	//81page
//	@RequestMapping(value ="/test/login.do", method= {RequestMethod.GET, RequestMethod.POST})
//	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception{
//		request.setCharacterEncoding("utf-8");
//	ModelAndView mav = new ModelAndView();
//	mav.setViewName("result");
//	String userID=request.getParameter("userID");
//	String userName = request.getParameter("userName");
//	mav.addObject("userID", userID);
//	mav.addObject("userName", userName);
//	return mav;
//	}
//}
	
	//82page
//	@RequestMapping(value ="/test/login.do", method= {RequestMethod.GET, RequestMethod.POST})
//	public ModelAndView login(@RequestParam("userID") String userID,
//			@RequestParam("userName") String userName,
//			HttpServletRequest request, HttpServletResponse response) throws Exception{
//		request.setCharacterEncoding("utf-8");
//	ModelAndView mav = new ModelAndView();
//	mav.setViewName("result");
//
//	mav.addObject("userID",userID);
//	mav.addObject("userName",userName);
//	return mav;
//	}
//}
	
	
	
//	//84page
//	@RequestMapping(value ="/test/login.do", method= {RequestMethod.GET, RequestMethod.POST})
//	public ModelAndView login(@RequestParam Map<String, String> info,
//			HttpServletRequest request, HttpServletResponse response) throws Exception{
//		request.setCharacterEncoding("utf-8");
//	ModelAndView mav = new ModelAndView();
//	
//	String userID = info.get("userID");
//	String userName=info.get("userName");
//	System.out.println("userID" +userID);
//	System.out.println("userName" +userName);
//	
//	mav.addObject("info", info);
//	mav.setViewName("result");
//	return mav;
//	}
//}
	
	
//85Page	
@RequestMapping(value="/test/login4.do", method={RequestMethod.GET, RequestMethod.POST})
public ModelAndView login4(@ModelAttribute("info") LoginVO loginVO, 
HttpServletRequest request, HttpServletResponse response) throws Exception {
	request.setCharacterEncoding("utf-8");
	ModelAndView mav = new ModelAndView();
	mav.setViewName("result");
	return mav;}
}
	
	
	
	
	
	
	
	
