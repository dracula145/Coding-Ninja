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
