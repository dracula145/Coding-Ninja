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
