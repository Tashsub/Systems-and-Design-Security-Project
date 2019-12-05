package classes;  
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.*;

import gui.NewJournal;

import java.awt.EventQueue;
import java.awt.Font;

public class Article implements ActionListener {
	
	 
    //Database credentials
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://stusql.dcs.shef.ac.uk/team037";
    static final String USER = "team037";
    static final String PASS = "d84f5e63";
    static Connection conn = null;
    static Statement stmt = null;

    String articleID;
    String title;
    String abstracts;
    String file;
    String mainAuthor;
	String authors;
	
    public Article (String articleID, String title, String abstracts, String file, String mainAuthor, String authors) {
        this.articleID = articleID;
        this.title = title;
        this.abstracts = abstracts;
    	this.file = file;
    	this.mainAuthor = mainAuthor;
        this.authors = authors;
    }

    public static void initialiseArticleTable() throws ClassNotFoundException, SQLException{

        try{
            Class.forName("org.gjt.mm.mysql.Driver");

            //open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //execute a query
            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();

            String sql = "CREATE TABLE Article (" +
            		"ArticleID VARCHAR (100)," +
            		"Title VARCHAR (100)," +
            		"Abstracts VARCHAR (500)," +
		    		"File VARCHAR (100)," +
		    		"MainAuthor VARCHAR (100)," +
		    		"Authors VARCHAR (200)," +
		    		"PRIMARY KEY (ArticleID))";
//		    		"FOREIGN KEY (ArticleID) REFERENCES Submission (submissionID))";
            
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
    
    public static void insertData(String articleID, String title, String abstracts, String file, String mainAuthor, String authors) throws ClassNotFoundException, SQLException {
    	try {
    		Class.forName("org.gjt.mm.mysql.Driver");
    		conn = DriverManager.getConnection(DB_URL, USER, PASS);
    		//creating the query that will be inserted into the database
    		String query = " insert into Article (articleID, title, abstracts, file, mainAuthor, authors)"
    				+ " values (?,?,?,?,?,?)"; 
    		PreparedStatement stmt = conn.prepareStatement(query);
    		stmt.setString(1, articleID); 
    		stmt.setString(2, title); 
    		stmt.setString(3, abstracts); 
    		stmt.setString(4, file); 
    		stmt.setString(5, mainAuthor); 
    		stmt.setString(6, authors); 
    		
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
    	//Article ai = new Article("20191204", "Ha", "He", "Hi", "Ho","Hu");
    	//ai. initialiseArticleTable(); 
    	//initialiseArticleTable(); 
    }

	
	public void actionPerformed(ActionEvent e) {
        // if the user presses the save button show the save dialog 
        String com = e.getActionCommand(); 
  
        if (com.equals("ADD")) { 
        	try {
        		NewJournal nj = new NewJournal();
				insertData(nj.txtJIssn.getText(), "Ha", "He", "Hi", "Ho","Hu");
				
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
        }
        else { 
           System.out.println("Sorry");
        } 
          
         
    }  
}