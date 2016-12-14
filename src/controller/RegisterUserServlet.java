package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import helperClasses.DAO;
import helperClasses.ErrorMessagesBean;
import helperClasses.User;
import helperClasses.ValidationHelper;


/*
 * 	Project name: 	assignment2
 * 	Assignment: 	Assignment #2
 * 	Author:			Jens Jakob Sveding
 *	Date:			02/12/2016 
 *
 * 	Description:	RegisterUserServlet
 * 					Redirects user back to RegisterUser page if there is an error.
 * 					Redirect user to success login page if there is no error, and add user to the database
 * 
 * 					add session with the name of halfuser.
 */

@WebServlet("/RegisterUserServlet")
public class RegisterUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public RegisterUserServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User tempUser = new User();
		tempUser.setUsername(request.getParameter("username"));
		tempUser.setPassword(request.getParameter("password"));
		String confirmPass = request.getParameter("rePassword");
		
		ErrorMessagesBean errMsg = new ErrorMessagesBean();
		
		ValidationHelper.validateUserInformation(tempUser, errMsg, confirmPass);
		
		if(errMsg.hasUserErrors())
		{
			request.setAttribute("user", tempUser);
			request.setAttribute("errMsg", errMsg);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("RegisterUser.jsp");
			dispatcher.forward(request, response);
		}
		else if(!errMsg.hasUserErrors())
		{
			HttpSession session = request.getSession();
			User newUser = (User) session.getAttribute("halfUser");
			session.invalidate();
			newUser.setUsername(tempUser.getUsername());
			newUser.setPassword(tempUser.getPassword());
			
			//create user in DB
			DAO dao = new DAO();
			try {
				dao.addNewUser(newUser);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			//Redirect to succes page
			request.setAttribute("user", newUser);
			RequestDispatcher dispatcher = request.getRequestDispatcher("RegistrationSucces.jsp");
			dispatcher.forward(request, response);
		}
	}

}
