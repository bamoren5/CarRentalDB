//Brian Moreno
//Jonathan Jacildo
//Car Rental Database
//CS 315 - Prof. Adler
import java.util.Scanner; 

import java.sql.*;

public class CarRentalDB {
   public static void main(String[] args) {
   
   String exitCheck = "";
   
   do{
         int tableChoice = 0;
           
         do{
            Scanner input = new Scanner(System.in);
             
            
            System.out.println("            Welcome To The Car Rental Database");
            System.out.println();
            System.out.println("Please Enter Desired Table Number: ");
            System.out.print("Enter 1 for Customers Table \nEnter 2 for Cars Table \nEnter 3 for Rental Table \nEnter 4 Rental Location Table: ");
            tableChoice = input.nextInt();
            }
            while(tableChoice != 1 && tableChoice != 2 && tableChoice != 3 && tableChoice != 4);
            System.out.println();
            //add, view, remove
            if(tableChoice == 1){
            do{
               Scanner input = new Scanner(System.in);
               System.out.println("You chose the Customers table.");
               System.out.println("Select what you want to do: ");
               System.out.print("Enter 1 to add to the table. \nEnter 2 to view the contents of the table. \nEnter 3 to remove something from the table: ");
               tableChoice = input.nextInt();
               }while(tableChoice != 1 && tableChoice != 2 && tableChoice != 3);
               System.out.println();
                  if(tableChoice == 1){
                  System.out.println("You chose to add to the table");
                  Customers.insert();
                  }
                  else if(tableChoice == 2){
                  System.out.println("You chose to view the contents of the table. Here they are.");
                  Customers.select();
                  }
                  
                  else if(tableChoice == 3){
                  System.out.println("You chose to remove something from the table.");
                  Customers.delete();
                  }
            }
            
            else if(tableChoice == 2){
            do{
               Scanner input = new Scanner(System.in);
               System.out.println("You chose the Cars table.");
               System.out.println("Select what you want to do: ");
               System.out.print("Enter 1 to add to the table. \nEnter 2 to view the contents of the table. \nEnter 3 to remove something from the table: ");
               tableChoice = input.nextInt();
               }while(tableChoice != 1 && tableChoice != 2 && tableChoice != 3);
               System.out.println();
                  if(tableChoice == 1){
                  System.out.println("You chose to add to the table");
                  Cars.insert();
                  }
                  else if(tableChoice == 2){
                  System.out.println("You chose to view the contents of the table. Here they are.");
                  Cars.select();
                  }
                  
                  else if(tableChoice == 3){
                  System.out.println("You chose to remove something from the table.");
                  Cars.delete();
                  }
            }
            
            else if(tableChoice == 3){
            do{
                Scanner input = new Scanner(System.in);
               System.out.println("You chose the Rental table.");
               System.out.println("Select what you want to do: ");
               System.out.print("Enter 1 to add to the table. \nEnter 2 to view the contents of the table. \nEnter 3 to remove something from the table: ");
               tableChoice = input.nextInt();
               }while(tableChoice != 1 && tableChoice != 2 && tableChoice != 3);
               System.out.println();
                  if(tableChoice == 1){
                  System.out.println("You chose to add to the table");
                  Rented.insert();
                  }
                  else if(tableChoice == 2){
                  System.out.println("You chose to view the contents of the table. Here they are.");
                  Rented.select();
                  }
                  
                  else if(tableChoice == 3){
                  System.out.println("You chose to remove something from the table.");
                  Rented.delete();
                  }
            }
            
            else if(tableChoice == 4){
            do{
                Scanner input = new Scanner(System.in);
               System.out.println("You chose the Rental Location table.");
               System.out.println("Select what you want to do: ");
               System.out.print("Enter 1 to add to the table. \nEnter 2 to view the contents of the table. \nEnter 3 to remove something from the table: ");
               tableChoice = input.nextInt();
               }while(tableChoice != 1 && tableChoice != 2 && tableChoice != 3);
               System.out.println();
                  if(tableChoice == 1){
                  System.out.println("You chose to add to the table");
                  RentalLocation.insert();
                  }
                  else if(tableChoice == 2){
                  System.out.println("You chose to view the contents of the table. Here they are.");
                  RentalLocation.select();
                  }
                  
                  else if(tableChoice == 3){
                  System.out.println("You chose to remove something from the table.");
                  RentalLocation.delete();
                  }
            }
         System.out.println();
         System.out.println("Press (M) for main menu.\nPress (X) to exit.");
         System.out.print("What would you like to do next?");
            Scanner check = new Scanner(System.in);
            exitCheck = check.next();
         
        
            if(exitCheck.contentEquals("X") || exitCheck.contentEquals("x")){
               System.out.println("Thank you for using Car Rental Database!");
               System.out.print("Good Bye!");
            }
      
      }while(exitCheck.contentEquals("M") || exitCheck.contentEquals("m"));

   }
   
   
}