package com.cotroller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@WebServlet("/RegistrationManager")
@MultipartConfig(maxFileSize = 16177215)
public class RegistrationManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	String url="jdbc:mysql://localhost:3306/VSB";
	String unm="root";
	String pwd="root";
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         
		String pname=request.getParameter("pname");
		String address=request.getParameter("address");
		String gender =request.getParameter("gender");
		long contact =Long.parseLong(request.getParameter("contact"));
		InputStream istrm=null;
		Part fp=request.getPart("records");
		if(fp != null) {
			System.out.println(fp.getName());
			System.out.println(fp.getSize());
			System.out.println(fp.getContentType());
			istrm=fp.getInputStream();
		}
		Connection con=null;
		String msg=null;
		try {
			
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			 con=DriverManager.getConnection(url,unm,pwd);
		String sql = "INSERT INTO patientdata (Name, address, gender, contact, records) VALUES (?, ?, ?, ?, ?)";
			 PreparedStatement ps=con.prepareStatement(sql);
			 ps.setString(1, pname);
			 ps.setString(2, address);
			 ps.setString(3, gender);
			 ps.setLong(4, contact);
			 if(istrm != null) {
				 ps.setBlob(5, istrm);
			 }
			 
			 int res=ps.executeUpdate();
			 if(res > 0) {
				 msg="Data uploaded successfully";
				 
			 }
			 con.close();
			 
		}
		catch (SQLException e) {
            e.printStackTrace();
		}
		request.setAttribute("msg", msg);
		getServletContext().getRequestDispatcher("/Message.jsp").forward(request, response);
	
	}

}
