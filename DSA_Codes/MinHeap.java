/*
 * Title: Min Heap Implementation in Java
 * Description: The code has insert,swap and extractMin functionalities to add to minHeap and make the root of the heap the smallest element in the data structure.
 * Author: Isha Shelke
 * Last Updated: October 2025
 */
class Min_heap{
	int[] heap;
	int heap_Capacity, current_heap_size;
	Min_heap(int size){
		this.heap_Capacity = size;
		this.heap = new int[heap_Capacity];
		this.current_heap_size = 0;
	}
	
	//This a function to swap two values
	void swap(int x, int y) {
		int temp = heap[x];
		heap[x]=heap[y];
		heap[y]=temp;
	}
	
	//Function to add a given value to heap
	//Time Complexity - O(log N) and Space Complexity - O(1)
	void insert(int value) {
   		if(current_heap_size == heap_Capacity) {
		System.out.println("Heap is full");
		}
   		int i = current_heap_size;
        heap[i] = value;
        current_heap_size++;
while(i>0) {
	//calculate parent for each element added
	int parent = (i-1)/2;
   		if(heap[i] < heap[parent]) {
			swap(i,parent);
			i=parent;
		}else {break;}
	}
	}
	
	//Function to get the root/the smallest number in heap
	//Time Complexity - O(log N) and Space Complexity - O(1)
	int extractMin() {
        if (current_heap_size <= 0) {
            System.out.println("Heap is empty");
            return Integer.MAX_VALUE;
        }
        if (current_heap_size == 1){
            current_heap_size--;
            return heap[0];
        }

        int root = heap[0];
        heap[0] = heap[current_heap_size - 1];
        current_heap_size--;

        // Bubble down
        heapify(0);

        return root;
    }
	
	//Update smallest number if its in any other position than root
	//Time Complexity - O(log N) and Space Complexity - O(1)
	void heapify(int i) {
		int left = 2 * i + 1;
        int right = 2 * i + 2;
        int smallest = i;

        if (left < current_heap_size && heap[left] < heap[smallest])
            smallest = left;
        if (right < current_heap_size && heap[right] < heap[smallest])
            smallest = right;

        if (smallest != i) {
            swap(i, smallest);
            heapify(smallest);
        }
	}
	
	//Function to print the heap
	//Time Complexity - O(N) and Space Complexity - O(1)
	void printHeap() {
        for (int i = 0; i < current_heap_size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
	
	//Deleting an element at given index
	//Time Complexity - O(log N) and Space Complexity - O(1)
	void delete(int i) {
	    if (i >= current_heap_size) {
	        System.out.println("Index out of range");
	        return;
	    }

	    // Replace with last element
	    heap[i] = heap[current_heap_size - 1];
	    current_heap_size--;

	    // Bubble down (heapify) from this position
	    heapify(i);

	    // Bubble up in case replaced element is smaller
	    int parent = (i - 1) / 2;
	    while (i > 0 && heap[i] < heap[parent]) {
	        swap(i, parent);
	        i = parent;
	        parent = (i - 1) / 2;
	    }
	}
}

public class MinHeap {

	public static void main(String[] args) {
		Min_heap m = new Min_heap(10);
		m.insert(6);
		m.insert(9);
		m.printHeap();
		m.insert(2);
		m.printHeap();
		m.insert(1);
		m.printHeap();
		m.delete(2);
		m.printHeap();
	}

}
