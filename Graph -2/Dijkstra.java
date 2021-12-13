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
        for(int i=1; i<v; i++) distance[i] = Integer.MAX_VALUE;   // setting infinity to all indices >1

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
