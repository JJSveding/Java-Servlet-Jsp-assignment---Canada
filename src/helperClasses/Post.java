package helperClasses;


/*
 * 	Project name: 	assignment2
 * 	Assignment: 	Assignment #2
 * 	Author:			Jens Jakob Sveding
 *	Date:			02/12/2016 
 */

import java.util.ArrayList;
import java.util.Date;

public class Post {
	private int id;
	private String user;
	private Date ts;
	private String text;
	private ArrayList<Comment> comments;
	
	public String getUser() {
		return user;
	}
	
	public Post(String user, String text){
		this.user = user;
		this.text = text;
	}
	
	public Post() {
		
	}

	public void setUser(String user) {
		this.user = user;
	}
	public Date getTs() {
		return ts;
	}
	public void setTs(Date ts) {
		this.ts = ts;
	}

	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public ArrayList<Comment> getComments() {
		return comments;
	}
	public void setComments(ArrayList<Comment> comments) {
		this.comments = comments;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
