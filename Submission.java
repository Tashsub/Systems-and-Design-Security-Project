import java.sql.*;

public class Submission {
	
	
	 
    //Database credentials
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://stusql.dcs.shef.ac.uk/team037";
    static final String USER = "team037";
    static final String PASS = "d84f5e63";
    static Connection conn = null;
    Statement stmt = null;

    enum CurrentStatus {   
        Pending, Accepted, Rejected
    }

    String submissionID; 
    String title; 
    String abstracts; 
    String link; 
    User mainAuthor; 
    User authors; 
    CurrentStatus status;  
    
    public Submission(String submissionID, String title,String abstracts,String link,User mainAuthor, User authors, CurrentStatus status){
        this.submissionID = submissionID; 
        this.title = title; 
        this.abstracts = abstracts; 
        this.link = link; 
        this.mainAuthor = mainAuthor; 
        this.authors = authors; 
        this.status = status; 
    }
    

    public void initialiseSubmissionTable() throws ClassNotFoundException, SQLException{

        try{
            Class.forName("org.gjt.mm.mysql.Driver");

            //open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //execute a query
            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();

            String sql = "CREATE TABLE Submission " +
            "(SubmissionID VARCHAR(150) not NULL, " +
            " SubmissionTitle VARCHAR(150), " + 
            " SubmissionAbstract VARCHAR(250), " + 
            " SubmissionLink VARCHAR(150), " + 
            " Authors VARCHAR(150), "+
            " Reviews VARCHAR(150), "+
            " Responses VARCHAR(150), "+ 
            " Verdict Boolean not null, "+
            " PRIMARY KEY ( SubmissionID ))";
            
            //Creates the table in the database
            stmt.executeUpdate(sql);
            
            System.out.println("Created table in given database...");
            
            
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally {
          if (conn != null) conn.close();
        }

    }
    
    public static void insertData(String submissionID, String submissionTitle, String submissionAbstract,String submissionLink, String authors, String reviews, String responses, boolean verdict) throws ClassNotFoundException, SQLException {
    	try {
    		Class.forName("org.gjt.mm.mysql.Driver");
    		conn = DriverManager.getConnection(DB_URL, USER, PASS);
    		//creating the query that will be inserted into the database
    		String query = " insert into Submission (SubmissionID, SubmissionTitle, SubmissionAbstract, SubmissionLink, Authors, Reviews, Responses, Verdict)"
    				+ " values (?,?,?,?,?,?,?,?)"; 
    		PreparedStatement stmt = conn.prepareStatement(query); 
    		stmt.setString(1, submissionID ); 
    		stmt.setString(2, submissionTitle ); 
    		stmt.setString(3, submissionAbstract); 
    		stmt.setString(4, submissionLink); 
    		stmt.setString(5, authors); 
    		stmt.setString(6, reviews); 
    		stmt.setString(7, responses); 
    		stmt.setBoolean(8, verdict); 
    		
    		//execute the query and push the data into the submission table
    		stmt.execute(); 
    		conn.close(); 
    		
    	}catch (Exception e) {
    		System.out.println("Got an exception!"); 
    		System.out.println(e.getMessage()); 
    	}
        finally {
          if (conn != null) conn.close();
        }
    	
    	
    	
    }

    
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
    	User coAuthor = new User("Mr", "John", "Griffin", "log234", "UniversityOfSheffield", "qwert", false, false, true); 
    	User mainAuthor = new User("Mr", "Kev", "Hart", "log78", "UniversityOfSheffield", "1234", false, false, true);  
    	CurrentStatus c = CurrentStatus.Accepted; 
    	Submission lol = new Submission("thehe", "How to write your first book", "HSHSHHSGSGSHHSHSH", "www.bookfirst.com", coAuthor, mainAuthor, c );
    	
    	lol. initialiseSubmissionTable(); 
    	
    	//(String submissionID, String title,String abstracts,String link,User mainAuthor, User authors, Status status) 
    	//insertData("10029322", "How to cook", "cooking for advanced people", "www.cook.com", "Jimmy, Kent, May", "EHEHHD", "HSHDHHS", false); 
    }
}