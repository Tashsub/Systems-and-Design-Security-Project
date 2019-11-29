package classes;

public class Journal{

	//instance fields
	protected int journalISSN;
	protected String volume;
	protected int edition;
	protected int pagenum;
	
	
    // constructor
    public Journal(int journalISSN, String volume, int edition, int pagenum) {
        this.journalISSN = journalISSN;
        this.volume = volume;
        this.edition = edition;
        this.pagenum = pagenum;
    }
    
    // set methods
    public void journal() {
    	
    }
    
}
