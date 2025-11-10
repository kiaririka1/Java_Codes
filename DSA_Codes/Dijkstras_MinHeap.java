/*
 * Title: Dijkstra's Algorithm using Adjacency List in Java
 * Description: The code uses MinHeap/Priority queue to find the shortest paths to every other edge from a given edge.
 * Author: Isha Shelke
 * Last Updated: October 2025
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Dijkstras_MinHeap {

	//Input - src - start vertex, n - number of edged in the graph, adjList - adjacency list representation of the graph
	static void minHeapDijkstras(int src,int n, List<List<int[]>> adjList){
		int[] dist = new int[n];
		//Initialize distances
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[src] = 0; 
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));//this always gives you the smallest distance first
		pq.add(new int[]{0, src});//adding first to its own vertex and distance
		
		while(!pq.isEmpty()) {
			int[] current = pq.poll();//removes the node with the current smallest distance
			int d = current[0], u=current[1];
		if( d > dist[u]) {
			continue; //skipping outdated or bigger distances
		}
		for(int[] edge : adjList.get(u)) // accessing neighbors of u
		{
			int v = edge[0], w = edge[1];
			if(dist[u] + w < dist[v]) {
				dist[v] = dist[u] + w;
				pq.add(new int[]{dist[v], v});
			}
		}
		}
		 System.out.println("Shortest distances from node " + src + ":");
	        for (int i = 0; i < n; i++) {
	            System.out.println("To " + i + " -> " + dist[i]);
	        }
	}
	
	public static void main(String[] args) {
		//For every node u adjList.get(u) gives a list of neighbors, 
		//and each neighbor is stored as an int[] {v, w} → v = neighbor vertex, w = weight.
		List<List<int[]>> adj = new ArrayList<>();
		for (int i = 0; i < 5; i++) adj.add(new ArrayList<>());

		adj.get(0).add(new int[]{1, 4});
		adj.get(0).add(new int[]{2, 8});

		adj.get(1).add(new int[]{0, 4});
		adj.get(1).add(new int[]{4, 6});

		adj.get(2).add(new int[]{0, 8});
		adj.get(2).add(new int[]{3, 2});

		adj.get(3).add(new int[]{2, 2});
		adj.get(3).add(new int[]{4, 10});

		adj.get(4).add(new int[]{1, 6});
		adj.get(4).add(new int[]{3, 10});
		
		minHeapDijkstras(1,5,adj);
	}

}
