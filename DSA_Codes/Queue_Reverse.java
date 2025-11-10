/*
 * Title: Reverse the first K elements in Queue 
 * Description: The code reverses the first K elements of a queue. This is implemented using a Java in-built stack.
 * Author: Isha Shelke
 * Last Updated: October 2025
 */

import java.util.Stack;

public class Queue_Reverse {

	//Input - The queue to reverse and K is the number of elements to be reversed from the start
	static void rev_K_Queue(Queue q, int k) {
		Stack<Integer> s = new Stack<>();
		int x = k;
		while(x!=0) {
			s.push(q.deque());
			x--;
		}
		while(!s.isEmpty()) {
			q.enqueue(s.pop());
		}
		for (int i = 0; i < q.size - k; i++) {
		    q.enqueue(q.deque());
		}
		q.printCircularQueue();
	}
	public static void main(String[] args) {
		//Initialize the Queue
		Queue q = new Queue(5);
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);
		q.enqueue(50);
		rev_K_Queue(q,3);
		q.firstElement();
		//q.printCircularQueue();
}
}
