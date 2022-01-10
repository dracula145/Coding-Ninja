/*

An island is a small piece of land surrounded by water . A group of islands is said to be connected if we 
can reach from any given island to any other island in the same group . Given V islands (numbered from 1 to 
V) and E connections or edges between islands. Can you count the number of connected groups of islands.
Input Format :
The first line of input contains two integers, that denote the value of V and E.
Each of the following E lines contains two integers, that denote that there exists an edge between vertex a 
and b. 

Output Format :
Print the count the number of connected groups of islands
Constraints :
0 <= V <= 1000
0 <= E <= (V * (V-1)) / 2
0 <= a <= V - 1
0 <= b <= V - 1
Time Limit: 1 second
Sample Input 1:
5 8
0 1
0 4
1 2
2 0
2 4
3 0
3 2
4 3
Sample Output 1:
1 

*/

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
