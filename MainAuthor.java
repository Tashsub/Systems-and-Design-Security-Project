package classes;

public class MainAuthor{

	//instance fields
	User author;
	boolean isMainAuthor;
	Submission submission;
	
    // constructor
    public MainAuthor(User author, boolean isMainAuthor, Submission submission){
    	this.author = author;
    	this.isMainAuthor = isMainAuthor;
    	this.submission = submission;
    }
    
    // get methods 
    
    
    // set methods
    public void checkMainAuthor(User author, Submission submission){
    	if (author.isAuthor) //&& submission
    		System.out.println("You are the Main Author");
    	else
    		System.out.println("You are not the Main Author");
    }
    
    public void retireMainAuthor(User author) {
    	author.isAuthor = false;
    }
}
