package helperClasses;

public class ErrorMessagesBean {
	private String fName = "";
	private String lName = "";
	private String email = "";
	private String telephone = "";
	private String year = "";
	private String major = "";
	private String username = "";
	private String password = "";
	
	public boolean hasErrors()
	{
		if(this.fName != "") return true;
		if(this.lName != "") return true;
		if(this.email != "") return true;
		if(this.telephone != "") return true;
		if(this.year != "") return true;
		if(this.major != "") return true;
		return false;
	}
	
	public boolean hasUserErrors()
	{
		if(this.username != "") return true;
		if(this.password != "") return true;
		return false;
	}
	
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	

}
