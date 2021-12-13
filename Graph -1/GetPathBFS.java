import java.util.*;

public class GetPathBFS {

    private static void getPathBFS(int[][] adj_matrix, int curr_vertex, int v2){
        boolean visited[] = new boolean[adj_matrix.length];
        // hashmap to store parent of each vertex
        HashMap<Integer, Integer> child_parent = new HashMap<>();
        Queue<Integer> pending = new LinkedList<>();

        child_parent.put(curr_vertex, -1);
        pending.add(curr_vertex);
        visited[curr_vertex] = true;

        while(!pending.isEmpty()){
            int temp = pending.poll();
            
            // if v2 found then trace back to the parent node using hashmap
            if(temp == v2){
                System.out.print(temp + " ");
                int parent = child_parent.get(temp);
                while(parent != -1){
                    System.out.print(parent + " ");
                    parent = child_parent.get(parent);
                }
                return;
            }

            for(int i=0; i<adj_matrix.length; i++){
                if(adj_matrix[temp][i] == 1 && !visited[i]){
                    pending.add(i);
                    child_parent.put(i, temp);
                    visited[i] = true;
                }
            }
        }
    }
}
