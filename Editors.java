package classes;  

import java.sql.*;

public class Editors {
	
    //Database credentials
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://stusql.dcs.shef.ac.uk/team037";
    static final String USER = "team037";
    static final String PASS = "d84f5e63";
    static Connection conn = null;
    static Statement stmt = null;

    String submission;
    String editedArticle;
    String chiefEditor;
    String editor;
    boolean perm;
	boolean finalDecision;
	String newPassword;
	
    public Editors (String submission, String editedArticle, String chiefEditor, String editor, boolean perm, boolean finalDecision, String newPassword) {
        this.submission = submission;
        this.editedArticle = editedArticle;
        this.chiefEditor = chiefEditor;
    	this.editor = editor;
    	this.perm = perm;
        this.finalDecision = finalDecision;
        this.newPassword = newPassword;
    }

    public static void initialiseEditorsTable() throws ClassNotFoundException, SQLException{

        try{
            Class.forName("org.gjt.mm.mysql.Driver");

            //open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //execute a query
            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();

            String sql = "CREATE TABLE Editors (" +
            		"Submission VARCHAR (100)," +
            		"EditedArticle VARCHAR (100)," +
            		"ChiefEditor VARCHAR (50)," +
		    		"Editor VARCHAR (100)," +
		    		"Perm BOOLEAN (50)," +
		    		"FinalDecision BOOLEAN (50)," +
		    		"newPassword VARCHAR (50))";
            
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
    
    public static void insertData(String submission, String editedArticle, String chiefEditor, String editor, boolean perm, boolean finalDecision, String newPassword) throws ClassNotFoundException, SQLException {
    	try {
    		Class.forName("org.gjt.mm.mysql.Driver");
    		conn = DriverManager.getConnection(DB_URL, USER, PASS);
    		//creating the query that will be inserted into the database
    		String query = " insert into Editors (submission, editedArticle, chiefEditor, editor, perm, finalDecision, newPassword)"
    				+ " values (?,?,?,?,?,?,?)"; 
    		PreparedStatement stmt = conn.prepareStatement(query);
    		stmt.setString(1, submission); 
    		stmt.setString(2, editedArticle); 
    		stmt.setString(3, chiefEditor); 
    		stmt.setString(4, editor); 
    		stmt.setBoolean(5, perm); 
    		stmt.setBoolean(6, finalDecision);
    		stmt.setString(7, newPassword); 
    		
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
    	//Editors ed = new Editors("0829", "A", "E", "I", true, false, "O");
    	//ed. initialiseEditorsTable(); 
    	initialiseEditorsTable(); 
    }
}