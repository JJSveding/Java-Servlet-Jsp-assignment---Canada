package helperClasses;

import java.util.Date;

/*
 * 	Project name: 	assignment1
 * 	Assignment: 	Assignment #1
 * 	Author:			Jens Jakob Sveding	
 *	Date:			29/10/2016 
*/

public class Comment {
	private int id;
	private String user;
	private String text;
	private Date date;
	private int postID;
	
	public Comment() {
		//Empty constructor
	}
	
	public Comment(String user, String text){
		this.user = user;
		this.text = text;
	}
	
	
	public int getPostID() {
		return postID;
	}

	public void setPostID(int postID) {
		this.postID = postID;
	}

	

	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
}
