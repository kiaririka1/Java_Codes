/*
 * Title: Stack Using Linked List Implementation In Java 
 * Description: The code includes stack operations like pushing and popping to Stack and additional operations like peek and print Stack.
 * Author: Isha Shelke
 * Last Updated: October 2025
 */
//Stack using Linked List eliminates the need to give stack a fixed size. The stack becomes flexible to accommodate the number of elements as required. 
//Initialize top as 0 and element in stack as data.
//Let head be the first element of the Stack LL and next be the pointer to the next node.
class StackLL{
	int top=0,data;
	StackLL head,next;
	StackLL(){
		this.head = null;
		this.next = null;
	}
	
	//Checks if stack is empty
	boolean isEmpty() {
		return this.top==0;
	}
	
	//This function pushes element into stack. Each pushed element becomes the next head.
	//Insertion and Deletion from the head ensures constant time complexity.
	//Time Complexity - O(1) and space complexity - O(1)
	void pushStackLL(int data){
		top++;
		StackLL element = new StackLL();
		element.data = data;
		element.next = head;
		head = element;
		System.out.println("Pushed : " + element.data);
	}
	
	//This function pops element from the stack. Each element is popped from the head.
	//Time Complexity - O(1) and space complexity - O(1)
	void popStackLL() {
		if(isEmpty()) {
			System.out.println("Stack Underflow");
		}else{
			top--;
			StackLL temp=head;
			head=head.next;
			System.out.println("Popped : " + temp.data);
		}
	}
	
	//This function gives the element at the given index from the stack.
	//Time Complexity - O(n) and space complexity - O(1)
	void peekStackLL(int index) {
			StackLL temp = head;
			for(int i=0;i<index-1 && temp!=null;i++) {
				temp=temp.next;
			}
			if(temp!=null) {
				System.out.println("Element at index "+index + " is: "+temp.data);
			}else {
				System.out.println("Invalid Index");
		}
	}
	
	//This function prints the elements from the stack in top-down manner.
	//Time Complexity - O(n) and space complexity - O(1)
	void printStackLL() {
		int count = 0;
		if(isEmpty()) {
			System.out.println("Stack Underflow");
		}else {
		while(count<top){
			peekStackLL(count+1);
			count++;
		}
	}
	}
	
	//Returns top element of the stack
	//Time Complexity - O(1) and space complexity - O(1)
	void stackTop() {
		if(isEmpty()) {
			System.out.println("Stack is Empty");
		}else
		{System.out.println("Element at top of the Stack: "+ head.data);}
	}
	
	//Returns bottom element of the stack
	//Time Complexity - O(1) and space complexity - O(1)
	void stackBottom() {
		if(isEmpty()) {
			System.out.println("Stack is Empty");
		}else
		{
		StackLL temp=head;
		while(temp.next!=null) {
			temp=temp.next;
		}
		System.out.println("Element at bottom of the Stack: "+temp.data);
		}
	}
	
	//Returns the size of stack
	//Time Complexity - O(1) and space complexity - O(1)
	int size() {
		return top;
	}
}

public class Stack_Using_LL {

	public static void main(String[] args) {
		StackLL first= new StackLL();
		first.pushStackLL(10);
		first.pushStackLL(20);
		first.pushStackLL(30);
		first.pushStackLL(40);
		first.pushStackLL(50);
		System.out.println(first.size());
		first.peekStackLL(2);
		first.printStackLL();
		first.popStackLL();
		first.popStackLL();
		first.popStackLL();
		first.popStackLL();
		first.popStackLL();
		first.stackTop();
		first.stackBottom();
		first.printStackLL();
		}

}
