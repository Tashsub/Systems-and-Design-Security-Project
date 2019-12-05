package classes;

public class Submissionc{

	enum CurrentStatus {   
        Pending, Accepted, Rejected
    }

    //Should we declare variables as private or public
    Journal submissionID; 
    String title; 
    String abstracts; 
    String link; 
    User mainAuthor;
    User authors; 
    String status;
    Review review1;
    Review review2;
    Review review3;

    public Submissionc(Journal submissionID, String title, String abstracts, String link, User mainAuthor, User authors, String status, Review review1, Review review2, Review review3){
        this.submissionID = submissionID; 
        this.title = title; 
        this.abstracts = abstracts; 
        this.link = link; 
        this.mainAuthor = mainAuthor; 
        this.authors = authors; 
        this.status = status;
        this.review1 = review1;
        this.review2 = review2;
        this.review3 = review3;
    }
    
    public void trackStatus(Submission submissionID, String title, String abstracts, String link, User mainAuthor, User authors, String status, Review review) {	
		
	}

    public void makeSubmission(Submission submissionID, String title, String abstracts, String link, User mainAuthor, User authors) {
    	
    }

    public void respond(User mainAuthor, String response) {
    	
    }

    public boolean permission(Review review1, Review review2, Review review3) {
		return false;
    	
    }

}