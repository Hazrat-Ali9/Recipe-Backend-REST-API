package com.android.recipe.dao;
// User Data 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.android.recipe.entities.AppUser;
import com.android.recipe.helper.OracleConnection;


public class UserDao {
	Connection con;
	
	public String addUser(AppUser u) {
		System.out.println("in");
		String s="";
		con = OracleConnection.getConnection();
		String q="insert into app_users (user_name,user_email,user_password) values (?,?,?)";
		try {
			PreparedStatement pst = con.prepareStatement(q);
			pst.setString(1, u.getUser_name());
			pst.setString(2, u.getUser_email());
			pst.setString(3, u.getUser_password());
			int f = pst.executeUpdate();
			s=f+"";
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return s;
	}
	
	public AppUser getUser(AppUser user) {
		con = OracleConnection.getConnection();
		AppUser appUser = new AppUser();
		String q = "select * from app_users where user_email=? and user_password=?";
		try {
			PreparedStatement pst = con.prepareStatement(q);
			pst.setString(1, user.getUser_email());
			pst.setString(2, user.getUser_password());
			ResultSet res = pst.executeQuery();
			if(res.next()) {
				appUser.setUser_id(res.getInt(1));
				appUser.setUser_name(res.getString(2));
				appUser.setUser_email(res.getString(3));
				appUser.setUser_password(res.getString(4));
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return appUser;
	}

}
