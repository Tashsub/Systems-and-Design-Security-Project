package classes;

import java.sql.*;

public class Journal{

	//Database credentials
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://stusql.dcs.shef.ac.uk/team037";
    static final String USER = "team037";
    static final String PASS = "d84f5e63";
    static Connection conn = null;
    Statement stmt = null;
    
	//instance fields
	int journalISSN;
	String volume;
	String edition;
	int pageNum;
	
	
    // constructor
    public Journal(int journalISSN, String volume, String edition, int pageNum) {
        this.journalISSN = journalISSN;
        this.volume = volume;
        this.edition = edition;
        this.pageNum = pageNum;
    }
    
    public void initialiseJournalTable() throws ClassNotFoundException, SQLException{

        try{
            Class.forName("org.gjt.mm.mysql.Driver");

            //open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //execute a query
            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();

            String sql = "CREATE TABLE Journal (" +
            		"JournalISSN INT (50)," +
            		"Volume VARCHAR (50)," +
		    		"Edition VARCHAR (50)," +
		    		"PageNum INT (50))"; 
            
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
    
    public static void insertData(int journalISSN, String volume, String edition, int pageNum) throws ClassNotFoundException, SQLException {
    	try {
    		Class.forName("org.gjt.mm.mysql.Driver");
    		conn = DriverManager.getConnection(DB_URL, USER, PASS);
    		//creating the query that will be inserted into the database
    		String query = " insert into Journal (journalISSN, volume, edition, pageNum)"
    				+ " values (?,?,?,?)"; 
    		PreparedStatement stmt = conn.prepareStatement(query);
    		stmt.setInt(1, journalISSN); 
    		stmt.setString(2, volume); 
    		stmt.setString(3, edition); 
    		stmt.setInt(4, pageNum); 
    		
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
    	Journal yo = new Journal(20191204, "Volume 1", "First edition", 321); 	
    	yo. initialiseJournalTable();
    }
}
