/* ********************************************************************************************
 
 Program Name: Stacks
 Author:       A. SAMO
 

 Description:  Stacks is essentially a reverse polish notation (RPN) calculator.  The user 
               will enter integers and/or RPN commands, and, the program will abide by the
               commands entered.  Once a string is entered, we will parse it and either push
               integers onto the stack, or process the command entered.
 =============================================================================================
 
                                  M A I N T E N A N C E    H I S T O R Y
                                  
 Date Written  Version#  Author                            comments                                     
 ==========    ====      =========   =========================================================                                          
 2012-12-13    A.OO      A. SAMO     Initial write of the program
 
 ******************************************************************************************** */
 


//--------------------------------------------------------------------------------------------
// import section
//--------------------------------------------------------------------------------------------

import java.util.*;
import java.io.IOException;



public class Stacks {


  //--------------------------------------------------------------------------------------------
  //constants section
  //--------------------------------------------------------------------------------------------
	
  //program name and version
	public static final String PROGRAM_NAME                   = "Stacks";
	public static final String PROGRAM_VERSION                = "A.00";
	
	public static boolean      END_OF_PROGRAM                 = false;

		
	
  //the main class	
	public static void main(String[] args) {

      
		String userString       = "";                   //the raw data entered by the user 
		Stack<Integer> intStack = new Stack<Integer>(); //build stack
		showStartOfProgramInfo();                       //show program name, version, etc.
		
		userString = getUserString("Please press enter to start the program: ");
		
		showHelp();
		
        while (END_OF_PROGRAM == false) {
        	System.out.println("");
        	userString = getUserString("Please enter command: ");
        	if (isNumber(userString)) {
        		System.out.println(userString + " is a number");
        		intStack.push(toNumber(userString));
        		System.out.println("");
        	}
        	//Different cases for all available functions
           	if ((isNumber(userString) == false)) {
        		switch (userString.trim()) {
        			case "+": {	doAdd(intStack);              break; }
        			case "-": {	doSubtract(intStack);         break; }
        			case "*": { doMultiply(intStack);         break; }
        			case "/": { doDivide(intStack);           break; }
        			case "%": { doRemainder(intStack);        break; }
        			case "m": { doUnaryMinus(intStack);       break; }
        			case "r": { doExchange(intStack);         break; }
        			case "d": { doDuplicate(intStack);        break; }
        			case "p": { doPrint(intStack);            break; }
        			case "n": { doPrintAndRemove(intStack);   break; }
        			case "f": { doPrintAllContents(intStack); break; }
        			case "c": { doClearStack(intStack);       break; }
        			case "h": { showHelp();                   break; }
        			case "q": { END_OF_PROGRAM = true;        break; }
        			default:  {	System.out.println("Command not recognized"); break; }
           		} //switch
        	} //if not a number
		} //while
		
		showEndOfProgramInfo();
	
	}//main

	//get string from user
	public static String getUserString(String prompt) {
		Scanner StdInput = new Scanner(System.in);
		System.out.print(prompt);
		return StdInput.nextLine().trim().toLowerCase();
	}
    
    
    public static boolean isNumber(String prmString) {
    	boolean tmpGoodNumber = true;
    	int tmpInteger = 0; 
    	try
        {
          tmpInteger = Integer.parseInt(prmString.trim());
        }
        catch (NumberFormatException nfe)
        {
          tmpGoodNumber = false;
        }
    	return tmpGoodNumber;
    }
    
    //String is number 
    public static int toNumber(String prmString) {
    	try
        {
          return Integer.parseInt(prmString.trim());
        }
        catch (NumberFormatException nfe)
        {
          return 0;
        }
    }
    //help screen
    public static void showHelp() {
		System.out.println("\n");
		System.out.println("***************************");
		System.out.println("*                         *");
		System.out.println("* This is the help screen *");
		System.out.println("*                         *");
		System.out.println("***************************");
		System.out.println("\n");
		System.out.println("These are all the possible functions of this program:");
		System.out.println("");
		System.out.println("+: Add the top two items");
		System.out.println("*: Multiply the top two items");
		System.out.println("-: Subtract the top item from the next item");
		System.out.println("/: Integer divide the second item by the top item");
		System.out.println("%: Find the integer remainder when dividing the second item by the top item");
		System.out.println("m: Unary minus--negate the top item");
		System.out.println("r: Exchange the top two items");
		System.out.println("d: Duplicate the top item on the stack");
		System.out.println("p: Print the top item (to the screen)");
		System.out.println("n: Print and remove the top item on stack");
		System.out.println("f: Print all the contents of the stack (leaving it intact");
		System.out.println("c: Clear the stack");
		System.out.println("h: Help Screen");
		System.out.println("q: quit");
		System.out.println("\n");
	
    }  
    //******************************************
    //*										   *
    //*			ALL STACK FUNCTIONS			   *
    //*										   *
    //******************************************
    public static void doAdd(Stack intStack) { 
    	int result = 0;
    	int intPop1 = 0;
    	int intPop2 = 0;
    	
    	intPop1 = ((Integer) intStack.pop()).intValue();
    	intPop2 = ((Integer) intStack.pop()).intValue();
    	
    	result = intPop1 + intPop2;
    	System.out.println("Add top two items");
    	System.out.println("Result = " + result);
    }    
    public static void doSubtract(Stack intStack) { 
    	int result = 0;
    	int intPop1 = 0;
    	int intPop2 = 0;
    	
    	if (!intStack.empty()) {
        intPop1 = ((Integer) intStack.pop()).intValue();
    	intPop2 = ((Integer) intStack.pop()).intValue();
    	
    	result = intPop2 - intPop1;
    	System.out.println("Subtract the top item from the next item");
    	System.out.println("Result = " + result);
   		}
    }    
    public static void doMultiply(Stack intStack) { 
    	int result = 0;
    	int intPop1 = 0;
    	int intPop2 = 0;
    	
    	intPop1 = ((Integer) intStack.pop()).intValue();
    	intPop2 = ((Integer) intStack.pop()).intValue();
    	
    	result = intPop2 * intPop1;
    	System.out.println("Multiply the top two items");
    	System.out.println("Result = " + result);
    }
    public static void doDivide(Stack intStack) { 
    	int result = 0;
    	int intPop1 = 0;
    	int intPop2 = 0;
    	
    	intPop1 = ((Integer) intStack.pop()).intValue();
    	intPop2 = ((Integer) intStack.pop()).intValue();
    	
    	result = intPop2 / intPop1;
    	System.out.println("Divide the top two items");
    	System.out.println("Result = " + result);	
    }
    public static void doRemainder(Stack intStack) { 
    	int result = 0;
    	int intPop1 = 0;
    	int intPop2 = 0;
    	
    	intPop1 = ((Integer) intStack.pop()).intValue();
    	intPop2 = ((Integer) intStack.pop()).intValue();
    	
    	result = intPop2 % intPop1;
    	System.out.println("Find the remainder");
    	System.out.println("Result = " + result);	
    }
    public static void doUnaryMinus(Stack intStack) { 
    	int intPop1 = 0;
    	System.out.println("Negate the top item");
    	if (!intStack.empty()) {
        	intPop1 = ((Integer) intStack.pop()).intValue();
        	intPop1 = intPop1 * -1;
        	intStack.push(intPop1);
        	System.out.println("Result: " + intPop1);        
    	}
    }    
    public static void doExchange(Stack intStack) { 
    	System.out.println("Exchange the top item with the second item");
    	int intPop1 = 0;
    	int intPop2 = 0;
    	
    	if (!intStack.empty()) {
        	intPop1 = ((Integer) intStack.pop()).intValue();
        	intPop2 = ((Integer) intStack.pop()).intValue();
        	intStack.push(intPop1);
        	intStack.push(intPop2);
        	
        	System.out.println("Result: " + intPop1);
        	System.out.println("Result: " + 
        	intPop2);
    	}    	
    }    
    public static void doDuplicate(Stack intStack) { 
    	int intPop1 = 0;
    	
    	System.out.println("Duplicate the top item");
    	
    	if (!intStack.empty()) {
        	intPop1 = ((Integer) intStack.pop()).intValue();
        	intStack.push(intPop1);
        	intStack.push(intPop1);
        	System.out.println("Result: " + intPop1);
    	}
    }
    public static void doPrint(Stack intStack) { 
    	int result = 0;
    	int intPop1 = 0;
    	int intPop2 = 0;
    	
    	intPop1 = ((Integer) intStack.pop()).intValue();
    	intPop2 = ((Integer) intStack.pop()).intValue();
    	
    	result = intPop1;
    	System.out.println("Print the top item");
    	System.out.println("Result = " + result);	
    }
    public static void doPrintAndRemove(Stack intStack) { 
    	System.out.println("Print and remove the top item");

    	if (!intStack.empty()) {
    		System.out.println(intStack.pop() + "  ");
    	}
    }
    public static void doPrintAllContents(Stack intStack) { 
    	System.out.println("Print all contents");
    	
    	while (!intStack.empty()) {
		  System.out.println(intStack.pop() + "  ");
    	}
    	
    }
    public static void doClearStack(Stack intStack) { 
    	int result = 0;
    	int intPop1 = 0;
    	int intPop2 = 0;
    	
    	if (!intStack.empty()) {
        intPop1 = ((Integer) intStack.pop()).intValue();
    	intPop2 = ((Integer) intStack.pop()).intValue();
    	
    	intStack.clear();
    	System.out.println("Stack has been cleared");
    	
    	}
    	
    }
    //Beginning of program info (startup)
    public static void showStartOfProgramInfo() { 
        System.out.println("");
        System.out.println("");
        System.out.println("Program: " + PROGRAM_NAME + "-[Version: " + PROGRAM_VERSION + "] Starting...");
        System.out.println("----------------------------------------------------");
        System.out.println("");
        System.out.println("");
        System.out.println("Thank you for choosing Stacks!");
        System.out.println("\n");
        System.out.println("In this program you will be utilizing a reverse polish notation (RPN) calculator.");
        System.out.println("\n");
        System.out.println("");
	}
    //End of program info
    public static void showEndOfProgramInfo() { 
        System.out.println("");
        System.out.println("");
        System.out.println("----------------------------------------------------");
        System.out.println("Program: " + PROGRAM_NAME + "-[Version: " + PROGRAM_VERSION + "] Ending...");
        System.out.println("");
        System.out.println("");
    }

}
