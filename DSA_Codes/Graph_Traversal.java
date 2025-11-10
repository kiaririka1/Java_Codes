/*
 * Title: Graph Traversal in Java
 * Description: The code shows two types of graph traversal - BFS and DFS.
 * Author: Isha Shelke
 * Last Updated: October 2025
 */
//Graph Traversal refers to the process of visiting each vertex in a graph
public class Graph_Traversal {
	static int[][] graphMatrix = {
			{0,1,1,0,0},
			{1,0,1,1,0},
			{1,1,0,0,1},
			{0,1,0,0,0},
			{0,0,1,0,1}
	};
	static int[] visited = {0,0,0,0,0};

	//In Breadth First Search, we start at and vertex and explore its connected nodes. The same process is repeated with all the connecting nodes until all nodes are visited
	//We can have multiple results for one graph and order of visiting can be anything.
	//Input - Any vertex in the graph to start
	//Time Complexity - O(V^2) and Space Complexity - O(V)
	static void BFS(int startVertex) {
		// We use a Linked List queue for this operation.
		queue_by_LL q = new queue_by_LL();
		System.out.println(startVertex);
		q.enqueue(startVertex);
		visited[startVertex]=1;
		while(!q.isEmpty()){
			int node = q.deque();//deque a vertex and check all its neighbors
			for(int j=0;j<5;j++) {
			if(graphMatrix[node][j]==1 && visited[j]==0) {
				System.out.println(j);
				visited[j]=1;
				q.enqueue(j);//add all unvisited neighbors to the queue
			}
		}
	}
	}
	
	// Depth-First Search (DFS) traversal of a graph using recursion
	// DFS explores as far as possible along each branch before backtracking
	//Input - Any start vertex from the graph
	// Time Complexity - O(V^2) and Space Complexity - O(V)
	static void DFS(int startNode) {
		System.out.println(startNode);
		visited[startNode] = 1;
		for(int j=0;j<5;j++) {
			if(graphMatrix[startNode][j]==1 && visited[j] == 0) {
				DFS(j);			
			}
		}
	}
	
	public static void main(String[] args) {
		BFS(2);
		//DFS(2);
	}

}
