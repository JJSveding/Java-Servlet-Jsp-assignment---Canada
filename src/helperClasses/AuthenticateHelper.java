package helperClasses;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * 	Project name: 	assignment1
 * 	Assignment: 	Assignment #1
 * 	Author:			Jens Jakob Sveding	
 *	Date:			29/10/2016 
 *
 * 	Description: Method to validate username and password agianst the database
 */

public class AuthenticateHelper {
	
	public static boolean authenticate(String username, String password)
	{
		if(!ValidationHelper.validateUsername(username) || !ValidationHelper.validPassword(password)) return false;
		
		DAO dao = new DAO();
		User user = dao.getUserByUsername(username);
		
		//Matches the users password in DB with given password.
		if(user!=null && user.getPassword().equals(password))
		{
			return true;
		}
		return false;
	}
	
	public static boolean isLoggedIn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		//Tests session user exists in DB and matches password
				if(user!=null && AuthenticateHelper.authenticate(user.getUsername(), user.getPassword()))
				{
					System.out.println("Session found");
					return true;
				}
				else if (!CookieUtilities.isNewbie(request))
				{
					System.out.println("Cookies found");
					if(CookieUtilities.authenticateCookies(request))
					{
						return true;
					}
				}
		return false;
	}
}
