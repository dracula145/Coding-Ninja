/*

Implement the Graph's BFS and DFS

*/

import java.io.*;
import java.util.*;

public class Implement {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        
            System.out.println("Enter the number of vertices and edges : ");
            String[] ve = br.readLine().split("\s");
            int n = Integer.parseInt(ve[0]);
            if(n == 0) return; // if no vertex then array out of bound exc
            int e = Integer.parseInt(ve[1]);
            int adj_matrix[][] = new int[n][n];
            
            System.out.println("Enter the edges : ");
            for(int i=0; i<e; i++){
                String[] str_arr = br.readLine().split("\s");
                int v1 = Integer.parseInt(str_arr[0]);
                int v2 = Integer.parseInt(str_arr[1]);
                adj_matrix[v1][v2] = 1; // incase of weighted graph store the weight instead of 1
                adj_matrix[v2][v1] = 1; // incase of directed graph don't do this
            }

            System.out.println("\nThe Adjacency Matrix is : \n");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) System.out.print(adj_matrix[i][j] + " ");
                System.out.println();
            }

            // print the Depth First Traversal of graph
            //DF(adj_matrix);
            BF(adj_matrix);
    }

    // Depth First Traversal O(V^2)

    public static void DF(int[][] adj_matrix){
        boolean visited[] = new boolean[adj_matrix.length];
        for(int i=0; i<adj_matrix.length; i++){    // loop to make sure all components visited (for disconnected)
            if(!visited[i]){
                DF(adj_matrix, i, visited);
                System.out.println(); // one line gap after every component
            }
        }
    }

    //overloaded helper function for depth first
    private static void DF(int [][] adj_matrix, int curr_vertex, boolean[] visited){

        System.out.println(curr_vertex + " ");
        visited[curr_vertex] = true;

        for(int i=0; i<adj_matrix.length; i++){
            if(adj_matrix[curr_vertex][i] == 1 && !visited[i])
            //  if i is neighbour of current vertex and its not visited before
            DF(adj_matrix, i, visited);
        }
    }

    // Breadth First Traversal O(V^2)
    /*
        NOTE - if we use Adjacency list then O(V + 2E)
    */
    public static void BF(int[][] adj_matrix){
        boolean visited[] = new boolean[adj_matrix.length];
        Queue<Integer> pending = new LinkedList<>();
        int count = adj_matrix.length;

        pending.add(0);
        visited[0] = true; // make visited true while adding into queue.. not while removing

        //outer count loop to ensure all vertices explored. Useful incase of disconnection
    while(count > 0){

        while(!pending.isEmpty()){
            int vertex = pending.poll();
            System.out.print(vertex + " ");
            count--;

            for(int i=0; i<adj_matrix.length; i++){
                if(adj_matrix[vertex][i] == 1 && !visited[i]){
                    pending.add(i);
                    visited[i] = true;
                }
            }
        }

        // for disconnected graph components
        if(count != 0){ // if all elements not printed
            int i = 0;
            while(visited[i]) i++;  // whatever not visited add that to queue and continue again
            pending.add(i);
            visited[i] = true;
        }
    }
  }
}