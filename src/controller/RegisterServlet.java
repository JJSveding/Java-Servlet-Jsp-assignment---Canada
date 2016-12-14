package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import helperClasses.ErrorMessagesBean;
import helperClasses.User;
import helperClasses.ValidationHelper;

/*
 * 	Project name: 	assignment2
 * 	Assignment: 	Assignment #2
 * 	Author:			Jens Jakob Sveding
 *	Date:			02/12/2016 
 *
 *
 * 	Description:	Shows Registration page
 * 			
 * 					Validates user input using ValidationHelper (personal information)
 * 					generates new registration if errors in user input occurs (personal information)
 * 					
 * 					If personal information is correct it redirects to -> user account information
 *					Validates user input using ValidationHelper (User account)
 * 					generates new registration if errors in user input occurs (User account)
 * 
 * 					Redirects to Success page
 */

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public RegisterServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User tempUser = new User();
		tempUser.setfName(request.getParameter("fName"));
		tempUser.setlName(request.getParameter("lName"));
		tempUser.setEmail(request.getParameter("email"));
		tempUser.setTelephone(request.getParameter("areaCode") + request.getParameter("coCode") + request.getParameter("stCode"));
		tempUser.setYear(request.getParameter("year"));
		tempUser.setMajor(request.getParameter("major"));
		
		ErrorMessagesBean errMsg = new ErrorMessagesBean();
		
		ValidationHelper.validatePersonalInformation(tempUser, errMsg, request.getParameter("cEmail"));
		
		if(errMsg.hasErrors())
		{
			request.setAttribute("incUser", tempUser);
			request.setAttribute("errMsg", errMsg);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("Register.jsp");
			dispatcher.forward(request, response);
		}
		else{
			HttpSession session = request.getSession();
			session.setAttribute("halfUser", tempUser);
			RequestDispatcher dispatcher = request.getRequestDispatcher("RegisterUser.jsp");
			dispatcher.forward(request, response);
		}
		
		

	}

}
