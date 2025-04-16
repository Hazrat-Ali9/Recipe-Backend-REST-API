package com.android.recipe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.android.recipe.entities.Recipe;
import com.android.recipe.entities.RecipeSteps;
import com.android.recipe.helper.OracleConnection;

public class RecipeDao {

	Connection con;
	public ArrayList<Recipe> getRecipeByTime(int time) {
		ArrayList<Recipe>recList=new ArrayList<Recipe>();
		con = OracleConnection.getConnection();
		String query = "select * from recipes where recipe_time="+time;
		try {
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet res = pst.executeQuery();
			while(res.next()) {
				Recipe recipe = new Recipe();
				recipe.setRecipe_id(res.getInt(1));
				recipe.setRecipe_name(res.getString(2));
				recipe.setRecipe_img(res.getString(3));
				recipe.setRecipe_ing(res.getString(4));
				recipe.setRecipe_time(res.getInt(5));
				System.out.println( recipe.toString());
				recList.add(recipe);
				
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return recList;
	}
	public ArrayList<RecipeSteps> getRecipeStepsByRecipeId(int recipe_id) {
		// TODO Auto-generated method stub
		con = OracleConnection.getConnection();
		ArrayList<RecipeSteps>steps=new ArrayList<RecipeSteps>();
		String query = "select * from recipe_steps where recipe_id="+recipe_id+" order by recipe_sl asc";
		try {
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet res = pst.executeQuery();
			while(res.next()) {
				RecipeSteps step = new RecipeSteps();
				step.setRecipe_id(res.getInt(1));
				step.setRecipe_sl(res.getInt(2));
				step.setRecipe_step(res.getString(3));
				step.setRecipe_time(res.getInt(4));
				steps.add(step);
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return steps;
	}
	public Recipe getRecipeById(int id) {
		con = OracleConnection.getConnection();
		String q = "select * from recipes where recipe_id="+id;
		PreparedStatement pst;
		Recipe recipe = new Recipe();
		try {
			pst = con.prepareStatement(q);
			ResultSet res = pst.executeQuery();
			if(res.next()) {
				recipe.setRecipe_id(res.getInt(1));
				recipe.setRecipe_name(res.getString(2));
				recipe.setRecipe_img(res.getString(3));
				recipe.setRecipe_ing(res.getString(4));
				recipe.setRecipe_time(res.getInt(5));
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		return recipe;
	}
	
}
