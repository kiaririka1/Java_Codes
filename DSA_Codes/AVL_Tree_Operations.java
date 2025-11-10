/*
 * Title: AVL Tree Implementation In Java 
 * Description: The code includes different ways to insert an element into a AVL tree and different types of rotations of AVL trees.
 * Author: Isha Shelke
 * Last Updated: October 2025
 */
//AVL Tree is like a Binary Search Tree but with each node having a difference in height of at most one.
//AVL trees are self-balancing binary search trees, named after Adelson-Velsky and Landis, that use rotation operations to maintain balance and minimum height.
class AVLNode{
	int data;
	AVLNode left,right;
	int height;
}

public class AVL_Tree_Operations {
	//This is the function to insert a Node into AVL Tree considering height of the tree for faster search.
	//Input - n is the root of the tree and data is the value of node to insert into the tree.
	static AVLNode insert(AVLNode n,int data){
		if(n==null) {
			return(createNode(data));
		}
		if(data < n.data) {
			n.left = insert(n.left,data);
		}
		else if(data > n.data) {
			n.right = insert(n.right,data);
		}
		else {
			return n;
		}
		
		//to find the first unbalanced node to balance after insertion of the node
		n.height = 1+ max(getHeight(n.left),getHeight(n.right));
		int bf = getBalanceFactor(n);
		
		//Left-Left Insertion Case 
		if(bf>1 && data<n.left.data) {
			return rightRotate(n);
		}
		//Right-Right Insertion Case
		if(bf<-1 && data>n.right.data) {
			return leftRotate(n);
		}

		//left-right insertion case
		if(bf>1 && data>n.left.data) {
			n.left = leftRotate(n.left);
			return rightRotate(n);
		}
		//right-left insertion case
			if(bf<-1 && data<n.right.data) {
				n.right = rightRotate(n.right);
				return leftRotate(n);
			}
		return n;
	}

	//returns the height of the Node
	static int getHeight(AVLNode n) {
		 if(n==null) {
			 return 0;
		 }
		 else{return n.height;}
	 }
	 
	//This is the function for creation of the Node with given value
	 static AVLNode createNode(int value) {
		 AVLNode newNode = new AVLNode();
		 newNode.data=value;
		 newNode.left=null;
		 newNode.right=null;
		 newNode.height=1;
		 return newNode;
	 }
	 
	 //The balance factor in an AVL tree is the difference between the height of a node's left subtree and the height of its right subtree. 
	 //For an AVL tree to be considered balanced, the balance factor of every node must be -1, 0 or 1.  
	static int getBalanceFactor(AVLNode n) {
		 if(n==null) {
			 return 0;
		 }
		 else { return getHeight(n.left) - getHeight(n.right);}
	 }

	//This is a function to just return the maximum between two numbers
	 static int max(int a, int b) {
		 return (a>b)?a:b;
	 }
	 
	//Following are the functions for left and right rotate respectively and they take the unbalanced node as input.
	static AVLNode rightRotate(AVLNode y) {
		 AVLNode x = y.left;
		 AVLNode T2 = x.right;
		 
		 x.right=y;
		 y.left=T2;
		 
		 y.height = max(getHeight(y.right),getHeight(y.left)) +1;
		 x.height = max(getHeight(x.right),getHeight(x.left)) +1;
		 
		 return x; // because now x is the root
	 }
	 
	static AVLNode leftRotate(AVLNode x) {
		 AVLNode y = x.right;
		 AVLNode T2= y.left;
		 
		 x.right=T2;
		 y.left=x;
		 
		 y.height = max(getHeight(y.right),getHeight(y.left)) +1;
		 x.height = max(getHeight(x.right),getHeight(x.left)) +1;
		 
		 return y; // because now y is the root
	 }

	//Gives the in-order traversal of the tree. The working is same as Binary Tree traversal.
	static void inOrder(AVLNode root) {
	 if(root!=null) {
	 inOrder(root.left);
	 System.out.print(root.data + " ");
	 inOrder(root.right);}
	 }
	 
	//Gives the pre-order traversal of the tree. It is also the sorted order.
	 static void preOrder(AVLNode root){
		 if(root!=null) {
		 System.out.print(root.data + " ");
		 preOrder(root.left);
		 preOrder(root.right);
		 }
	 }
	 
 	public static void main(String[] args) {
		//Initialize the AVL tree
 		AVLNode root = createNode(45);
 		root = insert(root, 4);
 		root = insert(root, 5);
 		root = insert(root, 8);
 		root = insert(root, 9);
 		inOrder(root);
 		System.out.println();
 		preOrder(root);
	}
}
