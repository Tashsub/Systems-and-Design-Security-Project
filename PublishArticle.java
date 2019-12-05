package classes;

public class PublishArticle{

	//instance fields
	Submission submissionInfo;
	String mainAuthor;
	String authors;
	boolean finalDecision;
	
    // constructor
    public PublishArticle(Submission submissionInfo, String mainAuthor, String authors, boolean finalDecision){
    	this.submissionInfo = submissionInfo;
    	this.mainAuthor = mainAuthor;
    	this.authors = authors;
    	this.finalDecision = finalDecision;
    }
    
    // methods 
    public void publish(boolean finalDecision, Submission submissionInfo){
    	
    }
}
