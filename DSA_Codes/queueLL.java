/*
 * Title: Queue Using Linked List Implementation In Java 
 * Description: The code includes queue operations like enqueue,dequeue and print queue.
 * Author: Isha Shelke
 * Last Updated: October 2025
 */
//This implementation of queue does not limit use space and is expandable as needed
class queue_by_LL{
	Node front,back;
	
	boolean isEmpty() {
		return front==null;
	}
	
	//Linked List enqueue from the front where the head gets pushed forward and the back is added before the head.
	//Time Complexity - O(1) and Space complexity - O(1)
	void enqueue(int val) {
		Node head = new Node(val);
		head.next=null;
		if(isEmpty()) {
			front=back=head;
		}else {
		back.next=head;
		back=head;}
		System.out.println("Enqueued : "+ back.val);
	}
	
	//Linked List dequeue from the front where the front gets deleted forward and the front is moved to the next of current front.
	//Time Complexity - O(1) and Space complexity - O(1)
	int deque() {
		if(isEmpty()) {
			return 0;
		}else {
			int value = front.val;
			front = front.next;
			if(front==null) {
				back=null;//Reset the queue
			}
			return value;
		}
	}
	
	//returns the first Element in the queue.
	//Time Complexity - O(1) and Space complexity - O(1)
	void firstEle() {
		if(isEmpty()) {
			System.out.println("Queue is Empty");
		}else {
			System.out.println("First element in the queue is: " + front.val);
		}
	}
	
	//returns the last Element in the queue.
	//Time Complexity - O(1) and Space complexity - O(1)
	void lastEle() {
		if(isEmpty()) {
			System.out.println("Queue is Empty");
		}else {
			System.out.println("First element in the queue is: " + back.val);
		}
	}
	
	//prints all the elements in the queue.
	//Time Complexity - O(n) and Space complexity - O(1)
	void printQueue() {
		if(isEmpty()) {
			System.out.println("Queue is Empty");
		}else {
			Node temp=front;
			while(temp!=null) {
			System.out.println(temp.val);
			temp=temp.next;}
		}
	}

}

public class queueLL {
	public static void main(String[] args) {
		//Initialize the queue
		queue_by_LL q = new queue_by_LL();
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);
		q.enqueue(50);
		q.firstEle();
		q.lastEle();
		q.printQueue();
		q.deque();
		q.deque();
		q.deque();
		q.deque();
		q.deque();
		q.deque();
	}

}
