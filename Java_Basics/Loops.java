/*
 * Title: Loops in Java
 * Description: The code includes loops used in Java like while, do-while and for and some problems using those loops.
 * Author: Isha Shelke
 * Last Updated: October 2025
 */
import java.util.Scanner;
public class Loops {

	public static void main(String[] args) {
		//This loop gives us the sum of the first 'n' odd numbers.
		//Input - The Nth number upto which the user wants the sum.
		//Time Complexity - O(N) and Space Complexity - O(1)
//		System.out.println("Enter how many odd numbers are to be added:");
//		Scanner sc= new Scanner(System.in);
//		int n = sc.nextInt();
//		int j=0;
//		int i=1;
//		while(j<=n) {
//			//for Even numbers and the same problem, use i=2*j+i;
//			i=(2*j-1)+i;
//			j++;
//		}
//		System.out.print(i);
		
		//This loop prints * pattern in increasing order and forms a upright left-sided right-angled triangle.
		//Time Complexity - O(N ^ 2) and Space Complexity - O(1)
//		for(int i =0;i<=4;i++) {
//			for(int j=0;j<=i;j++) {
//			System.out.print("* ");
//		}
//			System.out.println();
//		}
//		
		//This is the same problem using a while loop and producing a decreasing order inverted triangle.
		//Time Complexity - O(N ^ 2) and Space Complexity - O(1)
//		int i=4;
//		while(i>=0) {
//			int j=0;
//			while(j<=i) {
//				System.out.print("* ");
//				j++;
//			}
//			System.out.println();
//			i--;
//		}
		
	//This is a simple do-while loop that runs at least once for the first time regardless of the condition and up until the condition holds true.
	//Time Complexity - O(N+1) and Space Complexity - O(1)
	/*int i=0;
	do{
	System.out.println(i);
	i--;
	}while(i>0);*/
		
	//Loop to print only odd numbers
	//Time Complexity - O(N) and Space Complexity - O(1)
	/*int n=100;
	for(int j=0; j<n; j++) {
		j=2*i+1;
		System.out.println(j);
		i++;
		if(i==25) {
			System.out.println("Mid life crisis");
			continue;//we use continue statement to go on with the loop regardless of the condition happening which usually stops the loop
		}
	}*/
		
		//Program to print multiplication table of a number
		//Time Complexity - O(N) and Space Complexity - O(1)
//		Scanner inp = new Scanner(System.in);
//		System.out.println("Enter a number to get its multiplication table");
//		int tableNum = inp.nextInt();
//		for(int i=1; i<=10;i++) { 
//			int tableCom = tableNum * i;
//			System.out.println(tableCom);
//		}
		
		//Table of 10 in reverse
		//Time Complexity - O(N) and Space Complexity - O(1)
//		for(int i=10; i>=0;i--) { 
//			int Table = 10 * i;
//			System.out.println(Table);
//		}
		
		//Function to get the factorial of a number
		//Time Complexity - O(N) and Space Complexity - O(1)
//		Scanner inp = new Scanner(System.in);
//		System.out.println("Enter a number to get its factorial");
//		int n = inp.nextInt();
//		int i=1;
//		int fact=1;
		//Using for loop
//		for(i=1;i<=n;i++)
//		{
//			fact = fact * i;
//		}
		//Using while loop
//		while(i<=n) {
//			fact=fact*i;
//			i++;
//		}
//		System.out.println("Factorial of " + n +" is:" + fact);
		
		//Sum of all numbers in a multiplication table.(Here we have table of 10)
		//Time Complexity - O(N) and Space Complexity - O(1)
//		System.out.println("Enter the number of table to which to get the sum of :");
//		Scanner sc= new Scanner(System.in);
//		int n = sc.nextInt();
//		int tableSum = 0 ;
//		for(int i=1; i<=10;i++) { 
//			int tablePro = n * i;
//			tableSum += tablePro;
//		}
//		System.out.println(tableSum);
		
		//Sum of first n numbers using for loop
		System.out.println("Enter how many numbers are to be added:");
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		int forSum=0;
		//Time Complexity - O(N) and Space Complexity - O(1)
		for(int j=0;j<=n;j++) {
			forSum+=j;
		}
		//System.out.println(forSum);
		//Time Complexity - O(1) and Space Complexity - O(1)
		int sumNum = (n*(n+1))/2;
		System.out.println(sumNum);
}
}
