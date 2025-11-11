/*
 * Title: Introduction to Strings in Java
 * Description: The code includes basic string operations like input from user, nested if-else and various string methods.
 * Author: Isha Shelke
 * Last Updated: October 2025
 */
import java.util.Scanner;

public class String_Prac {
	public static void main(String[] args) {
		System.out.println("Hello World \r This is String Practice: ");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter marks for Subject 1: ");
		float marks1 = sc.nextFloat();	
		System.out.println("Enter marks for Subject 2: ");
		float marks2 = sc.nextFloat();
		System.out.println("Enter marks for Subject 3: ");
		float marks3 = sc.nextFloat();
		System.out.println("Enter marks for Subject 4: ");
		float marks4 = sc.nextFloat();
		System.out.println("Enter marks for Subject 5: ");
		float marks5 = sc.nextFloat();
		float percent = ((marks1 + marks2+ marks3+ marks4+ marks5)/5);
		System.out.println("You have recieved the following percentage : " + percent + "%");
		//CGPA calculation problem
		float marks[] = new float[3];
		float total = 0;
		int value=0;
		while(value<3) {
			System.out.println("Enter marks for Subject " + (value+1) +":");
			marks[value] = sc.nextFloat();
			value+=1;
		}
		for(int i=0; i<marks.length;i++) {
			total = total + marks[i];
		}
		System.out.println("Your CGPA is:"+ ((total/3)/9.5));
		
		//Kilometers to miles conversion:
		System.out.println("Enter kilometers for conversion:");
		int kilo = sc.nextInt();
		double meters = (kilo * 0.621371);
		System.out.printf(kilo + " km in meters is: %.2fm \n",meters);

		//Check if the entered number is an Integer
		System.out.println("Enter the integer to check:");
		boolean isInt = sc.hasNextInt();	
		System.out.println(isInt);
		
		//Remove two or three spaces in string + String Operations
		String str = new String("Lia Is    Beautiful");
		String space = str.replace("  ","");
		System.out.println(space.replace("   ",""));//replaces the characters in string
		System.out.println(str.length());//returns string length
		System.out.println(str.toUpperCase());//turns entire string to uppercase
		System.out.println(str.toLowerCase());//turns entire string to lowercase
		System.out.println(str.trim());//trims the space at the start and end of the string
		System.out.println(str.substring(0,4));//returns characters in between given indices
		System.out.println(str.replace("Is Beautiful","Smith"));
		System.out.println(str.replace(" ","_"));
		System.out.println(str.startsWith("I"));//returns true if string starts with the given character
		System.out.println(str.charAt(6));//returns character at given index
		System.out.println(str.indexOf("I",4));//returns the first index of given character
		System.out.println(str.lastIndexOf("I",4));//returns the last index of given character
		String str1 = new String("lia is beautiful");
		System.out.println(str.equalsIgnoreCase("Lia is Beautiful"));//returns the string ignoring the case
		System.out.println("Enter your name:");
		String name = sc.next();
		sc.next();
		String letter = "Letter = \"Dear <|name|>,thanks a lot\"";
		System.out.println(letter.replace("<|name|>","Lia"));
		
		//If-else passing problem
		//Time Complexity - O(1) and Space Complexity - O(1)
		float percent1,percent2,percent3;
		System.out.println("Enter marks for Subject 1: ");
		percent1 = sc.nextFloat();
		System.out.println("Enter marks for Subject 2: ");
		percent2 = sc.nextFloat();
		System.out.println("Enter marks for Subject 3: ");
		percent3 = sc.nextFloat();
		if (percent1 < 33 || percent2<33 || percent3 < 33 || (percent1 + percent2 +percent3)/3 < 40) {
			System.out.println("You have failed!");
		}
		else {
			System.out.println("You have passed!");
		}
		
		//Nested If-else for Income Tax
		//Time Complexity - O(N) in worst case, O(1) in best case, and Space Complexity - O(1)
		float income;
		System.out.println("Enter your income for tax: ");
		income = sc.nextFloat();
		if(income <= 250000) {
		System.out.println("Your Income Tax is:0");
		}else if(income>250000 && income<=500000) {
		System.out.println("Your Income Tax at 5% is :"+ income*0.05);
		}else if(income>500000 && income<=1000000) {
		System.out.println("Your Income Tax at 20% is :"+ income*0.20);
		}else if(income>1000000) {
			System.out.println("Your Income Tax at 30% is :"+ income*0.30);
			}
		}
}