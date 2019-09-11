//Brian Moreno
//Jonathan Jacildo
//Car Rental Database
//CS 315 - Prof. Adler
import java.util.Scanner;
import java.sql.*;

public class Rented {
   //Add rented data into the database
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
      
         String dateRented; 
      
         System.out.print("Rental Date (YYYY-MM-DD): ");
         dateRented = kbd.next();
      
         System.out.print("Days Rented: ");
         int daysRented = kbd.nextInt();
         
         System.out.print("Customer ID: ");
         int cstID = kbd.nextInt();
         
         System.out.print("Car ID: ");
         int carID = kbd.nextInt();
      
         //Stores all rental data into one result
         String results = "'" + dateRented + "', " + daysRented + ", " + cstID + ", " + carID;
      
         String sql = "INSERT INTO Rented (dateRented, daysRented, cstID, carID) VALUES (" + results + ")";
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

         String opt;
            
         do{
            System.out.print("Enter rent ID# to be removed from database: ");
            int rentID = kbd.nextInt();
            //Confirm action
            System.out.print("Are you sure? (Y/N)");
            opt = kbd.next();
                      
            if(opt.contentEquals("Y") || opt.contentEquals("y")){
               String sql = "DELETE FROM Rented WHERE rentID = " + rentID;
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
      //Show all JOINED data from Rented, Customers, and Cars table
      Connection conn = null;
      try
      {
         conn = 
            DriverManager.getConnection("jdbc:mysql://cs.neiu.edu:3306/db_Spr19_bamoren5?serverTimezone=UTC&" +
                                        "user=db_Spr19_bamoren5&password=bamoren5");                                        
            Statement stmt = conn.createStatement();
            //JOIN Rented, Customers, and Cars tables
            String sql = "SELECT rentID, firstName, lastName, dateRented, daysRented, locationID, make, model, rentPerDay FROM Rented r, Customers p, Cars c WHERE r.cstID = p.cstID AND r.carID = c.carID";
            
            ResultSet rs = stmt.executeQuery(sql);
            
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.print('|');
            System.out.printf("%-10s %15s %15s %15s %15s %10s %18s %20s %10s", "Rent No.", "First Name", "Last Name", "Rental Date", "Days Rented", "Location", "Make", "Model", "Rent/Day");
            System.out.print('|');          
            System.out.println("");
            
            while(rs.next()){
               
               System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
            
               int rentID = rs.getInt("rentID");
               String firstName = rs.getString("firstName");
               String lastName = rs.getString("lastName");
               Date dateRented = rs.getDate("dateRented");
               int daysRented = rs.getInt("daysRented");
               String locationID = rs.getString("locationID");
               String make = rs.getString("make");
               String model = rs.getString("model");
               double rentPerDay = rs.getDouble("rentPerDay");
               
               System.out.print('|');
               System.out.format("%-10s %15s %15s %15s %8s %15s %20s %20s %10s", rentID , firstName, lastName, dateRented, daysRented, locationID, make, model, rentPerDay);
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