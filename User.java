package classes;

public class User{

	//instance fields
	String title;
	String forename;
	String surname;
	String loginID;
	String university;
	String password;
	boolean isReviewer;
	boolean isEditor;
	boolean isAuthor;
	
    // constructor
    public User(String title, String forename, String surname, String loginID, String university, String password, boolean isreviewer, boolean iseditor, boolean isauthor){
    	this.title = title;
    	this.forename = forename;
    	this.surname = surname;
    	this.loginID = loginID;
    	this.university = university;
	    this.password = password;
	    this.isReviewer = isreviewer;
	    this.isEditor = iseditor;
	    this.isAuthor = isauthor;
    }
    
    // get methods 
    public String getLoginID(){
    	return this.loginID;
    }
    
    public String getPassword(){
    	return this.password;
    }
    
}
