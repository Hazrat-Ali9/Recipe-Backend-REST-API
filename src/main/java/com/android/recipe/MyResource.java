package com.android.recipe;

import java.util.ArrayList;

import com.android.recipe.dao.CommentDao;
import com.android.recipe.dao.RecipeDao;
import com.android.recipe.dao.UserDao;
import com.android.recipe.entities.AppUser;
import com.android.recipe.entities.Comment;
import com.android.recipe.entities.Recipe;
import com.android.recipe.entities.RecipeSteps;
import com.android.recipe.entities.Reply;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Path("/recipe/time/{time}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Recipe> getAll(@PathParam("time") int time) {
    	ArrayList<Recipe> a= new RecipeDao().getRecipeByTime(time);
        return a;
    }
    
    @GET
    @Path("/recipe/id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Recipe getOne(@PathParam("id") int id) {
    	Recipe a= new RecipeDao().getRecipeById(id);
        return a;
    }
    
    @GET
    @Path("recipe/steps/{recipe_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<RecipeSteps> getSteps(@PathParam("recipe_id") int recipe_id) {
    	ArrayList<RecipeSteps> a= new RecipeDao().getRecipeStepsByRecipeId(recipe_id);
        return a;
    }
    
    @POST
    @Path("/user")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String addUser(AppUser user) {
    	String f= new UserDao().addUser(user);
    	return f;
    }
    
    @POST
    @Path("user/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public AppUser getUser(AppUser appUser) {
    	AppUser a = new UserDao().getUser(appUser);
        return a;
    }
    
    @POST
    @Path("comment/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String addCommnet(Comment comment) {
    	System.out.println("in2");
    	int f = new CommentDao().addComment(comment);
        return f+"";
    }

    @GET
    @Path("comment/{recipe_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Comment> getComment(@PathParam("recipe_id") int recipe_id) {
    	ArrayList<Comment> a= new CommentDao().getCommentsByRecipeId(recipe_id);
        return a;
    }
    
    @POST
    @Path("reply/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String addReply(Reply reply) {
//    	System.out.println("in2");
    	int f = new CommentDao().addReply(reply);
        return f+"";
    }
    
    @GET
    @Path("reply/{comment_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Reply> getReply(@PathParam("comment_id") int comment_id) {
//    	System.out.println("res in");
    	ArrayList<Reply> a= new CommentDao().getReplyByCommentId(comment_id);
        return a;
    }
    
    
    
    @DELETE
    @Path("comment/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteComment(@PathParam("id") int id) {
    	System.out.println("delin");
    	new CommentDao().deleteComment(id);
//        return a;
    }
    
    
    @DELETE
    @Path("reply/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteReply(@PathParam("id") int id) {
    	System.out.println("delin");
    	new CommentDao().deleteReply(id);
//        return a;
    }
}
