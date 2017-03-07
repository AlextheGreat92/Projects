import java.util.Scanner;

import java.io.IOException;



public class CalendarTools {



	//******************************************

	//		* @author Alex Samo                *

	//		* CS 1500 Computer Programming 1   *

	//		* Dr. Carter			   * 

	//		* Calendar Tools Project           *

	//		* Fall 2012                        *

	//******************************************

	

	static Scanner MyScanner;

	public static void main(String[] args) throws IOException {
		char userInput = 'z';
		
		MyScanner = new Scanner (System.in);
		
		showHelpOptionsForUser();	
		
		while (userInput != 'q') {
			userInput = enterCommand();

			switch (userInput) {
				case 'q': {
					System.out.println("Command is q");
					System.out.println("Thank you have a nice day");
					break; 
				}
				case 'd': {
					System.out.println("Command is d");
					dayOfTheWeek();
					break;
				}
				case 'h': {
					System.out.println("Command is h");
					showHelpOptionsForUser();
					break;
				}
				case 'r': {
					System.out.println("Command is r");
					romanToArabic();
					break;

				}
				default:
					System.out.println("Command not recognized");

			}

		}

	}

	//*Help screen for user*//
	public static void showHelpOptionsForUser() throws IOException {	
		System.out.println("d: day of the week");
		System.out.println("r: roman numeral to arabic number");
		System.out.println("h: this help screen");
		System.out.println("q: quit");

	}
	//*Get next command*//
	public static char enterCommand() throws IOException {
		char item, skip;  
		
		System.out.println("\n"); 
		System.out.print("Please enter a command: ");
		
		item = (char) System.in.read();
		skip = (char) System.in.read();
		return item;

	}

	//************** DAY OF WEEK METHOD ***************//
	public static void dayOfTheWeek() throws IOException {
		int userYear = 0;
		int userMonth = 0;
		int userDay = 0;
		
		while (!isGoodYear(userYear)) {

			System.out.print("Enter year (Must be 1700 or greater): ");

			userYear = MyScanner.nextInt();

			if (!isGoodYear(userYear)) {

				System.out.println("Year must be 1700 or greater");

				System.out.println("");

			}

		}

		System.out.println("");

		System.out.println("");

		while (!isGoodMonth(userMonth))  {
			System.out.print("Enter month (Must be between 1-12): ");
			userMonth = MyScanner.nextInt();
			if (!isGoodMonth(userMonth)) {
				System.out.println("Month must be between 1 and 12");
				System.out.println("");

			}
		}
		userDay = 99;

		System.out.println("");
		System.out.println("");

		while (!isGoodDay(userYear,userMonth,userDay))  {
			System.out.print("Enter Day: ");
			userDay = MyScanner.nextInt();
			if (!isGoodDay(userYear,userMonth,userDay)) {
				System.out.println("Days range from 1 to 30/31 depending month & leap year");
				System.out.println("");

			}

		}

		showDayOfWeek(userYear,userMonth,userDay);
	}

	public static boolean isGoodYear(int tmpYear) {
		if (tmpYear < 1700)

			return false;
		else 
			return true;

	}

	//*Calculating leap year*//
	public static boolean isLeapYear(int tmpYear) {
		if ((tmpYear % 4 == 0) ||
		   ((tmpYear % 100 != 0) && (tmpYear % 400 == 0)))

			return true;
		else
			return false;

	}
	//*Configure months*//
	public static boolean isGoodMonth (int tmpMonth) {

		if ((tmpMonth < 1) || (tmpMonth > 12))

			return false;

		else 

			return true;
	}

	//*Give months appropriate days counting leap year*//
	public static boolean isGoodDay(int tmpYear, int tmpMonth, int tmpDay) {
		boolean dayOk = false;
		switch (tmpMonth) {

			case 0: {

				dayOk = false;

				break;

			}

			case 1: {

				if (tmpDay <= 31) {

					dayOk = true;

				}

				break;

			}

			case 2: {

				if (isLeapYear(tmpYear)) 

					if(tmpDay <= 29)

						dayOk = true;

				if (!isLeapYear(tmpYear)) 

					if(tmpDay <= 28)

						dayOk = true;

				break;

			}

			case 3: {

				if(tmpDay <= 31)

					dayOk = true;

				break;

			}

			case 4: {

				if(tmpDay <= 30)

					dayOk = true;

				break;

			}

			case 5: {

				if(tmpDay <= 31)

					dayOk = true;

				break;

			}

			case 6: {

				if(tmpDay <= 30)

					dayOk = true;

				break;

			}

			case 7: {

				if(tmpDay <= 30)

					dayOk = false;

				break;

			}

			case 8: {

				if(tmpDay <= 31)

					dayOk = true;

				break;

			}

			case 9: {

				if(tmpDay <= 30)

					dayOk = true;

				break;

			}

			case 10: {

				if(tmpDay <= 31)

					dayOk = true;

				break;

			}

			case 11: {

				if(tmpDay <= 30)

					dayOk = true;

				break;

			}

			case 12: {

				if(tmpDay <= 31)

					dayOk = true;

				break;

			}

		}

		return dayOk;

	}

	//* Show day of week for all months*//
	public static void showDayOfWeek(int tmpYear,int tmpMonth,int tmpDay) {
	    int day_week = ((tmpYear - 1900) * 365)

	    		+ ((tmpYear - 1900) / 4);

	    	/*	- ((tmpYear - 1701) / 100)

	    		+ ((tmpYear - 1601) / 400);

	    		*/ 
        if (tmpYear % 4 == 0 && tmpMonth <= 2) {
                  day_week--;
          }

        switch (tmpMonth) {

        	case 12: day_week += 30; 

        	case 11: day_week+= 31;

        	case 10: day_week+= 30;

        	case 9: day_week+= 31;

        	case 8: day_week+= 31;

        	case 7: day_week+= 30;

        	case 6: day_week+= 31;

        	case 5: day_week+= 30;

        	case 4: day_week+= 31;

        	case 3: day_week+= 28;                     

        	case 2: day_week+= 31;

        }            

        day_week = (tmpDay + day_week) % 7;
      
        //*Display day of week for user*//

        switch (day_week) {

        	case 0: System.out.println("Day of week is Sunday");

                break;

        	case 1: System.out.println("Day of week is Monday");

                break;

        	case 2: System.out.println("Day of week is Tuesday");

                break;

        	case 3: System.out.println("Day of week is Wednesday");

                break;

        	case 4: System.out.println("Day of week is Thursday");

                break;  

        	case 5: System.out.println("Day of week is Friday");

                break;

        	case 6: System.out.println("Day of week is Saturday");

                break;

        }

	}

	//*****************ROMAN NUMERALS*******************//

	public static void romanToArabic() throws IOException {
    	Scanner input = new Scanner(System.in);
    	String userString = new String("");
    		int tmpStringLength     = 0, 
    			tmpStringIndx       = 0, 
    			tmpCalculatedResult = 0,
    			tmpPrevNumber       = 0,
    			tmpCurrentNumber    = 0;

    	char tmpChar = ' ';

    	boolean tmpIsValid = false;

        System.out.println("\n"); 
        System.out.print("Please enter Roman Numerals: ");
        userString = input.next();
    	System.out.println("you entered:" + userString);       
    	tmpStringLength = userString.length();
    	System.out.println("Lenght of string is:" + tmpStringLength);
    	tmpStringIndx = 0;

    	//*Case sensitivity test*//
    	while (tmpStringIndx <= (tmpStringLength -1)) {

    		tmpChar = userString.charAt(tmpStringIndx);

    		if ((tmpChar == 'i') || (tmpChar == 'I')

    		||  (tmpChar == 'v') || (tmpChar == 'V')

    		||  (tmpChar == 'x') || (tmpChar == 'X')

    		||  (tmpChar == 'l') || (tmpChar == 'L')

    		||  (tmpChar == 'c') || (tmpChar == 'C')

    		||  (tmpChar == 'd') || (tmpChar == 'D')

    		||  (tmpChar == 'm') || (tmpChar == 'M'))

    			tmpIsValid = true;
    		else
    			tmpIsValid = false;
    		if (tmpIsValid == true) 

            	System.out.println(tmpStringIndx + ":" 
            				+ userString.charAt(tmpStringIndx)
            				+ " is valid");
           	else

            	System.out.println(tmpStringIndx + ":" 
        				+ userString.charAt(tmpStringIndx)
        				+ " is NOT valid");
        	tmpStringIndx = tmpStringIndx + 1;

    	} //while 

    	System.out.println("Calculating result..."); 
    	tmpStringIndx = 0;
    	tmpPrevNumber = 16000;
    	tmpCurrentNumber = 0;

    	//*Give numerals values*//
    	while (tmpStringIndx <= (tmpStringLength -1)) {

    		tmpChar = userString.charAt(tmpStringIndx);

    		if ((tmpChar == 'i') || (tmpChar == 'I'))

    			tmpCurrentNumber = 1;

    		if ((tmpChar == 'v') || (tmpChar == 'V'))

    			tmpCurrentNumber = 5;

    		if ((tmpChar == 'x') || (tmpChar == 'X'))

    			tmpCurrentNumber = 10;

    		if ((tmpChar == 'l') || (tmpChar == 'L'))

    			tmpCurrentNumber = 50;

    		if ((tmpChar == 'c') || (tmpChar == 'C'))

    			tmpCurrentNumber = 100;

    		if ((tmpChar == 'd') || (tmpChar == 'D'))

    			tmpCurrentNumber = 500;

    		if ((tmpChar == 'm') || (tmpChar == 'M'))

    			tmpCurrentNumber = 1000;

    		//*Calculate numeral rules*//

    		if (tmpCurrentNumber > tmpPrevNumber) { 

    			tmpCalculatedResult = tmpCalculatedResult - tmpPrevNumber;

    			tmpCalculatedResult = tmpCalculatedResult + (tmpCurrentNumber - tmpPrevNumber);

    		} else {

   				tmpCalculatedResult = tmpCalculatedResult + tmpCurrentNumber;

    		}

    		tmpPrevNumber = tmpCurrentNumber;

        	tmpStringIndx = tmpStringIndx + 1;

   		} //while

    	System.out.println("Calculated number is:" + tmpCalculatedResult); 

    	

	}

	

}

		