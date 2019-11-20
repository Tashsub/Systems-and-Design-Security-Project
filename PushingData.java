package testing;
import java.sql.*;
import java.util.ArrayList;
import java.util.*;

public class FindDrivers {
	
	
	
	public static boolean containsTrue(boolean[] arr, boolean targetValue) {
		for(boolean s: arr){
			if(s == targetValue)
				return true;
		}
		return false;
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
		 
		 Class.forName("org.gjt.mm.mysql.Driver").newInstance();
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
		 int x = ps.executeUpdate(); 
		 if(x > 0 ) {
			 System.out.println("Updating datebase");
		 }else{
			 System.out.println("System not working"); 
			  }
		 */
		 
		 
		 // https://dev.mysql.com/doc/mysql-getting-started/en/
		 
	    //iterate through user input
		 String userInput = "Drop";
		 String[] checker = new String[]{ "drop", "take", "okay"}; 
	     int i; 
	     boolean[] arr = new boolean[checker.length]; 
	     ArrayList<Boolean> contansBoolVals = new ArrayList<Boolean>();
	 
	    for(i=0; i< checker.length; i++) {
	     arr[i]= (userInput.toLowerCase().contains(checker[i]));		
	    }
		 
	    System.out.println(java.util.Arrays.toString(arr));
    	
	    
	    
	    /*
	     * 
	     * Checks if the list contains atleast one true. 
	     * If so return true
	     * 
	     */
	    System.out.println(containsTrue(arr, true)); 
	    
	    
	    /*
	     * if one true stop
	     * if 0 true update database 
	     * 
	     * 
	     */
	 }

	 catch (SQLException ex) {
	     ex.printStackTrace();
	 }
	 finally {
	   if (con != null) con.close();
	 }
	    
	    }
}
