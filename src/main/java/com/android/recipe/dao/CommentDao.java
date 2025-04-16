package com.android.recipe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.android.recipe.entities.Comment;
import com.android.recipe.entities.Reply;
import com.android.recipe.helper.OracleConnection;

public class CommentDao {
	Connection con;
	
	public int addComment(Comment comment) {
		con = OracleConnection.getConnection();
		System.out.println("in");
		int f = 0;
			String q = "insert into comments (comment_text,recipe_id, user_id,user_name) values(?,?,?,?)";
			try {
				PreparedStatement pst = con.prepareStatement(q);
				pst.setString(1, comment.getComment_text());
				pst.setInt(2, comment.getRecipe_id());
				pst.setInt(3, comment.getUser_id());
				pst.setString(4, comment.getUser_name());
				f = pst.executeUpdate();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return f;
	}
	
	public ArrayList<Comment> getCommentsByRecipeId(int id) {
		ArrayList<Comment> comments = new ArrayList<Comment>();
		con = OracleConnection.getConnection();
		String q = "select * from comments where recipe_id="+id+"  order by comment_time desc";
		try {
			PreparedStatement pst = con.prepareStatement(q);
			ResultSet res = pst.executeQuery();
			while(res.next()) {
				Comment c = new Comment();
				c.setComment_id(res.getInt(4));
				c.setComment_text(res.getString(5));
				c.setRecipe_id(res.getInt(3));
				c.setUser_id(res.getInt(1));
				c.setUser_name(res.getString(2));
				c.setComment_time(res.getTimestamp(6));
				comments.add(c);
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return comments;
	}
	
	public int addReply(Reply r) {
		int f =0;
		con =OracleConnection.getConnection();
		String q = "insert into reply (comment_id,recipe_id,user_id,user_name,reply_text) values(?,?,?,?,?)";
		try {
			PreparedStatement pst = con.prepareStatement(q);
			pst.setInt(1, r.getComment_id());
			pst.setInt(2, r.getRecipe_id());
			pst.setInt(3, r.getUser_id());
			pst.setString(4, r.getUser_name());
			pst.setString(5, r.getReply_text());
			f = pst.executeUpdate();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return f;
	}
	
	public ArrayList<Reply> getReplyByCommentId(int id) {
		System.out.println("innn");
		ArrayList<Reply> replies = new ArrayList<Reply>();
		con = OracleConnection.getConnection();
		String q = "select * from reply where comment_id="+id+" order by reply_time desc";
		try {
			PreparedStatement pst = con.prepareStatement(q);
			ResultSet res = pst.executeQuery();
			while(res.next()) {
				Reply c = new Reply();
				c.setComment_id(res.getInt(1));
				c.setReply_text(res.getString(3));
				c.setRecipe_id(res.getInt(6));
				c.setUser_id(res.getInt(5));
				c.setReply_id(res.getInt(2));
				c.setUser_name(res.getString(4));
				c.setReply_time(res.getTimestamp(7));
				replies.add(c);
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return replies;
	}
	
	public void deleteComment(int id) {
		con = OracleConnection.getConnection();
		String q = "delete from comments where comment_id="+id;
		try {
			PreparedStatement pst = con.prepareStatement(q);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteReply(int id) {
		con = OracleConnection.getConnection();
		String q = "delete from reply where reply_id="+id;
		try {
			PreparedStatement pst = con.prepareStatement(q);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
