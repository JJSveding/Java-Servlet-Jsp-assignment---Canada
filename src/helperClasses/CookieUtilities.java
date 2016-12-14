package helperClasses;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 	Project name: 	assignment1
 * 	Assignment: 	Assignment #1
 * 	Author:			Jens Jakob Sveding	
 *	Date:			29/10/2016 
 *
 * 	Description:	This class contains methods for cookies.
 * 
 * 					isNewbie(): 				Checks if the user has checked the rememberMe checkbox.
 * 					isLoggedIn(): 				Finds username and password cookies and validates this on the Database
 * 					createPersistentCookie(): 	Creates a cookie with the age of a yaer
 * 					removeAllCookies(): 		Sets the age of all cookies to 0 - terminates all cookies			
 */

public class CookieUtilities {
	
	public static final int SECONDS_PER_YEAR = 60*60*24*365;
	
	public static boolean isNewbie(HttpServletRequest request)
	{
		boolean newbie = true;
		Cookie[] cookies = request.getCookies();
		
		if(cookies!= null){
			for(Cookie c: cookies){
				if(c.getName().equals("repeatVisitor") && (c.getValue().equals("yes")))
				{
					newbie = false;
					break;
				}
			}	
		}
		return newbie;
	}
	
	public static boolean authenticateCookies (HttpServletRequest request)
	{
		String username = "";
		String password = "";
		
		Cookie[] cookies = request.getCookies();
			for(Cookie c: cookies){
				if(c.getName().equals("username"))
				{
					username = c.getValue();
				}
				else if(c.getName().equals("password"))
				{
					password = c.getValue();
				}
			}
			if(AuthenticateHelper.authenticate(username, password))
			{
				DAO dao = new DAO();
				request.getSession().setAttribute("user", dao.getUserByUsername(username));
				return true;
			}
		return false;
	}
	
	
	public static Cookie createPersistentCookie(String name, String value)
	{
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(SECONDS_PER_YEAR);
		return cookie;
	}

	
	public static boolean removeAllCookies(HttpServletRequest request, HttpServletResponse response)
	{
		Cookie[] cookies = request.getCookies();
		for(Cookie c: cookies){
			c.setValue("");
			c.setMaxAge(0);
			response.addCookie(c);
			
		}
		return true;
	}
}
