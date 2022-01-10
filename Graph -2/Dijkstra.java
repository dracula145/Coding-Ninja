/*

Given an undirected, connected and weighted graph G(V, E) with V number of vertices (which are numbered 
from 0 to V-1) and E number of edges.
Find and print the shortest distance from the source vertex (i.e. Vertex 0) to all other vertices 
(including source vertex also) using Dijkstra's Algorithm.
Input Format :
Line 1: Two Integers V and E (separated by space)
Next E lines : Three integers ei, ej and wi, denoting that there exists an edge between vertex ei and 
vertex ej with weight wi (separated by space)
Output Format :
For each vertex, print its vertex number and its distance from source, in a separate line. The vertex 
number and its distance needs to be separated by a single space.
Note : Order of vertices in output doesn't matter.

Constraints :
2 <= V, E <= 10^5
Time Limit: 1 sec
Sample Input 1 :
4 4
0 1 3
0 3 5
1 2 1
2 3 8
Sample Output 1 :
0 0
1 3
2 4
3 5
*/

import java.io.*;

// similar to prim
// O(V^2) time
public class Dijkstra {

    public static void main(String[] args) throws IOException {
        int[][] adj_matrix = takeInput();
        dijkstra(adj_matrix);
    }

   private static void dijkstra(int[][] adj_matrix) {
        int v = adj_matrix.length;
        boolean[] visited = new boolean[v];
        int[] distance = new int[v];  // weight of vertex and parent
        for(int i=1; i<v; i++) distance[i] = Integer.MAX_VALUE;   // setting infinity to all indices >0

        // start the algorithm
        for(int i=0; i<v-1; i++){
            int min_dist_vertex = findMinDistanceVertex(distance,visited);
            visited[min_dist_vertex]=true;

            for(int j=0; j<v; j++){
                int curr_distance = adj_matrix[min_dist_vertex][j];
                if(curr_distance !=0 && !visited[j] ){
                    int new_distance = distance[min_dist_vertex] + curr_distance;
                    if(distance[j] > new_distance)
                    distance[j] = new_distance;
                }
            }
        }
        print(distance);
    }

   private static int findMinDistanceVertex(int[] distance, boolean[] visited) {
        int minvertex = -1;
        for(int i=0; i<distance.length; i++){
            if(!visited[i] && (minvertex==-1 || distance[i]<distance[minvertex]))
                minvertex=i;
        }
        return minvertex;
    }

private static void print(int[] distance) {
       for(int i=0; i<distance.length; i++) 
       System.out.println(i + " " + distance[i]);
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
