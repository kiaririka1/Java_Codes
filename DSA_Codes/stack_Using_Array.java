/*
 * Title: Stack Using Array Implementation In Java 
 * Description: The code includes stack operations like pushing and popping to Stack and additional operations like peek and print Stack.
 * Author: Isha Shelke
 * Last Updated: October 2025
 */
//Stack uses Last In First Out i.e. the last element to go in is popped first.
//We maintain a top pointer in stack that points to the top element in the stack and its initialized as -1 when stack is empty.
//We will use an array to implement this stack.
//Input - Length - Initializes the length of stack
class StackArray{
	int top=-1;
	int length;
	int[] arr;
	StackArray(int len){
		this.length = len;
		this.arr = new int[length];
	}
	
	//returns true if stack is full to maximum length
	boolean isFull() {
		return top == length-1;
	}
	
	//returns true if stack is empty
	boolean isEmpty() {
	return top == -1;}
	
	//This function pushes an element into stack.
	//Input - The element to be inserted in the stack
	//Time Complexity - O(1) and Space Complexity - O(1)
	void push(int element) {
		if(isFull()) {
			System.out.println("Stack Overflow");
		}else {
		top++;
		this.arr[top] = element;
		System.out.println("Pushed : " + element);
		}
	}
	
	//This function pops the last element entered into stack.
	//Time Complexity - O(1) and Space Complexity - O(1)
	int pop() {
		if(isEmpty()) {
			return 0;
			//System.out.println("Stack Underflow");
		}else {
		int temp = arr[top];
		top--;
		return temp;
		//System.out.println("Popped : " + temp);
		}
	}
	
	//This function pushes an element into stack.
	//Input - The position to be element in the stack
	//Time Complexity - O(1) and Space Complexity - O(1)
	void peek(int index) {
		int arrayIndex =top-index+1;
		if(arrayIndex<0 || arrayIndex>this.length){
			System.out.println("Invalid index");
		}else {
		System.out.println("Element at index "+ index + " is: " + arr[top-index+1]);}
	}
	
	//This function pushes an element into stack.
	//Time Complexity - O(n) and Space Complexity-O(1)
	void printStack() {
		int counter=0;
		if(isEmpty()) {
			System.out.println("Stack Underflow");
		}else {
		while(counter<=top) {
			peek(counter+1);
			counter++;
		}
		}
	}
	
	//This function returns the top of stack
	//Time Complexity - O(1) and Space Complexity - O(1)
	void stackTop() {
		System.out.println("Element at top of the Stack: "+arr[top]);
	}
	
	//This function returns the bottom of stack
	//Time Complexity - O(1) and Space Complexity - O(1)
	void stackBottom() {
		System.out.println("Element at bottom of the Stack: "+arr[0]);
	}
	
	//This function returns the size of stack
	//Time Complexity - O(1) and Space Complexity - O(1)
	int size() {
        return top + 1;
    }
}
public class stack_Using_Array {

	public static void main(String[] args) {
		//Initialize the Stack
		StackArray s = new StackArray(5);
		s.push(4);
		s.push(41);
		s.push(43);
		s.push(44);
		s.push(42);
		s.printStack();
		s.stackTop();
		s.stackBottom();
		s.pop();
		s.pop();
		s.printStack();
		s.pop();
		s.pop();
		s.pop();
		s.printStack();
		System.out.println(s.size());
		}

}
