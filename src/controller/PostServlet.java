package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import helperClasses.User;
import helperClasses.AuthenticateHelper;
import helperClasses.DAO;
import helperClasses.Post;

/*
 * 	Project name: 	assignment2
 * 	Assignment: 	Assignment #2
 * 	Author:			Jens Jakob Sveding
 *	Date:			02/12/2016 
 *
 * 	Description:	PostServlet
 * 					Add post to the Database.
 * 					If post is empty redirect back to welcome screen without adding the post to the database
 * 
 * 					add session with the name of halfuser.
 * 					Retreive a list of comments and posts and store it in httpsession called "comments" and "allposts"
 */
@WebServlet("/PostServlet")
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PostServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher;
		
		if(AuthenticateHelper.isLoggedIn(request, response))
		{
			
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute("user");
			
			String userInfo = user.getfName() + " " + user.getlName();
			String post = request.getParameter("post");
			post = post.replaceAll("\n", "<br/>");
			
			DAO mydao = new DAO();
			Post newPost = new Post(userInfo, post);
			
			if(!post.equals(""))
			{
				try {
					mydao.addNewPost(newPost);
					request.setAttribute("allposts", DAO.getAllPostsAndComments());
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			dispatcher = request.getRequestDispatcher("Welcome.jsp");
			
		}
		else
		{
			request.setAttribute("errMsg", "You must login first");
			dispatcher = request.getRequestDispatcher("Login.jsp");
		}
		
		dispatcher.forward(request, response);
	}
}
