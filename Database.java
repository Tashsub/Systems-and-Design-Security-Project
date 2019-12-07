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
       	    String sql = "DROP TABLE Article, Review, Journal, Editors, Submission, User";
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
       	    String sql = "DROP TABLE "+table+" WHERE "+ col +" = '"+ value +"'";
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
	String authors;
	
    public void Article (int journalISSN, String title, String abstracts, String file, String mainAuthor, String authors) {
    	this.journalISSN = journalISSN;
        this.title = title;
        this.abstracts = abstracts;
    	this.file = file;
    	this.mainAuthor = mainAuthor;
        this.authors = authors;
    }
    
    public static void initialiseArticleTable() throws ClassNotFoundException, SQLException{
        try{
            openConnection();

            String sql = "CREATE TABLE Article (" +
            		"ArticleID INT (100) AUTO_INCREMENT, " +
            		"JournalISSN INT (20), " +
            		"Title VARCHAR (100), " +
            		"Abstracts VARCHAR (500), " +
		    		"File VARCHAR (100), " +
		    		"MainAuthor VARCHAR (100), " +
		    		"Authors VARCHAR (200), " +
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
    public static void insertArticleData(int journalISSN, String title, String abstracts, String file, String mainAuthor, String authors) throws ClassNotFoundException, SQLException {
    	try {
    		openConnection();
    		
    		//creating the query that will be inserted into the database
    		String query = " insert into Article (journalISSN, title, abstracts, file, mainAuthor, authors)"
    				+ " values (?,?,?,?,?,?)"; 
    		PreparedStatement stmt = conn.prepareStatement(query);
    		stmt.setInt(1, journalISSN);
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

    public static void printAllArticle() throws ClassNotFoundException, SQLException {
        try {
        	openConnection();
    	    ResultSet res = stmt.executeQuery("SELECT * FROM Article");
    	    System.out.println("ArticleID \t JournalISSN \t Title \t Abstracts \t File \t MainAuthor \t Authors");
    	    while (res.next()) {
    	        String articleID = res.getString("articleID");
    	        int journalISSN = res.getInt("journalISSN");
    		    String title = res.getString("title");
    		    String abstracts = res.getString("abstracts");
    		    String file = res.getString("file");
    		    String mainAuthor = res.getString("mainAuthor");
    		    String authors = res.getString("authors");
    		    
    		    System.out.println(articleID +"\t"+ journalISSN +"\t"+ title +"\t"+ abstracts +"\t"+ file +"\t"+ mainAuthor +"\t" + authors);  
    		    
       	 /*   openConnection();
       	    ResultSet res = stmt.executeQuery("SELECT * FROM Article");
       	    while (res.next()) {
       	        int articleID = res.getInt("articleID");
       		    String title = res.getString("title");
       		    String abstracts = res.getString("abstracts");
       		    String file = res.getString("file");
       		    String mainAuthor = res.getString("mainAuthor");
       		    String authors = res.getString("authors");
       		
       			Articlec article = new Articlec(title, abstracts, file, mainAuthor, authors);
       			ArrayList<>
       			for (Articlec li : article)
       			System.out.println(article.getArticleID() + "\t" + article.getAbstract1() + article.getArticleID());
       		}

       

       		    */
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
       	        case("authors"): System.out.println("Authors");
                                 while (res.next()) {
                                     int authors = res.getInt("authors");
                                     System.out.println(authors);}	
                                 break;
       	        case("*"): System.out.println("ArticleID \t JournalISSN \t Title \t Abstracts \t File \t MainAuthor \t Authors");
                           while (res.next()) {
                               String articleID = res.getString("articleID");
                               int journalISSN = res.getInt("journalISSN");
	                           String title = res.getString("title");
	                           String abstracts = res.getString("abstracts");
	                           String file = res.getString("file");
	                           String mainAuthor = res.getString("mainAuthor");
	                           String authors = res.getString("authors");
	 
	                       System.out.println(articleID +"\t"+ journalISSN +"\t"+ title +"\t"+ abstracts +"\t"+ file +"\t"+ mainAuthor +"\t"+ authors);}
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
    
    // Create ArticleCoAuthor table
    String author;
    int submissionId;
    String authorId;
	
    public void ArticleCoAuthors (String author, int submissionId, String authorId) {
    	this.author = author;
    	this.submissionId = submissionId;
        this.authorId = authorId;
    }
    
    public static void initialiseCoAuthorsTable() throws ClassNotFoundException, SQLException{
        try{
            openConnection();

            String sql = "CREATE TABLE CoAuthors (" +
            		"Author VARCHAR (20), " +
            		"SubmissionID INT (20), " +
		    		"AuthorId VARCHAR (30), " +
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
    public static void insertCoAuthorsData(String author, int submissionId, String authorId) throws ClassNotFoundException, SQLException {
    	try {
    		openConnection();
    		
    		//creating the query that will be inserted into the database
    		String query = " insert into CoAuthors (author, submissionId, authorId) values (?,?,?)"; 
    		PreparedStatement stmt = conn.prepareStatement(query); 
    		stmt.setString(1, author); 
    		stmt.setInt(2, submissionId);
    		stmt.setString(3, authorId); 
    		
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
    	    System.out.println("Author \t SubmissionId \t AuthorId");
    	    while (res.next()) {
    	    	String author = res.getString("author");
    	        int submissionId = res.getInt("submissionId");
    		    String authorId = res.getString("authorId");
    		    		    
    		    System.out.println(author +"\t"+ submissionId +"\t"+ authorId);  
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
       	        case("authorId"): System.out.println("AuthorId");
			                      while (res.next()) {
			                          String authorId = res.getString("authorId");
			                          System.out.println(authorId);}
			                      break;
       	        case("*"): System.out.println("Author \t SubmissionId \t AuthorId");
                           while (res.next()) {
                        	   String author = res.getString("author");
                   	           int submissionId = res.getInt("submissionId");
                   		       String authorId = res.getString("authorId");
                   		       
                   		       System.out.println(author +"\t"+ submissionId +"\t"+ authorId); }
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

    //Create Editors table
    String submission;
    String editedArticle;
    String chiefEditor;
    String editor;
    String newPassword;
    	
    public void Editors (String submission, String editedArticle, String chiefEditor, String editor, String newPassword) {
        this.submission = submission;
        this.editedArticle = editedArticle;
        this.chiefEditor = chiefEditor;
        this.editor = editor;
        this.newPassword = newPassword;
    }
 
     public static void initialiseEditorsTable() throws ClassNotFoundException, SQLException{
        try{
            openConnection();
            	
            String sql = "CREATE TABLE Editors (" +
                "Submission VARCHAR (100)," +
                "EditedArticle VARCHAR (100)," +
                "ChiefEditor VARCHAR (50)," +
    		    "Editor VARCHAR (100),"+
    		    "NewPassword VARCHAR (50))";
                
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
    public static void insertEditorsData(String submission, String editedArticle, String chiefEditor, String editor, String newPassword) throws ClassNotFoundException, SQLException {
        try {
            openConnection();
        		
            //creating the query that will be inserted into the database
        	String query = " insert into Editors (submission, editedArticle, chiefEditor, editor, newPassword)"
        		+ " values (?,?,?,?,?)"; 
            PreparedStatement stmt = conn.prepareStatement(query);
        	stmt.setString(1, submission); 
        	stmt.setString(2, editedArticle); 
        	stmt.setString(3, chiefEditor); 
        	stmt.setString(4, editor); 
        	stmt.setString(5, newPassword); 
        		
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
        
    public static void printAllEditors() throws ClassNotFoundException, SQLException {
        try {
       	    openConnection();
       	    ResultSet res = stmt.executeQuery("SELECT * FROM Editors");
       	    System.out.println("Submission \t EditedArticle \t ChiefEditor \t Editor \t NewPassword");
       	    while (res.next()) {
       	        String submission = res.getString("submission");
       		    String editedArticle = res.getString("editedArticle");
       		    String chiefEditor = res.getString("chiefEditor");
       		    String editor = res.getString("editor");
       		    String newPassword = res.getString("newPassword");
  
       		    System.out.println(submission +"\t"+ editedArticle +"\t"+ chiefEditor +"\t"+ editor +"\t"+ newPassword);
       	}
       	res.close();
       	}catch (SQLException ex) {
       	    ex.printStackTrace();
       	}
    	finally {
       	    if (stmt != null) stmt.close();
       	}
    }
    
    public static void printEditors(String col, String col1, String value) throws ClassNotFoundException, SQLException {
    	try {
       	    openConnection();
       	    ResultSet res = stmt.executeQuery("SELECT "+col+" FROM Editors WHERE "+col1+" = '"+value+"'");
       	    switch(col) {
       	        case("submission"): System.out.println("Submission");
       	       				   while (res.next()) {
       	       				       String submission = res.getString("submission");
       	       				       System.out.println(submission);}
       	       				   break;
       	        case("editedArticle"): System.out.println("EditedArticle");
     						      while (res.next()) {
     						          String editedArticle = res.getString("editedArticle");
	       				              System.out.println(editedArticle);}
     						      break;
       	        case("chiefEditor"): System.out.println("ChiefEditor");
       	                         while (res.next()) {
			                         String chiefEditor = res.getString("chiefEditor");
		                             System.out.println(chiefEditor);}	
       	                         break;
       	        case("editor"): System.out.println("Editor");
       	       				        while (res.next()) {
                                        String editor = res.getString("editor");
                                        System.out.println(editor);}	
                                    break;
       	        case("newPassword"): System.out.println("NewPassword");
                           while (res.next()) {
                               String newPassword = res.getString("newPassword");
                               System.out.println(newPassword);}
                           break;
       	        case("*"): System.out.println("Submission \t EditedArticle \t ChiefEditor \t Editor \t NewPassword");
       	        		   while (res.next()) {
        	                   String submission = res.getString("submission");
        		               String editedArticle = res.getString("editedArticle");
        		               String chiefEditor = res.getString("chiefEditor");
        		               String editor = res.getString("editor");
        		               String newPassword = res.getString("newPassword");
   
        		               System.out.println(submission +"\t"+ editedArticle +"\t"+ chiefEditor +"\t"+ editor +"\t"+ newPassword);}
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


    // constructor
    public void Journal(String titlej, int journalISSN, String volume, String edition, int pageNum) {
    	this.titlej = titlej;
        this.journalISSN = journalISSN;
        this.volume = volume;
        this.edition = edition;
        this.pageNum = pageNum;
    }

    public static void initialiseJournalTable() throws ClassNotFoundException, SQLException{
        try{
    	    openConnection();

            String sql = "CREATE TABLE Journal (" +
            	"Title VARCHAR (50)," +
        		"JournalISSN INT (50)," +
        		"Volume VARCHAR (50)," +
	    		"Edition VARCHAR (50)," +
	    		"PageNum INT (50)," +
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
    public static void insertJournalData(String titlej, int journalISSN, String volume, String edition, int pageNum) throws ClassNotFoundException, SQLException {
	    try {
		    openConnection();
		
		    //creating the query that will be inserted into the database
		    String query = " insert into Journal (title, journalISSN, volume, edition, pageNum)"
				+ " values (?,?,?,?,?)"; 
		    PreparedStatement stmt = conn.prepareStatement(query);
		    stmt.setString(1, titlej);
		    stmt.setInt(2, journalISSN); 
		    stmt.setString(3, volume); 
		    stmt.setString(4, edition); 
		    stmt.setInt(5, pageNum); 
		
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
   	        System.out.println("Title \t JournalISSN \t Volume \t  Edition \t PageNum");
   	        while (res.next()) {
   	        	String title = res.getString("title");
   		        int journalISSN = res.getInt("journalISSN");
   		        String volume = res.getString("volume");
   		        String edition = res.getString("edition");
   		        int pageNum = res.getInt("pageNum");
   		 
   		        System.out.println(title +" \t "+ journalISSN +" \t "+ volume +" \t "+ edition +" \t "+ pageNum);
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
       	        case("*"): System.out.println("JournalISSN \t Volume \t Edition \t PageNum");
                           while (res.next()) {
                        	   int journalISSN = res.getInt("journalISSN");
                        	   String volume = res.getString("volume");
                        	   String edition = res.getString("edition");
                        	   int pageNum = res.getInt("pageNum");
	 
	                       System.out.println(journalISSN +"\t"+ volume +"\t"+ edition +"\t"+ pageNum);}
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
	int anonymousID;
	String initialVerdict;
	String critisisms;
	String response;
	String finalVerdict;


	public void Review(String reviewer, int anonymousID, String initialVerdict, String critisisms, String response, String finalVerdict) {
		this.reviewer = reviewer;
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
        		"Reviewer VARCHAR (150), " +
        		"AnonymousID INT (50), " +
        		"InitialVerdict VARCHAR (150), " +
	    		"Critisisms VARCHAR (150), " +
	    		"Response VARCHAR (150), " + 
	    		"FinalVerdict VARCHAR (150), " +
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
	public static void insertReviewData(String reviewer, int anonymousID, String initialVerdict, String critisisms, String response, String finalVerdict) throws ClassNotFoundException, SQLException {
		try {
			openConnection();
		
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

	public static void printAllReview() throws ClassNotFoundException, SQLException {
        try {
   	        openConnection();
   	        ResultSet res = stmt.executeQuery("SELECT * FROM Review");
   	        System.out.println("Reviewer \t  AnonymousID \t InitialVerdict \t Critisisms \t Response \t FinalVerdict");
   	        while (res.next()) {
   		        String reviewer = res.getString("reviewer");
   		        int anonymousID = res.getInt("anonymousID");
   		        String initialVerdict = res.getString("initialVerdict");
   		        String critisisms = res.getString("critisisms");
   		        String response = res.getString("response");
   		        String finalVerdict = res.getString("finalVerdict");
   		 
   		        System.out.println(reviewer +"\t"+ anonymousID +"\t"+ initialVerdict +"\t"+ critisisms +"\t"+ response +"\t"+ finalVerdict);
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
       	        case("*"): System.out.println("Reviewer \t AnonymousID \t InitialVerdict \t Critisisms \t Response \t FinalVerdict");
                           while (res.next()) {
                        	   String reviewer = res.getString("reviewer");
                        	   int anonymousID = res.getInt("anonymousID");
                        	   String initialVerdict = res.getString("initialVerdict");
                        	   String critisisms = res.getString("critisisms");
                        	   String response = res.getString("response");
                        	   String finalVerdict = res.getString("finalVerdict");
	 
                        	   System.out.println(reviewer +"\t"+ anonymousID +"\t"+ initialVerdict +"\t"+ critisisms +"\t"+ response +"\t"+ finalVerdict);}
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
    
    // Create Submission table
    enum CurrentStatus {   
        Pending, Accepted, Rejected
    }

    int submissionID; 
    String titles; 
    String abstractss; 
    String file1; 
    String mainAuthors;
    String authorss; 
    String status;
    String review1;
    String review2;
    String review3;
    String perm;
    boolean finalDecision;
    int journalISSNs;
    
    public void Submission(String titles, String abstractss, String file1, String mainAuthors, String authorss, String status, String review1, String review2, String review3, String perm, boolean finalDecision, int journalISSNs){
        this.title = titles; 
        this.abstracts = abstractss; 
        this.file1 = file1; 
        this.mainAuthor = mainAuthors; 
        this.authors = authorss; 
        this.status = status;
        this.review1 = review1;
        this.review2 = review2;
        this.review3 = review3;
        this.perm = perm;
        this.finalDecision = finalDecision;
        this.journalISSNs = journalISSNs;
    }
    
    public static void initialiseSubmissionTable() throws ClassNotFoundException, SQLException{
        try{
        	openConnection();

            String sql = "CREATE TABLE Submission (" +
            		"SubmissionID INT(30) not NULL AUTO_INCREMENT, " +
            		"SubmissionTitle VARCHAR(40), " + 
            		"SubmissionAbstract VARCHAR(500), " + 
            		"SubmissionLink VARCHAR(20), " + 
            		"MainAuthor VARCHAR(50), "+
            		"Authors VARCHAR(100), " +
            		"Status VARCHAR(50), " +
            		"Review1 VARCHAR(100), " +
            		"Review2 VARCHAR(100), " +
            		"Review3 VARCHAR(100), " +
            		"Perm VARCHAR(10), " +
        		    "FinalDecision boolean, " +
        		    "JournalISSN INT(20), " +
            		"PRIMARY KEY (SubmissionID), " +
                    "FOREIGN KEY (JournalISSN) REFERENCES Journal (JournalISSN) " +
                    "ON UPDATE CASCADE ON DELETE RESTRICT) ENGINE=INNODB";
            
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
    public static void insertSubmissionData(String submissionTitle, String submissionAbstract,String submissionLink, String mainAuthors, String authorss, String status, String review1, String review2, String review3, String perm, boolean finalDecision, int journalISSN) throws ClassNotFoundException, SQLException {
    	try {
    		openConnection();

    		//creating the query that will be inserted into the database
    		String query = " insert into Submission (submissionTitle, submissionAbstract, submissionLink, mainAuthor, authors, status, review1, review2, review3, perm, finalDecision, journalISSN)"
    				+ " values (?,?,?,?,?,?,?,?,?,?,?,?)"; 
    		PreparedStatement stmt = conn.prepareStatement(query); 
    		stmt.setString(1, submissionTitle ); 
    		stmt.setString(2, submissionAbstract); 
    		stmt.setString(3, submissionLink); 
    		stmt.setString(4, mainAuthors);
    		stmt.setString(5, authorss);
    		stmt.setString(6, status); 
    		stmt.setString(7, review1);
    		stmt.setString(8, review2);
    		stmt.setString(9, review3);
    		stmt.setString(10, perm); 
        	stmt.setBoolean(11, finalDecision);
        	stmt.setInt(12, journalISSN);
    		
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
   	        System.out.println("SubmissionID \t SubmissionTitle \t SubmissionAbstract \t SubmissionLink \t MainAuthor \t Authors"
   	        		+ "\t Status \t Review1 \t Review2 \t Review3 \t Perm \t FinalDecision \t JournalISSN");
   	        while (res.next()) {
   		        int submissionID = res.getInt("submissionID");
   		        String submissionTitle = res.getString("submissionTitle");
   		        String submissionAbstract = res.getString("submissionAbstract");
   		        String submissionLink = res.getString("submissionLink");
   		        String mainAuthor = res.getString("mainAuthor");
   		        String authors = res.getString("authors");
   		        String status = res.getString("status");
   		        String review1 = res.getString("review1");
   		        String review2 = res.getString("review2");
   		        String review3 = res.getString("review3");
   		        String perm = res.getString("perm");
    		    boolean finalDecision = res.getBoolean("finalDecision");
    		    int journalISSN = res.getInt("journalISSN");
   		 
   		        System.out.println(submissionID +"\t"+ submissionTitle +"\t"+ submissionAbstract +"\t"+ submissionLink +"\t"+ mainAuthor +"\t"+ 
   		        		authors+"\t"+ status+"\t"+ review1 +"\t"+ review2 + "\t"+ review3 +"\t"+ perm +"\t"+ finalDecision +"\t"+ journalISSN);
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
       	        case("mainAuthor"): System.out.println("MainAuthor");
       	        				  	while (res.next()) {
       	        				  		String mainAuthor = res.getString("mainAuthor");
       	        				  		System.out.println(mainAuthor);}	
       	        				  	break;
       	        case("authors"): System.out.println("Authors");
       	        				 while (res.next()) {
       	        					 String authors = res.getString("authors");
       	        				     System.out.println(authors);}	
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
                case("journalISSN"): System.out.println("JournalISSN");
                                     while (res.next()) {
                                         int journalISSN = res.getInt("journalISSN");
                                         System.out.println(journalISSN);}	
                                     break;
       	        case("*"): System.out.println("SubmissionID  SubmissionTitle \t SubmissionAbstract \t SubmissionLink \t MainAuthor \t "
       	        		+ "Authors \t Status \t Review1 \t Review2 \t Review3 \t Perm \t FinalDecision \t JournalISSN");
       	        		   while (res.next()) {
       	        			   int submissionID = res.getInt("submissionID");
       	        			   String submissionTitle = res.getString("submissionTitle");
       	        			   String submissionAbstract = res.getString("submissionAbstract");
       	        			   String submissionLink = res.getString("submissionLink");
       	        			   String mainAuthor = res.getString("mainAuthor");
       	        			   String authors = res.getString("authors");
       	        			   String status = res.getString("status");
       	        			   String review1 = res.getString("review1");
       	        			   String review2 = res.getString("review2");
       	        			   String review3 = res.getString("review3");
       	        			   String perm = res.getString("perm");
       	     		           boolean finalDecision = res.getBoolean("finalDecision");
       	     		           int journalISSN = res.getInt("journalISSN");
    		               
       	        		   System.out.println(submissionID +"\t"+ submissionTitle +"\t"+ submissionAbstract +"\t"+ submissionLink +"\t"+ mainAuthor +"\t"+ 
       	    		        		authors+"\t"+ status+"\t"+ review1 +"\t"+ review2 + "\t"+ review3 +"\t"+ perm +"\t"+ finalDecision +"\t"+ journalISSN);}
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
	
    public void Usertable (String title, String forename, String surname, String university, String loginID, int password, boolean isReviewer, boolean isEditor, boolean isAuthor) {
        this.title = titleu;
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
            		"Password INT (50)," +
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
       	    System.out.println("Title  Forename \t Surname \t University \t LoginID \t Password \t IsReviewer \t IsEditor \t IsAuthor");
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
       		 
       		    System.out.println(title +"\t"+ forename +"\t"+ surname +"\t"+ university +"\t"+ loginID +"\t" + password +"\t"
       			    + isReviewer +"\t"+ isEditor +"\t"+isAuthor);
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
       	        case("*"): System.out.println("Title  Forename \t Surname \t University \t LoginID \t Password \t IsReviewer \t IsEditor \t IsAuthor");
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
        		 
        		               System.out.println(title +"\t"+ forename +"\t"+ surname +"\t"+ university +"\t"+ loginID +"\t" + password +"\t"
        		          			    + isReviewer +"\t"+ isEditor +"\t"+isAuthor);}
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
 //   	Create all tables
 //   	initialiseArticleTable();
 //   	insertArticleData(12, "hi", "abstracts", "www", "Kim", "ga");
 //   	initialiseEditorsTable();
 //   	initialiseJournalTable();
 //   	initialiseReviewTable();
 //   	initialiseSubmissionTable();
 //   	initialiseUsertable(); */
 //   	initialiseCoAuthorsTable();
  //  	insertJournalData("as", 4, "First", "First", 120);
 //   	insertCoAuthorsData("ha", 6, "asd@sheffield.ac.uk");
   // 	insertArticleData(4, "Ba", "abstracts", "ww1", "Tom", "Bub");
   // 	insertSubmissionData("Hi", "Abstract", "www", "Jim", "Cup", "Pending", "Good", "Bad", "Nah", "Allow", true, 4);
    }
}
