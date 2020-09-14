package member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import member.service.MemberService;
import member.vo.MemberVO;

@Controller("memberController")
public class MemberControllerImpl implements MemberController {
@Autowired
private MemberService memberService;
@Autowired
private MemberVO memberVO;

@Override
@RequestMapping(value="/member/listMembers.do", method=RequestMethod.GET)
public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception{
	String viewName= getViewName(request);
	List membersList = memberService.listMembers();
	ModelAndView mav = new ModelAndView(viewName);
	System.out.println("MemberController listMembers");
	mav.addObject("membersList", membersList);
	System.out.println("여기에 오타가 있으면 어디로 가니?");
	return mav;
	
}

@Override
@RequestMapping(value="/member/addMember.do", method=RequestMethod.POST)
public ModelAndView addMember(@ModelAttribute("member") MemberVO member, 
		HttpServletRequest request, HttpServletRequest response) 
throws Exception {
	request.setCharacterEncoding("utf-8");
	int result=0;
	result = memberService.addMember(member);
	ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
	return mav;
}

@Override
@RequestMapping(value="/member/removeMember.do", method=RequestMethod.GET)
public ModelAndView removeMember(@RequestParam("id") String id,
		HttpServletRequest request,
		HttpServletResponse response) throws Exception{
	request.setCharacterEncoding("utf-8");
	memberService.removeMember(id);
	ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
	return mav;
	
}
@RequestMapping(value = "/member/*Form.do", method=RequestMethod.GET)
public ModelAndView form(HttpServletRequest request, HttpServletResponse response) throws Exception {
	String viewName = getViewName(request);
	ModelAndView mav = new ModelAndView();
	mav.setViewName(viewName);
	return mav;
}

//request 객체에서 URL 요청명을 가져와 .do를 제외한 요청명을 구한다
private String getViewName(HttpServletRequest request) throws Exception {
		System.out.println("request:  "+ request);
		String contextPath = request.getContextPath();
		String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
		if (uri == null || uri.trim().equals("")) {
			uri = request.getRequestURI();
		}

		int begin = 0;
		if (!((contextPath == null) || ("".equals(contextPath)))) {
			begin = contextPath.length();
		}

		int end;
		if (uri.indexOf(";") != -1) {
			end = uri.indexOf(";");
		} else if (uri.indexOf("?") != -1) {
			end = uri.indexOf("?");
		} else {
			end = uri.length();
		}

		String viewName = uri.substring(begin, end);
		if (viewName.indexOf(".") != -1) {
			viewName = viewName.substring(0, viewName.lastIndexOf("."));
		}
		if (viewName.lastIndexOf("/") != -1) {
			viewName = viewName.substring(viewName.lastIndexOf("/"), viewName.length());
		}
		System.out.println("viewName :" + viewName);
		return viewName;
	}




}
