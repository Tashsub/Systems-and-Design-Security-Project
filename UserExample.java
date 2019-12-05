package Systems;

import java.sql.*;

public class User{

	//Database credentials
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://stusql.dcs.shef.ac.uk/team037";
    static final String USER = "team037";
    static final String PASS = "d84f5e63";
    static Connection conn = null;
    static Statement stmt = null;
    
    
  //instance fields
  	protected String title;
  	protected String forename;
  	protected String surname;
  	protected String loginID;
  	protected String university;
  	protected String password;
  	protected boolean isReviewer;
  	protected boolean isEditor;
  	protected boolean isAuthor;
  	
  	//Open connection Method
  	public static void openConnection() throws SQLException, ClassNotFoundException {
  		Class.forName("org.gjt.mm.mysql.Driver");
  		conn = DriverManager.getConnection(DB_URL, USER, PASS);
  		stmt = conn.createStatement();
  	}
  	
  	
    //Within User we will have the author/reviewer and editor 

  	
  //------------------------ Author --------------------------
    public static void createAuthor() throws ClassNotFoundException, SQLException {
    	try{
    		
            openConnection();
            
            
            String sql = "CREATE TABLE Author " +
            "(Title  VARCHAR(100), " +
            " Forname VARCHAR(150), " + 
            " Surname VARCHAR(250), " + 
            " University VARCHAR(150), " + 
            " Login VARCHAR(150), "+
            " Password VARCHAR(150), "+
            " MainAuthor Boolean not NULL, "+ 
            " PRIMARY KEY (Login))"; 
            
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
    
  //------------------------ Editor --------------------------
    
    public static void createEditor() throws ClassNotFoundException, SQLException {
    	try{
    		
    		 openConnection();

            String sql = "CREATE TABLE Editor " +
            "(Title  VARCHAR(100), " +
            " Forname VARCHAR(150), " + 
            " Surname VARCHAR(250), " + 
            " Unversity VARCHAR(150), " + 
            " Login VARCHAR(150), "+
            " Password VARCHAR(150), "+
            " ChiefEditor Boolean not NULL, "+ 
            " PRIMARY KEY (Login))"; 
            
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
    
    //------------------------ Reviewer --------------------------
    
    public static void createReviewer() throws ClassNotFoundException, SQLException {
    	try{
    		
    		 openConnection();

            String sql = "CREATE TABLE Reviewer " +
            "(Title  VARCHAR(100), " +
            " Forname VARCHAR(150), " + 
            " Surname VARCHAR(250), " + 
            " Unversity VARCHAR(150), " + 
            " Login VARCHAR(150), "+
            " Password VARCHAR(150), "+
            " Reviewer Boolean not NULL, "+ 
            " PRIMARY KEY (Login))"; 
            
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
    
    //-----------------------------User---------------------------
    
    public static void initialiseUsertable() throws ClassNotFoundException, SQLException{

        try{
        	 openConnection();

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
    
    //----------------------Insert data into User table-------------------
    
    public void insertData(String title, String forename, String surname, String university, String loginID, String password, boolean isReviewer, boolean isEditor, boolean isAuthor) throws ClassNotFoundException, SQLException {
    	try {
    		 openConnection();
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
    
   
    //---------------- Return password from database 
    
    //return the password if found  and if not then return null; 
    //takes in a string, ideally the username/loginID and checks if that username exists if so return its corresponding password
    public static String checkUser(String userName) throws SQLException {
    	String userPassword = null;
    	String sql = "SELECT password FROM User WHERE email = `qwe@sheffield.ac.uK` ";
    	try {
    		 openConnection();
		
    	PreparedStatement st = conn.prepareStatement("SELECT * FROM User WHERE  loginID =?");
    	st.setString(1,userName);
    	ResultSet res = st.executeQuery();
    	
    	//if a password exists matching the loginID then find the password
    	if(res.next()==true) {
    		 userPassword = res.getString("password");
    	}else {
    		userPassword = null; 
    	}
    	
		conn.close();
		
    	}catch (Exception e) {
    		System.out.println("Got an exception!"); 
    		System.out.println(e.getMessage()); 
    	}
        finally {
          if (conn != null) conn.close();
        }
    	return userPassword;
    	
    }
    
    //--------Update method for isAuthor, isEditor, isReviewer
    
    public static void updateTypeOfUser(String loginID, boolean isAuthor, boolean isEditor, boolean isReviewer) throws SQLException {
    	
    	try {
    		openConnection();
    		
    		String query1 = "update User set isAuthor = ? where loginID = ?"; 
    		String query2 = "update User set isEditor = ? where loginID = ?"; 
    		String query3 = "update User set isReviewer = ? where loginID = ?"; 
    		
    		PreparedStatement preparedStmt1 = conn.prepareStatement( query1);
    		PreparedStatement preparedStmt2 = conn.prepareStatement( query2);
    		PreparedStatement preparedStmt3 = conn.prepareStatement( query3);
    		
    		
    		preparedStmt1.setBoolean(1, isAuthor);
    	    preparedStmt1.setString(2,loginID );
    	    
    	    preparedStmt2.setBoolean (1, isEditor  );
    	    preparedStmt2.setString(2, loginID);
    	    
    	    preparedStmt3.setBoolean(1, isReviewer);
    	    preparedStmt3.setString(2, loginID);
    		
    	    
    	    preparedStmt1.execute();
    	    preparedStmt2.execute();
    	    preparedStmt3.execute();
    	    
    	    conn.close();
    	    
    		}catch (Exception e) {
        		System.out.println("Got an exception!"); 
        		System.out.println(e.getMessage()); 
        	}
            finally {
              if (conn != null) conn.close();
            }
    	
    }
    
    //---------------------------Check email already exists in DB
    
    public static boolean checkEmailExists(String loginID) throws SQLException {
    	boolean email = false;  
    	try {
    		openConnection();
    		
    		String query = "SELECT * FROM User where loginID = ? "; 
    		
    		
    		PreparedStatement preparedStmt = conn.prepareStatement( query);
    		preparedStmt.setString(1, loginID);
    		
    		ResultSet res = preparedStmt.executeQuery();
    		
    		
    	    
			if(res.next()==true) {
			 //email = res.getString("loginID");
			email = true;
			}else {
			 email = false; 
			       	}
    	    conn.close();
    	    
    		}catch (Exception e) {
        		System.out.println("Got an exception!"); 
        		System.out.println(e.getMessage()); 
        	}
            finally {
              if (conn != null) conn.close();
            }
    	return email;
    }
    

  public static void main(String[] args) throws ClassNotFoundException, SQLException {
	  
	  //call methods 
	  //createAuthor();
	  //createEditor(); 
	  //createReviewer(); 
	  //System.out.println(checkUser("qwe@sheffield.ac.uk"));
	 // updateTypeOfUser("qwe@sheffield.ac.uk", true, true, false );

	  System.out.println(checkEmailExists("j@gmail.com"));
	  
	  
	  
	  
  }
   
}
