/*

Given an undirected, connected and weighted graph G(V, E) with V number of vertices (which are numbered from 0 to V-1) and E number of edges.
Find and print the Minimum Spanning Tree (MST) using Prim's algorithm.
For printing MST follow the steps -
1. In one line, print an edge which is part of MST in the format - 
v1 v2 w
where, v1 and v2 are the vertices of the edge which is included in MST and whose weight is w. And v1  <= v2 i.e. print the smaller vertex first while printing an edge.
2. Print V-1 edges in above format in different lines.
Note : Order of different edges doesn't matter.
Input Format :
Line 1: Two Integers V and E (separated by space)
Next E lines : Three integers ei, ej and wi, denoting that there exists an edge between vertex ei and vertex ej with weight wi (separated by space)
Output Format :
Print the MST, as described in the task.
Constraints :
2 <= V, E <= 10^5
1 <= Wi <= 10^5
Time Limit: 1 sec
Sample Input 1 :
4 4
0 1 3
0 3 5
1 2 1
2 3 8
Sample Output 1 :
0 1 3
1 2 1
0 3 5

*/

import java.io.*;

// O(V^2) time.. optimize further.. watch video for hints   
public class Prim {

    public static void main(String[] args) throws IOException {
        int[][] adj_matrix = takeInput();
        findMSTprim(adj_matrix);
    }

    private static void findMSTprim(int[][] adj_matrix) {
        int v = adj_matrix.length;
        int[] parent = new int[v]; // store parent of ith index having minimum edge weight
        boolean[] visited = new boolean[v];
        int[] weight = new int[v];  // weight of vertex and parent
        weight[0] = 0;
        for(int i=1; i<v; i++) weight[i] = Integer.MAX_VALUE;   // setting infinity to all indices >1

        // start the algorithm
        for(int i=0; i<v; i++){
            // find minimum vertex
            int min_vertex = findMinVertex(weight, visited);
            visited[min_vertex] = true;

            // explore its unvisited neighbors
            for(int j=0; j<v; j++){
                int curr_weight = adj_matrix[min_vertex][j];
                if(curr_weight > 0 && !visited[j] && curr_weight < weight[j]){
                    weight[j] = curr_weight;
                    parent[j] = min_vertex;
                }
            }
        }
        print(parent, weight);
    }

   private static void print(int[] parent, int[] weight) {
       // Print edges of MST
       int v = parent.length;
		for(int i = 1; i < v; i++){
			int min = Math.min(i, parent[i]);
            int max = Math.max(i, parent[i]);
            System.out.println(min + " " + max + " " + weight);
		}
    }

 private static int findMinVertex(int[] weight, boolean[] visited) {
        int minVertex = -1;
		for(int i = 0; i < weight.length; i++){
			if(!visited[i]  && (minVertex == -1 || weight[i] < weight[minVertex])){
				minVertex = i;
			}
		}
		return minVertex;
    }

    private static int[][] takeInput() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] ve = br.readLine().split("\\s");
            int n = Integer.parseInt(ve[0]);
            if(n == 0) return null; // if no vertex then array out of bound exc
            int e = Integer.parseInt(ve[1]);

            int[][] adj_matrix = new int[n][n];

            for(int i=0; i<e; i++){
                String[] str_arr = br.readLine().split("\\s");
                int v1 = Integer.parseInt(str_arr[0]);
                int v2 = Integer.parseInt(str_arr[1]);
                int weight = Integer.parseInt(str_arr[2]);
                adj_matrix[v1][v2] = weight; // incase of weighted graph store the weight instead of 1
                adj_matrix[v2][v1] = weight; // incase of directed graph don't do this
            }

            return adj_matrix;
    }
}
