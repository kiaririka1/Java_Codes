/*
 * Title: Linked List Implementation In Java 
 * Description: The code includes Linked List operations like adding to Linked List, Traversal and deletion.
 * Author: Isha Shelke
 * Last Updated: October 2025
 */
//Node class is one fragment of linked list that takes value in constructor and has a next pointer to point to the next node in the linked list
class Node{
	int val;
	Node next;
	public Node(int val){
		this.val = val;
		this.next=null;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
}

public class Linked_List_DSA {
	//This function prints The Linked List from any given Node
	//Input - Head or any node to print the list from in the order of next in the Linked List.
	//Time Complexity - O(n) and Space Complexity - O(1)
	static void printLL(Node current) {
		while(current!=null){
			System.out.print(current.val+"->");
			current=current.next;
		}
		System.out.println();
	}
	
	//This function adds a Node to the head of the Linked List.
	//Input - Head Node and value of Node to be entered at the head of the Linked List.
	//Time Complexity - O(1) and Space Complexity - O(1)
	static Node addToHead(Node head, int val) {
		Node newNode = new Node(val);//make new node
		newNode.next = head; //point new node to head
		head = newNode;//make head the new node
		return head;
	}
	
	//This function adds a Node to the end of the Linked List.
	//Input - Head Node and value of Node to be entered at the end of the Linked List.
	//Time Complexity - O(n) and Space Complexity - O(1)
	//Time Complexity can be made O(1) if we store the tail Node.
	static void addToEnd(Node head, int val) {
		Node temp = head; // use a temp node to move through the Linked List
		while(temp.next!=null){
		temp = temp.next;
		}
		Node endNode = new Node(val);
		temp.next = endNode; //make last node point to new node
		endNode.next = null; //make new node the last node
	}
	
	//This function adds a Node to the head of the Linked List.
	//Input - Head Node,addAfter - Value of Node after which to add the node, NodeVal - value of Node to be added in the Linked List.
	//Time Complexity - O(n) and Space Complexity - O(1)
	static void addInBetween(Node head, int addAfter, int NodeVal) {
		Node temp = head;
		while(temp.next!=null) {
			if(temp.val == addAfter) {
				Node newNode1 = new Node(NodeVal);
				newNode1.setNext(temp.next);
				temp.next=newNode1;
				break;
			}
			temp=temp.next;
		}
	}
	
	//This function adds a Node to the head of the Linked List.
	//Input - Head Node,addBefore - Value of Node before which to add the node, NodeVal - value of Node to be added in the Linked List.
	//Time Complexity - O(n) and Space Complexity - O(1)
	static void addBeforePointer(Node head, int addBefore, int NodeVal) {
		Node temp = head;
		while(temp.next!=null){
			if(temp.next.val == addBefore){
				Node Node1 = new Node(NodeVal);
				Node1.setNext(temp.next);
				temp.next=Node1;
				break;
			}
			temp = temp.next;
		}
	}
	
	//This function adds a Node to the head of the Linked List.
	//Input - Head Node,NodeVal - value of Node to be deleted from the Linked List.
	//Time Complexity - O(n) and Space Complexity - O(1)
	static Node deleteNode(Node head, int NodeVal){
		if(head == null) {return null;}
		//if the node is at the head, Time Complexity - O(1)
		if(head.val == NodeVal) {
			return head.next;
		}
		Node temp = head;
		while(temp!=null && temp.next!=null) {
			if(temp.next.val == NodeVal) {
				temp.setNext(temp.next.next);
				break;
			}
			temp=temp.next;
		}
		return head;
	}
	
	public static void main(String[] args) {
		//Initialize the Linked List
		Node head = new Node(11);
		Node first = new Node(10);
		head.setNext(first);
		Node second = new Node(8);
		first.setNext(second);
		Node third = new Node(7);
		second.setNext(third);
		Node fourth = new Node(4);
		third.setNext(fourth);
		Node fifth = new Node(3);
		fourth.setNext(fifth);
		Node sixth = new Node(1);
		fifth.setNext(sixth);
		//Linked List traversal, pass the head node as input
		printLL(head);
		//add at head of LinkedList
		int val=24;
		head = addToHead(head,val);
		printLL(head);
		//addatEnd of LinkedList
		addToEnd(head,val);
		printLL(head);
		//addinBetween, after Node of value 10 and add Node of value 9
		addInBetween(head,10,9);
		printLL(head);
		//add when you only know the next pointer, assuming I know the node pointer to third
		addBeforePointer(head,7,6);
		printLL(head);
		//delete node
		head = deleteNode(head,24);
		printLL(head);
	}
}
