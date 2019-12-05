package classes;

public class Reader{

	//instance fields
	Articlec article;
	
    // constructor
    public Reader(Articlec article){
    	this.article = article;
    }
    
    // get methods 
    public String list(Articlec article){
    	System.out.println("");
		return null;
    }
    
    public void viewArticles(String list){
    	System.out.println(list);
    }
}
