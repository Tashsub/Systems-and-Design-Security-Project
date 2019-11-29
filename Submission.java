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
    
    public Submission(String submissionID, String title,String abstracts,String link,User mainAuthor, User authors, Status status){
        this.submissionID = submissionID; 
        this.title = title; 
        this.abstracts = abstracts; 
        this.link = link; 
        this.mainAuthor = mainAuthor; 
        this.authors = authors; 
        this.status = status; 
    }
    

    public void makeSubmission(){
        
    }
}