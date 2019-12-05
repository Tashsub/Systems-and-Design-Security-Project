package classes;

public class Login {

	//instance fields
	User user;
	
    // constructor
    public Login(User user) {
        this.user = user;	
    }
    
    // set methods
    public void loginReviewer(String loginID, String password, boolean isReviewer) {
    	if (isReviewer)
    	    System.out.println("Login as Reviewer");
    	else
    		System.out.println("Sorry");
    }
    
    public void loginAuthor(String loginID, String password, boolean isAuthor) {
    	if (isAuthor)
    		System.out.println("Login as Author");
    	else
    		System.out.println("Sorry");
    }
    
    public void logineditor(String loginID, String password, boolean isEditor) {
    	if (isEditor)
    		System.out.println("Login as Editor");
    	else
    		System.out.println("Sorry");
    }
   
    public void loginReader() {
    	
    	
    }
}
