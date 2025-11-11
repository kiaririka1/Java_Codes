/*
 * Title: Introduction to Java
 * Description: The code includes basic Java operations like input from user using Scanner and BufferedReader as well as loops and switch cases.
 * Author: Isha Shelke
 * Last Updated: October 2025
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
public class Input_Basics {

	public static void main(String[] args) {
		//Basic use of variables in java
		int value = 5;
		String test = "Hello";
		String test1 = test + " there" + value;
		System.out.println(test1);
		
		while(value <10) {
			System.out.println(value);
			value+=1;
		}
		for(int i=0; i<=value; i++) {
			System.out.println(i);
		}
		
		//Input from User using BufferedReader. We use a try-catch block to run it to handle file not closing or not found errors.
		BufferedReader input1 = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter your number");
		String getInput;
		try {
			getInput = input1.readLine();
			System.out.println("Your number is : " + getInput);	
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//We use Scanner class to get input from user. It provides various methods to read next data like nextInt(),nextLine(),next(),nextDouble(),etc.
		Scanner userInput = new Scanner(System.in);
		System.out.println("Enter a number between 1,2 or 3: ");
		int caseNumber = userInput.nextInt();
		//We use switch cases to perform a specific operation for a specific type of input. 
		//Always use break after each case so that all the other cases are not executed.
		//It supports char,int,byte,String, and short data types.
		switch(caseNumber) {
		case 1 : System.out.println("This is the first case");break;
		case 2 : System.out.println("This is the second case");break;
		case 3 : System.out.println("This is the third case");break;
		default : System.out.println("None was selected");
		}
		
		//We can also have an array or multiple numbers of a same datatype grouped together as a list.
		//The default values are 0 and we can access and assign values according to the index the starts at 0.
		int[] listOfNumbers = new int[5];
		for(int i = 0; i < listOfNumbers.length;){
			for(int j=0; j<25; j+=5 ) {
			listOfNumbers[i]=j;
			i++;
			}
		}
		//We use for loops to work through each element of a array. It has a initialization of a variable i.e. int i=0, 
		//a condition upto which the loop goes on and a increment or decrement operation for the established variable.
		for(int k =0; k<listOfNumbers.length; k++) {
			System.out.println(listOfNumbers[k]);
		}
	}
}

