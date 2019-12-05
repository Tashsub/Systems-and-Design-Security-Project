package classes;

public class Journalc{

	//instance fields
	int journalISSN;
	String volume;
	String edition;
	int pageNum;
	
    // constructor
	public Journalc(int journalISSN, String volume, String edition, int pageNum) {
        this.journalISSN = journalISSN;
        this.volume = volume;
        this.edition = edition;
        this.pageNum = pageNum;
    }
    
    // set methods 
    public void addVolume(String volume){
    	this.volume += volume;
    }
    
    public void addEdition(String edition){
    	this.edition += edition;
    }
    
    public void addPageNum(int pageNum){
    	this.pageNum += pageNum;
    }
}
