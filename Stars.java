/*
*
* The program Stars.java uses recursion to create a hourglass of stars 
* of a size entered by the user.
*
* @author  Wajd Mariam
* @version 1.0
* @since   2021/01/18
*/

// Importing Scanners
import java.util.Scanner; 

public class Stars {
  
  /**
   * This function prints the stars.
   */ 
  public static void printStars(int numberStars) {
    // Printing stars
    for (int printCounter = 0; printCounter < numberStars; printCounter++) {
      System.out.print("*");
    }
    System.out.println("");
  }
  
  /**
   * The "starsDecreasing" method uses recursion to add stars.
   */ 
  public static void starsDecreasing(int number, int originalInput) {
    if (number == 1) {
      printStars(number);
      starsIncreasing(number, originalInput);  
    } else {
      // Calling "printStars" method:
      printStars(number);
      // Recalling "starsDecreasing" method 
      // again to add less stars than the previous time by 1.
      starsDecreasing(number - 1, originalInput);
    }
  }
      
  /**
   * The "starsIncreasing" method uses recursion to add stars.
   */     
  public static void starsIncreasing(int number1, int originalInput1) {
    if (number1 == originalInput1) {
      printStars(number1);
      System.out.println("");
      System.out.println("Done");
    } else {
      // Calling "printStars" function :
      printStars(number1);
      // Recalling "starsIncreasing" method 
      // again to add more stars than the previous time by 1.
      starsIncreasing(number1 + 1, originalInput1);   
    }
  }
    
  /**
   * The main function gets input from user 
   * and passes parameters to methods.
   */ 
  public static void main(String[] args) {
    // Declaring variables used:
    int intInput = 0;
    
    // Try Catch Statement.
    try {
      
      // Getting input from users.
      final Scanner input = new Scanner(System.in);
      System.out.print("Enter a number to form a glass hour of it: ");
      intInput = input.nextInt();
      System.out.println("");
      
      // Checking if input == 1;
      if (intInput == 1) {
        throw null;
      } else {
        // Calling "starsDecreasing" method first since the hourglass starts from
        // top and gradually decrease in size.
        starsDecreasing(intInput, intInput);
      }
    } catch (NullPointerException e) {
      System.out.println("ERROR: You can't make an hour glass with integer 1!");
      // Catches errors.
    } catch (Exception e) {
      System.out.print("");
      System.out.println("ERROR.");
    }
  }
}
