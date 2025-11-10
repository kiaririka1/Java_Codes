/*
 * Title: Queue Using Array Implementation In Java 
 * Description: The code includes queue operations like enqueue,dequeue and additional operations like peek and print queue.
 * Both circular and straight queues are implemented.
 * Author: Isha Shelke
 * Last Updated: October 2025
 */
//Queue is a First In First Out data structure.
//Initialize front and back at -1 because queue index start at 0.
class Queue{
	int front=-1,back=-1;
	int size;
	int[] arr;
	Queue(int length){
		this.size = length;
		this.arr = new int[size];
	}
	//Normal queue but it doesn't regard for space complexity. We need a larger queue as we are incrementing front in deque.
//	boolean isEmpty() {
//		return front==back;
//	}
//	
//	boolean isFull() {
//		return back==arr.length;
//	}
//	
//	//This function adds element at back of the queue
//	//Time Complexity - O(1) and Space Complexity - O(1)
//	void enqueue(int val) {
//		if(!isFull()) {
//			back++;
//			arr[back]=val;
//			System.out.println(arr[back]+" element is added at index " + back);
//		}else {
//			System.out.println("Queue is full");
//		}
//	}
//	
//	//This function removes element from the front of the queue
//	//Time Complexity - O(1) and Space Complexity - O(1)
//	//Space Complexity becomes O(n) if we shift all elements after dequeuing the first element
//	void deque() {
//		if(!isEmpty()) {
//			front++;
//			int a = arr[front];
//			arr[front]=0;
//			System.out.println(a+" element at Index "+front+" has been dequed");
//		}else {
//			System.out.println("Queue is empty");
//		}
//	}
//	
//	//This function returns first element of the queue
//	//Time Complexity - O(1) and Space Complexity - O(1)
//	void firstElement() {
//		System.out.println("The first element is: " + arr[front+1]);
//	}
//	
//	//This function returns last element of the queue
//	//Time Complexity - O(1) and Space Complexity - O(1)
//	void lastElement() {
//		System.out.println("The last element is: " + arr[back]);
//	}
//	
//	//This function returns element at the given index of the queue
//	//Time Complexity - O(1) and Space Complexity - O(1)
//	void peekElement(int index) {
//		if(isEmpty() || index<=0) {
//			System.out.println("Invalid index");
//		}else {
//		System.out.println("The element at "+ index + " is: " + arr[index-1]);}
//	}
//	
	//This function prints all the elements of the queue
	//Time Complexity - O(n) and Space Complexity - O(1)
//	void printQueue() {
//		int temp;
//		if(front == -1) {
//		temp = 0;}
//		else {temp = front;}
//		while(arr[temp]!=0) {
//			System.out.println(arr[temp]);
//			temp++;
//		}
//	}
	
	//circular queue implementation
	//We use circular queue to reuse space after deque operation. It also makes space and time complexity O(1)
	boolean isEmpty() {
		return front==-1;
	}
	
	boolean isFull() {
		return (back+1)%size==front;
	}
	
	//Enqueue in Circular queue and it resets back on queue becoming full by using '%'
	//Time Complexity - O(1) and Space Complexity - O(1)
	void enqueue(int val) {
		if(!isFull()){
			if(front==-1) {
				front=0;
			}
			back=(back+1)%size;
			arr[back]=val;
			System.out.println(arr[back]+" element is added at index " + back);
		}else{
			System.out.println("Queue is full");
		}
	}
	
	//Deque function and the queue resets on each deque when the entire queue becomes empty
	//Time Complexity - O(1) and Space Complexity - O(1)
	int deque() {
		if(!isEmpty()) {
			int a = arr[front];
			arr[front]=0;
			System.out.println(a+" element at Index "+front+" has been dequed");
			if(front == back) {
	            //Queue is now empty
	            front = back = -1;
	        }else {
	        	front = (front+1)%size;
	        }
			return a;
		}else {
			return 0;
		}
	}
	
	//Returns first element of circular queue
	//Time Complexity - O(1) and Space Complexity - O(1)
	void firstElement() {
		if(!isEmpty())
		    System.out.println("The first element is: " + arr[(front) % size]);
		else
		    System.out.println("Queue is empty");
	}

	//Returns last element of circular queue
	//Time Complexity - O(1) and Space Complexity - O(1)
	void lastElement() {
		System.out.println("The last element is: " + arr[back]);
	}
	
	//Returns element at the given index of circular queue
	//Time Complexity - O(1) and Space Complexity - O(1)
	void peekElement(int index) {
		 if (isEmpty() || index <= 0 || index > size) {
		        System.out.println("Invalid index");
		    } else {
		        int actualIndex = (front + index-1) % size;
		        System.out.println("The element at position " + index + " is: " + arr[actualIndex]);
		    }	
		 }
	
//Prints all elements of circular queue
//Time Complexity - O(n) and Space Complexity - O(1)
	void printCircularQueue() {
		int temp=front;
		while(true){
			System.out.println(arr[temp]);
			if(temp==back)
				break;
			temp=(temp+1)%size;
		}
	}
}
public class queueArray {

	public static void main(String[] args) {
		Queue q = new Queue(5);
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);
		q.enqueue(50);
		//q.printQueue();
		q.peekElement(3);
		q.firstElement();
		q.lastElement();
		q.deque();
		q.enqueue(60);
	    q.printCircularQueue();
		q.deque();
		q.deque();
		q.deque();
		q.deque();
	}

}
