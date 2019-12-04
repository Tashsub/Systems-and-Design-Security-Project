package classes;  
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
    String mainAuthor;
    String authors; 
    String status;
    String review1;
    String review2;
    String review3;
    
    public Submission(String submissionID, String title, String abstracts, String link, String mainAuthor, String authors, String status, String review1, String review2, String review3){
        this.submissionID = submissionID; 
        this.title = title; 
        this.abstracts = abstracts; 
        this.link = link; 
        this.mainAuthor = mainAuthor; 
        this.authors = authors; 
        this.status = status;
        this.review1 = review1;
        this.review2 = review2;
        this.review3 = review3;
    }
    

    public void initialiseReviewTable() throws ClassNotFoundException, SQLException{

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
            "(SubmissionID VARCHAR(30) not NULL, " +
            " SubmissionTitle VARCHAR(40), " + 
            " SubmissionAbstract VARCHAR(500), " + 
            " SubmissionLink VARCHAR(20), " + 
            " MainAuthor VARCHAR(50), "+
            " Authors VARCHAR(100), " +
            " Status VARCHAR(50), " +
            " Review1 VARCHAR(100), " +
            " Review2 VARCHAR(100), " +
            " Review3 VARCHAR(100), " +
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
    
    public static void insertData(String submissionID, String submissionTitle, String submissionAbstract,String submissionLink, String mainAuthor, String authors, String status, String review1, String review2, String review3) throws ClassNotFoundException, SQLException {
    	try {
    		Class.forName("org.gjt.mm.mysql.Driver");
    		conn = DriverManager.getConnection(DB_URL, USER, PASS);
    		//creating the query that will be inserted into the database
    		String query = " insert into Submission (SubmissionID, SubmissionTitle, SubmissionAbstract, SubmissionLink, mainAuthor, Authors, Status, Review1, Review2, Review3)"
    				+ " values (?,?,?,?,?,?,?,?,?,?)"; 
    		PreparedStatement stmt = conn.prepareStatement(query); 
    		stmt.setString(1, submissionID ); 
    		stmt.setString(2, submissionTitle ); 
    		stmt.setString(3, submissionAbstract); 
    		stmt.setString(4, submissionLink); 
    		stmt.setString(5, mainAuthor);
    		stmt.setString(6, authors);
    		stmt.setString(7, status); 
    		stmt.setString(8, review1);
    		stmt.setString(9, review2);
    		stmt.setString(10, review3);
    		
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
    	Submission lol = new Submission("thehe", "How to write your first book", "HSHSHHSGSGSHHSHSH", "www.bookfirst.com", "Tash", "Ha", "Finished", "Good", "Great", "Fantastic" );
    	
    	lol. initialiseReviewTable(); 
    	
    	//(String submissionID, String title,String abstracts,String link,User mainAuthor, User authors, Status status) 
    	//insertData("10029322", "How to cook", "cooking for advanced people", "www.cook.com", "Jimmy, Kent, May", "EHEHHD", "HSHDHHS", false); 
    }
}