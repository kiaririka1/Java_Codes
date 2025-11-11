/*
 * Title: Abstract Class and Methods in Java
 * Description: The code includes exceptions and custom exceptions implementations in java.
 * Author: Isha Shelke
 * Last Updated: October 2025
 */
//An exception is an event that occurs when a program is executed disrupting the normal flow of instructions.
//Exceptions are of two types - 1. Checked exceptions - Complie time exceptions - The code does not run unless they are handled.
//2. Unchecked exceptions - Runtime exceptions - Code cannot predict these errors.

import java.util.*;
//We can write custom exceptions using exception class in java.
class customExcept extends Exception{
	//This function prints the exception message.
	public String getMessage() {
		return "You have an error!";
	}
	//This function is run when sout(e) is ran.
	public String toString() {
		return "Error!";
	}
}

public class Exception_Prac extends Exception{
 public static int multiply(int x, int y) {
	 int result = x + y;
	 return result;
 }
 
 public static int array(int[] arr) throws customExcept{
	 Scanner in = new Scanner(System.in);
	 	System.out.println("Enter array index to access:");
		int z = in.nextInt();
		int counter=1;
		boolean count= true;
		while(count && counter<5){
		//Exceptions are handled by try-catch blocks in Java. We use it so the code doesn't stop running on getting an exception.
		try {
			System.out.println("The element at index "+ z+ " is: " + arr[z]);
			count = false;
		}
		//We can print the exception using e in catch block after the exception is encountered.
		catch(Exception e) {
			System.out.println("Array out of bounds. Try again:");
			z = in.nextInt();
			counter++;
		}
		//Finally block contains the code which always executes whether the exception is handled or not
		finally {
			System.out.println("The Array exists anyways!");
		}
		}
		return counter;
}

 		public static void main(String[] args) {
		//int a=9 --> syntax error
		//d = 5; --> syntax error
		//logical error, program for multiplying two numbers returns their addition
		int a=4, b=5;
		System.out.println(multiply(a,b));
		
		//runtime error/ input error/ user side error
		Scanner in = new Scanner(System.in);
		int x,y=0;
		System.out.println("Enter dividend:");
		x = in.nextInt();
		System.out.println("Enter divisor:");
		y = in.nextInt(); //0
		try {
			System.out.println("The result of division is:" + x/y);
		}
		catch(Exception e) {
			System.out.println("You have entered zero and triggered exception: " + e);
			//e - gives the exact error that has occurred.
		}
		//user getting error until valid array is accessed and error after 5 tries
		int[] arr = {1,2,3};
		try {
			if(array(arr)==5) {
				throw new customExcept();
			}
			} catch (customExcept e) {
			e.printStackTrace();//prints stack trace to error
		}
		System.out.println("Enter array index to access:");
		int z = in.nextInt();
		int counter=0;
		boolean count= true;
		while(count) {
			//WE can also have nested try-catchs which is usually a try-catch in a try block
		try{
			if(counter==4){
				throw new Exception();
				//throw new customExcept();
			}
		try {
			System.out.println("The element at index "+ z+ " is: " + arr[z]);
			count = false;
		}
		catch(Exception e) {
			System.out.println("Array out of bounds. Try again:");
			z = in.nextInt();
			counter++;
		}
		}
		catch(Exception e) {
			System.out.println("Error!");
			break;
		}
		}
		
		//Haha at Arithmetic exception, hehe at Illegal exception
		int m,n;
		try {
			System.out.println("Enter dividend:");
			m = in.nextInt();
			System.out.println("Enter divisor:");
			n = in.nextInt(); //0

			System.out.println("The result of division is:" + x/y);
		}
		//We can also target specific exceptions using multiple catch blocks.
		catch(ArithmeticException e) {//Division by zero error
			System.out.println("Haha");
		}
		catch(InputMismatchException e) {//Wrong type of input error
			System.out.println("HEHE");
		}
	}
}
