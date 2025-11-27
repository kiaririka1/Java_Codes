/*
 * Title: Array Questions in Leetcode with Solutions
 * Description: The code includes various array questions including find missing number, if array contains duplicate,minimum time to visit all points, etc.
 * Author: Isha Shelke
 * Last Updated: November 2025
 */
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class leetCode_Arrays {
	//This is the function to check if the array contains a duplicate
	//Input - Array to operate on
	//Output - true if the array has a duplicate, false otherwise
	//Time Complexity - O(N) and Space Complexity - O(N)
	static boolean containsDuplicate(int[] nums){
        Set<Integer> uniqueNums = new HashSet<>();//Make a set and add all array elements to it
        for(int k: nums){
            uniqueNums.add(k);
        }
        //compare the set and array size, if they're not equal, the array has an duplicate
        return uniqueNums.size() != nums.length;
    }
	
	//This is the function to return the missing number in an array
	//Input - Array to operate on
	//Output - returns the missing number in the array
	//Time Complexity - O(N) and Space Complexity - O(N)
	static int missingNumber(int[] nums) {
		int size = nums.length+1;
		int[] temp = new int[size];//initialize an array with same size + 1, considering 0 as number too
	    Arrays.fill(temp, -1);	//fill it with -1 for all places
	    for (int num : nums){
	        temp[num] = num;//only change the number at indices that equals the number
	    }
	    for(int i=0; i< size;i++) {
		  if(temp[i]==-1)return i;//return index where value is -1, that's the missing number
	  }
	  return -1;
	}
	
	//Best Solution for Missing Number
	//Space Complexity - O(1), no extra array
//	static int missingNumber(int[] nums) {
//        int n = nums.length;
//        int sum2;
//        int sum =0;
//        for(int i=0;i<n;i++){
//            sum+=nums[i];//sum by loop
//        }
//        sum2 = (n*(n+1))/2;//sum by formula
//        return sum2-sum;//difference gives missing number 
//    }
	
	//This is the function to return a list of missing numbers from the array
	//Input - Array to operate on
	//Output - returns the list of missing numbers in the array
	//Time Complexity - O(N) and Space Complexity - O(N)
	static List<Integer> allMissingNumbers(int[] nums) {
		int max = 0;
		List<Integer> result = new ArrayList<>();
	    for(int i=0;i<nums.length;i++) {
	    	if(nums[i]>max) {
	    		max = nums[i];
	    	}
	    }
	    int[] temp = new int[max+1];//initialize an array with same size + 1, considering 0 as number too
	    Arrays.fill(temp, -1);//fill it with -1 for all places
	    for (int num : nums){
	        temp[num] = num;//only change the number at indices that equals the number
	    }
	    for(int i=1; i<temp.length;i++){
		  if(temp[i]==-1) {
			  result.add(i);//add to list where value is -1, those are the missing numbers
		  }
	  }
	  return result;
	}

	//This is the function that returns the number of numbers smaller than the current number in the array
	//Input - Array to operate on
	//Output - returns the array of numbers lesser than current from the array
	//Time Complexity - O(N ^ 2) and Space Complexity - O(N) for result array
	static int[] smallerNumbersThanCurrent(int[] nums) {
		int[] res = new int[nums.length];
	   int counter=0;
	   for(int i=0;i<nums.length;i++) {
	   	    for(int j =0; j<nums.length;j++){
	   	    if(nums[i]>nums[j]) {
	   	    counter++;
	   	    }
	   	}
	   	res[i] = counter;
  	    counter=0;
	    }
	   return res;
	}
	    
	    //Best case solution for above problem	    
	    //Count Sort - O(N) and Space Complexity - O(N)
//	     static int[] smallerNumbersThanCurrent(int[] nums) {
//	            int n = nums.length;
//	            int res[] = new int[n];
//	            int[] small = new int[101];
//	            for(int i = 0; i < n ; i++)
//	            {
//	                small[nums[i]]++;
//	            }
//	            for(int i = 1 ; i < 101 ; i++)
//	            {
//	                small[i] += small[i-1];
//	            }
//	            for(int i = 0 ; i < n ; i++)
//	            {
//	                res[i] = nums[i] == 0 ? 0 : small[nums[i]-1];
//	            }
//	            return res;        
//	        }
	        
	    //Minimum time to visit all points if plotted on a graph and you can only move one place, up-down or diagonally in one unit of time
		//Input - Array of points to visit
		//Output - returns minimum time required
		//Time Complexity - O(N ^ 2) and Space Complexity - O(N)
	    static int minTimeToVisitAllPoints(int[][] points) {
	    	int res=0;
	    	//Kind of unnecessary to use this list and slower solution
//	    	List<List<Integer>> list = new ArrayList<>();
//	    	for (int[] p : points) {
//	            List<Integer> inner = new ArrayList<>();
//	            for (int val : p) {
//	                inner.add(val);
//	            }
//	            list.add(inner);
//	    	}
//	    	// Iterate through each consecutive pair of points
//	    	for(int i=1; i<list.size();i++) {
//	    		int x1 = list.get(i-1).get(0);
//	    		int y1 = list.get(i-1).get(1);
//	    		int x2 = list.get(i).get(0);
//	    		int y2 = list.get(i).get(1);
//	    		// Minimum time to move from (x1,y1) to (x2,y2) is max of horizontal and vertical distance
//	            // because diagonal moves reduce both at the same time
//	    		res+=Math.max(Math.abs(y2-y1),Math.abs(x2-x1));
//	    	}
	    	
	    	//Faster solution
	    	//Time Complexity - O(N) and Space Complexity-O(1)
	    	for(int i=0;i<points.length-1;i++) {
	    		res+=Math.max(Math.abs(points[i][0]-points[i+1][0]),Math.abs(points[i][1]-points[i+1][1]));
	    	}
	    	return res;
	    }
	    
	  //Accessing elements of a matrix in spiral form
	  //Input - Two-Dimensional matrix
	  //Output - List of elements accessed in a spiral order from the matrix
	  //Time Complexity - O(M * N) where M is the number of rows and N is the number of columns and Space Complexity - O(M*N) for result list
	    static List<Integer> spiralMatrix(int[][] mat){
	    	int rows = mat.length;
	    	int cols = mat[0].length;
	    	List<Integer> res = new ArrayList<>(rows * cols);
	    	int i,pos=0;
	    	int top = 0, bottom = rows - 1;
	        int left = 0, right = cols - 1;
	        //left to right horizontally first
	        while (top <= bottom && left <= right){
	    	for(i=left; i<= right;i++) {
	    		res.add(mat[top][i]);
	    	}
	    	top++;
	    	//right corner to down
	    	for(i=top; i<=bottom;i++){
	    		res.add(mat[i][right]);
	    	}
	    	right--;
	    	//down to left in reverse traversal
	    	if(top<=bottom) {
	    	for(i=right; i>=left ;i--){
	    		res.add(mat[bottom][i]);
	    	}
	    	bottom--;
	    	}
	    	//bottom to up last traversal before loop repeats and executes again
	    	if (left <= right) {
	    	for(i=bottom; i>=top ;i--){
	    		res.add(mat[i][left]);
	    	}
	    	left++;
	    	}
	        }
	    	return res;
	    }
	    
	  //This function returns the peak element index from an array, if there are multiple peaks, it will access any one of them
	  //Input - An Array to find its peak
	  //Output - Index of Peak element
	  //Time Complexity - O(N) and Space Complexity - O(1)
	    static int findPeakElement(int[] nums) {
	        for(int k = 0; k<nums.length; k++) {
	               if (nums.length == 1) return 0;
	           	//To check if first element is peak
	           	if(k==0 && nums[k]>nums[k+1]) {
	           	return k;
	           	}
	           	//to check if the peak is in between
	           	else if(k!=0 && k!=nums.length - 1 && nums[k]>nums[k+1] && nums[k]>nums[k-1])
	           	{
	           	return k;
	           	}
	           	//To check if last element is peak
	           	else if(k==nums.length - 1 && nums[k]>nums[k-1]) {
	           	return k;
	           	}   
	       }
	       return 0;
	   }
	    
	//This function returns the peak elements from an array,even if there are multiple peaks.
	//Input - An Array to find its peaks
	//Output - List of Peak elements
	//Time Complexity - O(N) and Space Complexity - O(h) where h is the number of peak elements 
	    static List<Integer> findPeakElementsinArray(int[] peakArray) {
	    List<Integer> peak = new ArrayList<Integer>();
	       for(int k = 0; k<peakArray.length; k++) {
	        	//To check if first element is peak
	        	if(k==0 && peakArray[k]>peakArray[k+1]) {
	        	peak.add(peakArray[k]);
	        	}
	        	//to check if the peak is in between
	        	else if(k!=0 && k!=peakArray.length - 1 && peakArray[k]>peakArray[k+1] && peakArray[k]>peakArray[k-1])
	        	{
	        	peak.add(peakArray[k]);
	        	}
	        	//To check if last element is peak
	        	else if(k==peakArray.length - 1 && peakArray[k]>peakArray[k-1]) {
	        	peak.add(peakArray[k]);
	        	}
	       }
	       return peak;
	    }
	    
    public static void main(String[] Args){
        int[] arrDupli = {1,2,3,3,4,5};
        System.out.println(containsDuplicate(arrDupli));
        
        int[] noMissing = {0,1,3,4,5};
        System.out.println(missingNumber(noMissing));
        
        int[] allMissing = {0,3,5};
        System.out.println(allMissingNumbers(allMissing));
        
        int[] smallerThanCurr = {8,1,2,2,3};
        int[] noSmaller = smallerNumbersThanCurrent(smallerThanCurr);
        for(int x : noSmaller) {
        	System.out.print(x + " ");
        }System.out.println();
        
        int[][] points = {{1,1},{3,4},{-1,0}};
        int time = minTimeToVisitAllPoints(points);
        System.out.println(time);
        
        int mat[][] = {
        		{1,2,44,3},
        		{4,5,0,6},
        		{7,8,34,9}
        };
        List<Integer> res = spiralMatrix(mat);
        System.out.println(res);
        	
     	int[] peakArray = {1,2,9,6,0,5};
     	System.out.println(findPeakElement(peakArray));
        List<Integer> peak = findPeakElementsinArray(peakArray);
        System.out.println(peak.toString());
    }
}
