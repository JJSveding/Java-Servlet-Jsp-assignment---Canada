package helperClasses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;

/*
 * 	Project name: 	assignment1
 * 	Assignment: 	Assignment #1
 * 	Author:			Jens Jakob Sveding	
 *	Date:			29/10/2016 
 *
 * 	Description:	Data acces object. 
 * 					Used to run SQL statements on the Database
 * 
 * 					addNewUser():
 * 					getUserByUsername();
 * 					addComment();
 * 					getUserByUsername();
 * 					getAllPostsAndComments();
 * 					getCommentsById();
 * 					isUsernameTaken();
 * 					isEmailTaken();
 */

public class DAO {
	
	//Add new user to DB. 
	public void addNewUser(User user) throws Exception
	{
		Connection con = null;
        PreparedStatement ps = null;
        
        try
        {
            con = MySQLDatabase.getInstance().getConnection();

        }
        catch(Exception e) {e.printStackTrace();}
        
        String sqlString = "INSERT INTO USERS ("
			        		+ "firstname, lastname, email, phone, year, major, username, password) "
			        		+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
		ps = con.prepareStatement(sqlString);
        ps.setString(1, user.getfName());
        ps.setString(2, user.getlName());
        ps.setString(3, user.getEmail());
        ps.setString(4, user.getTelephone());
        ps.setString(5, user.getYear());
        ps.setString(6, user.getMajor());
        ps.setString(7, user.getUsername());
        ps.setString(8, user.getPassword());
        ps.executeUpdate();
        
        
        ps.close();
        con.close();
	}
	
	//Add post to DB. 
		public void addNewPost(Post post) throws Exception
		{
			Connection con = null;
	        PreparedStatement ps = null;
	        
	        try
	        {
	            con = MySQLDatabase.getInstance().getConnection();

	        }
	        catch(Exception e) {e.printStackTrace();}
	        
	        String sqlString = "INSERT INTO POSTS ("
				        		+ "user, post_text) "
				        		+ "VALUES (?, ?)";
	        
	        
			ps = con.prepareStatement(sqlString);
	        ps.setString(1, post.getUser());
	        ps.setString(2, post.getText());
	        ps.executeUpdate();
	        
	        ps.close();
	        con.close();
		}
		
		//Add comment to DB. 
		public void addComment(Comment comment) throws Exception
		{
			Connection con = null;
	        PreparedStatement ps = null;
	        
	        try
	        {
	            con = MySQLDatabase.getInstance().getConnection();

	        }
	        catch(Exception e) {e.printStackTrace();}
	        
	        String sqlString = "INSERT INTO COMMENTS ("
				        		+ "user, comment_text, post_id) "
				        		+ "VALUES (?, ?, ?)";
	        
			ps = con.prepareStatement(sqlString);
	        ps.setString(1, comment.getUser());
	        ps.setString(2, comment.getText());
	        ps.setInt(3, comment.getPostID());
	        ps.executeUpdate();
	        
	        ps.close();
	        con.close();
		}
	
	
	public User getUserByUsername(String user) 
	{
		Connection con = null;
        ResultSet rs; 
        User newUser = null;
        
        try
        {
            con = MySQLDatabase.getInstance().getConnection();
        
	        String sqlString = "SELECT * FROM USERS WHERE UserName=?;";
	        
	        PreparedStatement ps = con.prepareStatement(sqlString);
	        ps.setString(1, user);
	        
	        rs = ps.executeQuery();
	        
	        if(!rs.next())
	        {
	            return null;
	        }
	        
	        newUser = new User();
	        newUser.setfName(rs.getString("firstname"));
	        newUser.setlName(rs.getString("lastname"));
	        newUser.setEmail(rs.getString("email"));
	        newUser.setTelephone(rs.getString("phone"));
	        newUser.setYear(rs.getString("year"));
	        newUser.setMajor(rs.getString("major"));
	        newUser.setUsername(rs.getString("username"));
	        newUser.setPassword(rs.getString("password"));
	        
	        con.close();
	    }
        catch (Exception e)
        {
        	e.printStackTrace();
        }
        return newUser;
	}
	
	public static ArrayList<Post> getAllPostsAndComments()
	{
		Connection con = null;
        ResultSet rs; 
        ArrayList<Post> posts = new ArrayList<Post>();
        
        try
        {
            con = MySQLDatabase.getInstance().getConnection();

	        String sqlString = "SELECT * FROM POSTS ORDER BY post_time;";
	        
	        PreparedStatement ps = con.prepareStatement(sqlString);
	        rs = ps.executeQuery();
	        
	        
	        while(rs.next())
	        {
	        	Post post = new Post();
	        	post.setUser(rs.getString("user"));
	        	post.setText(rs.getString("post_text"));
	        	post.setTs(rs.getTimestamp("post_time"));
	        	post.setId(rs.getInt(1));
	        	post.setComments(DAO.getCommentsById(post.getId()));
	        	posts.add(post);
	        }
	        
	        con.close();
	    }
        catch (Exception e)
        {
        	e.printStackTrace();
        }
        
        Collections.reverse(posts);
        return posts;
	}
	
	public static ArrayList<Comment> getCommentsById(int postId) 
	{
		Connection con = null;
        ResultSet rs; 
        ArrayList<Comment> comments = new ArrayList<Comment>();
        
        try
        {
            con = MySQLDatabase.getInstance().getConnection();

	        String sqlString = "SELECT * FROM COMMENTS WHERE post_id=?;";
	        
	        PreparedStatement ps = con.prepareStatement(sqlString);
	        ps.setInt(1, postId);
	        rs = ps.executeQuery();

	        while(rs.next())
	        {
	        	Comment comment = new Comment();
	        	comment.setId(rs.getInt("comment_id"));
	        	comment.setUser(rs.getString("user"));
	        	comment.setText(rs.getString("comment_text"));
	        	comment.setPostID(rs.getInt("post_id"));
	        	comments.add(comment);
	        }
	        
	        con.close();
	    }
        catch (Exception e)
        {
        	e.printStackTrace();
        }
        return comments;
	}
	
	public static boolean isUsernameTaken(String username)
	{
		Connection con = null;
        ResultSet rs; 

        try
        {
            con = MySQLDatabase.getInstance().getConnection();
      
 	        String sqlString = "SELECT * FROM USERS WHERE username=?;";
	        
	        PreparedStatement ps = con.prepareStatement(sqlString);
	        ps.setString(1, username);
	        
	        rs = ps.executeQuery();
	        
	        while(!rs.next())
	        {
	        	return false;
	        }
	    }
        catch (Exception e)
        {
        	e.printStackTrace();
        }
        return true;
	}
	
	public static boolean isEmailTaken(String email)
	{
		Connection con = null;
        ResultSet rs; 

        try
        {
            con = MySQLDatabase.getInstance().getConnection();
      
	        String sqlString = "SELECT * FROM USERS WHERE email=?;";
	        
	        PreparedStatement ps = con.prepareStatement(sqlString);
	        ps.setString(1, email);
	        
	        rs = ps.executeQuery();
	        
	        while(!rs.next())
	        {
	        	return false;
	        }
	    }
        catch (Exception e)
        {
        	e.printStackTrace();
        }
        return true;
	}
}
