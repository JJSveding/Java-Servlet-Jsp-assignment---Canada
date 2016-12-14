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
import helperClasses.CookieUtilities;
import helperClasses.DAO;
import helperClasses.User;
import helperClasses.ValidationHelper;

/*
 * 	Project name: 	assignment2
 * 	Assignment: 	Assignment #2
 * 	Author:			Jens Jakob Sveding
 *	Date:			02/12/2016 
 *
 *
 * 	Description: AuthencitateServlet is used to authenticate users.
 * 
 * 				 Tries to:
 * 					Authenticate Session
 * 					Authenticate Cookies 
 * 					Authencticate user input from login page 
 * 					Return to login page
 */

@WebServlet("/AuthenticateServlet")
public class AuthenticateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AuthenticateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher;
		
		if(AuthenticateHelper.isLoggedIn(request, response))
		{
			//PostServlet.showPostAndComment(request, response);
			request.setAttribute("allposts", DAO.getAllPostsAndComments());
			dispatcher = request.getRequestDispatcher("Welcome.jsp");
		}
		else
		{
			//Reads parameters from Login page
			System.out.println("Reads parameters from login page");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String rememberMe = request.getParameter("remenberMe");
			
			if(ValidationHelper.isMissing(username) && ValidationHelper.isMissing(username))
			{
				dispatcher = request.getRequestDispatcher("Login.jsp");
			}
			else if(AuthenticateHelper.authenticate(username, password))
			{
				if(rememberMe != null && rememberMe.equals("yes"))
				{
					response.addCookie(CookieUtilities.createPersistentCookie("repeatVisitor", "yes"));
					response.addCookie(CookieUtilities.createPersistentCookie("username", username));
					response.addCookie(CookieUtilities.createPersistentCookie("password", password));
				}
				
				DAO dao = new DAO();
				HttpSession session = request.getSession();
				User user = dao.getUserByUsername(username);
				
				
				session.setAttribute("user", user);
				//PostServlet.showPostAndComment(request, response);
				request.setAttribute("allposts", DAO.getAllPostsAndComments());
				dispatcher = request.getRequestDispatcher("Welcome.jsp");
				
			}
			else {
				String errMsg = "Invalid Username and/or password";
				request.setAttribute("errMsg", errMsg);
				
				dispatcher = request.getRequestDispatcher("Login.jsp");
			}
		}
		dispatcher.forward(request, response);
	}
}
