/*
 * Title: Binary Tree Questions in Leetcode with solutions
 * Description: The code includes various binary tree problems like level order traversals, min and max depth.
 * Author: Isha Shelke
 * Last Updated: November 2025
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Default treeNode class with left and right nodes
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
 }

public class leetcode_Binary_Tree {
	//This is the function for level order traversal of a binary tree.
	//Input - Root of the tree
	//Output - Nodes on each level in form of a list
	//Time Complexity - O(N) and Space Complexity - O(N)
	 static List<List<Integer>> levelOrder(TreeNode root) {
		 List<List<Integer>> res = new ArrayList<>();
		 if (root == null) return res;//handling the null tree condition

		 Queue<TreeNode> queue = new LinkedList<>();//make a queue to add each element of a level
		 queue.add(root);//start with root
		 
		 while (!queue.isEmpty()) {
		        int levelSize = queue.size(); 
		        List<Integer> level = new ArrayList<>();//list according to the number of elements in a level
		        for (int i = 0; i < levelSize; i++) {
		            TreeNode node = queue.poll();//remove from queue
		            level.add(node.val); //add to list             

		            //add left and right nodes if present to the queue
		            if (node.left != null) queue.add(node.left);
		            if (node.right != null) queue.add(node.right);
		        }
		        res.add(level); //write addFirst for reverse level order traversal
		 }
		 return res;
	    }
	 
	//This is the function for average of levels of a binary tree.
	//Input - Root of the tree
	//Output - Average of each level in form of a list
	//Time Complexity - O(N) and Space Complexity - O(N)
	 static List<Double> averageOfLevels(TreeNode root) {
		 List<Double> res = new ArrayList<>();
		 if (root == null) return res;//handling the null tree condition, this is always important

		 Queue<TreeNode> queue = new LinkedList<>();//make a queue to add each element of a level
		 queue.add(root);//start with root
		 
		 while (!queue.isEmpty()) {
		        int levelSize = queue.size(); 
		        double sum = 0.00000;//variable to add each element of a level
		        for (int i = 0; i < levelSize; i++) {
		            TreeNode node = queue.poll();//remove from queue
		            sum += node.val; //sum of all nodes in one level             

		          //add left and right nodes if present to the queue
		            if (node.left != null) queue.add(node.left);
		            if (node.right != null) queue.add(node.right);
		        }
		        double avg = sum/levelSize;//get an average for each level
		        res.add(avg);//add to list
		 }
		 return res;
	 }
	 
	//This is the function to find the minimum depth of a binary tree.
	//Input - Root of the tree
	//Output - Minimum depth of the given tree
	//Time Complexity - O(N) and Space Complexity - O(N)
	 static int minDepth(TreeNode root) {
	 if (root == null) return 0;//handling the null tree condition
	 int min = 1;//consider 1 if only root is present
	 Queue<TreeNode> queue = new LinkedList<>();//make a queue to add each element of a level
	 queue.add(root);//start with root
	 
	 while(!queue.isEmpty()) {
	int levelSize = queue.size(); 
	 for (int i = 0; i < levelSize; i++) {
	 TreeNode node = queue.poll();//remove from queue          
	 if(node.left == null && node.right == null) {return min;}//return on last level or no more children present
	//add left and right nodes if present to the queue
	 if (node.left != null)queue.add(node.left);
	 if (node.right != null)queue.add(node.right);
	 }
	 min++;//increment on finishing a level which is not the last one
	 }
	 return min;
	 }
	 
	//This is the function to find the maximum depth of a binary tree.
	//Input - Root of the tree
	//Output - Maximum depth of the given tree
	//Time Complexity - O(N) and Space Complexity - O(N)
	 static int maxDepth(TreeNode root) {
		 if (root == null) return 0;//handling the null tree condition
		 int max = 0;
		 Queue<TreeNode> queue = new LinkedList<>();//make a queue to add each element of a level
		 queue.add(root);//start with root
		 
		 while(!queue.isEmpty()) {
		int levelSize = queue.size(); 
		 for (int i = 0; i < levelSize; i++) {
		 TreeNode node = queue.poll();//remove from queue 
		//add left and right nodes if present to the queue
		 if (node.left != null)queue.add(node.left);
		 if (node.right != null)queue.add(node.right);
		 }
		 max++;
		 }
		 return max;
	    }
	 
	 //This is the Faster Recursive maximum depth of tree solution
	 //Time Complexity - O(N) and Space Complexity - O(h) where h is the height of the tree
	 //It can be O(log N) in best case and O(N) in worst
//	 static int maxDepth(TreeNode root) {
//	        if(root == null) return 0;//handling the null tree condition
//	 		//recursive calls on left and right nodes till last node is reached
//	        int left = maxDepth(root.left);
//	        int right = maxDepth(root.right);
//	        return 1 + Math.max(left,right);
//	    }
	 
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
	    root.left = new TreeNode(9);
	    root.right = new TreeNode(20);
	    root.right.left = new TreeNode(15);
	    root.right.right = new TreeNode(7);

	    List<List<Integer>> res = levelOrder(root);
	    System.out.println(res);
	    
	    List<Double> avg = averageOfLevels(root);
	    System.out.println(avg);
	    
	    System.out.println(minDepth(root));
	    System.out.println(maxDepth(root));
	}
}
