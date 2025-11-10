/*
 * Title: Doubly Linked List Implementation In Java 
 * Description: The code includes different Doubly Linked List operations like setting next and previous and addition and deletion from the List.
 * Author: Isha Shelke
 * Last Updated: October 2025
 */
//In Doubly Linked List, each node is linked to a previous and a next node and it has a value to it.
//Like Linked List, it has expandable memory to accommodate the increasing number of entries like needed.
class DLLNode{
	int val;
	DLLNode next,prev;
	public DLLNode(int val){
		this.val = val;
		this.next=null;
		this.prev=null;
	}
	public DLLNode getNext() {
		return next;
	}
	public void setNext(DLLNode next) {
		this.next = next;
	}
	public DLLNode getPrev() {
		return prev;
	}
	public void setPrev(DLLNode prev) {
		this.prev = prev;
	}
}

public class Doubly_Linked_List {
	//This function prints the values in a Doubly linked list.
	//Input - Head of the DLL.
	//Time Complexity - O(N) and Space Complexity - O(1).
	static void printLL(DLLNode head) {
	    if (head == null) {
	        System.out.println("List is empty.");
	        return;
	    }
	    DLLNode current = head;
	    while (current != null) {
	        System.out.print("<-" + current.val + "-> ");
	        current = current.next;
	    }
	    System.out.println();
	}

	//This function prints the values in a Doubly linked list.
	//Input - Head of the DLL.
	//Time Complexity - O(N) and Space Complexity - O(1).
	static DLLNode getEnd(DLLNode head) {
		DLLNode temp = head;
		while(temp.next!=null) {
			temp=temp.next;
		}
		return temp;
	}

	//This function adds the given value at the head of a Doubly linked list.
	//Input - Head of the DLL and value of the node to be added.
	//Time Complexity - O(1) and Space Complexity - O(1).
	static DLLNode addAtHead(DLLNode head, int value) {
		DLLNode newNode = new DLLNode(value);
		newNode.prev = null;
		newNode.next = head;
		head.prev = newNode;
		head=newNode;
		return head;
	}
	
	//This function adds the given value at the end of a Doubly linked list.
	//Input - Head of the DLL and value to be added.
	//Time Complexity - O(1) and Space Complexity - O(1).
	static DLLNode addAtEnd(DLLNode head, int value) {
		DLLNode endNode = new DLLNode(value);
		DLLNode tempEndNode = getEnd(head);
		tempEndNode.setNext(endNode);
		endNode.setPrev(tempEndNode);
		endNode.next = null;
		return head;
	}
	
	//This function adds the given value at the position after a value(addAfter) of a Doubly linked list.
	//Input - Head of the DLL, value to add the node After and value of the node to be added.
	//Time Complexity - O(N) and Space Complexity - O(1).
	static DLLNode addAfter(DLLNode head,int addAfter,int value) {
		DLLNode temp = head;
		while(temp!=null) {
			if(temp.val == addAfter) {
				DLLNode newNode = new DLLNode(value);
				newNode.setNext(temp.next);
				newNode.setPrev(temp);
				if (temp.prev != null) {
					temp.next.prev = newNode;
	            } else {
	                head = newNode; // to add at the head
	            }
	            temp.next = newNode;
				break;
			}
			temp=temp.next;
		}
		return head;
	}
	
	//This function adds the given value at the position before a value(addBefore) of a Doubly linked list.
	//Input - Head of the DLL, value to add the node before and value of the node to be added.
	//Time Complexity - O(N) and Space Complexity - O(1).
	static DLLNode addBefore(DLLNode head,int addBefore,int value) {
		DLLNode temp = head;
		while(temp!=null) {
			if(temp.val == addBefore) {
				DLLNode newNode = new DLLNode(value);
				newNode.setNext(temp);
				newNode.setPrev(temp.prev);
				if (temp.prev != null) {
	                temp.prev.next = newNode;
	            } else {
	                head = newNode; // to add at the head and Time Complexity becomes - O(1)
	            }
	            temp.prev = newNode;
				break;
			}
			temp=temp.next;
		}
		return head;
	}
	
	//This function deletes the given value in a Doubly linked list.
	//Input - Head of the DLL and value of the node to be deleted.
	//Time Complexity - O(N) and Space Complexity - O(1).
	static DLLNode deleteNode(DLLNode head, int value) {
		if(head == null) {return null;}
		//if the node is at the head, Time Complexity - O(1)
		if(head.val == value) {
			return head.next;
		}
		DLLNode temp = head;
		while(temp!=null && temp.next!=null ) {
			if(temp.next.val == value) {
				temp.setNext(temp.next.next);
				break;
			}
			temp=temp.next;
		}
		return head;
	}
	
	public static void main(String[] args) {
		//Initialize the Doubly linked list and set prev and next for each node
		DLLNode head = new DLLNode(11);
		DLLNode first = new DLLNode(10);
		head.setPrev(null);
		head.setNext(first);
		DLLNode second = new DLLNode(8);
		first.setPrev(head);
		first.setNext(second);
		DLLNode third = new DLLNode(7);
		second.setPrev(first);
		second.setNext(third);
		DLLNode fourth = new DLLNode(4);
		third.setPrev(second);
		third.setNext(fourth);
		DLLNode fifth = new DLLNode(3);
		fourth.setPrev(third);
		fourth.setNext(fifth);
		DLLNode sixth = new DLLNode(1);
		fifth.setPrev(fourth);
		fifth.setNext(sixth);
		sixth.setPrev(fifth);
		//Linked List traversal, pass the head node as input
		printLL(head);
		//add at head of LinkedList
		head = addAtHead(head,24);
		printLL(head);
		//addatEnd of LinkedList
		head = addAtEnd(head,34);
		printLL(head);
		//addinBetween, after 10
		head = addAfter(head, 10, 13);
		printLL(head);
		//add when you only know the next pointer, adding element before
		head = addBefore(head, 4, 6);
		printLL(head);
		//delete node
		head = deleteNode(head,24);
		printLL(head);
	}
}
