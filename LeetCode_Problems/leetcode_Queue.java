/*
 * Title: MinStack and Queue Problems in Leetcode with solutions
 * Description: The code includes the minStack representation of a stack and the Time Required To Buy Tickets Queue Problem.
 * Author: Isha Shelke
 * Last Updated: November 2025
 */
//This is a class to maintain the minimum element in a stack at the top. We are using an array to represent the stack
class MinStack {
	int top;
	int[] arr,minArr;
    public MinStack() {
    	this.top =-1;
    	this.arr = new int[10];
    	this.minArr = new int[10];//minArr stores the minimum value in array upto that point
    	//minArr reduces the time complexity of getting the minimum value from an array
    }
    
	boolean isEmpty() {
	return top == -1;//To check if array is empty
	}
	
	//This is the function for pushing an element into the stack.
	//Input - Value to add to array
	//Time Complexity - O(1) and Space Complexity - O(n)
    public void push(int val) {
    		if (top == arr.length - 1) {
    			//This is to double the value of array when it is full
                int[] newArr = new int[arr.length * 2];
                int[] newMinArr = new int[arr.length * 2];
                for (int i = 0; i < arr.length; i++) {
                    newArr[i] = arr[i];
                    newMinArr[i] = minArr[i];
                }
                arr = newArr;
                minArr = newMinArr;
            }
		top++;
		arr[top] = val;//increment and add element to array
        if (top == 0) {
            minArr[top] = val;//when array is empty
        } else {
            minArr[top] = Math.min(val, minArr[top - 1]);//update with minimum between the top of stack and the value being pushed into the stack
        }
    }
    
    //This is the function for popping an element from the stack.
  	//Output - Removes the top element in the stack
  	//Time Complexity - O(1) and Space Complexity - O(1)
    public void pop() {
    	if(isEmpty()) {
			return;
		}else {
		top--;
		}
    }
    
    public int top() {
        return arr[top];
    }
    
    //This is the function for getting the smallest element in the stack
  	//Output - The minimum value in the stack
  	//Space Complexity - O(1)
    public int getMin() {
    	//min using only arr and not minArr
    	//Time Complexity - O(N)
//    	int min = Integer.MAX_VALUE;
//        for (int i = 0; i <= top; i++) {
//            min = Math.min(min, arr[i]);
//        }
//        return min;
    	//Time Complexity - O(1)
        return minArr[top];
    }
}
public class leetcode_Queue {
	//This function gives us the time required by a person in a queue to buy a ticket. 
	//Input - tickets array is queue and k is the position of the person
	//Output - Time required to get the ticket
	//Time Complexity - O(N) and Space Complexity - O(1)
static int timeRequiredToBuy(int[] tickets, int k) {
	int count=0;
        	for(int i=0;i<tickets.length;i++) {
        		if (i <= k) {
                    count += Math.min(tickets[i], tickets[k]);//People before or upto k need tickets[k] turns
                } else {
                    count += Math.min(tickets[i], tickets[k] - 1);//People after k only need k-1 turns because k finishes earlier
                }
        }
        return count;
}

	public static void main(String[] args) {
		MinStack m = new MinStack();
		m.push(5);
		m.push(0);
		m.push(1);
		m.push(6);
		m.pop();
		System.out.println(m.top());
		System.out.println(m.getMin());

		int[] tick = {2,3,2};
		System.out.println(timeRequiredToBuy(tick,2));
	}

}
