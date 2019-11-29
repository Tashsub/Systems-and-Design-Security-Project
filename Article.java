package classes;

public class Article{

	//instance fields
	protected String articleID;
	protected String title;
	protected String abstract1;
	protected String link;
	
    // constructor
    public Article(String articleID, String title, String abstract1, String link){
    	this.articleID = articleID;
    	this.title = title;
    	this.abstract1 = abstract1;
    	this.link = link;
    }
    
    // get methods 
    public String getArticleID(){
    	return this.articleID;
    }
    
    public String getTitle(){
    	return this.title;
    }
    
    public String getAbstract1(){
    	return this.abstract1;
    }
    
    public String getLink(){
    	return this.link;
    }
    
    // set methods
    
    
    
}
