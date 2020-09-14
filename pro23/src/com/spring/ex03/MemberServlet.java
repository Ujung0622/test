package com.spring.ex03;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spring.ex01.MemberVO;


@WebServlet("/mem4.do")
public class MemberServlet extends HttpServlet {

protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
	doHandle(request, response);
}
	protected void dopost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		MemberDAO dao = new MemberDAO();
		MemberVO memberVO = new MemberVO();
		String action =request.getParameter("action");
		String nextPage="";
		if(action==null || action.contentEquals("listMembers")){
			List<MemberVO> membersList = dao.selectAllMemberList();
			request.setAttribute("membersList", membersList);
			nextPage="test02/listMembers.jsp";
		}else if(action.contentEquals("selectMemberById")) {
			String id=request.getParameter("value");
			memberVO=dao.selectMemberById(id);
			request.setAttribute("member",  memberVO);
			nextPage="test02/memberInfo.jsp";
		}else if(action.contentEquals("selectMemberByPwd")) {
			String pwd = request.getParameter("value");
			List<MemberVO> membersList = dao.selectMemberByPwd(pwd);
			request.setAttribute("membersList", membersList);
			nextPage="test02/listMembers.jsp";
			}else if(action.contentEquals("insertMember")) {
					 String id= request.getParameter("id");
					 String pwd= request.getParameter("pwd");
					 String name= request.getParameter("name");
					 String email= request.getParameter("email");
			nextPage="/mem4.do?action=listMembers";				
			}
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request,response);
		
	}
}

