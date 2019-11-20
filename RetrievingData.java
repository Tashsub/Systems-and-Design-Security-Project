package testing;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

public class retrieveData {
	
	 public static void main(String[] args) throws Exception {
		    System.out.println("\nDrivers loaded as properties:");
		    System.out.println(System.getProperty("jdbc.drivers"));
		    System.out.println("\nDrivers loaded by DriverManager:");
		    Enumeration<Driver> list = DriverManager.getDrivers();
		    while (list.hasMoreElements())
		      System.out.println(list.nextElement());
		    
		    
	
		    Class.forName("org.gjt.mm.mysql.Driver").newInstance();
		    //String sql = "SELECT title, forename, surname" + "FROM user";
		    String sql = "SELECT forename, surname FROM user";
		    
		 try (Connection con = DriverManager.getConnection("jdbc:mysql://stusql.dcs.shef.ac.uk/team037", "team037" , "d84f5e63");
				 Statement st = con.createStatement();
				 ResultSet rs    = st.executeQuery(sql);
				 )
				 {
			 
			
			 //String DB = "jdbc:mysql://stusql.dcs.shef.ac.uk/team037", "team037" , "d84f5e63";
			 
			 //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myTest", "root", "Bottle123");
			 //con = DriverManager.getConnection("jdbc:mysql://stusql.dcs.shef.ac.uk/team037", "team037" , "d84f5e63");
			
			 
			 System.out.println("GETTING INFORMATION"); 
			 System.out.println(); 
			 System.out.println(); 
			 
			 
			 
			 while (rs.next()) {
				   System.out.println(rs.getString("forename")  + "\t" +
				                      rs.getString("surname"));
				                    
				}
			 
			
			 
			 
			 
			 
		 }catch (SQLException ex) {
	            System.out.println(ex.getMessage());
	        }


		    
		    }


}
