//Brian Moreno
//Jonathan Jacildo
//Car Rental Database
//CS 315 - Prof. Adler
import java.util.Scanner;
import java.sql.*;

public class Cars {
   //Add car data into the database
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
      
         String vin, make, model, locationID;
      
         System.out.print("VIN: ");
         vin = kbd.nextLine();
      
         System.out.print("Make: ");
         make = kbd.nextLine();
      
         System.out.print("Model: ");
         model = kbd.nextLine();
      
         System.out.print("Location: ");
         locationID = kbd.nextLine();
      
         System.out.print("Year: ");
         int year = kbd.nextInt();
         
         System.out.print("Rent per Day: ");
         double rentPerDay = kbd.nextDouble();
         //Stores all Car data into one result
         String results = "'" + vin + "', '" + make + "', '" + model + "', " + year + ", '" + locationID + "', " + rentPerDay;
         
         String sql = "INSERT INTO Cars (vin, make, model, year, locationID, rentPerDay) VALUES (" + results + ")";
         System.out.println("Inserting records into table...");
         stmt.executeUpdate(sql);
         
      }catch (SQLException ex) {
         // handle any errors
         System.out.println("SQLException: " + ex.getMessage());
         System.out.println("SQLState: " + ex.getSQLState());
         System.out.println("VendorError: " + ex.getErrorCode());
	   }
         //End Add cars     
   }
   
   public static void delete(){
      //Delete car data using carID
      Scanner kbd = new Scanner(System.in);
      
      Connection conn = null;
     
      try
      {
         conn = 
            DriverManager.getConnection("jdbc:mysql://cs.neiu.edu:3306/db_Spr19_bamoren5?serverTimezone=UTC&" +
                                        "user=db_Spr19_bamoren5&password=bamoren5");                                        
            Statement stmt = conn.createStatement(); 

         String opt = "";
          
         do{
            System.out.print("Enter car ID# to be removed from database: ");
            int carID = kbd.nextInt();
            //Confirm action
            System.out.print("Are you sure? (Y/N)");
            opt = kbd.next();
           
            if(opt.contentEquals("Y") || opt.contentEquals("y")){
               String sql = "DELETE FROM Cars WHERE carID = " + carID;
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
      //Show all data from Cars table
      Connection conn = null;
      try
      {
         conn = 
            DriverManager.getConnection("jdbc:mysql://cs.neiu.edu:3306/db_Spr19_bamoren5?serverTimezone=UTC&" +
                                        "user=db_Spr19_bamoren5&password=bamoren5");                                        
            Statement stmt = conn.createStatement();
            
            String sql = "SELECT * FROM Cars";
            
            ResultSet rs = stmt.executeQuery(sql);
            
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.print('|');
            System.out.printf("%-10s %-30s %-25s %-25s %15s %15s %15s", "ID", "VIN", "Make", "Model", "Year", "Location", "Rent/Day");
            System.out.print('|');          
            System.out.println("");
            
            while(rs.next()){
               
               System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
               
               int carID = rs.getInt("carID");
               String vin = rs.getString("vin");
               String make = rs.getString("make");
               String model = rs.getString("model");
               int year = rs.getInt("year");
               String locationID = rs.getString("locationID");
               double rentPerDay = rs.getDouble("rentPerDay");
               
               System.out.print('|');
               System.out.format("%-10s %-30s %-25s %-25s %15s %15s %15.2f", carID, vin , make, model, year, locationID, rentPerDay);
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