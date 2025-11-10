/*
 * Title: Circular Linked List Implementation In Java 
 * Description: The code includes Circular Linked List operations like adding and deleting Nodes and printing the List.
 * Author: Isha Shelke
 * Last Updated: October 2025
 */
//In Circular Linked List, make the last Node point to head. The rest is same as Linked List implementation.
class CircularNode{
	int val;
	CircularNode next;
	public CircularNode(int val){
		this.val = val;
		this.next=null;
	}
	public CircularNode getNext() {
		return next;
	}
	public void setNext(CircularNode next) {
		this.next = next;
	}
}

public class Circular_LL {
	//This function is to print all the elements in the list until we come across the head again.
	//Time complexity - O(n) and Space Complexity - O(1)
	static void printLL(CircularNode head) {
		CircularNode current=head;
		do {
			System.out.print(current.val+"->");
			current=current.next;
		}while(current!=head);
		System.out.println();
		}
	
	//This function is to get the end node of the list. This function is needed to update the endNode at every other function call.
	//Time Complexity - O(n) and Space Complexity - O(1)
	static CircularNode getEndNode(CircularNode head) {
		CircularNode temp = head;
		while(temp.next!=head) {
			temp=temp.next;
		}
		return temp;
	}
	
	//This function is to get the size of the list.
	//Time complexity - O(n) and Space Complexity - O(1)
	static int getLength(CircularNode head) {
		int len=1;
		CircularNode temp2 = head;
		do{
			temp2=temp2.next;
			len++;
		}while(temp2.next!=head);
		return len;
	}
	
	//This function is to add at the head of the list.
	//Time complexity - O(1) and Space Complexity - O(1)
	static CircularNode addAtHead(CircularNode head, int val) {
		CircularNode newNode = new CircularNode(val);
		newNode.next = head;
		CircularNode updateEnd = getEndNode(head);
		updateEnd.next=newNode;
		head=newNode;
		return head;
	}
	
	//This function is to add at the end of the list.
	//Time complexity - O(1) and Space Complexity - O(1)
	static CircularNode addAtEnd(CircularNode head, int val) {
	CircularNode endNode = new CircularNode(val);
	CircularNode temp = getEndNode(head);
	temp.next = endNode;
	endNode.next = head;
	return head;
	}
	
	//This function is to add val Node after the given value in the list.
	//Time complexity - O(1) and Space Complexity - O(1)
	static CircularNode addAfter(CircularNode head,int addAfter, int val) {
		CircularNode temp = head;
		while(temp.next!=head) {
			if(temp.val == addAfter) {
				CircularNode newNode = new CircularNode(val);
				newNode.setNext(temp.next);
				temp.next=newNode;
				break;
			}
			temp=temp.next;
		}
		return head;
	}
	
	//This function is to add val Node before the given value in the list.
	//Time complexity - O(1) and Space Complexity - O(1)
	static CircularNode addBefore(CircularNode head,int addBefore, int val) {
		CircularNode temp = head;
		while(temp.next!=head){
			if(temp.next.val == addBefore){
				CircularNode Node = new CircularNode(val);
				Node.setNext(temp.next);
				temp.next=Node;
				break;
			}
			temp = temp.next;
		}
		return head;
	}
	
	//This function is to delete the given value in the list.
	//Time complexity - O(n) and Space Complexity - O(1)
	static CircularNode deleteNode(CircularNode head, int val) {
		if(head == null) {return null;}
		//if the node is at the head, Time Complexity - O(1)
		if(head.val == val) {
			CircularNode last = head;
		    while(last.next != head){
		        last = last.next;
		    }
		    last.next = head.next; // make sure to change last node to the next of head
			return head.next;
		}
		CircularNode temp = head;
		while(temp.next!=head) {
			if(temp.next.val == val) {
				temp.setNext(temp.next.next);
				break;
			}
			temp = temp.next;
		}
		return head;
	}
	
	public static void main(String[] args) {
		//Initialize the Circular Linked List
		CircularNode head = new CircularNode(11);
		CircularNode first = new CircularNode(10);
		head.setNext(first);
		CircularNode second = new CircularNode(8);
		first.setNext(second);
		CircularNode third = new CircularNode(7);
		second.setNext(third);
		CircularNode fourth = new CircularNode(4);
		third.setNext(fourth);
		CircularNode fifth = new CircularNode(3);
		fourth.setNext(fifth);
		CircularNode sixth = new CircularNode(1);
		fifth.setNext(sixth);
		//make the last node point to head
		sixth.setNext(head);
		//Linked List traversal, pass the head node as input
		printLL(head);
		//add at head of LinkedList
		head = addAtHead(head,23);
		printLL(head);
		//addatEnd of LinkedList
		head = addAtEnd(head,40);
		printLL(head);
		//addinBetween, after 10
		head = addAfter(head,10,12);
		printLL(head);
		//add before number 7
		head = addBefore(head,7,6);
		printLL(head);
		//delete node
		head = deleteNode(head,23);
		printLL(head);
		System.out.println(getLength(head));
	}
}
