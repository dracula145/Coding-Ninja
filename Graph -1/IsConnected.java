import java.util.*;
import java.io.*;

public class IsConnected {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number of vertices and edges : ");
            String[] ve = br.readLine().split("\\s");
            int n = Integer.parseInt(ve[0]);
           if(n == 0){
            System.out.println(true); // if no vertex then array out of bound exc
            return;
           } 
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

            System.out.println(isConnected(adj_matrix));

    }

    // done in BFS way... like implement.java
    public static boolean isConnected(int[][] adj_matrix){
        
        boolean visited[] = new boolean[adj_matrix.length];
        Queue<Integer> pending = new LinkedList<>();
        int count = adj_matrix.length;

        pending.add(0);
        visited[0] = true; // make visited true while adding into queue.. not while removing

        while(!pending.isEmpty()){
            int vertex = pending.poll();
            count--;

            for(int i=0; i<adj_matrix.length; i++){
                if(adj_matrix[vertex][i] == 1 && !visited[i]){
                    pending.add(i);
                    visited[i] = true;
                }
            }
        }
        //if all elements not encountered => disconnected
        if(count != 0) return false;
        return true;

    }
  }

