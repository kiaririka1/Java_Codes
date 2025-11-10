/*
 * Title: Arrays In DSA Implementation
 * Description: The code includes search operations, sort check, adding and removing an element from array, binary search and various array examples solved.
 * Author: Isha Shelke
 * Last Updated: October 2025
 */
import java.util.*;

public class Array_DSA {
	public static int[] arr1 = {12,23,38,40,45,67,78,89,90,100,105};
	public static int[] arr2 = new int[10];
	public static int first=arr1[0],last=arr1[arr1.length-1],mid=arr1[(findIndex(first)+findIndex(last))/2];
	public static boolean found =false;
	//Linear Search searches through each number in the array to find a match and returns not found if the number isn't present
	//Input - The number you want to find in the array
	//Time Complexity - O(n) and Space Complexity - O(1)
	static void linearSearch(int no) {
		boolean numberFound = false;
		for(int n : arr1) {
			if(n == no) {
				numberFound = true;
				break;
			}
		}
		if(numberFound == true) {System.out.println("Number found!");}
		else {System.out.println("Number not found!");}
	}
	
	//This function returns the index of the matching number from the array, -1 when the number does not exist in the array
	//Input - The number you want to find in the array
	//Time Complexity - O(n)
	static int findIndex(int no) {
		int index = -1;
		for(int x=0; x<=arr1.length-1;x++) {
			if(arr1[x]==no) {
				index = x;
				break;
			}
		}
		return index;
	}
	
	//Binary Search - Searches through a sorted array by taking first,mid and last element from an array and halving the search time
	//by searching only in the search space obtained by comparison with the input number.
	//Error - It doesn't consider the case of number not found
	//Time Complexity - O(n * log n)
//	static void binarySearch(int no) {
//		if(first == no || last==no || mid==no){
//			System.out.println("Number found!");
//		}
//		else if(no > mid){
//			first = mid;
//			mid = arr1[(findIndex(mid) + findIndex(last))/2];
//			binarySearch(no);
//		}else if(no < mid){
//			last = mid;
//			mid = arr1[(findIndex(first)+findIndex(mid))/2];
//			binarySearch(no);
//		}else {System.out.println("Number not found!");}
//	}
	
	//This function inserts an element at a given position but does not shift numbers just fills into an empty array position
	//Input - The number you want to insert in the array and its position
	//Time Complexity - O(n) and space complexity = O(1)
	static void insertArray(int no,int pos) {
		while(arr2[pos] == 0 && pos<=arr2.length -1) {
		arr2[pos] = no;
		for(int i:arr2)
		{System.out.println(i);}
		return;
		}
		System.out.println(pos +" Index is full, Enter another index:(both number and position) ");
		Scanner inp = new Scanner(System.in);
		int no1=inp.nextInt();
		int pos2 = inp.nextInt();
		insertArray(no1,pos2);
	}
	
	//This function considers a bigger array and shifting of numbers.
	//Space Complexity can be O(k) when the array space is lesser and you need more space in the array but that isn't coded here.
	//Input - Here no = the value of number you want to add, pos = position you want to add the number at, 
	//n = current number of elements in the array and arr is the array of operation.
	//Time Complexity - O(n) and Space Complexity - O(1)
	static void addToArray(int no, int pos,int n, int[] arr) {
		if(pos<0 || pos>n) {
			System.out.println("Invalid Index");
			return;
		}
		for(int i=n;i>pos;i--) {
			arr[i] = arr[i-1];
		}
		arr[pos] = no;
		for(int j : arr) {
			System.out.println(j);
		}
	}
	
	//This function removes the given array element but it only sets it to zero and does actually empty the position
	//Input - The number you want to remove from the array
	//Time Complexity - O(n)
	static void removeArray(int no) {
		for(int j : arr2) {
			if(j == no) {
				j=0;
			}
			System.out.println(j);
		}
	}
	
	//This function checks if array is sorted
	//Input - Array to check
	//Time Complexity - O(n)
	static void checkSort(int[] arr) {
		int sorted=0;
		for(int x=0; x<arr.length-1; x++){
			if(arr[x]>arr[x+1]) {
				sorted=1;
				break;
			}
		}
		if(sorted==1) {
			System.out.println("Array is not sorted");
		}else {System.out.println("Array is sorted");}
	}

	//This is the upgraded binary search to not recursively call the findIndex function. 
	//It reduces the time complexity and also handles the number not present in the array condition.
	//Input - Number to search in the array
	//Time_Complexity - O(log n)
	static void upgradeBinarySearch(int no) {
		int left=0, right = arr1.length-1;
		while(left<=right){
			int mid1 = left + (right-left)/2;
			if(arr1[mid1] == no) {
				System.out.println("Number found at index:" + mid1);
				return;
			}
			else if(arr1[mid1]<no) {
				left= mid1+1;
			}
			else {right = mid1-1;}
		}
		System.out.println("Number not found");
	}
	
	//This is a function to sort a binary array. We use additional variables to store zeroes and ones count but that doesn't affect the space complexity overall.
	//Time Complexity - O(n) and Space Complexity - O(1)
	static void sortBinaryArray() {
		int zeroCount =0, oneCount=0;
		int[] biArr1= {1,0,0,1,0,1,1,1,1,1,0};
		//counting zeroes and ones
		for(int i:biArr1) {
			if(i==0){
				zeroCount++;
			}else {oneCount++;}
		}
		//copy into array till zerocount
		for(int x=0;x<=zeroCount;x++) {
			biArr1[x]=0;
		}
		//make the rest ones or we can also just use zero count and go upto the end of array size
		for(int y=0;y<oneCount;y++) {
			biArr1[zeroCount+y]=1;
		}
		for(int j:biArr1) {
			System.out.println(j);
		}
	}
	
	//This is a function to sort Binary Array in one pass without needing variables to sort zeroes and ones count.
	//Time Complexity - O(n) and Space complexity - O(1)
	static void sortBinaryOnePass() {
		int[] biArr2= {1,0,0,1,1,1,0,1,0};
		int left=0,right = biArr2.length-1;
		while(left<=right) {
			//skip if left is zero
			if(biArr2[left]==0) {
				left++;
			}//skips if right is one
			else if(biArr2[right]==1) {
				right--;
			}//swaps the two otherwise and the array is sorted
			else {
				int temp=biArr2[left];
				biArr2[left]=biArr2[right];
				biArr2[right]=temp;
			}
		}
		for(int j: biArr2) {
			System.out.println(j);
		}
	}
	
	//This function moves all zeroes in an array to the end.
	//Time Complexity - O(n) and Space Complexity - O(1)
	static void moveZerosToEnd(int... arr) {
		int count=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]!=0) {
				arr[count++] = arr[i];
			}
		}
		while(count<arr.length) {
			arr[count++]=0;
		}
		for(int j: arr) {
			System.out.println(j);
		}
	}
	
	//This function puts all even numbers before odd ones in an array
	//The array isn't sorted and space complexity requires another array
	//Time Complexity - O(n) and Space complexity-O(k)
	static void evenBeforeOdd(int... arr) {
		int countEven=0,countOdd=0; int[] arrOdd=new int[arr.length];//copy all odd numbers to this array
		for(int i=0;i<arr.length;i++) {
			if(arr[i]%2 ==0) {
				arr[countEven++]=arr[i];
			}else{
				arrOdd[countOdd++]=arr[i];
			}
		}
		
		//copy odd array into original array
		for(int x=0;x<countOdd;x++) {
			arr[countEven++]=arrOdd[x];
		}
		for(int j: arr) {
			System.out.println(j);
		}
	}
	
	//single array logic with swapping but again it won't be in sequence
	//Time Complexity - O(n) and Space Complexity - O(1)
	static void evenBeforeOddSwap(int... arr) {
		int start=0,end=arr.length-1;
		while(start<end){
			if(arr[start]%2==0) {
				start++;
			}else if(arr[end]%2==1) {
				end--;
			}else {
				int temp = arr[start];
				arr[start] = arr[end];
				arr[end] = temp;
				start++;
				end--;
			}
		}
		for(int j: arr) {
			System.out.println(j);
		}
	}
	
	//This function sorts rows of a matrix array individually but not the entirety of the matrix
	static void matrixSort(int[][] matArr) {
		for(int[] i:matArr) {
			Arrays.sort(i); //in-built Java array sort
		}
		//array print function
		for(int i=0;i<matArr.length;i++) {
			System.out.print("[ ");
			for(int j=0;j<matArr.length;j++) {
				System.out.print(matArr[i][j] + " ");
			}
			System.out.println("]");
		}
	}
	
	//This function sorts the entire matrix.
	//Time Complexity - O(m * n log (m*n)) and Space Complexity-O(m*n) 
	static void entireMatrixSort(int[][] matArr) {
		int rows = matArr.length, cols = matArr[0].length;
		int[] oneD= new int[rows* cols]; 
		int count=0;
		//copy all to one-dimensional array and sort it
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				oneD[count++] = matArr[i][j];
			}
		}
		Arrays.sort(oneD);
		//copy the array into matrix
		count=0;
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				matArr[i][j] = oneD[count++];
			}
		}
		
		//printing the matrix
		for(int i=0;i<rows;i++) {
			System.out.print("[ ");
			for(int j=0;j<cols;j++) {
				System.out.print(matArr[i][j] + " ");
			}
			System.out.println("]");
		}
	}
	
	public static void main(String[] args) {
		linearSearch(34);
		System.out.println(findIndex(12));
		//binarySearch(50); --- does not account for numbers not in the array and goes into infinite loop
		insertArray(12,0);
		insertArray(23,1);
		insertArray(32,2);
		int[] addArr = new int[10];
		addArr[0]=23;addArr[1]=34;addArr[2] = 4; addArr[3]=22;int n=4;//this is the current number of elements in array
		addToArray(9,2,n,addArr);
		removeArray(23);
		checkSort(arr1);
		upgradeBinarySearch(12);
		sortBinaryArray();
		sortBinaryOnePass();
		int[] zeroesToEndArr = {1,0,3,0,4,0,0,4,5,0};
		moveZerosToEnd(zeroesToEndArr);
		int[] evenOddArr = {3,5,2,7,4,0,6};
		evenBeforeOdd(evenOddArr);
		evenBeforeOddSwap(evenOddArr);
		int[][] matArr = {{3,0,1},{0,4,3},{9,7,8}};
		matrixSort(matArr);
		entireMatrixSort(matArr);
	}
}
