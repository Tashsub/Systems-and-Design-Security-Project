package classes;  

import java.sql.*;

public class Database {
	 
    //Database credentials
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://stusql.dcs.shef.ac.uk/team037";
    static final String USER = "team037";
    static final String PASS = "d84f5e63";
    static Connection conn = null;
    static Statement stmt = null;

    public static void openConnection() throws SQLException, ClassNotFoundException {
  		Class.forName("org.gjt.mm.mysql.Driver");
  		conn = DriverManager.getConnection(DB_URL, USER, PASS);
  		stmt = conn.createStatement();
  	}
    
    // update function
    public static void update(String table, String col, String newvalue, String condition, String conditionvalue) throws ClassNotFoundException, SQLException {
    	try {
       	    openConnection();
       	    int count = stmt.executeUpdate("UPDATE "+table+" SET "+col+" = '"+newvalue+"' WHERE "+condition+" = '"+conditionvalue+"'");
       	}catch (SQLException ex) {
       	    ex.printStackTrace();
       	}
    	finally {
       	    if (stmt != null) stmt.close();
       	}
    }
    
    // delete all table function
    public static void deleteAllTables() throws ClassNotFoundException, SQLException {
    	try {
       	    openConnection();
       	    String sql = "DROP TABLE CoAuthors, CoEditors, Article, Submission, Review, Journal, User";
      		stmt.executeUpdate(sql);
       	   
       	}catch (SQLException ex) {
       	    ex.printStackTrace();
       	}
    	finally {
       	    if (stmt != null) stmt.close();
       	}
    }
    
    // clear all data inside user table
    public static void deleteAllUserTable() throws ClassNotFoundException, SQLException {
    	try {
       	    openConnection();
       	    String sql = "TRUNCATE TABLE User";
      		stmt.executeUpdate(sql);
       	   
       	}catch (SQLException ex) {
       	    ex.printStackTrace();
       	}
    	finally {
       	    if (stmt != null) stmt.close();
       	}
    }
    
    // delete function
    public static void delete(String table, String col, String value) throws ClassNotFoundException, SQLException {
    	try {
       	    openConnection();
       	    String sql = "DELETE FROM "+table+" WHERE "+ col +" = "+ value;
      		stmt.executeUpdate(sql);
       	   
       	}catch (SQLException ex) {
       	    ex.printStackTrace();
       	}
    	finally {
       	    if (stmt != null) stmt.close();
       	}
    }
    
    // Create Article table
    int articleID;
    int journalISSN;
    String title;
    String abstracts;
    String file;
    String mainAuthor;
	
    public void Article (int journalISSN, String title, String abstracts, String file, String mainAuthor) {
    	this.journalISSN = journalISSN;
        this.title = title;
        this.abstracts = abstracts;
    	this.file = file;
    	this.mainAuthor = mainAuthor;
    }
    
    public static void initialiseArticleTable() throws ClassNotFoundException, SQLException{
        try{
            openConnection();

            String sql = "CREATE TABLE Article (" +
            		"ArticleID INT (30) AUTO_INCREMENT, " +
            		"JournalISSN INT (50), " +
            		"Title VARCHAR (30), " +
            		"Abstracts VARCHAR (250), " +
		    		"File VARCHAR (20), " +
		    		"MainAuthor VARCHAR (20), " +
		    		"PRIMARY KEY (ArticleID), " +
		    		"FOREIGN KEY (JournalISSN) REFERENCES Journal (JournalISSN) " +
		    		"ON UPDATE CASCADE ON DELETE RESTRICT) ENGINE=INNODB";
            
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
    
    // insert and select functions
    public static void insertArticleData(int journalISSN, String title, String abstracts, String file, String mainAuthor) throws ClassNotFoundException, SQLException {
    	try {
    		openConnection();
    		
    		//creating the query that will be inserted into the database
    		String query = " insert into Article (journalISSN, title, abstracts, file, mainAuthor)"
    				+ " values (?,?,?,?,?)"; 
    		PreparedStatement stmt = conn.prepareStatement(query);
    		stmt.setInt(1, journalISSN);
    		stmt.setString(2, title); 
    		stmt.setString(3, abstracts); 
    		stmt.setString(4, file); 
    		stmt.setString(5, mainAuthor); 
    		
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

    public static void printAllArticle() throws ClassNotFoundException, SQLException {
        try {
        	openConnection();
    	    ResultSet res = stmt.executeQuery("SELECT * FROM Article");
    	    System.out.format("%30s%50s%30s%250s%20s%20s\n", "ArticleID", "JournalISSN", "Title", "Abstract", "File", "MainAuthor");
    	    while (res.next()) {
    	        int articleID = res.getInt("articleID");
    	        int journalISSN = res.getInt("journalISSN");
    		    String title = res.getString("title");
    		    String abstracts = res.getString("abstracts");
    		    String file = res.getString("file");
    		    String mainAuthor = res.getString("mainAuthor");
    		    
    		    System.out.format("%30d%50d%30s%250s%20s%20s\n", articleID, journalISSN, title, abstracts, file, mainAuthor);
       	}
       	res.close();
       	}catch (SQLException ex) {
       	    ex.printStackTrace();
       	}
    	finally {
       	    if (stmt != null) stmt.close();
       	}
    }
    
    public static void printArticle(String col, String col1, String value) throws ClassNotFoundException, SQLException {
    	try {
       	    openConnection();
       	    ResultSet res = stmt.executeQuery("SELECT "+col+" FROM Article WHERE "+col1+" = '"+value+"'");
       	    switch(col) {
       	        case("articleID"): System.out.println("ArticleID");
       	       				       while (res.next()) {
       	       				           int articleID = res.getInt("articleID");
       	       				           System.out.println(articleID);}
       	       				       break;
       	        case("journalISSN"): System.out.println("JournalISSN");
			                         while (res.next()) {
			                             int journalISSN = res.getInt("journalISSN");
			                             System.out.println(journalISSN);}
			                         break;
       	        case("title"): System.out.println("Title");
     						   while (res.next()) {
     						       String title = res.getString("title");
	       				           System.out.println(title);}
     						   break;
       	        case("abstracts"): System.out.println("Abstracts");
       	                           while (res.next()) {
			                           String abstracts = res.getString("abstracts");
		                               System.out.println(abstracts);}	
       	                           break;
       	        case("file"): System.out.println("File");
       	       				  while (res.next()) {
                                  String file = res.getString("file");
                                  System.out.println(file);}	
                              break;
       	        case("mainAuthor"): System.out.println("MainAuthor");
                                    while (res.next()) {
                                        String mainAuthor = res.getString("mainAuthor");
                                        System.out.println(mainAuthor);}	
                                    break;
       	        case("*"): System.out.format("%30s%50s%30s%250s%20s%20s\n", "ArticleID", "JournalISSN", "Title", "Abstract", "File", "MainAuthor");
                           while (res.next()) {
                               String articleID = res.getString("articleID");
                               int journalISSN = res.getInt("journalISSN");
	                           String title = res.getString("title");
	                           String abstracts = res.getString("abstracts");
	                           String file = res.getString("file");
	                           String mainAuthor = res.getString("mainAuthor");
	                           
	                           System.out.format("%30d%50d%30s%250s%20s%20s\n", articleID, journalISSN, title, abstracts, file, mainAuthor);}
                           break;
                default: System.out.println("Wrong command");               
       	}
       	res.close();
       	}catch (SQLException ex) {
       	    ex.printStackTrace();
       	}
    	finally {
       	    if (stmt != null) stmt.close();
       	}
    }
    
    public static void printArticlePage() throws ClassNotFoundException, SQLException {
        try {
        	openConnection();// 
    	    ResultSet res = stmt.executeQuery("SELECT ar.JournalISSN, jo.Volume, jo.Edition, ar.Title, ar.Abstracts, ar.MainAuthor, ca.Author, "
    	    	+ "ar.File FROM Article ar, CoAuthors ca, Journal jo WHERE ca.ArticleID = ar.ArticleID AND ar.JournalISSN = jo.JournalISSN");
    	    System.out.format("%10s%50s%20s%30s%250s%20s%20s%20s\n","JournalISSN", "Volume", "Edition", "Title", "Abstract", "MainAuthor", "Author", "File");
    	    while (res.next()) {
    	    	int journalISSN = res.getInt("journalISSN");
    	    	String volume = res.getString("volume");
    	        String edition = res.getString("edition");
    		    String title = res.getString("title");
    		    String abstracts = res.getString("abstracts");
    		    String mainAuthor = res.getString("mainAuthor");
    		    String author = res.getString("author");
    		    String file = res.getString("file");
    		    
    		    System.out.format("%10d%50s%20s%30s%250s%20s%20s%20s\n", journalISSN, volume, edition, title, abstracts, mainAuthor, author, file);
       	}
       	res.close();
       	}catch (SQLException ex) {
       	    ex.printStackTrace();
       	}
    	finally {
       	    if (stmt != null) stmt.close();
       	}
    }
    
    public static void printMainAuthorPage() throws ClassNotFoundException, SQLException {
        try {
        	openConnection();// 
    	    ResultSet res = stmt.executeQuery("SELECT su.JournalISSN, jo.Volume, jo.Edition, su.Title, su.Abstracts, re.anonymousID, "
    	        + "re.initialVerdict, re.critisism, re.response, re.finalVerdict, su.File FROM Submission ar, CoAuthors ca, Journal jo, Review re "
    	        + "WHERE ca.SubmissionID = su.SubmissionID AND re.SubmissionID = su.SubmissionID AND su.JournalISSN = jo.JournalISSN");
    	    System.out.format("%20s%10s%20s%40s%250s%4s%15s%100s%100s%15s%20s\n","JournalISSN", "Volume", "Edition", "Title", "Abstract", 
    	    	"AnonymousID", "InitialVerdict", "Critisism", "Response", "FinalVerdict", "File");
    	    while (res.next()) {
    	    	int journalISSN = res.getInt("journalISSN");
    	    	String volume = res.getString("volume");
    	        String edition = res.getString("edition");
    		    String title = res.getString("title");
    		    String abstracts = res.getString("abstracts");
    		    int anonymousID = res.getInt("anonymousID");
    		    String initialVerdict = res.getString("initialVerdict");
    		    String critisism = res.getString("critisism");
    		    String response = res.getString("response");
    		    String finalVerdict = res.getString("finalVerdict");
    		    String file = res.getString("file");
    		    
    		    System.out.format("%20s%10s%20s%40s%250s%4s%15s%100s%100s%15s%20s\n",journalISSN, volume, edition, title, abstracts, anonymousID,
    		    	initialVerdict, critisism, response, finalVerdict, file);
       	}
       	res.close();
       	}catch (SQLException ex) {
       	    ex.printStackTrace();
       	}
    	finally {
       	    if (stmt != null) stmt.close();
       	}
    }
    
    // Create CoAuthors table
    String author;
    int submissionId;
    int articleID1;
	
    public void CoAuthors (String author, int submissionId, int articleID1) {
    	this.author = author;
    	this.submissionId = submissionId;
        this.articleID1 = articleID1;
    }
    
    public static void initialiseCoAuthorsTable() throws ClassNotFoundException, SQLException{
        try{
            openConnection();

            String sql = "CREATE TABLE CoAuthors (" +
            		"Author VARCHAR (20), " +
            		"SubmissionID INT (50), " +
		    		"ArticleID INT (30), " +
		    		"PRIMARY KEY (SubmissionID), " +
                    "FOREIGN KEY (SubmissionID) REFERENCES Submission (SubmissionID) " +
                    "ON UPDATE CASCADE ON DELETE RESTRICT) ENGINE=INNODB";
            
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
    
    // insert and select functions
    public static void insertCoAuthorsData(String author, int submissionId, int articleID) throws ClassNotFoundException, SQLException {
    	try {
    		openConnection();
    		
    		//creating the query that will be inserted into the database
    		String query = " insert into CoAuthors (author, submissionId, articleID) values (?,?,?)"; 
    		PreparedStatement stmt = conn.prepareStatement(query); 
    		stmt.setString(1, author); 
    		stmt.setInt(2, submissionId);
    		stmt.setInt(3, articleID); 
    		
    		//execute the query and push the data into the ArticleCoAuthor table
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

    public static void printAllCoAuthors() throws ClassNotFoundException, SQLException {
        try {
        	openConnection();
    	    ResultSet res = stmt.executeQuery("SELECT * FROM CoAuthors");
    	    System.out.format("%20s%50s%30s\n", "Author", "SubmissionID", "ArticleID");
    	    while (res.next()) {
    	    	String author = res.getString("author");
    	        int submissionId = res.getInt("submissionId");
    		    int articleID = res.getInt("articleID");
    		    		    
    		    System.out.format("%20s%50d%30d\n", author, submissionId, articleID); 
       	}
       	res.close();
       	}catch (SQLException ex) {
       	    ex.printStackTrace();
       	}
    	finally {
       	    if (stmt != null) stmt.close();
       	}
    }
    
    public static void printCoAuthors(String col, String col1, String value) throws ClassNotFoundException, SQLException {
    	try {
       	    openConnection();
       	    ResultSet res = stmt.executeQuery("SELECT "+col+" FROM CoAuthors WHERE "+col1+" = '"+value+"'");
       	    switch(col) {
       	        case("author"): System.out.println("Author");
       	       				    while (res.next()) {
       	       				        String author = res.getString("author");
       	       				        System.out.println(author);}
       	       				    break;
       	        case("submissionId"): System.out.println("SubmissionId");
     						   		  while (res.next()) {
     						   			  int submissionId = res.getInt("submissionId");
	       				                  System.out.println(submissionId);}
     						          break;
       	        case("articleID"): System.out.println("ArticleID");
			                      while (res.next()) {
			                          int articleID = res.getInt("articleID");
			                          System.out.println(articleID);}
			                      break;
       	        case("*"): System.out.format("%20s%50s%30d\n", "Author", "SubmissionID", "ArticleID");
                           while (res.next()) {
                        	   String author = res.getString("author");
                   	           int submissionId = res.getInt("submissionId");
                   	        int articleID = res.getInt("articleID");
                   		       
                   		       System.out.format("%20s%50d%30d\n", author, submissionId, articleID);}
                           break;
                default: System.out.println("Wrong command");               
       	}
       	res.close();
       	}catch (SQLException ex) {
       	    ex.printStackTrace();
       	}
    	finally {
       	    if (stmt != null) stmt.close();
       	}
    }
    
 // Create CoEditors table
    int journalISSNce;
    String editorc;
	
    public void CoEditors (int journalISSNce, String editorc) {
    	this.journalISSNce = journalISSNce;
        this.editorc = editorc;
    }
    
    public static void initialiseCoEditorsTable() throws ClassNotFoundException, SQLException{
        try{
            openConnection();

            String sql = "CREATE TABLE CoEditors (" +
            		"JournalISSN INT (50), " +
		    		"Editor VARCHAR (30))";
            
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
    
    // insert and select functions
    public static void insertCoEditorsData(int journalISSN, String editor) throws ClassNotFoundException, SQLException {
    	try {
    		openConnection();
    		
    		//creating the query that will be inserted into the database
    		String query = " insert into CoEditors (journalISSN, editor) values (?,?)"; 
    		PreparedStatement stmt = conn.prepareStatement(query); 
    		stmt.setInt(1, journalISSN); 
    		stmt.setString(2, editor);
    		
    		//execute the query and push the data into the ArticleCoAuthor table
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

    public static void printAllCoEditors() throws ClassNotFoundException, SQLException {
        try {
        	openConnection();
    	    ResultSet res = stmt.executeQuery("SELECT * FROM CoEditors");
    	    System.out.format("&50s%30s\n", "JournalISSN", "Editor");
    	    while (res.next()) {
    	    	int journalISSN = res.getInt("journalISSN");     
       		    String editor = res.getString("editor");
    		    		    
       		    System.out.format("&50d%30s\n", journalISSN, editor);  
       	}
       	res.close();
       	}catch (SQLException ex) {
       	    ex.printStackTrace();
       	}
    	finally {
       	    if (stmt != null) stmt.close();
       	}
    }
    
    public static void printCoEditors(String col, String col1, String value) throws ClassNotFoundException, SQLException {
    	try {
       	    openConnection();
       	    ResultSet res = stmt.executeQuery("SELECT "+col+" FROM CoEditors WHERE "+col1+" = '"+value+"'");
       	    switch(col) {
       	        case("journalISSN"): System.out.println("JournalISSN");
                                     while (res.next()) {
                                         int journalISSN = res.getInt("journalISSN");
                                         System.out.println(journalISSN);}
                                     break;
                case("editor"): System.out.println("Editor");
		                        while (res.next()) {
                                    String editor = res.getString("editor");
                                    System.out.println(editor);}	
                                break;
       	        case("*"): System.out.format("&50s%30s\n", "JournalISSN", "Editor");
                           while (res.next()) {
                        	   int journalISSN = res.getInt("journalISSN");     
                      		   String editor = res.getString("editor");
                   		    		    
                      		   System.out.format("&50d%30s\n", journalISSN, editor);}
                           break;
                default: System.out.println("Wrong command");               
       	}
       	res.close();
       	}catch (SQLException ex) {
       	    ex.printStackTrace();
       	}
    	finally {
       	    if (stmt != null) stmt.close();
       	}
    }
    
    //Create Journal table
    String titlej;
    int journalISSNj;
    String volume;
    String edition;
    int pageNum;
    String chiefEditor;

    // constructor
    public void Journal(String titlej, int journalISSN, String volume, String edition, int pageNum, String chiefEditor) {
    	this.titlej = titlej;
        this.journalISSN = journalISSN;
        this.volume = volume;
        this.edition = edition;
        this.pageNum = pageNum;
        this.chiefEditor = chiefEditor;
    }

    public static void initialiseJournalTable() throws ClassNotFoundException, SQLException{
        try{
    	    openConnection();

            String sql = "CREATE TABLE Journal (" +
            	"Title VARCHAR (30), " +
        		"JournalISSN INT (50), " +
        		"Volume VARCHAR (10), " +
	    		"Edition VARCHAR (20), " +
	    		"PageNum INT (100), " +
	    		"ChiefEditor VARCHAR (20), " +
	    		"PRIMARY KEY (JournalISSN))";
        
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

    // insert and select function
    public static void insertJournalData(String titlej, int journalISSN, String volume, String edition, int pageNum, String chiefEditor) throws ClassNotFoundException, SQLException {
	    try {
		    openConnection();
		
		    //creating the query that will be inserted into the database
		    String query = " insert into Journal (title, journalISSN, volume, edition, pageNum, chiefEditor)"
				+ " values (?,?,?,?,?,?)"; 
		    PreparedStatement stmt = conn.prepareStatement(query);
		    stmt.setString(1, titlej);
		    stmt.setInt(2, journalISSN); 
		    stmt.setString(3, volume); 
		    stmt.setString(4, edition); 
		    stmt.setInt(5, pageNum);
		    stmt.setString(6, chiefEditor); 
		
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

    public static void printAllJournal() throws ClassNotFoundException, SQLException {
        try {
   	        openConnection();
   	        ResultSet res = stmt.executeQuery("SELECT * FROM Journal");
   	        System.out.format("%30s%50s%10s%20s%100s%20s\n", "Title", "JournalISSN", "Volume", "Edition", "PageNum", "ChiefEditor");
   	        while (res.next()) {
   	        	String title = res.getString("title");
   		        int journalISSN = res.getInt("journalISSN");
   		        String volume = res.getString("volume");
   		        String edition = res.getString("edition");
   		        int pageNum = res.getInt("pageNum");
   		        String chiefEditor = res.getString("chiefEditor");
   		 
   		        System.out.format("%30s%50d%10s%20s%100d%20s\n", title, journalISSN, volume, edition, pageNum, chiefEditor);
            }
   	    res.close();
   	    }
   	    catch (SQLException ex) {
   	         ex.printStackTrace();
   	    }
   	    finally {
   	       if (stmt != null) stmt.close();
   	    }
    }
    
    public static void printJournal(String col, String col1, String value) throws ClassNotFoundException, SQLException {
    	try {
       	    openConnection();
       	    ResultSet res = stmt.executeQuery("SELECT "+col+" FROM Journal WHERE "+col1+" = '"+value+"'");
       	    switch(col) {
       	    	case("title"): System.out.println("Title");
       	    						 while (res.next()) {
       	    							 String title = res.getString("title");
       	    							 System.out.println(title);}
       	    						 break;
       	        case("journalISSN"): System.out.println("JournalISSN");
       	       				         while (res.next()) {
       	       				             int journalISSN = res.getInt("journalISSN");
       	       				             System.out.println(journalISSN);}
       	       				         break;
       	        case("volume"): System.out.println("Volume");
     						    while (res.next()) {
     						        String volume = res.getString("volume");
	       				            System.out.println(volume);}
     						    break;
       	        case("edition"): System.out.println("Edition");
       	                         while (res.next()) {
			                         String edition = res.getString("edition");
		                             System.out.println(edition);}	
       	                         break;
       	        case("pageNum"): System.out.println("PageNum");
       	       				     while (res.next()) {
                                     int pageNum = res.getInt("pageNum");
                                     System.out.println(pageNum);}	
                                 break;
       	        case("chiefEditor"): System.out.println("ChiefEditor");
                                     while (res.next()) {
                                         String chiefEditor = res.getString("chiefEditor");
                                         System.out.println(chiefEditor);}	
                                     break;
       	        case("*"): System.out.format("%30s%50s%10s%20s%100s%20s\n", "Title", "JournalISSN", "Volume", "Edition", "PageNum", "ChiefEditor");
                           while (res.next()) {
                        	   String title = res.getString("title");
                        	   int journalISSN = res.getInt("journalISSN");
                        	   String volume = res.getString("volume");
                        	   String edition = res.getString("edition");
                        	   int pageNum = res.getInt("pageNum");
                        	   String chiefEditor = res.getString("chiefEditor");
	 
                        	   System.out.format("%30s%50d%10s%20s%100d%20s\n", title, journalISSN, volume, edition, pageNum, chiefEditor);}
                           break;
                default: System.out.println("Wrong command");               
       	}
       	res.close();
       	}catch (SQLException ex) {
       	    ex.printStackTrace();
       	}
    	finally {
       	    if (stmt != null) stmt.close();
       	}
    }

	// Create Review table
	String reviewer;
	int submissionIDr;
	int anonymousID;
	String initialVerdict;
	String critisisms;
	String response;
	String finalVerdict;


	public void Review(String reviewer, int submissionIDr, int anonymousID, String initialVerdict, String critisisms, String response, String finalVerdict) {
		this.reviewer = reviewer;
		this.submissionIDr = submissionIDr;
		this.anonymousID = anonymousID;
		this.initialVerdict = initialVerdict;
		this.critisisms = critisisms;
		this.response = response;
		this.finalVerdict = finalVerdict; 
	}

	public static void initialiseReviewTable() throws ClassNotFoundException, SQLException{
		try{
			openConnection();
			
			String sql = "CREATE TABLE Review (" +
        		"Reviewer VARCHAR (20), " +
				"SubmissionID INT (30), " +
        		"AnonymousID INT (1), " +
        		"InitialVerdict VARCHAR (15), " +
	    		"Critisisms VARCHAR (100), " +
	    		"Response VARCHAR (100), " + 
	    		"FinalVerdict VARCHAR (15), " +
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

	// insert and select function
	public static void insertReviewData(String reviewer, int submissionID, int anonymousID, String initialVerdict, String critisisms, String response, String finalVerdict) throws ClassNotFoundException, SQLException {
		try {
			openConnection();
		
			//creating the query that will be inserted into the database
			String query = " insert into Review (reviewer, submissionID, anonymousID, initialVerdict, critisisms, response, finalVerdict)"
				+ " values (?,?,?,?,?,?,?)"; 
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, reviewer);
			stmt.setInt(2, submissionID);
			stmt.setInt(3, anonymousID); 
			stmt.setString(4, initialVerdict);
			stmt.setString(5, critisisms); 
			stmt.setString(6, response);
			stmt.setString(7, finalVerdict);
		
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

	public static void printAllReview() throws ClassNotFoundException, SQLException {
        try {
   	        openConnection();
   	        ResultSet res = stmt.executeQuery("SELECT * FROM Review");
   	        System.out.format("%10s%30s%4s%15s%100s%100s%15s\n", "Reviewer", "SubmissionID", "AnonymousID", "InitialVerdict", "Critisisms", 
   	        	"Response", "FinalVerdict");
   	        while (res.next()) {
   		        String reviewer = res.getString("reviewer");
   		        int submissionID = res.getInt("submissionID");
   		        int anonymousID = res.getInt("anonymousID");
   		        String initialVerdict = res.getString("initialVerdict");
   		        String critisisms = res.getString("critisisms");
   		        String response = res.getString("response");
   		        String finalVerdict = res.getString("finalVerdict");
   		 
   		        System.out.format("%10s%30d%4d%15s%100s%100s&15s\n", reviewer, submissionID, anonymousID, initialVerdict, critisisms, response
   		        	, finalVerdict);
            }
   	    res.close();
   	    }
   	    catch (SQLException ex) {
   	         ex.printStackTrace();
   	    }
   	    finally {
   	       if (stmt != null) stmt.close();
   	    }
    }
    
    public static void printReview(String col, String col1, String value) throws ClassNotFoundException, SQLException {
    	try {
       	    openConnection();
       	    ResultSet res = stmt.executeQuery("SELECT "+col+" FROM Review WHERE "+col1+" = '"+value+"'");
       	    switch(col) {
       	        case("reviewer"): System.out.println("Reviewer");
       	       				      while (res.next()) {
       	       				          String reviewer = res.getString("reviewer");
       	       				          System.out.println(reviewer);}
       	       				      break;
       	        case("submissionID"): System.out.println("SubmissionID");
		                              while (res.next()) {
		                                  int submissionID = res.getInt("submissionID");
	                                      System.out.println(submissionID);}
		                              break;
       	        case("anonymousID"): System.out.println("AnonymousID");
     						         while (res.next()) {
     						             int anonymousID = res.getInt("anonymousID");
	       				                 System.out.println(anonymousID);}
     						         break;
       	        case("initialVerdict"): System.out.println("initialVerdict");
       	                         		while (res.next()) {
       	                         			String initialVerdict = res.getString("initialVerdict");
       	                         			System.out.println(initialVerdict);}	
       	                         		break;
       	        case("critisisms"): System.out.println("Critisisms");
       	        					while (res.next()) {
       	        						String critisisms = res.getString("critisisms");
       	        						System.out.println(critisisms);}	
       	        					break;
       	        case("response"): System.out.println("Response");
       	        				  while (res.next()) {
       	        				      String response = res.getString("response");
       	        				      System.out.println(response);}	
       	        				 break;
       	        case("finalVerdict"): System.out.println("FinalVerdict");
       	        				      while (res.next()) {
       	        				    	  String finalVerdict = res.getString("finalVerdict");
       	        				          System.out.println(finalVerdict);}	
       	        				      break;
       	        case("*"): System.out.format("%10s%30s%4s%15s%100s%100s%15s\n", "Reviewer", "SubmissionID", "AnonymousID", "InitialVerdict", 
       	        		       "Critisisms", "Response", "FinalVerdict");
                           while (res.next()) {
                        	   String reviewer = res.getString("reviewer");
                        	   int submissionID = res.getInt("submissionID");
                        	   int anonymousID = res.getInt("anonymousID");
                        	   String initialVerdict = res.getString("initialVerdict");
                        	   String critisisms = res.getString("critisisms");
                        	   String response = res.getString("response");
                        	   String finalVerdict = res.getString("finalVerdict");
	 
                        	   System.out.format("%10s%30d%4d%15s%100s%100s&15s\n", reviewer, submissionID, anonymousID, initialVerdict, 
                        		   critisisms, response, finalVerdict);}
                           break;
                default: System.out.println("Wrong command");               
       	}
       	res.close();
       	}catch (SQLException ex) {
       	    ex.printStackTrace();
       	}
    	finally {
       	    if (stmt != null) stmt.close();
       	}
    }
    
    public static void printReviewPage() throws ClassNotFoundException, SQLException {
        try {
   	        openConnection();
   	        ResultSet res = stmt.executeQuery("SELECT su.JournalISSN, jo.Volume, jo.Edition, su.Title, su.Abstracts, su.MainAuthor, ca.Author, " + 
   	        	"su.File FROM Submission su, CoAuthors ca, Journal jo WHERE su.SubmissionID = ca.SubmissionID AND su.JournalISSN = jo.JournalISSN");
   	        System.out.format("%30s%10s%20s%40s%250s%20s%20s%20s\n", "JournalISSN", "Volume", "Edition", "Title", "Abstract", "MainAuthor", "Author", "File");
   	        while (res.next()) {
   	        	int journalISSN = res.getInt("journalISSN");
    	    	String volume = res.getString("volume");
    	        String edition = res.getString("edition");
    		    String title = res.getString("title");
    		    String abstracts = res.getString("abstracts");
    		    String mainAuthor = res.getString("mainAuthor");
    		    String author = res.getString("author");
    		    String file = res.getString("file");
   		 
   		        System.out.format("%30s%10s%20s%40s%250s%20s%20s%20s\n", journalISSN, volume, edition, title, abstracts, mainAuthor, author, file);
            }
   	    res.close();
   	    }
   	    catch (SQLException ex) {
   	         ex.printStackTrace();
   	    }
   	    finally {
   	       if (stmt != null) stmt.close();
   	    }
    }
    
    // Create Submission table
    enum CurrentStatus {   
        Pending, Accepted, Rejected
    }

    int journalISSNs;
    int submissionID; 
    String titles; 
    String abstractss; 
    String file1;
    String editedFile;
    String mainAuthors;
    String status;
    String review1;
    String review2;
    String review3;
    String perm;
    boolean finalDecision;
    
    public void Submission(int journalISSNs, String titles, String abstractss, String file1, String editedFile, String mainAuthors, String status, String review1, String review2, String review3, String perm, boolean finalDecision){
    	this.journalISSNs = journalISSNs;
    	this.titles = titles; 
        this.abstractss = abstractss; 
        this.file1 = file1;
        this.editedFile = editedFile;
        this.mainAuthors = mainAuthors; 
        this.status = status;
        this.review1 = review1;
        this.review2 = review2;
        this.review3 = review3;
        this.perm = perm;
        this.finalDecision = finalDecision;    
    }
    
    public static void initialiseSubmissionTable() throws ClassNotFoundException, SQLException{
        try{
        	openConnection();

            String sql = "CREATE TABLE Submission (" +
            		"JournalISSN INT (20), " +
            		"SubmissionID INT (30) not NULL AUTO_INCREMENT, " +
            		"SubmissionTitle VARCHAR (40), " + 
            		"SubmissionAbstract VARCHAR (250), " + 
            		"SubmissionLink VARCHAR (20), " +
            		"EditedArticle VARCHAR (20), " +
            		"MainAuthor VARCHAR (20), "+
            		"Status VARCHAR (10), " +
            		"Review1 VARCHAR (100), " +
            		"Review2 VARCHAR (100), " +
            		"Review3 VARCHAR (100), " +
            		"Perm VARCHAR (10), " +
        		    "FinalDecision boolean, " +
            		"PRIMARY KEY (SubmissionID), " +
                    "FOREIGN KEY (JournalISSN) REFERENCES Journal (JournalISSN) " +
                    "ON UPDATE SET NULL ON DELETE RESTRICT) ENGINE=INNODB";
      //       
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
    
    // insert and select functions
    public static void insertSubmissionData( int journalISSN, String submissionTitle, String submissionAbstract, String submissionLink, 
        String editedArticle, String mainAuthors, String status, String review1, String review2, String review3, String perm, 
        boolean finalDecision) throws ClassNotFoundException, SQLException {
    	try {
    		openConnection();

    		//creating the query that will be inserted into the database
    		String query = " insert into Submission (journalISSN, submissionTitle, submissionAbstract, submissionLink, editedArticle, mainAuthor,"
    				+ " status, review1, review2, review3, perm, finalDecision) values (?,?,?,?,?,?,?,?,?,?,?,?)"; 
    		PreparedStatement stmt = conn.prepareStatement(query);
    		stmt.setInt(1, journalISSN);
    		stmt.setString(2, submissionTitle ); 
    		stmt.setString(3, submissionAbstract); 
    		stmt.setString(4, submissionLink);
    		stmt.setString(5, editedArticle);
    		stmt.setString(6, mainAuthors);
    		stmt.setString(7, status); 
    		stmt.setString(8, review1);
    		stmt.setString(9, review2);
    		stmt.setString(10, review3);
    		stmt.setString(11, perm); 
        	stmt.setBoolean(12, finalDecision);
        	
    		
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
    
    public static void printAllSubmission() throws ClassNotFoundException, SQLException {
        try {
   	        openConnection();
   	        ResultSet res = stmt.executeQuery("SELECT * FROM Submission");
   	        System.out.format("%20s%30s%40s%250s%20s%20s%20s%10s%20s%20s%20s%10s%8s\n", "JournalISSN", "SubmissionID", "SubmissionTitle",
   	        	"SubmissionAbstract", "SubmissionLink", "EditedArticle", "MainAuthor", "Status", "Review1", "Review2", "Review3", "Perm", "FinalDecision");
   	        while (res.next()) {
   	        	int journalISSN = res.getInt("journalISSN");
   		        int submissionID = res.getInt("submissionID");
   		        String submissionTitle = res.getString("submissionTitle");
   		        String submissionAbstract = res.getString("submissionAbstract");
   		        String submissionLink = res.getString("submissionLink");
   		        String editedArticle = res.getString("editedArticle");
   		        String mainAuthor = res.getString("mainAuthor");
   		        String status = res.getString("status");
   		        String review1 = res.getString("review1");
   		        String review2 = res.getString("review2");
   		        String review3 = res.getString("review3");
   		        String perm = res.getString("perm");
    		    boolean finalDecision = res.getBoolean("finalDecision");
    		   
    		    System.out.format("%20d%30d%40s%250s%20s%20s%20s%10s%20s%20s%20s%10s%8s\n", journalISSN, submissionID, submissionTitle, submissionAbstract,
    		    	submissionLink, editedArticle, mainAuthor, status, review1, review2 ,review3, perm, finalDecision);
            }
   	    res.close();
   	    }
   	    catch (SQLException ex) {
   	         ex.printStackTrace();
   	    }
   	    finally {
   	       if (stmt != null) stmt.close();
   	    }
    }

	public static void printSubmission(String col, String col1, String value) throws ClassNotFoundException, SQLException {
    	try {
       	    openConnection();
       	    ResultSet res = stmt.executeQuery("SELECT "+col+" FROM Submission WHERE "+col1+" = '"+value+"'");
       	    switch(col) {
       	        case("journalISSN"): System.out.println("JournalISSN");
                                     while (res.next()) {
                                         int journalISSN = res.getInt("journalISSN");
                                         System.out.println(journalISSN);}	
                                     break;
       	        case("submissionID"): System.out.println("SubmissionID");
       	       				      	  while (res.next()) {
       	       				      		  int submissionID = res.getInt("submissionID");
       	       				      		  System.out.println(submissionID);}
       	       				      	  break;
       	        case("submissionTitle"): System.out.println("SubmissionTitle");
     						         	 while (res.next()) {
     						         		 String submissionTitle = res.getString("submissionTitle");
     						         		 System.out.println(submissionTitle);}
     						         	 break;
       	        case("submissionAbstract"): System.out.println("SubmissionAbstract");
       	                         		    while (res.next()) {
       	                         		    	String submissionAbstract = res.getString("submissionAbstract");
       	                         		    	System.out.println(submissionAbstract);}	
       	                         		    break;
       	        case("submissionLink"): System.out.println("SubmissionLink");
       	        						while (res.next()) {
       	        							String submissionLink = res.getString("submissionLink");
       	        							System.out.println(submissionLink);}	
       	        						break;
       	        case("editedArticle"): System.out.println("EditedArticle");
				                       while (res.next()) {
				 	                       String editedArticle = res.getString("editedArticle");
					                       System.out.println(editedArticle);}	
				                       break;
       	        case("mainAuthor"): System.out.println("MainAuthor");
       	        				  	while (res.next()) {
       	        				  		String mainAuthor = res.getString("mainAuthor");
       	        				  		System.out.println(mainAuthor);}	
       	        				  	break;
       	        case("status"): System.out.println("Status");
       	        				while (res.next()) {
       	        					String status = res.getString("status");
       	        					System.out.println(status);}	
       	        				break;
       	        case("review1"): System.out.println("Review1");
       	        				 while (res.next()) {
       	        					 String review1 = res.getString("review1");
       	        					 System.out.println(review1);}	
       	        				 break;
       	        case("review2"): System.out.println("Review2");
       	        				 while (res.next()) {
       	        					 String review2 = res.getString("review2");
       	        					 System.out.println(review2);}	
       	        				 break;
       	        case("review3"): System.out.println("Review3");
       	        				 while (res.next()) {
       	        					 String review3 = res.getString("review3");
       	        					 System.out.println(review3);}	
       	        				 break;
       	        case("perm"): System.out.println("Perm");
                              while (res.next()) {
                                     String perm = res.getString("perm");
                                     System.out.println(perm);}	
                              break;
                case("finalDecision"): System.out.println("FinalDecision");
                                       while (res.next()) {
                                           boolean finalDecision = res.getBoolean("finalDecision");
                                           System.out.println(finalDecision);}	
                                       break;
       	        case("*"): System.out.format("%20s%30s%40s%250s%20s%20s%20s%10s%20s%20s%20s%10s%8s\n", "JournalISSN", "SubmissionID", 
       	        		       "SubmissionTitle", "SubmissionAbstract", "SubmissionLink", "EditedArticle", "MainAuthor", "Status", "Review1", 
       	        		       "Review2", "Review3", "Perm", "FinalDecision");
       	        		   while (res.next()) {
       	        			   int journalISSN = res.getInt("journalISSN");
       	        			   int submissionID = res.getInt("submissionID");
       	        			   String submissionTitle = res.getString("submissionTitle");
       	        			   String submissionAbstract = res.getString("submissionAbstract");
       	        			   String submissionLink = res.getString("submissionLink");
       	        			   String editedArticle = res.getString("editedArticle");
       	        			   String mainAuthor = res.getString("mainAuthor");
       	        			   String status = res.getString("status");
       	        			   String review1 = res.getString("review1");
       	        			   String review2 = res.getString("review2");
       	        			   String review3 = res.getString("review3");
       	        			   String perm = res.getString("perm");
       	     		           boolean finalDecision = res.getBoolean("finalDecision");
       	     		            
       	     		           System.out.format("%20d%30d%40s%250s%20s%20s%20s%10s%20s%20s%20s%10s%8s\n", journalISSN, submissionID, submissionTitle,
       	     		        	   submissionAbstract, submissionLink, editedArticle, mainAuthor, status, review1, review2 ,review3, perm, finalDecision);}
       	        		       break;
                default: System.out.println("Wrong command");               
       	}
       	res.close();
       	}catch (SQLException ex) {
       	    ex.printStackTrace();
       	}
    	finally {
       	    if (stmt != null) stmt.close();
       	}
    }
    
    // Create User table
    String titleu;
    String forename;
    String surname;
    String university;
    String loginID;
    int password;
    boolean isReviewer;
    boolean isEditor;
    boolean isAuthor;
	
    public void Usertable (String titleu, String forename, String surname, String university, String loginID, int password, boolean isReviewer, boolean isEditor, boolean isAuthor) {
        this.titleu = titleu;
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
        	openConnection();

            String sql = "CREATE TABLE User (" +
            		"Title VARCHAR (5)," +
            		"Forename VARCHAR (20)," +
            		"Surname VARCHAR (20)," +
            		"University VARCHAR (50)," +
            		"LoginID VARCHAR (30)," +
            		"Password INT (15)," +
            		"IsReviewer boolean," +
            		"IsEditor boolean," +
            		"IsAuthor boolean," +
		    		"PRIMARY KEY (LoginID))";
            
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
    
    // insert and select functions
    public static void insertUserData(String title, String forename, String surname, String university, String loginID, int password, boolean isReviewer, boolean isEditor, boolean isAuthor) throws ClassNotFoundException, SQLException {
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
    		stmt.setInt(6, password);
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
    
    public static void printAllUser() throws ClassNotFoundException, SQLException {
        try {
       	    openConnection();
       	    ResultSet res = stmt.executeQuery("SELECT * FROM User");
       	    System.out.format("%6s%20s%20s%50s%30s%15s%14s%14s%14s\n", "Title", "Forename", "Surname", "University", "LoginID", "Password", 
       	        "IsReviewer", "IsEditor", "IsAuthor");
       	    while (res.next()) {
       	        String title = res.getString("title");
       		    String forename = res.getString("forename");
       		    String surname = res.getString("surname");
       		    String university = res.getString("university");
       		    String loginID = res.getString("loginID");
       		    int password = res.getInt("password"); 
       		    boolean isReviewer = res.getBoolean("isReviewer");
       		    boolean isEditor = res.getBoolean("isEditor");
       		    boolean isAuthor = res.getBoolean("isAuthor");
       		    
       		    System.out.format("%6s%20s%20s%50s%30s%15s%14s%14s%14s\n", title, forename, surname, university, loginID, password, isReviewer, 
       		        isEditor, isAuthor);
       	
       	    }
       	    res.close();
       	}catch (SQLException ex) {
       	    ex.printStackTrace();
       	}
    	finally {
       	    if (stmt != null) stmt.close();
       	}
    }
    
    public static void printUser(String name, String name1, String value) throws ClassNotFoundException, SQLException {
    	try {
       	    openConnection();
       	    ResultSet res = stmt.executeQuery("SELECT "+name+" FROM User WHERE "+name1+" = '"+value+"'");
       	    switch(name) {
       	        case("title"): System.out.println("Title");
       	       				   while (res.next()) {
       	       				       String title = res.getString("title");
       	       				       System.out.println(title);}
       	       				   break;
       	        case("forename"): System.out.println("Forename");
     						      while (res.next()) {
     						          String forename = res.getString("forename");
	       				              System.out.println(forename);}
     						      break;
       	        case("surname"): System.out.println("Surname");
       	                         while (res.next()) {
			                         String surname = res.getString("surname");
		                             System.out.println(surname);}	
       	                         break;
       	        case("university"): System.out.println("University");
       	       				        while (res.next()) {
                                        String university = res.getString("university");
                                        System.out.println(university);}	
                                    break;
       	        case("loginID"): System.out.println("LoginID");
                                 while (res.next()) {
                                     String loginID = res.getString("loginID");
                                     System.out.println(loginID);}	
                                 break;
       	        case("password"): System.out.println("Password");
                                  while (res.next()) {
                                      int password = res.getInt("password");
                                      System.out.println(password);}	
                                  break;
       	        case("isReviewer"): System.out.println("IsReviewer");
                                    while (res.next()) {
                                        boolean isReviewer = res.getBoolean("isReviewer");
                                        System.out.println(isReviewer);}	
                                    break;
       	        case("isEditor"): System.out.println("IsEditor");
                                  while (res.next()) {
                                      boolean IsEditor = res.getBoolean("IsEditor");
                                      System.out.println(IsEditor);}	
                                  break;
       	        case("isAuthor"): System.out.println("IsAuthor");
                                  while (res.next()) {
                                      boolean isAuthor = res.getBoolean("isAuthor");
                                      System.out.println(isAuthor);}	
                                  break;
       	        case("*"): System.out.format("%6s%20s%20s%50s%30s%15s%14s%14s%14s\n", "Title", "Forename", "Surname", "University", "LoginID", 
       	        		       "Password", "IsReviewer", "IsEditor", "IsAuthor");
       	                   while (res.next()) {
        	                   String title = res.getString("title");
        		               String forename = res.getString("forename");
        		               String surname = res.getString("surname");
        		               String university = res.getString("university");
        		               String loginID = res.getString("loginID");
        		               int password = res.getInt("password"); 
        		               boolean isReviewer = res.getBoolean("isReviewer");
        		               boolean isEditor = res.getBoolean("isEditor");
        		               boolean isAuthor = res.getBoolean("isAuthor");
        		 
        		               System.out.format("%6s%20s%20s%50s%30s%15s%14s%14s%14s\n", title, forename, surname, university, loginID, password, 
        		            	   isReviewer, isEditor, isAuthor);}
       	                   break;
        		
                default: System.out.println("Wrong command");               
       	}
       	res.close();
       	}catch (SQLException ex) {
       	    ex.printStackTrace();
       	}
    	finally {
       	    if (stmt != null) stmt.close();
       	}
    }
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
    //  Create all tables
 //       initialiseSubmissionTable();
 //       initialiseArticleTable();
 //       initialiseCoEditorsTable();
 //       initialiseJournalTable();                        
 //       initialiseReviewTable();                       
 //       initialiseUsertable();
 //       initialiseCoAuthorsTable();
 //       insertJournalData("as", 5, "First", "First", 120, "you");
 //       insertArticleData(5, "Ba", "abstracts", "ww1", "Tom");
 //       insertSubmissionData(5, "Hi", "Abstract", "www", "Jim", "Cup", "Pending", "Good", "Bad", "Nah", "Allow", true);
 //       insertCoAuthorsData("BU", 2, 4);
 //   	  printArticlePage();
 //   	  insertUserData("Prof", "Mixalis", "Nikolaou", "Sheffield", "mixn1@sheffield.ac.uk", 839402890, false, false, false);
 //       printAllJournal();
 //       insertCoAuthorsData("hasda", 1, "asd@sheffield.ac.uk");
    }
}
