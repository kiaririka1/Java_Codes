/*
 * Title: Binary Tree Implementation In Java 
 * Description: The code includes different ways to traverse a binary tree and check if it is BST and deletion of a node in BST.
 * Author: Isha Shelke
 * Last Updated: October 2025
 */
// Binary tree node structure includes a left and right pointers to child Nodes and a data to hold value.
class BTNode{
	BTNode right,left;
	int data;
	BTNode(int data){
		this.data = data;
		this.right=null;
		this.left = null;
	}
}

public class Binary_Tree {
	static BTNode prev=null;
//This code is for all different types of traversals of a binary tree - PreOrder, InOrder and PreOrder.
//Input - It takes the root of the Binary Tree as input.
//Time Complexity - O(N) and Space complexity - O(N).
 static void preOrder(BTNode root){
	 if(root!=null) {
	 System.out.print(root.data + " ");
	 preOrder(root.left);
	 preOrder(root.right);
	 }
 }
 static void inOrder(BTNode root) {
	 if(root!=null) {
	 inOrder(root.left);
	 System.out.print(root.data + " ");
	 inOrder(root.right);}
 }
 static void postOrder(BTNode root) {
	 if(root!=null) {
	 postOrder(root.left);
	 postOrder(root.right);
	 System.out.print(root.data + " ");
	 }
 }

 //This code is to Check if the given Binary Tree is a Binary Search Tree.
 //Input - It takes the root of the Binary Tree as Input.
 //Time Complexity - O(log n) for a balanced tree and O(n) in worst case or a skewed tree. 
 //Space complexity - O(N)
 static boolean isBST(BTNode root) {
	 //First check if root is null. We have already established prev as a null node.
		 if(root!=null){
			 if(!isBST(root.left)) {
				 return false;
			 }
			 //if the data at right is less than the root data, it will return false otherwise it keeps going right to check even in the left subtree.
			 if(prev!=null && root.data<=prev.data){
				 return false;
			 }
			 //The code first comes here and prev becomes root and then goes to the right of root.
			 prev=root;
			 return isBST(root.right);
		 }else {
			 return true;
		 }
 }
 
 //Searching in BST with a search key.
 //Input - Root of the tree and the key to search.
 //Time Complexity - O(N) worst case for a skewed tree, O(log n) for a balanced one.
 //Space Complexity - O(N) in worst Case.
 static void searchBST(BTNode root,int key) {
	 if(root!=null){
		 if(key == root.data) {
			 System.out.println("Key found in BST");
		 }
		 if(key < root.data) {
			 searchBST(root.left,key);
		 }
		 if(key > root.data) {
			 searchBST(root.right,key);
		 }
	 }else {
		 System.out.println("Key not found");
	 }
 }
 
 //Inserting into a BST.
//Input - Root of the tree and the key to insert into the tree.
//Time Complexity - O(N) worst case for a skewed tree, O(log n) for a balanced one.
//Space Complexity - O(N) in worst Case.
 static void insertBST(BTNode root,BTNode key) {
	 while(root!=null){
		 //set prev as root to traverse the tree
		 prev =root;
		 //Makes sure no same data is entered into the tree
		 if(key.data == root.data){
			 System.out.println("Key already exists");
		 }
		 else if(key.data < root.data) {
			 root = root.left;
		 }else {root = root.right;}
	 }
	 //set as Node in the BST
	 if(key.data<prev.data) {
		 prev.left=key;
	 }else {
		 prev.right=key;
	 }
 }
 
 //This function is to find the inorder predecessor of a Node.
 //Input - Root of the BST
 //Time Complexity - O(N) worst case for a skewed tree, O(log n) for a balanced one.
//Space Complexity - O(1)
 static BTNode inOrderPre(BTNode root) {
	 root = root.left;
	 while(root.right!=null) {
		 root=root.right;
	 }
	 return root;
 }
 
//code for in-order successor just in case
//Input - Root of the BST
//Time Complexity - O(N) worst case for a skewed tree, O(log n) for a balanced one.
//Space Complexity - O(1)
static BTNode inOrderSuccessor(BTNode root){
	    root = root.right;
	    while (root.left != null) {
	        root = root.left;
	    }
	    return root;
	}

//In this function, we first find the Node to be deleted by a key and then deleting it and replacing it with either the Inorder Predecessor or the inorder successor. 
//Input - Root of the BST and The key of Node to be deleted
//Time Complexity - O(N) worst case for a skewed tree, O(log n) for a balanced one.
//Space Complexity - O(N) in the worst case and O(log n) for a balanced tree.
static BTNode deleteBST(BTNode root, int key) {
	 if(root == null) {
		 return null;
	 }
	 //Only root in the tree condition
	 if(root.left == null && root.right == null) {
		 root = null;
		 return root;
	 }
	 if(key < root.data) {
		 root.left = deleteBST(root.left,key);
	 }else if(key > root.data){
		 root.right = deleteBST(root.right,key);
	 }else {
		 BTNode inPre = inOrderPre(root);
		 root.data = inPre.data;
		 root.left = deleteBST(root.left, inPre.data);
	 }
	 return root;
 }
 
	public static void main(String[] args) {
		//Binary tree example
//		BTNode root = new BTNode(1);
//		BTNode first = new BTNode(7);
//		BTNode second = new BTNode(9);
//		root.left=first;
//		root.right=second;
//		BTNode third = new BTNode(2);
//		BTNode fourth = new BTNode(6);
//		first.left=third;
//		first.right=fourth;
//		BTNode fifth = new BTNode(5);
//		BTNode sixth = new BTNode(11);
//		fourth.left = fifth;
//		fourth.right = sixth;
//		BTNode seventh = new BTNode(9);
//		second.right=seventh;
//		BTNode eighth = new BTNode(5);
//		seventh.left=eighth;
//		preOrder(root);
//		System.out.println();
//		inOrder(root);
//		System.out.println();
//		postOrder(root);
//		System.out.println();
		//BST checking code and BST tree made
		BTNode root = new BTNode(8);
		BTNode first = new BTNode(3);
		BTNode second = new BTNode(10);
		root.left=first;
		root.right=second;
		BTNode third = new BTNode(1);
		BTNode fourth = new BTNode(6);
		first.left=third;
		first.right=fourth;
		BTNode fifth = new BTNode(4);
		fourth.left = fifth;
		BTNode key = new BTNode(7);
		boolean BSTorNo = isBST(root);
		if(BSTorNo) {
			System.out.println("The given tree is a BST");
		}else {
			System.out.println("The given tree is not a BST");
		}
		//searching a key in BST
		//searchBST(root,7);
		//insertion in BST
//		insertBST(root,key);
//		inOrder(root);
//		deleteBST(root,8);
//		System.out.println(root.data);
//		inOrder(root);
	}
}
