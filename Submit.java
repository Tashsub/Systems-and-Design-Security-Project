public class Submit extends ReviewArticle {
	
	String submissionTitle; 
	String submisisonAbstract; 
	String submissionLink; 
	String mainAuthor; 
	String authors; 

	public Submit(String AnonymousID, String reviewSummary, String typoErrors, String criticism, String response,
			String reviewer, String submissionID, String submissionTitle, String submisisonAbstract, String submissionLink, 
			String mainAuthor,String authors) {
		super(AnonymousID, reviewSummary, typoErrors, criticism, response, reviewer, submissionID);
	this.submissionTitle  = submissionTitle; 
	this.submisisonAbstract = submisisonAbstract; 
	this.submissionLink = submissionLink; 
	this.mainAuthor = mainAuthor; 
	this.authors = authors; 	
	}

	public String getSubmissionTitle() {
		return submissionTitle;
	}

	public void setSubmissionTitle(String submissionTitle) {
		this.submissionTitle = submissionTitle;
	}

	public String getSubmisisonAbstract() {
		return submisisonAbstract;
	}

	public void setSubmisisonAbstract(String submisisonAbstract) {
		this.submisisonAbstract = submisisonAbstract;
	}

	public String getSubmissionLink() {
		return submissionLink;
	}

	public void setSubmissionLink(String submissionLink) {
		this.submissionLink = submissionLink;
	}

	public String getMainAuthor() {
		return mainAuthor;
	}

	public void setMainAuthor(String mainAuthor) {
		this.mainAuthor = mainAuthor;
	}

	public String getAuthors() {
		return authors;
	}

	public void setAuthors(String authors) {
		this.authors = authors;
	}
	
	
	public String makeSubmision(String submissionTitle, String submisisonAbstract, String submissionLink, String mainAuthor, String authors) {
		String lol = "lol"; 
		return lol; 
	}
	
	

}
