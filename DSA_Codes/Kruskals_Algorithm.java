/*
 * Title: Kruskal's Algorithm 
 * Description: The code uses Disjoint Set Union(DSU) to find the minimum spanning trees in a graph.
 * Author: Isha Shelke
 * Last Updated: October 2025
 */
//We basically sort edges and find the minimum cost edges and place them in the increasing order. We start with the smallest and mark it visited.
//Then, we continues adding the minimum cost edges in such a way that including that edge doesn't form a cycle or a closed figure
import java.util.Arrays;
import java.util.Comparator;

class DSU{
	//In DSU, we store the parent and ranks for each edge. Parent is the root of that connected edges' group and rank is the approximate height (or sometimes size) of the tree whose root is i.
	int[] Parent,rank;
	DSU(int n){
		Parent = new int[n];
		rank = new int[n];
		for(int i=0; i<n; i++) {
			Parent[i] = i;
			rank[i] = 1;
		}
	}
	
	//all connected edges have the same parent in find.
	int find(int x) {
		if(Parent[x]!=x) {
			Parent[x] = find(Parent[x]);
		}
		return Parent[x];
	}
	
	//Attach smaller tree under larger tree to keep depth minimal
	void union(int x, int y) {
        int s1 = find(x);
        int s2 = find(y);
        if (s1 != s2) {
            if (rank[s1] < rank[s2]) {
                Parent[s1] = s2;
            } else if (rank[s1] > rank[s2]) {
                Parent[s2] = s1;
            } else {
                Parent[s2] = s1;
                rank[s1]++;
            }
        }
	}
}

public class Kruskals_Algorithm {

	//Time Complexity - O(E log E + E α(V)) ≈ O(E log E) and Space Complexity - O(V + E)
	static int Kruskal_Algo(int n, int[][] edges) {
		//first sort edges by distance between them
		Arrays.sort(edges, Comparator.comparingInt(e -> e[2]));
		
		DSU d = new DSU(n);
		int cost=0, count =0;
		for(int[] e : edges) {
			int x = e[0], y = e[1], w=e[2];
			// For each edge (x, y, w):
			// If x and y belong to different sets (no cycle), include this edge in MST.
			// Merge their sets using union().
			// Stop once we have (V - 1) edges in the MST.
			if(d.find(x)!= d.find(y)) {
				d.union(x, y);
				cost +=w;
				if(++count == n-1) {
					break;
				}
			}
		}
		return cost;
	}
	public static void main(String[] args) {
		int[][] MSTMatrix = {{0,1,2},
				{1,2,8},
				{2,3,15},
				{0,3,6},
				{0,2,3},
				{1,3,1}};
		System.out.println(Kruskal_Algo(4,MSTMatrix));
	}

}
