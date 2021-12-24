package Assignment;

import java.util.*;

public class Islands {

    // same code as BF implement... just use num_count
    public static int numConnected(int[][] edges, int n) {

        boolean visited[] = new boolean[edges.length];
        Queue<Integer> pending = new LinkedList<>();
        int count = edges.length, num_count = 1;
        if(count == 0) return 0;

        pending.add(0);
        visited[0] = true; // make visited true while adding into queue.. not while removing

        //outer count loop to ensure all vertices explored. Useful incase of disconnection
    while(count > 0){

        while(!pending.isEmpty()){
            int vertex = pending.poll();
            count--;

            for(int i=0; i<edges.length; i++){
                if(edges[vertex][i] == 1 && !visited[i]){
                    pending.add(i);
                    visited[i] = true;
                }
            }
        }

        // for disconnected graph components
        if(count != 0){ // if all elements not printed
            num_count ++ ; // everytime a disconnected graph appears add 1
            int i = 0;
            while(visited[i]) i++;  // whatever not visited add that to queue and continue again
            pending.add(i);
            visited[i] = true;
        }
    }
    return num_count;
	}
}

/*
        DFS solution

        	public class Solution {
	static int count=0;
    public static int numConnected(int[][] edges, int n) {
        
        boolean [] visited=new boolean[edges.length];
        for(int i=0;i<n;i++){
            if(visited[i]==false){
                dftraversal(edges,i,visited);
                count++;
            }
        }
        return count;
    }
    public static void dftraversal(int adjMatrix[][],int c, boolean visited[]) {
        visited[c]=true;
        for(int i=0;i<adjMatrix.length;i++) {
            if(adjMatrix[c][i]==1 && visited[i]==false) {
                dftraversal(adjMatrix,i,visited);
            }
        }
    }
}

*/
