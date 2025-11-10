/*
 * Title: Double Ended Queue Implementation In Java 
 * Description: The code includes implementation of Double Ended Queue using Doubly Linked List and its operations like enqueue and deque from both the front and back ends.
 * Author: Isha Shelke
 * Last Updated: October 2025
 */
//We maintain a front and a back pointer in the Double Ended Queue to track addition and deletion from both sides separately.
//Maintaining two pointer ensures our Time and Space Complexity remains O(1)
class Double_Ended_queue{
	DLLNode front,back;
	//When both pointers are empty, the queue is empty
	boolean isEmpty() {
		return front==null && back==null;
	}
	
	//This function is for adding an element to the end of the DEqueue.
	//Input - Value of the element to be added.
	//Time Complexity - O(1) and Space Complexity - O(1)
	void enqueueFromBack(int val) {
		DLLNode backNode = new DLLNode(val);
		backNode.next=null;
		//When DEQueue is empty
		if(isEmpty()) {
			front=back=backNode;
			front.prev=null;
		}else{
		//When DEQueue has some elements
		backNode.prev = back;
		back.next=backNode;
		back=backNode;}
		System.out.println("Enqueued from back: "+ back.val);
	}
	
	//This function is for adding an element to the start of the DEqueue.
	//Input - Value of the element to be added.
	//Time Complexity - O(1) and Space Complexity - O(1)
	void enqueueFromFront(int val) {
		DLLNode frontNode = new DLLNode(val);
		frontNode.next=null;
		//When DEQueue is empty
		if(isEmpty()) {
			front=back=frontNode;
			back.next=null;
		}else{
			//When DEQueue has some elements
			frontNode.next=front;
			front.prev = frontNode;
			front=frontNode;
		}System.out.println("Enqueued from front: "+ front.val);
	}
	
	//This function is for removing an element from the end of the DEqueue.
	//Time Complexity - O(1) and Space Complexity - O(1)
	void dequeueFromBack() {
		if(isEmpty()) {
			System.out.println("Queue is Empty");
		}else{
			int value = back.val;
			back = back.prev;
			if(back==null) {
				front=null;//reset the queue
			}else {
				back.next=null;
			}
			System.out.println("Dequeued from back: " + value);
		}
	}
	
	//This function is for removing an element from the front of the DEqueue.
	//Time Complexity - O(1) and Space Complexity - O(1)
	void dequeueFromFront() {
		if(isEmpty()) {
			System.out.println("Queue is Empty");
		}else {
			int value = front.val;
			front = front.next;
			if(front==null) {
				back=null;//reset the queue
			}else {
				front.prev=null;
			}
			System.out.println("Dequeued from front: " + value);
		}
	}

	//This function returns the first element in the DEqueue.
	//Time Complexity - O(1) and Space Complexity - O(1)
	void firstEle() {
		if(isEmpty()) {
			System.out.println("Queue is Empty");
		}else {
			System.out.println("First element in the queue is: " + front.val);
		}
	}
	
	//This function returns the first element in the DEqueue.
	//Time Complexity - O(1) and Space Complexity - O(1)
	void lastEle() {
		if(isEmpty()) {
			System.out.println("Queue is Empty");
		}else {
			System.out.println("Last element in the queue is: " + back.val);
		}
	}
	
	//This function prints all the elements in the DEqueue in the order they were entered.
	//Time Complexity - O(N) and Space Complexity - O(n)
	void printQueue() {
		if(isEmpty()) {
			System.out.println("Queue is Empty");
		}else {
			DLLNode temp=front;
			while(temp!=null) {
			System.out.println(temp.val);
			temp=temp.next;}
		}
	}

}
public class DEqueue {

	public static void main(String[] args) {
		//Initialize the Double Ended Queue
		Double_Ended_queue q = new Double_Ended_queue();
		q.enqueueFromFront(10);
		q.enqueueFromFront(20);
		q.enqueueFromBack(30);
		q.enqueueFromBack(40);
		q.enqueueFromBack(50);
		q.firstEle();
		q.lastEle();
		q.printQueue();
		q.dequeueFromBack();
		q.dequeueFromFront();
		q.dequeueFromFront();
		q.printQueue();
		q.dequeueFromFront();
		q.dequeueFromFront();
		q.dequeueFromFront();
	}

}