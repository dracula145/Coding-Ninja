/*

Given an undirected graph G(V, E) and two vertices v1 and v2 (as integers), check if there exists any path 
between them or not. Print true if the path exists and false otherwise.
Note:
1. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1. 
2. E is the number of edges present in graph G.
Input Format :
The first line of input contains two integers, that denote the value of V and E.
Each of the following E lines contains two integers, that denote that there exists an edge between vertex 
'a' and 'b'.
The following line contain two integers, that denote the value of v1 and v2.
Output Format :
The first and only line of output contains true, if there is a path between v1 and v2 and false otherwise.
Constraints :
0 <= V <= 1000
0 <= E <= 1000
0 <= a <= V - 1
0 <= b <= V - 1
0 <= v1 <= V - 1
0 <= v2 <= V - 1
Time Limit: 1 second
Sample Input 1 :
4 4
0 1
0 3
1 2
2 3
1 3
Sample Output 1 :
true
Sample Input 2 :
6 3
5 3
0 1
3 4
0 3
Sample Output 2 :
false

*/

import java.io.*;

public class HasPath {
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
            System.out.println(hasPath(adj_matrix, v1, v2, visited));

    }

    private static boolean hasPath(int[][] adj_matrix, int curr_vertex, int v2, boolean visited[]){
        visited[curr_vertex] = true;
        if(curr_vertex == v2) return true;

        for(int i=0; i<adj_matrix.length; i++){
            if(adj_matrix[curr_vertex][i] == 1 && !visited[i])
                if(hasPath(adj_matrix, i, v2, visited)) return true;
                // note here - return haspath(...) would be wrong becuase whatever the first value
                // returned, that will be sent and other options won't be explored
        }
        return false;
    }
}
