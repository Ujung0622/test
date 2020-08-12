package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@WebServlet("/json")
public class JsonServlet1 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
//		response.sendRedirect("test04/json5.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String J_ID = request.getParameter("J_ID");
		response.getWriter().write(getJSON(J_ID));
	}
	
	
	public String getJSON (String J_ID) {
		if(J_ID ==null) J_ID="";
		StringBuffer result = new StringBuffer("");
		result.append("{\"result\":[");
		JsonDAO dao = new JsonDAO();
		List<JsonVO> list = dao.listMembers(J_ID);
		for(int i =0; i<list.size(); i++) {
			result.append("{\"value\":\""+list.get(i).getID() +"\"},");
			result.append("{\"value\":\""+list.get(i).getPWD() +"\"},");
			result.append("{\"value\":\""+list.get(i).getNAME() +"\"},");
			result.append("{\"value\":\""+list.get(i).getEMAIL() +"\"},");
			result.append("{\"value\":\""+list.get(i).getJOINDATE() +"\"},");
		}
		result.append("]}");
		return result.toString();
		
	}
//		
//		PrintWriter writer = response.getWriter();
//		String J_ID = request.getParameter("J_ID");
//		JsonDAO dao = new JsonDAO();
//
//		JSONObject totaObject = new JSONObject();
//		JSONArray memberArray = new JSONArray();
//		JSONObject memberInfo = new JSONObject();
//		JsonVO vo = new JsonVO();
//		List<JsonVO>list = dao.listMembers(J_ID);
//		
//		System.out.println("이 전에도???");
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println("이거지???"+vo.getID()+"//"+vo.getNAME()+"//"+vo.getPWD()+"//"+vo.getEMAIL());
//		System.out.println(list.get(i));
//		vo = list.get(i);
//		memberInfo = new JSONObject();
//			memberInfo.put("ID", vo.getID());
//			memberInfo.put("PWD", vo.getPWD());
//			memberInfo.put("NAME", vo.getNAME());
//			memberInfo.put("EMAIL", vo.getEMAIL());
//			memberInfo.put("JOINDATE", vo.getJOINDATE());
////			list.add(memberInfo);
//		}
//			totaObject.put("members", memberArray);
//			String jsonInfo = totaObject.toJSONString();
//			System.out.println(jsonInfo);
//			writer.print(jsonInfo);
//		}
	}

