/*
 * Title: Dijkstra's Algorithm Simple Version in Java
 * Description: The code finds the shortest path from one vertex to another.
 * Author: Isha Shelke
 * Last Updated: October 2025
 */
import java.util.Arrays;
public class Dijkstras_Simple {
	static void Dijkstras(int src, int n, int[][] edges){ //src - start vertex, n = number of vertices, edges - adjacent matrix with weights
		int[] dist = new int[n]; // holds the shortest distance so far
		boolean[] visited = new boolean[n]; // determines whether a vertex is visited or not
		int[] parent = new int[n]; //holds previous visited vertex to calculate shortest path
	Arrays.fill(dist,Integer.MAX_VALUE);
	Arrays.fill(visited,false);
	Arrays.fill(parent,-1);
	
	dist[src] = 0;
	
	for(int i=0; i< n-1;i++) {
		//picking an unvisited vertex, finding the minimum distance, marking it as visited
		int u = minDistance(dist, visited, n);
		visited[u] = true;
		
		//updating neighboring distances
		for (int v = 0; v < n; v++) {
			if(!visited[v] && edges[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + edges[u][v] < dist[v]) {
				dist[v] = dist[u] + edges[u][v];
				parent[v] = u;
			}
		}
	}
	
    for (int i = 0; i < n; i++) {
        System.out.print("Shortest distances from node " + src + " To " + i + " -> " + dist[i] + " | Path: ");
        printPath(parent, i);
        System.out.println();
    }
	}
	
	//returns the minimum distance
	static int minDistance(int[] dist, boolean[] visited, int n) {
		int min = Integer.MAX_VALUE, minIndex=-1;
		for (int v = 0; v < n; v++) {
            if (!visited[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
	}
	
	//Prints the path of the shortest distance
	static void printPath(int[] parent, int j) {
		if (j == -1) return;
        printPath(parent, parent[j]);
        System.out.print(j + " ");
	}
	
	public static void main(String[] args) {
		int n = 5;
		int[][] edges = {{0,4,8,0,0},
				{4,0,0,0,6},
				{8,0,0,2,0},
				{0,0,2,0,10},
				{0,6,0,10,0}};
		Dijkstras(1,n,edges);
	}

}
