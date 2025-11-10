/*
 * Title: Sorting Algorithms in Java
 * Description: The code includes sorting algorithms like Bubble Sort, Insertion Sort, Selection Sort, Quick Sort, Partition Sort, Merge Sort and Count Sort.
 * Author: Isha Shelke
 * Last Updated: October 2025
 */
public class sorting_Algorithms {
int Barr;
	//This algorithm swaps every current and next element till the entire array becomes sorted.
	//Input - Array to Sort
	//Time Complexity - O(N * 2) and Space complexity - O(1) as it is an in-place algorithm
	static void bubbleSort(int[] arr) {
		boolean sortedArray = false; //reduces checking time and passes for sorted array, makes algorithm adaptive
		for(int i=0;i<arr.length-1;i++) {//for passes
			sortedArray=true;
			System.out.println("Number of passes required :" + (i+1));
			for(int j=0;j<arr.length-i-1;j++) {
				if(arr[j]>arr[j+1]) 
				{
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					sortedArray=false;
				}
			}
			//Time Complexity - O(n) when the array is already sorted
			if(sortedArray) {
				return;
			}
		}
	}
	
	//This algorithm assumes the first element is sorted and next is inserted by comparison to the first in its right place.
	//Input - Array to Sort
	//Time Complexity - O(N * 2) and Space complexity - O(1) as it is an in-place algorithm.
	//Best Case Time Complexity is O(N) when the array is already sorted.
	static void insertionSort(int[] arr) {
		int key,j;
		for(int i=1;i<arr.length;i++) {
			key = arr[i];
			j=i-1;
			while(j>=0 && arr[j]>key){
				arr[j+1]=arr[j];
				j--;
			}arr[j+1]=key;
		}
	}
	
	//This algorithm finds the minimum element in the array and swaps with first then the next smallest and so on until the entire array is sorted.
	//Input - Array to Sort
	//Time Complexity - O(N * 2) and Space complexity - O(1) as it is an in-place algorithm
	static void selectionSort(int[] arr) {
		int min;
		for(int i=0;i<arr.length;i++) {
			min=i;
			for(int j=i+1;j<arr.length;j++) {
				if(arr[j]<arr[min]) {
					min=j;
				}
			}
			int temp = arr[i];
			arr[i]=arr[min];
			arr[min] = temp;
		}
	}
	
	//This algorithm uses partitioning on each element such that every element to the left of it is smaller than that element and every element to the right is greater than it.
	//Input - low - first index position in the array, high - last index position in the array and Array to Sort.
	//Time Complexity - O(N * 2) in the worst case, O(N * log N) in the best case and Space complexity - O(1) as it is an in-place algorithm
	static void QuickSort(int low, int high, int[] arr) {
		if(low<high) {
		int partitionIndex = partition(arr,low,high);// index of pivot after partition
		QuickSort(low,partitionIndex-1,arr);//first half
		QuickSort(partitionIndex+1,high,arr);}//second half
	}
	
	static int partition(int[] arr, int low, int high) {
		int i = low + 1,j=high,pivot=arr[low];
		do {
		while(arr[i]<=pivot) {
			i++;
		}
		while(arr[j]>pivot) {
			j--;
		}
		if(i<j){
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		}while(i<j);
		//swap pivot/arr[low] with j when j becomes less than i
		int temp=arr[j];
		arr[j]=arr[low];
		arr[low] = temp;
		return j;
	}
	
	//This algorithm is used to merge two sorted array separate or in one array.
	//Input - low - first index position in the array, high - last index position in the array and Array to Sort.
	//Time Complexity - O(N * log N) in the all cases and Space complexity - O(N) as needs an additional array the size of both sorted arrays combined.
	static void MergeSort(int[] arr, int low, int high) {
		int mid = (low+high)/2;
		if(low<high){
		MergeSort(arr,low,mid);
		MergeSort(arr,mid+1,high);
		Merge(arr,low,mid,high);
		}
	}
	
	static void Merge(int[] arr, int low, int mid, int high) {
		int i = low,j=mid+1,k=low;// k is for updating empty new merge sort array, i starts at 0 goes till mid that is first array, b starts at mid+1 goes till high that is the second array
		int[] Barr = new int[high+1]; //array for storing merge sort values
		while(i<=mid && j<=high){
			if(arr[i]<arr[j]){ //both arr[i] and arr[j] halves of arr are sorted array so the minimum element is put into Barr first
				Barr[k]=arr[i];
				k++;i++;
			}else {
				Barr[k]=arr[j];
				k++;j++;
			}
		}
		while(i<=mid) { // remaining arr[i] array is copied into Barr till high is reached
			Barr[k++]=arr[i++];
		}
		while(j<=high) { // remaining of arr[j] is copied into Barr
			Barr[k++]=arr[j++];
		}
		for(int x=low;x<=high;x++) {
			arr[x]=Barr[x];
		}
	}
	
	//This algorithm involves finding the maximum element in the given array and making a additional array of that size and putting every occuring element as count++ and the rest non-occuring as zero.
	//Input - Array to Sort.
	//Time Complexity - O(N + K) where K is the range(maximum - minimum values) and Space complexity - O(N + K) as it requires an additional array of the maximum element's size.
	static void countSort(int[] arr) {
		int maxNumber = 0;
		int i,j;
		for(i=0;i<arr.length;i++) {
			if(arr[i]>maxNumber) { // to find the maximum number in an array
				maxNumber = arr[i];
			}
		}
		
		//initialize array of maximum element's size
		int[] count = new int[maxNumber+1];
		//initialize all elements as zero
		for(i=0;i<count.length;i++) {
				count[i]=0;
		}
		
		//incrementing count if element is found
		for(i=0;i<arr.length;i++) {
			count[arr[i]]++;
		}

		i=0;// counter for count array
		j=0; // counter for arr array
		while(i<=maxNumber) {
			if(count[i]>0) {
				arr[j]=i;
				count[i]--;
				j++;
			}
			else{i++;}
		}
	}
	
	//Function to print array
	static void printArray(int[] arr) {
		for(int element : arr) {
			System.out.print(element+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] arr = {12,76,5,20,34,90};
		//Sorted Array Example - {10,30,20,40,50,60};
		//bubbleSort(arr);
		//insertionSort(arr);
		//selectionSort(arr);
		//QuickSort(0,arr.length-1,arr);
		//MergeSort(arr,0,arr.length-1);
		//countSort(arr);
		printArray(arr);
	}

}
