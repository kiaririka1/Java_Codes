/*
 * Title: Arrays in Java
 * Description: The code includes array operations like print,sum, max-min in array, addition of matrix and check sort.
 * Author: Isha Shelke
 * Last Updated: October 2025
 */

import java.util.Scanner;
public class Array_Prac{

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		//Print an array in reverse
		//Time Complexity - O(N) and Space Complexity - O(1)
//		for(int i=arr.length - 1;i>=0;i--) {
//			System.out.println(arr[i]);
//		}
		
		//For-each loop to print each element in an array but to access and manipulate indices, we should use For loop.
		//Time Complexity - O(N) and Space Complexity - O(1)
//		for(int element : arr) {
//			System.out.println(element);		
//		}
		
		//Sum of Float array elements
		//Time Complexity - O(N) and Space Complexity - O(1)
//		float[] Flarr = {98.0f,88.5f,90.0f,78.5f,86.5f};
//		float count=0.0f;
//		for(int i=0; i < Flarr.length;i++) {
//			count+=Flarr[i];
//		}
//		System.out.println(count);
		
		//Integer present in array or not
		//Time Complexity - O(N) in worst case, O(1) in best case and Space Complexity - O(1)
//		System.out.println("Enter the number to search in array : ");
//		Scanner sc = new Scanner(System.in);
//		int searchInt = sc.nextInt();
//		boolean present = false;
//		for(int i=0;i<arr.length;i++) {
//			if(arr[i]==searchInt) {
//			present=true;
//			}
//		}
//		System.out.println(present);
		
		//Average marks from array
		//Time Complexity - O(N) and Space Complexity - O(1)
//		int count=0;
//		int[] marks= {99,98,96,94,100};
//		for(int i:marks) {
//			count+=i;
//		}
//		System.out.printf("The average marks are: %d",count/5);
		
		//Addition of matrices
		//Time Complexity - O(N ^ 2) and Space Complexity - O(1)
		int[][] mat1 = new int[2][3];
		int[][] mat2 = new int[2][3];
		int[][] result = new int[2][3];
		mat1[0][0]=20;
		mat1[0][1]=30;
		mat1[0][2]=40;
		mat1[1][0]=10;
		mat1[1][1]=50;
		mat1[1][2]=60;
		mat2[0][0]=15;
		mat2[0][1]=25;
		mat2[0][2]=5;
		mat2[1][0]=10;
		mat2[1][1]=0;
		mat2[1][2]=2;
		for(int i=0;i<mat1.length;i++) {
			for(int j=0;j<mat1[i].length;j++) {
				result[i][j] = mat1[i][j] + mat2[i][j];
			}
		}
		for(int i=0;i<result.length;i++) {
			for(int j=0;j<result[i].length;j++) {
				System.out.printf("%d ",result[i][j]);
			}
			System.out.println();
		}
		
		//Reverse an array
		//Time Complexity - O(N) and Space Complexity - O(1)
//		Scanner input = new Scanner(System.in);
//		System.out.println("Enter size of array:");
//		int size = input.nextInt();
//		int[] arr = new int[size];
//		int[] rev = new int[size];
//		System.out.println("Enter elements of array:");
//		for(int i=0;i<size;i++) {
//			arr[i] = input.nextInt();
//		}
//		for(int i=0;i<arr.length;i++) {
//			rev[--size] = arr[i];
//		}
//		for(int val : rev) {
//			System.out.print(val);
//		}
		
		//Maximum element in an array
		//Time Complexity - O(N) and Space Complexity - O(1)
//		Scanner input = new Scanner(System.in);
//		System.out.println("Enter size of array:");
//		int size = input.nextInt();
//		int[] maxArr = new int[size];
//		System.out.println("Enter elements of array:");
//		for(int i=0;i<size;i++) {
//			maxArr[i] = input.nextInt();
//		}
//		int maximum = Integer.MIN_VALUE;
//		int minimum = Integer.MAX_VALUE;
//		for(int i=0;i<maxArr.length;i++) {
//		if(maxArr[i] > maximum) {
//		maximum = maxArr[i];
//		}
//		if(maxArr[i] < minimum) {
//		minimum=maxArr[i];
//		}
//		}
//		System.out.printf("The max in array is: %d and the min is: %d",maximum,minimum);
		
		//Checking if array is Sorted
		//Time Complexity - O(N) in all cases and Space Complexity - O(1)
//		int count = 0;
//		for(int i=0;i<arr.length;i++) {
//		try {
//			if(arr[i]<=arr[i+1]) {
//			count++;
//			}
//		}catch(Exception e) {}
//		}
//		if(count == arr.length-1){
//			System.out.println("Array is Sorted");
//		}else {
//					System.out.println("Array is not Sorted");
//		}

		//Quicker Code for sorting
		//Time Complexity - O(N) in worst case, O(1) in Best Case and Space Complexity - O(1)
		boolean isSorted = true;
		for (int i = 0; i < arr.length - 1; i++) {  // Loop only until arr.length - 2
		if (arr[i] > arr[i + 1]) {  // Check if any element is greater than the next
		isSorted = false;
		break;  // No need to continue checking, array is unsorted
		}
		}
		if (isSorted) {
		System.out.println("Array is Sorted");
		} else {
		System.out.println("Array is not Sorted");
		}
	}
}