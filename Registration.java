package database;

public class Registration{

	//instance fields
	protected String title;
	protected String forename;
	protected String surname;
	protected String loginID;
	protected String university;
	protected String password;
	
	
    // constructor
    public Registration(String title, String forename, String surname, String loginID, String university, String password){
    	this.title = title;
    	this.forename = forename;
    	this.surname = surname;
    	this.loginID = loginID;
    	this.university = university;
	    this.password = password;
    }
    
    // get methods 
    public String getLoginID(){
    	return this.loginID;
    }
    
    public String getPassword(){
    	return this.password;
    }
    
    public String registration(String title, String forename, String surname, String university, String loginID, String password){
    	return registration(title, forename, surname, university, loginID, password);
    }
    
    // set methods
    public void selfRegistration(String title, String forename, String surname, String university, String loginID, String password){
    	registration(title, forename, surname, university, loginID, password);
    }
    
    public void colleagueRegistration(String title, String forename, String surname, String university, String loginID, String password){
    	registration(title, forename, surname, university, loginID, password);
    }
    
    public void changePassword(String loginID, String password){
    	this.password = password;
    }
    
    public void retire(String loginID) {
        
    }
    
}
