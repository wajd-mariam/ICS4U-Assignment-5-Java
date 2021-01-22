/*
*
* The program Palindrome.java uses recursion to find how many iterations 
* it will take to find the palindrome number.
* 
* @author  Wajd Mariam
* @version 1.0
* @since   2021/01/18
*/

// Importing Scanners
import java.util.Scanner; 

public class Palindrome {
  
  
  /**
   * The reverseFunction function uses recursion 
   * to reverse the received strings and pass them back.
   */ 
  public static String reverseFunction(String inputNumber) {
    // Declaring variables used.
    String stringReversed = "";
    // Reversing string:
    if (inputNumber.length() == 0) {
      stringReversed = inputNumber;
    } else {
      return reverseFunction(inputNumber.substring(1)) + inputNumber.charAt(0);
    }
    return stringReversed;
  }
  
  /**
   * The plaindromeChecker method checks if the entered number and its reverse 
   * are equal.
   */ 
  public static void palindromeChecker(String reversedString1, String comparedNumber,
                                       int counter, String originalNumber1) {
    
    if (reversedString1.equals(comparedNumber)) {
      System.out.println(comparedNumber + " is a palindrome!");
      System.out.println("This means that " + originalNumber1 
                          + " is depth " + counter + " palindrome!");
      System.out.println("It took " + counter + " iterations to find its palindrome");
    } else {
      // Converting strings to integers.
      int reversedNumber = Integer.parseInt(reversedString1);
      int originalNumber = Integer.parseInt(comparedNumber);
    
      // Adding the two numbers to check if the sum is a palindrome or not.
      int sum = reversedNumber + originalNumber;
        
      // Converting sum to string
      String sumString = Integer.toString(sum);
      
      // Calling "reverseFunction" method to reverse the current sum.
      String reversedString2 = reverseFunction(sumString);
      
      // Increasing counter every time a number is checked whether it is a palindrome.
      counter = counter + 1;
      
      // Recall the same function "palindromeChecker"the check if the current 
      // sum and it's reverse are equal (forms a palindrome).
      palindromeChecker(reversedString2, sumString, counter++, originalNumber1);
    }
  }
    
  
  /**
   * The main function get input from user 
   * and passes parameters to the methods.
   */ 
  public static void main(String[] args) {
    // Declaring variables:
    String stringInput = "";
    int counter = 0;
    
    // Try Catch Statement.
    try {
      
      // Getting input from users.
      final Scanner input = new Scanner(System.in);
      System.out.print("Enter a number to determine its palindrome: ");
      stringInput = input.nextLine();
      System.out.println("");
      
      // Calling "reverseFunction" method.
      String reversedString = reverseFunction(stringInput);
      
      // Calling "palindromeChecker" method.
      palindromeChecker(reversedString, stringInput, counter, stringInput);

      // Catches errors.
    } catch (Exception e) {
      System.out.print("");
      System.out.println("ERROR.");
    }
  }
}
