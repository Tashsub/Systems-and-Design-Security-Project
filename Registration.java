package classes;

public class Registration{

	//instance fields
	User user;
	
	
    // constructor
    public Registration(User user) {
    	this.user = user;
    }
    
    // get methods 
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
    
    public void changePassword(User user){
    	
    }
    
    public void retire(String loginID) {
        
    }
    
}
