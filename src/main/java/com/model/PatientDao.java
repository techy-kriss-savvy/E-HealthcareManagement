package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PatientDao {

	public static List<Patient> getRecords(int i,int t){
		i=i-1;
		String sql="select Pid, Doctor,Conditions from Patients limit "+i+","+t+"";
		List<Patient> li=new ArrayList<Patient>();
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/VSB","root","root");
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				Patient p=new Patient();
			
				p.setPid(rs.getInt(1));
				p.setDoctor(rs.getString(2));
				p.setConditions(rs.getString(3));
				
				li.add(p);
			}
		}
		catch (SQLException e) {
       e.printStackTrace();
		}
		return li;
	}
}
