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


@WebServlet("/DocRegistrationManager")
@MultipartConfig(maxFileSize = 16177215)
public class DocRegistrationManager extends HttpServlet {
	private static final long serialVersionUID = 1L;

	RegistrationManager rm=new RegistrationManager();
	
	    String url=rm.url;
		String unm=rm.unm;
		String pwd=rm.pwd;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dname=request.getParameter("dname");
		String address=request.getParameter("address");
		String gender =request.getParameter("gender");
		long contact =Long.parseLong(request.getParameter("contact"));
		String specialisation =request.getParameter("specialisation");
		InputStream istrm=null;
		InputStream istrm1=null;
		Part fp1=request.getPart("license");
		 Part fp=request.getPart("profile");
		if(fp != null) {
			System.out.println(fp.getName());
			System.out.println(fp.getSize());
			System.out.println(fp.getContentType());
			istrm=fp.getInputStream();
		}
		istrm1=fp1.getInputStream();
		Connection con=null;
		String msg=null;
		try {
			
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			
			con=DriverManager.getConnection(url,unm,pwd);
		String sql = "INSERT INTO doctor (Name, address, gender,contact, profile, license, specialisation) VALUES (?, ?, ?, ?, ?, ?, ?)";
			 PreparedStatement ps=con.prepareStatement(sql);
			 ps.setString(1, dname);
			 ps.setString(2, address);
			 ps.setString(3, gender);
			 ps.setLong(4, contact);
			 if(istrm != null) {
				 ps.setBlob(5, istrm);
			 }
			 ps.setBlob(6, istrm1);
			 ps.setString(7, specialisation);
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

