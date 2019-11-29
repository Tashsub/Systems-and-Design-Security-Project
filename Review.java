package classes;

public class Review{

	//instance fields
	protected String critisisms;
	verdictEnum judgement;
	protected String response;
	Submission submission;
	
    // constructor
    public Review(String critisisms, verdictEnum judgement, String response, Submission submission) {
        this.critisisms = critisisms;
        this.judgement = judgement;
        this.response = response;
        this.submission = submission;
    }
    
    // set methods
    public getResponse(Submission submission) {
    	return this.response;
    }
    
}
