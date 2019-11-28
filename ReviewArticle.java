
public class ReviewArticle{

    enum AnonymousID{
        Reviewer1,  Reviewer2, Reviewer3
    }

    enum Verdict{
       StrongAccept, WeakAccept, WeakReject, StrongReject  
    }

    //Should we declare variables as private or public
    String AnonymousID; 
    String reviewSummary; 
    String typoErrors; 
    String criticism; 
    String response; 
    String reviewer;
    String submissionID; 

    public ReviewArticle(String AnonymousID, String reviewSummary, String typoErrors, String criticism, String response, String reviewer, String submissionID ){
    this.AnonymousID = AnonymousID; 
    this.reviewSummary = reviewSummary; 
    this.typoErrors = typoErrors; 
    this.criticism = criticism; 
    this.response = response; 
    this.reviewer = reviewer; 
    this.submissionID = submissionID; 
    
    }
    
    public String getReviewer() {
        return reviewer; 
    }
    
    public String getSubmissionID() {
        return submissionID; 
    }
    
    public String anonymise( String reviewer, String submisisonID) {
    
       //does this mean takes in a persons name at converts that to either reviwer 1, 2 or 3? 

    return anonymousID;
    }



    public static void main (String[] args){

       // AnonymousID lol = AnonymousID.Reviewer1; 
        System.out.println(lol); 

    }
}
