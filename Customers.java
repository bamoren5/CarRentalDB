//Brian Moreno
//Jonathan Jacildo
//Car Rental Database
//CS 315 - Prof. Adler
import java.util.Scanner;
import java.sql.*;

public class Customers {
   //Add customer data into the database
   public static void insert(){
      Scanner kbd = new Scanner(System.in);
      kbd.useDelimiter("\n");
      
      Connection conn = null;
     
      try
      {
         conn = 
            DriverManager.getConnection("jdbc:mysql://cs.neiu.edu:3306/db_Spr19_bamoren5?serverTimezone=UTC&" +
                                        "user=db_Spr19_bamoren5&password=bamoren5");                                        
            Statement stmt = conn.createStatement(); 

         String opt;

         String firstName, lastName, address, city, state, zipcode, email, phone;
      
         System.out.print("First Name: ");
         firstName = kbd.nextLine();
      
         System.out.print("Last Name: ");
         lastName = kbd.nextLine();
      
         System.out.print("Address: ");
         address = kbd.nextLine();
      
         System.out.print("City: ");
         city = kbd.nextLine();
      
         System.out.print("State: ");
         state = kbd.nextLine();
      
         System.out.print("Zipcode: ");
         zipcode = kbd.nextLine();
      
         System.out.print("Email: ");
         email = kbd.nextLine();
      
         System.out.print("Phone: ");
         phone = kbd.nextLine();
         //Stores all customer data into one result
         String results = "'" + firstName + "', '" + lastName + "', '" + address + "', '" + city + "', '" + state + "', '" + zipcode + "', '" + email + "', '" + phone + "'";
      
         String sql = "INSERT INTO Customers (firstName, lastName, address, city, state, zipcode, email, phone) VALUES (" + results + ")";
         System.out.println("Inserting records into table...");
         stmt.executeUpdate(sql);
         //End Add customer 
         }catch (SQLException ex) {
         // handle any errors
         System.out.println("SQLException: " + ex.getMessage());
         System.out.println("SQLState: " + ex.getSQLState());
         System.out.println("VendorError: " + ex.getErrorCode());
	   } 
    
   }
   
   public static void delete(){
      //Delete customer data using cstID
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
            System.out.print("Enter customer ID# to be removed from database: ");
            int cstID = kbd.nextInt();
            //Confirm action
            System.out.print("Are you sure? (Y/N)");
            opt = kbd.next();
            
            if(opt.contentEquals("Y") || opt.contentEquals("y")){
               String sql = "DELETE FROM Customers WHERE cstID = " + cstID;
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
      //Show all data from Customers table
      Connection conn = null;
      try
      {
         conn = 
            DriverManager.getConnection("jdbc:mysql://cs.neiu.edu:3306/db_Spr19_bamoren5?serverTimezone=UTC&" +
                                        "user=db_Spr19_bamoren5&password=bamoren5");                                        
            Statement stmt = conn.createStatement();
            
            String sql = "SELECT * FROM Customers";
            
            ResultSet rs = stmt.executeQuery(sql);
            
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.print('|');
            System.out.printf("%5s %15s %15s %30s %15s %10s %10s %20s %15s", "ID", "First Name", "Last Name", "Address", "City", "State", "Zip Code", "Email", "Phone");
            System.out.print('|');          
            System.out.println("");
   
            while(rs.next()){
               
               System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
               
               int cstID = rs.getInt("cstID");
               String firstName = rs.getString("firstName");
               String lastName = rs.getString("lastName");
               String address = rs.getString("address");
               String city = rs.getString("city");
               String state = rs.getString("state");
               String zipcode = rs.getString("zipcode");
               String email = rs.getString("email");
               String phone = rs.getString("phone");
               
               System.out.print('|');
               System.out.format("%5s %15s %15s %30s %15s %10s %10s %20s %15s", cstID , firstName, lastName, address, city, state, zipcode, email, phone);
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