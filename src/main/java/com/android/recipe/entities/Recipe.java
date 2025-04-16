package com.android.recipe.entities;

public class Recipe {
	int recipe_id;
	String recipe_name;
	String recipe_img;
	String recipe_ing;
	int recipe_time;
	public int getRecipe_id() {
		return recipe_id;
	}
	public void setRecipe_id(int recipe_id) {
		this.recipe_id = recipe_id;
	}
	public String getRecipe_name() {
		return recipe_name;
	}
	public void setRecipe_name(String recipe_name) {
		this.recipe_name = recipe_name;
	}
	public String getRecipe_img() {
		return recipe_img;
	}
	public void setRecipe_img(String recipe_img) {
		this.recipe_img = recipe_img;
	}
	public String getRecipe_ing() {
		return recipe_ing;
	}
	public void setRecipe_ing(String recipe_ing) {
		this.recipe_ing = recipe_ing;
	}
	public int getRecipe_time() {
		return recipe_time;
	}
	public void setRecipe_time(int recipe_time) {
		this.recipe_time = recipe_time;
	}
	@Override
	public String toString() {
		return "Recipe [recipe_id=" + recipe_id + ", recipe_name=" + recipe_name + ", recipe_img=" + recipe_img
				+ ", recipe_ing=" + recipe_ing + ", recipe_time=" + recipe_time + "]";
	}
	
	
}
