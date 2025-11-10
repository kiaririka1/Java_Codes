/*
 * Title: Prim's Algorithm 
 * Description: The code finds the minimum spanning tree(MST) in a graph.
 * Author: Isha Shelke
 * Last Updated: October 2025
 */
//It uses greedy approach to find the minimum spanning tree. We start with any node and find the minimum spanning tree until n-1 edges are formed.
public class Prims_Algorithm {
	static int[] key = {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE};
	static boolean[] visited = {false,false,false,false};
	static int[][] MSTMatrix = {{0,2,3,6},
			{2,0,8,1},
			{3,8,0,15},
			{6,1,15,0}};
	static int cost = 0;
	static int minNumber() {
		int min = Integer.MAX_VALUE, minIndex = -1;
		for(int i=0; i<4;i++) {
			if(key[i]<min && visited[i]!=true){
				min=key[i]; //finds the minimum in a row
				minIndex = i;
			}
		}
		return minIndex;
	}
	
	static void primsMST(){
		key[0] =0; // start vertex is zero
		for(int c=0; c< 4;c++) {
			int u= minNumber();//finding minimum cost for one vertex
			visited[u] = true;
			cost+=key[u];
			for (int v = 0; v < 4; v++) {
                if (MSTMatrix[u][v] != 0 && !visited[v] && MSTMatrix[u][v] < key[v]) {
                    key[v] = MSTMatrix[u][v]; //finding the minimum edge
                }
            }
		}
		System.out.println(cost);
	}
	
	public static void main(String[] args) {
		primsMST();
	}
}