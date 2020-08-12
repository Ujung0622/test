package sec03.ex01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JsonDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	private ResultSet rs;
	
	public JsonDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public List listMembers(String J_ID) {
		List<JsonVO>list = new ArrayList<JsonVO>();
		
		try {
			con = dataFactory.getConnection();
			String query = "select * from t_member where  id like '%"+J_ID+"%'";
			System.out.println("prepareStatememt: " + query);
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String joinDate = rs.getString("joinDate");
				JsonVO vo = new JsonVO();
				vo.setID(id);
				vo.setPWD(pwd);
				vo.setNAME(name);
				vo.setEMAIL(email);
				vo.setJOINDATE(joinDate);
				list.add(vo); 
				System.out.println("vo:"+vo.toString());
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	
	
	
	
	
	
	
}
