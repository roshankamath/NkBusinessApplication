package com.nkba.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {
	
	public static boolean validate(String name,String pass){
		boolean status=true;
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/nkbusinessapplication","root","tiger");
			
			PreparedStatement ps = con.prepareStatement("select * from staff_table where staff_username=? and staff_password=?");
		
			ps.setString(1,name);
			ps.setString(2,pass);
			
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			
		}catch(Exception e){System.out.println(e);}
		return status;
		}

}
