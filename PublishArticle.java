public class PublishArticle {

	String submissionTitle; 
	String submisisonAbstract; 
	String submissionLink; 
	String mainAuthor; 
	String authors;
	
	
	 enum Verdict{
	    StrongAccept, WeakAccept, WeakReject, StrongReject  
	    }
	    
	Verdict reviewer1; 
    Verdict reviewer2; 
    Verdict reviewer3;
	
    public PublishArticle( ) {

    }
	
}