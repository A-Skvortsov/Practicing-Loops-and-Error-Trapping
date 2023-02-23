//Loops Practice Menu!
//A pop-up menu that gives the user options to run loop-based functions
//@author Andrey Skvortsov
//February 2023

    import java.util.Scanner;

public class U1A2LoopsPracticeMenu {
    //Global variable declaration.
    static int playCounter = 1; //this will show the user how many times they are repeating the program.
    static Scanner QWE = new Scanner (System.in); //used for strings.
    static Scanner ASD = new Scanner(System.in); //used for ints.
        
    //Method to set up the program to repeat.
    public static void playAgain()  {
        playCounter++;
        System.out.println("Enter any character to continue: ");
        QWE.nextLine();
        System.out.println("\n----------");
    }
    
    //Method to check if postal code is valid.
    public static boolean checkPostCode(String myCode, boolean y) {
        myCode = myCode.replaceFirst(" ", "");
        
        for (int i = 0; i < myCode.length(); i++) //runs until every char in the postal code has been checked.
           {if (i % 2 == 0) //checks if character is odd or even. If even, it should be a letter.
               {switch (myCode.charAt(i)) //checks for letter.
                   {case 'A':case 'B':case 'C':case 'D':case 'E':case 'F':case 'G':case 'H':case 'I':case 'J':case 'K':case 'L':case 'M':case 'N':case 'O':case 'P':case 'Q':case 'R':case 'S':case 'T':case 'U':case 'V':case 'W':case 'X':case 'Y':case 'Z':
                        break;
                    default:
                        i = myCode.length();  //forces for loop to break since char is not a capital letter, user will have to input again.
                        break; 
                   } 
               } 
                            
            else 
               {switch (myCode.charAt(i)) //checks for number.
                   {case '0':case '1':case '2':case '3':case '4':case '5':case '6':case '7':case '8':case '9':
                        break;
                    default:
                        i = myCode.length();  //forces for loop to break since char is not a capital letter, user will have to input again.
                        break; 
                   }
               }
                            
            if (i == myCode.length() - 1) {y = false;}            
           }
        return(y); //if y is true, input was invalid, need new input. If line 42 conditional is satisfied, y becomes false and input is considered valid.
    }

    
    
    
    
    //Main method.
    public static void main(String[] args) {
        char userIn = 'x';                      //user's inputted option.               
        int userTable = 0;                      //integer for which to output multiplication table.
        String postCode = " ";                  //inputted postal code.
        boolean end = true;                     //set to false when user picks 'quit' option - exiting the program's loop

        //Main part of code.
        while (end) { //this loop encapsulates the program's option menu.
            do {System.out.println(playCounter + ") Please select one of the options below: \n"
                        + "A - Postal Code Verification \n"
                        + "B - Multiplication Table \n"
                        + "C - Quit");
                userIn = QWE.nextLine().charAt(0);
               } while (userIn != 'A' && userIn != 'B' && userIn != 'C' && userIn != 'a' && userIn != 'b' && userIn != 'c'); //"Do-while" ensures user picks one of the options.

            switch (userIn) 
               {case 'A':
                case 'a':
                    boolean x = true; //set to false once valid postal code is given, breaking out of loop.
                    while (x) 
                       {while (true) //contains postal code input error trap.
                           {try 
                               {do {System.out.println("\nPlease enter a valid postal code in the form A1A 1A1: ");
                                    postCode = QWE.nextLine();}
                                while (postCode.length() != 7 || postCode.charAt(3) != ' '); //7 chars + space at third character in 'A1A 1A1' format. if these condtions aren't met, input is invalid. 'do-while' loops to get valid input.
                                break;} //If user inputs less than three chars (i.e. A1), 'while' statement on line 72 throws indexoutofboundsexception. 'try-catch' will catch this exception and continue the input loop. If no exception is thrown, input is considered valis and 'break;' command breaks the input loop.
                            catch (Exception IndexOutofBoundsException){} 
                           }
                        
                        x = checkPostCode(postCode, true); //calls on method to check validity of inputted postal code.
                       }
                    System.out.println("Your postal code, " + postCode + ", is valid.");
                    break; //end of case A.
                    
                case 'B':
                case 'b':
                    while (true) 
                       {try //"try-catch" ensures input is an integer.
                           {System.out.println("\nPlease enter an integer to see its multiplication table: ");
                            userTable = ASD.nextInt();
                            break;} //if no issue with wrong input during try-catch, error trap broken.
                        catch (Exception NumberFormatException) {ASD = new Scanner (System.in);} //if issue, catch runs nothing and the loop just repeats.
                       }

                    //Below uses printf to give the formatted mutliplication table.
                    System.out.printf("%n%-12s%-12s%-12s%-12s%-12s%-12s%-12s%-12s%-12s%-12s%n", "x1", "x2", "x3", "x4", "x5", "x6", "x7", "x8", "x9", "x10");
                    System.out.printf("%-12s%-12s%-12s%-12s%-12s%-12s%-12s%-12s%-12s%-12s%n", userTable, userTable * 2, userTable * 3, userTable * 4, userTable * 5, userTable * 6, userTable * 7, userTable * 8, userTable * 9, userTable * 10);
                    break; //end of case B.
                    
                case 'C':
                case 'c':
                    System.out.println("\nGoodbye!");
                    end = false;
                    break;
               }

            if (end == false) {break;}//breaks out of entire while loop and ends the program.
           
            //Below only happens if player does not select 'quit' option. Otherwise, the above conditional will end the program.
            playAgain();
            
        }

    }

}
