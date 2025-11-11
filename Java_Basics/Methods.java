/*
 * Title: Methods and Recursion in Java
 * Description: The code includes implementation of method overloading and recursion and some similar problems.
 * Author: Isha Shelke
 * Last Updated: October 2025
 */
import java.util.*;
public class Methods {

	static int add(int x, int y) {
		return x+y;
	}
	
	//Method Overloading - Using different parameters for the same name of constructor to decide which to call depending on the input.
	static void first() {System.out.println("This is First");}
	static void first(int a) {System.out.println("This is Second");}
	static void first(int a, int b) {
		System.out.println("This is Third");
	}
	
	//VarArgs - It is used when method overloading has too many parameters but performs the same functions.
	//Time Complexity - O(N) and Space Complexity - O(1)
	static int multiple(int ...arr) {
		int total = 0;
		for(int each : arr) {
			total +=each;
		}
		return total;
	}
	
	//Array reference value can be changed
	static void change(int[] arr) {
		arr[0] = 0;
	}
	
	//Direct datatype value change not possible
	static void change2(int a) {
		a = 200;
	}
	
	//Factorial function using method recursion
	//Time Complexity - O(N) and Space Complexity - O(N)
	static int fact(int n) {
		if(n==0 || n==1) {
			return 1;
		}else {
		return n*fact(n-1);
		}
	}
	
	//Factorial using increment operator
	//Time Complexity - O(N) and Space Complexity - O(N)
	static int factorial(int n) {
		int result = 1;
		for(int i=1; i<=n; i++) {
			result *= i;
		}
		return result;
	}
	
	//Fibonacci using recursion
	//Time Complexity - O(N) and Space Complexity - O(N)
	static int fibonacci(int no) {
		if(no<=1)
		{
			return no;
		}
		else {
		return fibonacci(no-2) + fibonacci(no-1);
		}	
}
	
	//Sum of first n natural numbers
	//Time Complexity - O(N) and Space Complexity - O(1)
	static int natSum(int n) {
		int sum=0;
		//iteration
//		for(int i=1; i<=n; i++) {
//			sum += i;
//		}
		//recursion
		if(n==1){
			return 1;
		} else{
		sum = n + natSum(n-1);
		}
		return sum;
	}
	
	//Average of all given numbers code
	//Time Complexity - O(N) and Space Complexity - O(1)
	static double average(int ...arr) {
		int average = 0;
		for(int i:arr) {
			average += i;
		}
		return (double)average/arr.length;
	}
	
	//Celsius to Fahrenheit Code
	//Time Complexity - O(1) and Space Complexity - O(1)
	static double cTof(double cel) {
		return cel*9/5+32;
	}
	
	public static void main(String[] args) {
		int a=10, b=20, f=30, d=40, e=50;
		int c;
		//static int method call
//		c = add(a,b);
//		System.out.println(c);
		//initializing method object from classname call
//		Methods add1 = new Methods();
//		System.out.println(add1.add(a,b));
		//add(a,b);
//		first();
//		first(a);
//		first(a,b);
//		change2(a);
		//System.out.println(a);//value did not change to 200
//		int[] arr = {a,b,f,d,e};
//		System.out.println(average(arr));
//		change(arr);
//		for(int x : arr) {
//			System.out.println(x);
//		}
//		c = multiple(a,b,d,e,f);
//		System.out.println(c);
		int factOf = 5, no=6;
//		int getFact, recFact;
//		getFact = factorial(factOf);
//		recFact = fact(factOf);
//		System.out.println("The factorial with recursion is: " + recFact + " and with increment is: "+ getFact);
//		for(int i=0; i<no; i++) {
//		System.out.println(fibonacci(i));
//		}
		//first n natural numbers sum
		System.out.println("Enter the number of first natural numbers to get their sum:");
		Scanner inp = new Scanner(System.in);
		int nSum = inp.nextInt();
		System.out.println(natSum(nSum));
		System.out.println("Enter the Celsius temperature to convert to Fahreinheit :");
		double celInp = inp.nextDouble();
		System.out.println(cTof(celInp));
		}
}
