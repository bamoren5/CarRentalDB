//Brian Moreno
//Jonathan Jacildo
//Car Rental Database
//CS 315 - Prof. Adler
import java.util.Scanner;
import java.sql.*;

public class RentalLocation {
   //Add rental location data into the database
   public static void insert(){
      Scanner kbd = new Scanner(System.in);
      
      Connection conn = null;
     
      try
      {
         conn = 
            DriverManager.getConnection("jdbc:mysql://cs.neiu.edu:3306/db_Spr19_bamoren5?serverTimezone=UTC&" +
                                        "user=db_Spr19_bamoren5&password=bamoren5");                                        
            Statement stmt = conn.createStatement(); 

         String opt;

      
         String locationID, locationName, locationCity;
      
         System.out.print("ID: ");
         locationID = kbd.nextLine();
      
         System.out.print("Name: ");
         locationName = kbd.nextLine();
      
         System.out.print("City: ");
         locationCity = kbd.nextLine();
      
         //Stores all location data into one result
         String results = "'" + locationID + "', '" + locationName + "', '" + locationCity + "'";
         
         String sql = "INSERT INTO RentalLocation (locationID, locationName, locationCity) VALUES (" + results + ")";
         System.out.println("Inserting records into table...");
         stmt.executeUpdate(sql);
         //End Add location 
       }catch (SQLException ex) {
         // handle any errors
         System.out.println("SQLException: " + ex.getMessage());
         System.out.println("SQLState: " + ex.getSQLState());
         System.out.println("VendorError: " + ex.getErrorCode());
	   }
    
   }
   
   public static void delete(){
      //Delete location data using locationID
      Scanner kbd = new Scanner(System.in);
           
      Connection conn = null;
     
      try
      {
         conn = 
            DriverManager.getConnection("jdbc:mysql://cs.neiu.edu:3306/db_Spr19_bamoren5?serverTimezone=UTC&" +
                                        "user=db_Spr19_bamoren5&password=bamoren5");                                        
            Statement stmt = conn.createStatement(); 

         String opt, locationID;
         
          
         do{
            System.out.print("Enter location ID to be removed from database: ");
            locationID = kbd.next();
            //Confirm action
            System.out.print("Are you sure? (Y/N)");
            opt = kbd.next();
            
            if(opt.contentEquals("Y") || opt.contentEquals("y")){
               String sql = "DELETE FROM RentalLocation WHERE locationID = '" + locationID + "'";
               System.out.println("Deleting record from database...");
               stmt.executeUpdate(sql);
            }
         }while(opt.contentEquals("N") || opt.contentEquals("n"));
         //End delete
     	   
      }catch (SQLException ex) {
         // handle any errors
         System.out.println("SQLException: " + ex.getMessage());
         System.out.println("SQLState: " + ex.getSQLState());
         System.out.println("VendorError: " + ex.getErrorCode());
	   } 
   }
   
   public static void select(){
      //Show all data from RentalLocation table
      Connection conn = null;
      try
      {
         conn = 
            DriverManager.getConnection("jdbc:mysql://cs.neiu.edu:3306/db_Spr19_bamoren5?serverTimezone=UTC&" +
                                        "user=db_Spr19_bamoren5&password=bamoren5");                                        
            Statement stmt = conn.createStatement();
            
            String sql = "SELECT * FROM RentalLocation";
            
            ResultSet rs = stmt.executeQuery(sql);
            
            System.out.println("---------------------------------------------------------------------");
            System.out.print('|');
            System.out.printf("%-10s %-40s %-15s", "Location", "Name", "City");
            System.out.print('|');          
            System.out.println("");
            
            while(rs.next()){
               
               System.out.println("---------------------------------------------------------------------");
            
               String locationID = rs.getString("locationID");
               String locationName = rs.getString("locationName");
               String locationCity = rs.getString("locationCity");
               
               System.out.print('|');
               System.out.format("%-10s %-40s %-15s", locationID, locationName , locationCity);
               System.out.print('|');
               System.out.println("");
            }
            rs.close();
            
      }catch (SQLException ex) {
         // handle any errors
         System.out.println("SQLException: " + ex.getMessage());
         System.out.println("SQLState: " + ex.getSQLState());
         System.out.println("VendorError: " + ex.getErrorCode());
	   } 
   }
}