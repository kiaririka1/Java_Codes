/*
 * Title: If-Else and Switch Cases in Java
 * Description: The code includes if-else and switch case use in Java. It only has a rock-paper-scissors game and some basic Java problems.
 * Author: Isha Shelke
 * Last Updated: October 2025
 */
import java.util.*;

public class SwitchPrac {
	public static void main(String[] args){	
		//Rock Paper Scissors with Computer
		//Time Complexity - O(n+m) worst case going through all the conditions, O(n) otherwise because of the while loop.
		//Space Complexity - O(1)
		Scanner inp = new Scanner(System.in);
		int count=0;int userInput;
		while(count< 5) {
		System.out.println("Round "+ (count+1));
		//Input validation loop
		while(true) {
			System.out.println("Enter your move(Enter 0 for Rock/Enter 1 for Paper/Enter 2 for Scissors):");
			if (inp.hasNextInt()) { //Check if input is an integer
		       userInput = inp.nextInt();
		        if (userInput >= 0 && userInput <= 2) { //Valid range check
		            break; //Exit loop
		        } else {
		            System.out.println("Invalid choice! Please enter 0, 1, or 2 only.");
		        }
		    } else {
		        System.out.println("That's not a number! Please enter 0, 1, or 2.");
		        inp.next(); // Clear invalid input
		    }
		}
		Random rand = new Random();
		int comp = rand.nextInt(2);
		if(comp == 0) {
			System.out.println("Computer has played rock");
		}
		else if(comp == 1) {
			System.out.println("Computer has played scissors");
		} else if(comp ==2){System.out.println("Computer has played paper");}
			if((userInput == 0 && comp == 1) || (userInput == 1 && comp == 2) || (userInput == 2 && comp == 0)) {
				System.out.println("You have won!");
				count++;
			} else if ((comp == 0 && userInput == 1) || (comp == 1 && userInput == 2) || (comp == 2 && userInput == 0)) {
				System.out.println("Computer has won! Better luck next time!");
				count++;
			} else if(comp == userInput) {System.out.println("Play again! You and computer have chosen the same");}
		}
		
		//Weekday from number input
		//Time Complexity - O(1) and Space Complexity - O(1) for switch cases
//		System.out.println("Enter a number to get weekday:");
//		Scanner sc = new Scanner(System.in);
//		int value = sc.nextInt();
//		switch(value) {
//		case 1 -> System.out.println("Monday");
//		case 2 -> System.out.println("Tuesday");
//		case 3 -> System.out.println("Wednesday");
//		case 4 -> System.out.println("Thursday");
//		case 5 -> System.out.println("Friday");
//		case 6 -> System.out.println("Saturday");
//		case 7 -> System.out.println("Sunday");
//		default -> System.out.println("Not a weekday");
//		}
		
		//Basic if-else Questions
		//Check if entered year is leap
//		System.out.println("Enter your year:");
//		int year = sc.nextInt();
//		if (year%4 == 0) {
//		System.out.println("This is a leap year");}
//		else {
//			System.out.println("Not a leap year");
//		}
		
		//Check website from extension
//		System.out.println("Enter your website url:");
//		String webSite = sc.next();
//			String extension = webSite.substring(webSite.indexOf('.'));
//			switch(extension) {
//		case ".com" -> System.out.println("This is a commmercial website");
//		case ".org" -> System.out.println("This is a organisation website");
//		case ".in" -> System.out.println("This is a Indian website");
//		}
	}
}
