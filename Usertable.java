package classes;  
import java.sql.*;

public class Usertable {
	
	 
    //Database credentials
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://stusql.dcs.shef.ac.uk/team037";
    static final String USER = "team037";
    static final String PASS = "d84f5e63";
    static Connection conn = null;
    static Statement stmt = null;

    String title;
    String forename;
    String surname;
    String university;
    String loginID;
    String password;
    boolean isReviewer;
    boolean isEditor;
    boolean isAuthor;
    
	
    public Usertable (String title, String forename, String surname, String university, String loginID, String password, boolean isReviewer, boolean isEditor, boolean isAuthor) {
        this.title = title;
        this.forename = forename;
        this.surname = surname;
    	this.university = university;
        this.loginID = loginID;
        this.password = password;
        this.isReviewer = isReviewer;
        this.isEditor = isEditor;
        this.isAuthor = isAuthor;
    }

    public static void initialiseUsertable() throws ClassNotFoundException, SQLException{

        try{
            Class.forName("org.gjt.mm.mysql.Driver");

            //open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //execute a query
            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();

            String sql = "CREATE TABLE User (" +
            		"title VARCHAR (150)," +
            		"forename VARCHAR (150)," +
            		"surname VARCHAR (150)," +
            		"university VARCHAR (150)," +
            		"loginID VARCHAR (150)," +
            		"password VARCHAR (150)," +
            		"isReviewer boolean," +
            		"isEditor boolean," +
            		"isAuthor boolean," +
		    		"PRIMARY KEY (loginID))";
            
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
    
    public static void insertData(String title, String forename, String surname, String university, String loginID, String password, boolean isReviewer, boolean isEditor, boolean isAuthor) throws ClassNotFoundException, SQLException {
    	try {
    		Class.forName("org.gjt.mm.mysql.Driver");
    		conn = DriverManager.getConnection(DB_URL, USER, PASS);
    		//creating the query that will be inserted into the database
    		String query = " insert into User (title, forename, surname, university, loginID, password, isReviewer, isEditor, isAuthor)"
    				+ " values (?,?,?,?,?,?,?,?,?)"; 
    		PreparedStatement stmt = conn.prepareStatement(query);
    		stmt.setString(1, title);
    		stmt.setString(2, forename); 
    		stmt.setString(3, surname); 
    		stmt.setString(4, university);
    		stmt.setString(5, loginID);
    		stmt.setString(6, password);
    		stmt.setBoolean(7, isReviewer); 
    		stmt.setBoolean(8, isEditor); 
    		stmt.setBoolean(9, isAuthor);  
    		
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
    	//Usertable ut = new Usertable("Mr", "Man", "Men", "CS", "qwe@sheffield.ac.uk", "123", true, false, false);
    	//ut.initialiseUserTable(); 
    	//initialiseUsertable();
    	insertData("Mr", "Man", "Men", "CS", "qwe@sheffield.ac.uk", "123", true, false, false);
    	 
    }
}