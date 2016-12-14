package helperClasses;

/*
 * 	Project name: 	assignment1
 * 	Assignment: 	Assignment #1
 * 	Author:			Jens Jakob Sveding	
 *	Date:			29/10/2016 
 *
 * 	Description:	Contains methods for validating user inputs.			
 */					

public class ValidationHelper {

	public static void validatePersonalInformation(User tempUser, ErrorMessagesBean errMsg, String confirmEmail)
	{
		if(!ValidationHelper.validateFName(tempUser.getfName()))
		{

			tempUser.setfName("");
			errMsg.setfName("Invalid First Name");
		}
		
		if(!ValidationHelper.validateLName(tempUser.getlName()))
		{
			tempUser.setlName("");
			errMsg.setlName("Invalid Last Name");
		}
		
		if(!ValidationHelper.validateEmail(tempUser.getEmail()))
		{
			tempUser.setEmail("");
			errMsg.setEmail("Invalid email");
		}
		else if(!ValidationHelper.validatecEmail(tempUser.getEmail(), confirmEmail))
		{
			tempUser.setEmail("");
			errMsg.setEmail("E-mails does not match");
		}
		else if(DAO.isEmailTaken(tempUser.getEmail()))
		{
			tempUser.setEmail("");
			errMsg.setEmail("Email already in use");
		}
		
		if(!ValidationHelper.validateTelephone(tempUser.getTelephone()))
		{
			tempUser.setTelephone("");
			errMsg.setTelephone("Invalid Telephone Number");
		}
		
		if(!ValidationHelper.validateYear(tempUser.getYear()))
		{
			tempUser.setYear("");
			errMsg.setYear("Select a Year");
		}
		
		if(!ValidationHelper.validateYear(tempUser.getMajor()))
		{
			tempUser.setMajor("");
			errMsg.setMajor("Select a Major");
		}
	}
	
	public static void validateUserInformation(User tempUser, ErrorMessagesBean errMsg, String confirmPass)
	{
		if(!ValidationHelper.validateUsername(tempUser.getUsername()))
		{
			System.out.println("Invalid username");
			tempUser.setUsername("");
			errMsg.setUsername("Invalid First Name");
		}
		else if(DAO.isUsernameTaken(tempUser.getUsername()))
		{
			System.out.println("Username is taken");
			tempUser.setUsername("");
			errMsg.setUsername("Username is taken");
		}
		
		if(!ValidationHelper.validPassword(tempUser.getPassword()))
		{
			System.out.println("Invalid password");
			tempUser.setPassword("");
			errMsg.setPassword("Invalid password");
		}
		else if(!ValidationHelper.validPasswordMatch(tempUser.getPassword(), confirmPass))
		{
			System.out.println("Passwords does not match");
			tempUser.setPassword("");
			errMsg.setPassword("Passwords does not match");
		}
	}
	 
   public static boolean validateFName(String fName)
   {
		if(isMissing(fName)) return false;
   	
		fName = fName.substring(0,1).toUpperCase() + fName.substring(1).toLowerCase();
       return fName.matches( "[a-zA-Z]*" );
   }

   public static  boolean validateLName(String lName)
   {
   	if(isMissing(lName)) return false;
   	
   	lName = lName.substring(0,1).toUpperCase()+ lName.substring(1);
    return lName.matches( "[a-zA-z]+([ '-][a-zA-Z]+)*" );
   }

   public static  boolean validateEmail(String email)
   {
   	if(isMissing(email))return false;
   	
       return email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
   }
   
   public static  boolean validatecEmail(String email, String cEmail)
   {
   	return email.equals(cEmail);
   }

   public static  boolean validateTelephone(String telephone)
   {
   	//Does not support international numbers
   	//validate phone numbers of format "1234567890"
   	if(isMissing(telephone)) return false;
   	
		return telephone.matches("^[0-9]{10}");
		
   }
   
   public static  boolean validateYear(String year)
   {
   	return !isMissing(year);
   }
   
   public static  boolean validateMajor(String major)
   {
   	return !isMissing(major);
   }
   
   public static boolean validateUsername(String username)
   {
   	if(isMissing(username)) return false;

   	return username.matches( "[a-zA-Z]*" );
   }
   
   public static  boolean validPasswordMatch(String password, String confirmPassword)
   {	  	
   	return password.equals(confirmPassword);
   }
   
   public static boolean validPassword(String password)
   {
   	if(isMissing(password)) return false;
   	
   	return true;
   }    
   
   
   public static boolean isMissing(String input)
   {
	   if(input == null || input.trim()=="") return true;
	   
	   return false;
   }
   
  
   
   
}
