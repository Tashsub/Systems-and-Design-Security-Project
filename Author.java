package database;

public class Author{

	//instance fields
	protected boolean attribute1;
	protected boolean attribute2;
	protected boolean attribute3;
	protected boolean attribute4;
	
    // constructor
    public Author(boolean attribute1, boolean attribute2, boolean attribute3, boolean attribute4){
    	this.attribute1 = attribute1;
    	this.attribute2 = attribute2;
    	this.attribute3 = attribute3;
    	this.attribute4 = attribute4;
    }
    
    // get methods 
    
    
    // set methods
    public void registerCoAuthors(String loginID){
    	this.attribute1 = true;
    }
    
    public void trackStatus(String loginID){
        
    }
    
    public void responseCritisisms(String loginID, String articleID) {
    	
    }
}
