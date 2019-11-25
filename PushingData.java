package testing;
import java.sql.*;
import java.util.ArrayList;
import java.util.*;

public class FindDrivers {
	
	
	/*
	 * 
	 * Function: containsTrue 
	 * Takes in a list of booleans and a target value (in this case true)
	 * will see if that list contains true, if it does will return true else false
	 */
	public static boolean containsTrue(boolean[] arr, boolean targetValue) {
		for(boolean s: arr){
			if(s == targetValue)
				return true;
		}
		return false;
	}
	
	/*
	 * Takes in a string, that being the user input 
	 * and checks if any of that input contains forbidden words 
	 * 
	 */
	public static boolean userInput(String word){
		
		 
		 //Array contains all the words that the userInput cannot contain 
		 String[] forbiddenWords = new String[]{ "drop", "take"};
		 
		 
	     int i; 
	     //Creates a new array arr where
	     //The Size of array will be equal to the number of elements within forbiddenWords array. 
	     boolean[] arr = new boolean[forbiddenWords.length];

	 
	    // Takes the userInput and checks if it contains any of the words in forbiddenWords array. 
	    // Iterates through forbiddenWords array and produces a list of booleans 
	    for(i=0; i< forbiddenWords.length; i++) {
	     arr[i]= (word.toLowerCase().contains(forbiddenWords[i])); 
	    }
	    
	    //System.out.println(java.util.Arrays.toString(arr));
		
	    //System.out.println(containsTrue(arr, true)); 
	    
	    /*
	     * Checks if the list contains at least one true. 
	     * If so return true
	     * This means that the userInput contains a forbidden word  
	     */
	    return containsTrue(arr, true);
		
	}
   
	
	 

 public static void main(String[] args) throws Exception {
	    System.out.println("\nDrivers loaded as properties:");
	    System.out.println(System.getProperty("jdbc.drivers"));
	    System.out.println("\nDrivers loaded by DriverManager:");
	    Enumeration<Driver> list = DriverManager.getDrivers();
	    while (list.hasMoreElements())
	      System.out.println(list.nextElement());
	    
	    
	 Connection con = null; // 
	    
	     
	 try {
		 
		 Class.forName("org.gjt.mm.mysql.Driver");
		 //String DB = "jdbc:mysql://stusql.dcs.shef.ac.uk/team037", "team037" , "d84f5e63";
		 
		 
		 //testing variables 
		 /*
		 int id = 1029493;
		 String title  = "Game Of Thrones"; 
		 String submissionAbstract = "JSJJSHDGGDHDJSHSG"; 
		 String link = "www.gameof.com"; 
		 String author = "George R. R. Martin"; 
		 String reviews = "good reviews"; 
		 String responses = " GSHSHSHHS";
		 Boolean verdict = false; 
		 */
		
		 String title  = "Game Of Thrones"; 
		 String forname = "lol"; 
		 String surname = "open"; 
		 String university = "University of Sheffield"; 
		 String loginID = "lol.open.R@sheff.ac.uk"; 
		 String password = "qwert";
		 Boolean isAuthor = true; 
		 Boolean isEditor = false; 
		 Boolean isReviewer = false; 
		 
		 
		 
		 
		 //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myTest", "root", "Bottle123");
		 con = DriverManager.getConnection("jdbc:mysql://stusql.dcs.shef.ac.uk/team037", "team037" , "d84f5e63");
		 PreparedStatement ps  = con.prepareStatement("insert into user(title, forename, surname, university, loginID, password, isAuthor, isEditor, isReviewer )values(?,?,?,?,?,?,?,?,?)");
		 ps.setString(1, title);
		 ps.setString(2, forname);
		 ps.setString(3, surname);
		 ps.setString(4, university);
		 ps.setString(5, loginID); 
		 ps.setString(6, password);
		 ps.setBoolean(7, isAuthor);
		 ps.setBoolean(8, isEditor);
		 ps.setBoolean(9,  isReviewer);
		 
		 /*
		  * This pushes code into the database 
		  * 
		 int x = ps.executeUpdate(); 
		 if(x > 0 ) {
			 System.out.println("Updating database");
		 }else{
			 System.out.println("System not working"); 
			  }
		 */
		 
		 
		 // https://dev.mysql.com/doc/mysql-getting-started/en/
	
    	
	
	    System.out.println(userInput("drop")); 
         
	    
	    
	 }
	
	 catch (SQLException ex) {
	     ex.printStackTrace();
	 }
	 finally {
	   if (con != null) con.close();
	 }

	    }
}
