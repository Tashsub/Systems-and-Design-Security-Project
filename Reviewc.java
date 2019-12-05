package classes;

public class Reviewc{

    enum AnonymousID{
        Reviewer1,  Reviewer2, Reviewer3
    }

    enum initialVerdict{
       Champion, WeakAccept, WeakReject, Detractor  
    }
    
    enum finalVerdict{
        Champion, WeakAccept, WeakReject, Detractor  
     }

    //Should we declare variables as private or public
    User reviewer;
    int AnonymousID;
    String initialVerdict;
    String criticism; 
    String response; 
    String finalVerdict;

    public Reviewc(User reviewer,int AnonymousID, String initialVerdict, String criticism, String response, String finalVerdict){
    	this.reviewer = reviewer;
    	this.AnonymousID = AnonymousID; 
        this.initialVerdict = initialVerdict;
    	this.criticism = criticism;
    	this.response = response;
    	this.finalVerdict = finalVerdict;
    }
    
    public void selectSubmission(String submisison) {
    	
    }

    public void anonymise(User reviewer, Submission submisisonID) {
    	
    }

    public void setFinalVerdict(String initialVerdict, String response) {
    	System.out.println(finalVerdict);
    }

    public void noReviewer(String reviewer, String finalVerdict) {
    	
    }

   
}