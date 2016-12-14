package helperClasses;

/*
 * 	Project name: 	assignment1
 * 	Assignment: 	Assignment #1
 * 	Author:			Jens Jakob Sveding	
 *	Date:			29/10/2016 
 *
 * 	Description:	User object that is used to hold user information.
 * 					
 * 					Overridden toString method for testing purposes.
 */				

public class User {
	
	protected String fName;
	protected String lName;
	protected String email;
	protected String telephone;
	protected String year;
	protected String major;
	protected String username;
	protected String password;
	
	
	public User()
	{
		
	}


    public void setfName(String fName) {
		this.fName = fName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getfName() {
        return fName;
    }

	public String getlName() {
        return lName;
    }

    public String getEmail() {
        return email;
    }


    public String getTelephone() {
        return telephone;
    }

    public String getYear() {
        return year;
    }

    public String getMajor() {
        return major;
    }

    public String getUsername() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }
    
    @Override
    public String toString()
    {
    	return " First name: " + fName + " Last name: " + lName + " Email: " + email + " Telephone: " + telephone 
    			+ " year: " + year + " Major: " + major + "Username:" + username + "Password: " + password;
    }
}
