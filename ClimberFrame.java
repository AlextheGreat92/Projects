import java.util.Scanner;
import java.io.IOException;

/* ********************************************************************************************

Program Name: ClimberFrame
Author:       A. SAMO


Description:  Climber frame will convert centigrade to fahrenheit and fahrenheit to centigrade. 
   			  It will also convert dollars to euros and euros to dollars. This program will 
   			  also calculate the wind-chill giving you the actual outside temperature. 
=============================================================================================

                                 M A I N T E N A N C E    H I S T O R Y
                                 
Date Written  Version#  Author                            comments                                     
==========    ====      =========   =========================================================                                          
2012-12-13    A.OO      A. SAMO     Initial write of the program

******************************************************************************************** */

//--------------------------------------------------------------------------------------------
//import section
//--------------------------------------------------------------------------------------------

public class ClimberFrame {

	// @param args the command line arguments

	static Scanner myScanner;

	public static void main(String[] args) throws IOException {
		char userInput = 'z';
		
		myScanner = new Scanner(System.in);
		
		showHelpOptionsForUser();
		
		// userInput = enterCommand();
		while (userInput != 'q') {
			userInput = enterCommand();
			switch (userInput) {
			// *centigrade to fahrenheit*//
			case 'c': {
				System.out.println("Command is c");
				centigradeToFahrenheit();

				break;
			}
			// *fahrenheit to centigrade*//
			case 'f': {

				System.out.println("Command is f");
				fahrenheitToCentigrade();

				break;
			}
			// *dollars to euros*//
			case 'd': {
				System.out.println("Command is d");
				dollarsToEuros();
				break;
			}
			// *euros to dollars*//
			case 'e': {
				System.out.println("Command is e");
				eurosToDollars();
				break;
			}
			// *convert wind-chill*//
			case 'w': {
				System.out.println("Command is w");
				windChill();
				break;
			}
			// *quit the program*//
			case 'q': {
				System.out.println("Thank you");
				System.out.println("**End Of Program**");
				System.out.println();
				break;
			}
			default:
				System.out.println("Command not recognized");
			}
		}
	}
	
	// *This is a help menue to assist the user*//
	public static void showHelpOptionsForUser() throws IOException {
		System.out.println("c will calculate centigrade into fahrenheit");
		System.out.println("f will calulate fahrenheit into centigrade");
		System.out.println("d will calculate dollars into euros");
		System.out.println("e will calculate euros into dollars");
		System.out.println("w will calculate the windchill");
		System.out.println("q will quit the program");
	}
	
	// *Read in the next command*//
	public static char enterCommand() throws IOException {
		char item, skip;
		System.out.println("\n");
		System.out.print("Please enter a command: ");
		item = (char) System.in.read();
		skip = (char) System.in.read();
		return item;
	}
	
	// **************************************************************//
	// *The below methods are each used for the actual calculations**//
	// **************************************************************//	
	public static void centigradeToFahrenheit() throws IOException {
		int centigrade = 0;
		int fahrenheit = 0;
		System.out.println("Executing centigrade to fahrenheit");
		System.out.println("\n");
		System.out.print("Please enter centigrade: ");

		centigrade = myScanner.nextInt();
		fahrenheit = ((centigrade * 9 / 5) + 32);

		System.out.println("Centigrade: " + centigrade);
		System.out.println("Fahrenheit: " + fahrenheit);
		System.out.println();
	}

	public static void fahrenheitToCentigrade() throws IOException {
		int centigrade = 0;
		int fahrenheit = 0;
		
		System.out.println("Executing fahrenheit to centigrade");
		System.out.println("\n");
		System.out.print("Please enter fahrenheit: ");

		fahrenheit = myScanner.nextInt();
		centigrade = ((fahrenheit - 32) * 5 / 9);
	
		System.out.println("fahrenheit: " + fahrenheit);
		System.out.println("centigrade: " + centigrade);
		System.out.println();
	}
	
	public static void dollarsToEuros() throws IOException {
		double dollars = 0.0;
		double euros = 0.0;
		
		System.out.println("Executing dollars to euros");
		System.out.println("\n");
		System.out.print("Please enter dollars: ");
		
		dollars = myScanner.nextDouble();
		euros = (dollars * 0.77);

		System.out.println("dollars: " + dollars);
		System.out.println("euros: " + euros);
		System.out.println("\n");
	}
	
	public static void eurosToDollars() throws IOException {
		double dollars = 0.0;
		double euros = 0.0;

		System.out.println("Executing euros to dollars");
		System.out.println("\n");
		System.out.print("Please enter euros: ");

		euros = myScanner.nextDouble();
		dollars = (euros * 1.30);

		System.out.println("euros: " + euros);
		System.out.println("dollars: " + dollars);
		System.out.println("\n");
	}
	public static void windChill() throws IOException {
		double windSpeed = 0.0;
		double airTemperature = 0.0;
		double windChill = 0.0;

		System.out.println("Executing wind-chill");
		System.out.println("\n");
		System.out.print("Please enter wind speed: ");

		windSpeed = myScanner.nextDouble();
		System.out.print("Please enter air temperature (fahrenheit): ");
		airTemperature = myScanner.nextDouble();
		windChill =
				(35.74

						+ (0.6215 * airTemperature)

						- (35.75 * (Math.pow(windSpeed, 0.16)))

						+ (0.4275 * airTemperature * (Math.pow(windSpeed, 0.16)))

				);

		System.out.println("wind speed: " + windSpeed);
		System.out.println("air temperature: " + airTemperature);
		System.out.println("actual outside temperature: " + windChill);

	}

}
