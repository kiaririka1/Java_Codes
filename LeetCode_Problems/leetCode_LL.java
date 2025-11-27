/*
 * Title: Linked List Questions in Leetcode with Solutions
 * Description: The code includes getting the middle node, reversing, removing elements in a Linked List and various other questions.
 * Author: Isha Shelke
 * Last Updated: November 2025
 */

//Class for a singly linked list according to Leetcode
class ListNode {
    int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

public class leetCode_LL {
	//This is the function to find the middle node of a Linked List.
	//Input - Head of the Linked List
	//Output - Middle Node of the Linked list
	//Time Complexity - O(N) and Space Complexity - O(1)		 
	static ListNode middleNode(ListNode head) {
	ListNode slow=head, fast = head;
	while(fast!= null && fast.next!=null) {
		slow= slow.next;//jumps by one place
		fast = fast.next.next;//jumps by two places
	}
	return slow;//return slow when fast reaches the end and that's slow in the middle
	}
	
	//This is the function to find if a Linked List has a cycle.
	//Input - Head of the Linked List
	//Output - true if Linked list has a cycle, false otherwise
	//Time Complexity - O(N) and Space Complexity - O(1)	
static boolean hasCycle(ListNode head) {
	ListNode slow=head, fast = head;
	while(fast!= null && fast.next!=null) {
		slow= slow.next;//jumps by one place
		fast = fast.next.next;//jumps by two places
		if(slow == fast) {
			return true;//at any point if the two meet, its a cycle and loop ends
			//To find the start of the cycle, we increment both by one place and where they meet again becomes the start
//			slow = head;
//			while (slow != fast) {
//			    slow = slow.next;
//			    fast = fast.next;
//			}
//			return slow;
		}
	}
	return false;
 }

//This is the function to reverse a Linked List.
//Input - Head of the Linked List
//Output - The new head i.e. the last node that has become the head
//Time Complexity - O(N) and Space Complexity - O(1)
static ListNode reverseList(ListNode head) {
	ListNode curr = head, prev = null;
	while(curr != null){
		ListNode next = curr.next;//temporarily holds the node's next
		curr.next = prev;//reverses the next pointer
		prev = curr;//prev moves forward
		curr = next;//current moves forward using temporary pointer
	}
    return prev;//prev becomes new head
}

//This is the function to remove elements from a Linked List.
//Input - Head of the Linked List
//Output - The new head of the List
//Time Complexity - O(N) and Space Complexity - O(1)
static ListNode removeElements(ListNode head, int val) {
	if(head == null) {return null;}//handling the null head condition
	ListNode dummy = new ListNode();//to point through all nodes including head
	dummy.next = head;
	ListNode tempDel = dummy;
	//if the node is at the head, Time Complexity - O(1)
	while(tempDel!=null && tempDel.next!=null) {
		if(tempDel.next.val == val) {
			tempDel.next = tempDel.next.next;//link to next of next node when the next value equals the value to delete
		}
		else {
		tempDel=tempDel.next;//move by one place when value not found
		}
	}
	return dummy.next;
}

//This is the function to reverse elements between given left and right index from a Linked List.
//Input - Head of the Linked List, left index and right index to which to reverse the list between
//Output - The new head of the List
//Time Complexity - O(N) and Space Complexity - O(1)
static ListNode reverseBetween(ListNode head, int left, int right) {
	if(head == null || left == right) return head;
	ListNode dummy_head = new ListNode();
	ListNode left_prev,curr,prev,next_pointer;
	//prev - head of reversed sublist
	//curr - node after right(right+1)
	//left_prev - node BEFORE left
	//left_prev.next - original left node(now the tail of reversed section)
	dummy_head.next = head;
	left_prev = dummy_head;
	curr= head;
	for(int i=0; i<left-1;i++) {
		left_prev = curr;//left_prev points to the node before left
		curr = curr.next;//curr points to the node at left position
	}
	prev = null;
	//reverse list from left to right
	for(int i=0; i<right-left+1;i++) {//loop upto right
		next_pointer = curr.next;
		curr.next = prev;
		prev = curr;
		curr = next_pointer;
	}
	//reconnects reversed list
	left_prev.next.next = curr;//tail connects to the remainder
	left_prev.next = prev;//node before left connects to the new head of reversed list, prev
	return dummy_head.next;
}

//This is the function to check if a Linked List is palindrome.
//Input - Head of the Linked List
//Output - True if Palindrome, false otherwise
//Time Complexity - O(N) and Space Complexity - O(1)
static boolean isPalindrome(ListNode head) {
	ListNode slow=head, fast = head;
	//slow at middle, fast at end of the list
	while(fast!= null && fast.next!=null) {
		slow= slow.next;//moves 1 step
		fast = fast.next.next;//moves 2 steps
	}
	//reverse the second half of the list
	ListNode prev = null;
	while(slow!=null) {
		ListNode next_point = slow.next;
		slow.next = prev;
		prev = slow;
		slow = next_point;
	}
	//Compare the first and reversed second half
	ListNode left=head, right = prev;//prev is the head of the reversed list
	while(right!=null) {//only need to check the second half
		if(left.val != right.val) {
			return false;
		}
		left = left.next;
		right = right.next;
	}
	return true;
}

//This is the function to merge two sorted Linked Lists.
//Input - Heads of then both Linked Lists
//Output - The new head of the merged lists
//Time Complexity - O(N) and Space Complexity - O(1)
static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode curr = new ListNode();
    ListNode dummy = curr;
    while(list1!=null && list2!=null) {
    	//Compare the lists and add in the elements in curr list accordingly
    	if(list1.val<list2.val) {
    		curr.next = list1;
    		list1 = list1.next;
    	}else {
    		curr.next = list2;
    		list2 = list2.next;
    	}
    	curr = curr.next;
    }
    if(list1!=null || list2!=null) {
    	curr.next = (list1!=null)?list1 : list2;//enter all remaining elements from the lists
    }
    return dummy.next;
}

//This is the function to print elements from a Linked List.
//Input - Node from which to print the list
//Output - List Traversal through next pointer
//Time Complexity - O(N) and Space Complexity - O(1)
static void printLL(ListNode current) {
	while(current.next!=null) {
		System.out.print(current.val+"->");
		current=current.next;
	}System.out.print(current.val);
	System.out.println();
}

	public static void main(String[] args) {
		ListNode fourth = new ListNode(5);
		//extra nodes for palindrome check
//		ListNode sixth = new ListNode(4,seventh);
//		ListNode fifth = new ListNode(2,sixth);
//		ListNode zeroth = new ListNode(1,fifth);
//		ListNode seventh = new ListNode(5,zeroth);
		ListNode third = new ListNode(4,fourth);
		ListNode second = new ListNode(3,third);
		ListNode first = new ListNode(2,second);
		ListNode head = new ListNode(1,first);
		ListNode res = middleNode(head);
		printLL(head);
		System.out.println(res.val);
		System.out.println(hasCycle(head));
		head = reverseList(head);
		printLL(head);
		//Linked List indices start at 1 and not 0
		head = removeElements(head,3);
		printLL(head);
		head = reverseBetween(head,1,4);
		printLL(head);
		//Second Linked list
		ListNode third2 = new ListNode(8);
		ListNode second2 = new ListNode(6,third2);
		ListNode first2 = new ListNode(3,second2);
		ListNode head2 = new ListNode(0,first2);
		ListNode newHead = mergeTwoLists(head,head2);
		printLL(newHead);
		//Palindrome Check
		//System.out.println(isPalindrome(head));
		}

}
