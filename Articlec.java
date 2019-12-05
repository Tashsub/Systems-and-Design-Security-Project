package classes;

public class Articlec{

	//instance fields
	String articleID;
	String title;
	String abstract1;
	String file;
	User mainAuthor;
	User authors;
	
    // constructor
    public Articlec(String articleID, String title, String abstract1, String file, User mainAuthor, User authors){
    	this.articleID = articleID;
    	this.title = title;
    	this.abstract1 = abstract1;
    	this.file = file;
    	this.mainAuthor = mainAuthor;
    	this.authors = authors;
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
    
    public String getFile(){
    	return this.file;
    }
    
    // set methods
    
    
    
}
