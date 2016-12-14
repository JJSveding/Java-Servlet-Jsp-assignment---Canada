package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helperClasses.CookieUtilities;

/*
 * 	Project name: 	assignment2
 * 	Assignment: 	Assignment #2
 * 	Author:			Jens Jakob Sveding	
 *	Date:			02/12/2016 
 *
 * 	Description:	Servlet used to logout users. Meaning removing session, cookies and redirecting them back to login page.
 * 				
 */

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LogoutServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CookieUtilities.removeAllCookies(request, response);
		request.getSession().invalidate();
		response.sendRedirect("AuthenticateServlet");
	}

}
