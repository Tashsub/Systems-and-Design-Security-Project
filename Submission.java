public class Submission{

    enum Status {   
        Pending, Accepted, Rejected
    }

    String submissionID; 
    String title; 
    String abstracts; 
    String link; 
    User mainAuthor; 
    User authors; 
    Status status;  
    
    public void makeSubmission(){

    }
}