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
import helperClasses.DAO;


/*
 * 	Project name: 	assignment2
 * 	Assignment: 	Assignment #2
 * 	Author:			Jens Jakob Sveding
 *	Date:			01/12/2016 
 *
 * 	Description:	WelcomeServlet
 * 					Redirects user back to LoginPage if they haven't been authenticated.
 * 
 * 					Checks Session for valid user object.
 * 
 * 					If cookies are found, new session is created through CookieUtilities.isLoggedIn():
 * 					and it redirects user back to WelcomeServlet with a user object in session.
 */

@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public WelcomeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher;
		if(AuthenticateHelper.isLoggedIn(request, response))
		{
			request.setAttribute("allposts", DAO.getAllPostsAndComments());
			dispatcher = request.getRequestDispatcher("Welcome.jsp");
			
		}
		else {
			HttpSession session = request.getSession();
			session.setAttribute("errMsg", "You must login first!");
			dispatcher = request.getRequestDispatcher("Login.jsp");
		}
		dispatcher.forward(request, response);

	}

}
