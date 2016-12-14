package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import helperClasses.AuthenticateHelper;
import helperClasses.Comment;
import helperClasses.DAO;
import helperClasses.User;

/*
 * 	Project name: 	assignment2
 * 	Assignment: 	Assignment #2
 * 	Author:			Jens Jakob Sveding
 *	Date:			02/12/2016 
 *
 *
 * 	Description: CommentServlet
 * 				 Get comment from the request parameter and add it to the database
 * 				 If comment is empty don't add it to database
 */

@WebServlet("/CommentServlet")
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CommentServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher;
		
		if(AuthenticateHelper.isLoggedIn(request, response))
		{
			String comment = request.getParameter("comment");
			comment = comment.replaceAll("\n", "<br/>");
			
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute("user");
			String userInfo = user.getfName() + " " + user.getlName();

			Comment newComment = new Comment(userInfo, comment);
			newComment.setPostID(Integer.parseInt(request.getParameter("post_id")));
			
			dispatcher = request.getRequestDispatcher("Welcome.jsp");
			
			if(!comment.equals("")){
				try {
					DAO mydao = new DAO();
					mydao.addComment(newComment);
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


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
