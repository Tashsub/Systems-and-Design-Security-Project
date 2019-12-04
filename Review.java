package classes; 

import java.sql.*;

public class Review {
	
	 
    //Database credentials
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://stusql.dcs.shef.ac.uk/team037";
    static final String USER = "team037";
    static final String PASS = "d84f5e63";
    static Connection conn = null;
    Statement stmt = null;

    String reviewer;
    int anonymousID;
    String initialVerdict;
    String critisisms;
	String response;
	String finalVerdict;
	
    
    public Review(String reviewer, int anonymousID, String initialVerdict, String critisisms, String response, String finalVerdict) {
    	this.reviewer = reviewer;
    	this.anonymousID = anonymousID;
        this.initialVerdict = initialVerdict;
    	this.critisisms = critisisms;
        this.response = response;
        this.finalVerdict = finalVerdict;
       
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

            String sql = "CREATE TABLE Review (" +
            		"Reviewer VARCHAR (150)," +
            		"AnonymousID INT (50)," +
            		"InitialVerdict VARCHAR (150)," +
		    		"Critisisms VARCHAR (150)," +
		    		"Response VARCHAR (150)," + 
		    		"FinalVerdict VARCHAR (150)," +
		    		"PRIMARY KEY (AnonymousID))";
            
            //Creates the table in the database
            stmt.executeUpdate(sql);
            
            System.out.println("Created table in given database...");
            
            
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally {
          if (conn != null) conn.close();
        }

    }
    
    public static void insertData(String reviewer, int anonymousID, String initialVerdict, String critisisms, String response, String finalVerdict) throws ClassNotFoundException, SQLException {
    	try {
    		Class.forName("org.gjt.mm.mysql.Driver");
    		conn = DriverManager.getConnection(DB_URL, USER, PASS);
    		//creating the query that will be inserted into the database
    		String query = " insert into Review (reviewer, anonymousID, initialVerdict, critisisms, response, finalVerdict)"
    				+ " values (?,?,?,?,?,?)"; 
    		PreparedStatement stmt = conn.prepareStatement(query);
    		stmt.setString(1, reviewer);
    		stmt.setInt(2, anonymousID); 
    		stmt.setString(3, initialVerdict);
    		stmt.setString(4, critisisms); 
    		stmt.setString(5, response);
    		stmt.setString(6, finalVerdict);
    		
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
    	Review yo = new Review("Person", 001, "No error", "Bad", "Nice try", "Goodbye");
    	yo. initialiseReviewTable();
    	 
    }
}