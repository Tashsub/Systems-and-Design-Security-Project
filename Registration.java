package classes;

import java.sql.SQLException;

public class Registration{

	//instance fields
	User user;
	
	
    // constructor
    public Registration(User user) {
    	this.user = user;
    }
    
    // get methods 
    public String registration(String title, String forename, String surname, String university, String loginID, String password, boolean isReviewer, boolean isEditor, boolean isAuthor){
    	return registration(title, forename, surname, university, loginID, password, isReviewer, isEditor, isAuthor);
    }
    
    // set methods
    public void selfRegistration(String title, String forename, String surname, String university, String loginID, String password, boolean isReviewer, boolean isEditor, boolean isAuthor){
    	registration(title, forename, surname, university, loginID, password, isReviewer, isEditor, isAuthor);
    }
    
    public void colleagueRegistration(String title, String forename, String surname, String university, String loginID, String password, boolean isReviewer, boolean isEditor, boolean isAuthor) throws ClassNotFoundException, SQLException{
    	Usertable.insertData(title, forename, surname, university, loginID, password, isReviewer, isEditor, isAuthor);
    }
    
    public void changePassword(User user){
    	
    }
    
    public void retire(String loginID) {
        
    }
    
}
