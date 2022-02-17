package org.vtech.dbtest;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DBtestServlet
 */
@WebServlet("/DBtestServlet")
public class DBtestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DBtestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		out.println("Hello world...");
		
		String user="root";
		String pass="root";
		String JdbcUrl = "jdbc:mysql://localhost:3306/student_manager";
		String Driver = "com.mysql.cj.jdbc.Driver";
		
		try {
			Class.forName(Driver);
			Connection con= DriverManager.getConnection(JdbcUrl,user,pass);
			System.out.println("con:"+con);
//			PreparedStatement psmt = con.prepareStatement("select * from student_manager.student");
//			ResultSet rs= psmt.executeQuery();
//			while(rs.next()) {
//				System.out.println(rs.getInt(1));
//				System.out.println(rs.getString(2));
//			}
			System.out.println("Success...");
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
