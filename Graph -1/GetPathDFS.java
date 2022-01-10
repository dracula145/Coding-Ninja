/*

Given an undirected graph G(V, E) and two vertices v1 and v2(as integers), find and print the path from 
v1 to v2 (if exists). Print nothing if there is no path between v1 and v2.
Find the path using DFS and print the first path that you encountered.
Note:
1. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1. 
2. E is the number of edges present in graph G.
3. Print the path in reverse order. That is, print v2 first, then intermediate vertices and v1 at last.
4. Save the input graph in Adjacency Matrix.
Input Format :
The first line of input contains two integers, that denote the value of V and E.
Each of the following E lines contains two integers, that denote that there exists an edge between vertex 
'a' and 'b'.
The following line contain two integers, that denote the value of v1 and v2.
Output Format :
Print the path from v1 to v2 in reverse order.
Constraints :
2 <= V <= 1000
1 <= E <= (V * (V - 1)) / 2
0 <= a <= V - 1
0 <= b <= V - 1
0 <= v1 <= 2^31 - 1
0 <= v2 <= 2^31 - 1
Time Limit: 1 second
Sample Input 1 :
4 4
0 1
0 3
1 2
2 3
1 3
Sample Output 1 :
3 0 1
Sample Input 2 :
6 3
5 3
0 1
3 4
0 3
Sample Output 2 :

*/

import java.util.*;
import java.io.*;

public class GetPathDFS {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number of vertices and edges : ");
            String[] ve = br.readLine().split("\\s");
            int n = Integer.parseInt(ve[0]);
            if(n == 0) return; // if no vertex then array out of bound exc
            int e = Integer.parseInt(ve[1]);
            int adj_matrix[][] = new int[n][n];
            
            System.out.println("Enter the edges : ");
            for(int i=0; i<e; i++){
                String[] str_arr = br.readLine().split("\\s");
                int v1 = Integer.parseInt(str_arr[0]);
                int v2 = Integer.parseInt(str_arr[1]);
                adj_matrix[v1][v2] = 1;
                adj_matrix[v2][v1] = 1;
            }
            String[] to_check = br.readLine().split("\\s");
            int v1 = Integer.parseInt(to_check[0]);
            int v2 = Integer.parseInt(to_check[1]);

            boolean visited[] = new boolean[adj_matrix.length];
            ArrayList<Integer> path = getPathDFS(adj_matrix, v1, v2, visited);
            for(int i : path) System.out.print(i + " ");

            //getPathBFS(adj_matrix, v1, v2);

    }
    private static ArrayList<Integer> getPathDFS(int [][]adj_matrix, int curr_vertex, int  v2, boolean[] visited){
        visited[curr_vertex] = true;
        if(curr_vertex == v2){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(v2);
            return list;
        }
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=0 ; i<adj_matrix.length; i++){
            if(adj_matrix[curr_vertex][i] == 1 && !visited[i]){
                answer = getPathDFS(adj_matrix, i, v2, visited);
                if(answer != null){
                    answer.add(curr_vertex);
                    return answer;
                }
            }
        }
        return null;   // if no path found till now then return null
    }
}
